package tests;

import base.BaseTest;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import models.Shop;
import models.ShopConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class ShopNavigationTest extends BaseTest {

    @Test
    public void verifyShoppingWebsitesNavigation() {

        // Read website configuration
        ShopConfig config = JsonReader.read("shopUrls.json");

        List<Page> openedPages = new ArrayList<>();

        for (Shop shop : config.shops()) {

            // Create independent browser session
            BrowserContext context = browserFactory.createContext();

            // Create new browser tab
            Page page = context.newPage();

            // Navigate to shopping website
            page.navigate(shop.url());

            // Verify navigation
            Assert.assertTrue(
                    page.url().startsWith("http"),
                    shop.name() + " navigation failed"
            );

            openedPages.add(page);

            System.out.println(
                    shop.name() + " opened successfully: " + page.url()
            );
        }

        Assert.assertEquals(
                openedPages.size(),
                config.shops().size(),
                "Not all shopping websites were opened"
        );
    }
}