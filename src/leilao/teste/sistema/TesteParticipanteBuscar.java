package leilao.teste.sistema;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteParticipanteBuscar {
	
	private WebDriver browser;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
//	@After
//	public void end() {
//		browser.close();
//	}
	
	@Test
	public void deveBuscarPorParticipante() {
		browser.get("http://localhost:8080/leilao/participante.html?");
		WebElement botaoBuscar = browser.findElement(By.name("btn-buscar"));
		botaoBuscar.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean existe = browser.getPageSource().contains("Editar");
		assertTrue(existe);
	}
}
