package driver;

import constants.Navegador;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class DriverManager {

private WebDriver driver;
private DesiredCapabilities capabilities = new DesiredCapabilities();
private File root = new File("driverNavegador");
private String extensionDriver = "";

       protected void resolveDriver(Navegador nav, String ambURL) {
    	    File driverPath;
    	    String os = System.getProperty("os.name").toLowerCase();
    	    System.out.println("\nSistema operativo ->" + System.getProperty("os.name").toLowerCase() + " " +System.getProperty("os.version").toLowerCase() +"\n");
    	    if (!os.contains("mac"))
    	      this.extensionDriver = ".exe";
    	    System.out.println(nav);
    	    switch (nav) {
				case Chrome:
					System.out.println("Se selecciona Chrome");
					WebDriverManager.chromedriver().setup();
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--disable-dev-shm-usage");
					chromeOptions.addArguments("--no-sandbox");
					chromeOptions.addArguments("--disable-gpu");
					chromeOptions.addArguments("--remote-allow-origins=*");
					chromeOptions.addArguments("--ignore-ssl-errors=yes");
					this.driver = new ChromeDriver(chromeOptions);
					this.driver.manage().deleteAllCookies();
					break;
    	      case Firefox:
    	        System.out.println("Se selecciona Firefox");
    	        WebDriverManager.firefoxdriver().setup();
    	        this.driver = (WebDriver)new FirefoxDriver();
    	        this.capabilities.setBrowserName("Firefox");
    	        break;
    	      case Edge:
    	        System.out.println("Se selecciona Edge");
    	        WebDriverManager.edgedriver().setup();
    	        this.driver = (WebDriver)new EdgeDriver();
    	        this.capabilities.setBrowserName("Microsoft Edge");
    	        break;
    	      case Safari:
    	        System.out.println("Se selecciona Safari");
    	        driverPath = new File(this.root, "safaridriver" + this.extensionDriver);
    	        System.setProperty("webdriver.safari.driver", driverPath.getAbsolutePath());
    	        this.driver = (WebDriver)new SafariDriver();
    	        this.capabilities.setBrowserName("Safari");
    	        break;
    	      default:
    	        System.out.println("No es posible lanzar el navegador, no se reconoce el navegador: " + nav);
    	        break;
    	    }
    	    this.driver.manage().window().maximize();
    		this.driver.get(ambURL);

    	  }
       
   
    protected WebDriver getDriver() {
    	if (driver == null) {
			return driver;
		} else {
			return driver;
		}    	
    
    }

}
