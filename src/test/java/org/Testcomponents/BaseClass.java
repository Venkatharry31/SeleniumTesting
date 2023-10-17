package org.Testcomponents;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pageobjects.LandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public LandingPage landingpage;

    public WebDriver initializeDriver() throws IOException {
        //using properties class

        Properties prop = new Properties();
        FileInputStream fis =  new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//Resources//TestData.properties");
        prop.load(fis);

        // catching browser details from mvn command
        String browsername = System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
        //String browsername = prop.getProperty("browser");

        if(browsername.contains("chrome"))
        {
            ChromeOptions option = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if(browsername.contains("headless"))
            {
                option.addArguments("headless");
            }
            driver = new ChromeDriver(option);
            driver.manage().window().setSize(new Dimension(1440,900));

        }

        else if(browsername.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingpage = new LandingPage(driver);
        landingpage.goTo();
        return landingpage;
    }

    public String[] dbConnection() throws SQLException {
        String host = "localhost";
        String port = "3306";
        String[] creds = new String[2];
        //String username;
        //String password;
        //creds[0] = username;
        //creds[1] = password;

        Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/seleniumautomation","root","Appu@100");
        Statement s1 = con.createStatement();
        ResultSet r1 = s1.executeQuery("select username, password from usercredentials\n" +
                "where scenario = 'Positive';");
        while (r1.next())
        {
            creds[0] = r1.getString("username");
            creds[1] = r1.getString("password");
            System.out.println(creds[0]);
            System.out.println(creds[1]);
                   }
        return creds;

    }

    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        driver.close();
    }
}
