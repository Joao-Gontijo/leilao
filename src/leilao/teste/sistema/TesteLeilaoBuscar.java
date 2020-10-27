package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLeilaoBuscar {
	
	private WebDriver browser;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		browser = new ChromeDriver();
	}

	@After
	public void end() {
		browser.close();
	}

}
