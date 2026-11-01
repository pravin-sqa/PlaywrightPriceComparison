package base;
import com.microsoft.playwright.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest  {

    protected BrowserFactory browserFactory;
    protected Browser browser;

    @BeforeClass
    public void setUp() {

        browserFactory = new BrowserFactory();
        browserFactory.setUp();

        browser = browserFactory.getBrowser();
    }

    @AfterClass
    public void tearDown() {

        if (browserFactory != null) {
            browserFactory.tearDown();
        }
    }
}