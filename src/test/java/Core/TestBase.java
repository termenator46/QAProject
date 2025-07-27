package Core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import until.ApplicationManeger;

public class TestBase {
    public WebDriver driver;

    protected ApplicationManeger app = new ApplicationManeger(System.getProperty("browser", "chrome"));

    //@BeforeMethod == @BeforeEach
    //@BeforeSuite == @BeforeAll
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void init(TestInfo testInfo) {
        driver = app.startTest();
        logger.info("Start test " + testInfo.getDisplayName());
    }}
//    @AfterEach
//    public void tearDown() {
//        app.stopTest();
//        logger.info("Stop test");
//        logger.info("========================================");
//    }
//}






