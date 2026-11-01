package tests;

import models.ShopConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReader;

public class JsonReaderTest {

    @Test
    public void verifyShopConfiguration() {

        // Read JSON configuration
        ShopConfig config = JsonReader.read("shopUrls.json");

        // Validate configuration
        Assert.assertNotNull(config, "Configuration should not be null");

        Assert.assertEquals(
                config.product(),
                "Nike Air Max SC",
                "Product name does not match"
        );

        Assert.assertEquals(
                config.shops().size(),
                5,
                "Expected five shopping websites"
        );

        // Print loaded websites
        config.shops().forEach(shop ->
                System.out.println(shop.name() + " : " + shop.url())
        );
    }
}