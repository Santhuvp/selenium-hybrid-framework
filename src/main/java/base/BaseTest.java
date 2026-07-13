package base;

/**
 * BaseTest extends Base_Class to inherit all driver lifecycle methods
 * (@BeforeTest, @BeforeClass, @BeforeMethod, @AfterMethod, @AfterClass, @AfterTest).
 *
 * Test classes should extend BaseTest to gain access to:
 *   - getdriver()        → current thread's WebDriver instance
 *   - loginPage          → LoginPage POM (initialized after @BeforeMethod runs)
 *   - extent / test      → ExtentReports instances for reporting
 *
 * NOTE: Do NOT initialize loginPage in a constructor here — the WebDriver is
 * not available until @BeforeClass runs. Access loginPage after @BeforeMethod.
 */
public class BaseTest extends Base_Class {
    // Inherits loginPage, getdriver(), extent, test from Base_Class.
    // Add shared helper methods here that all test classes need.
}
