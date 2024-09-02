import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		//Invoke Browser
		//Chrome - ChromeDriver exten-> Methods 
		//WebDriver is the interfaces that the other driver class implement
		//The driver is a .exe file that invoke the specific browser
		//Step to invoke the driver
		//Selenium anager chek if there is not a step that invoke the driver and if its not this download the driver to the specxific browser and place in the correct path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kevhe\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//if we dont the step above the selenium manager will not be active,take more seconds
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?hl=es");
		System.out.println(driver.getTitle());//bring back the little title in the upper tab
		System.out.println(driver.getCurrentUrl());//for review if the url is not changin when you enter in the page
		driver.close();//close only the window that selenium open not the associted windows opnened by the proces or test
		//otrhe method to close the browser
		driver.quit();//this closethis close the complete page if selenium open more than one or assosiated windows
	}

}
