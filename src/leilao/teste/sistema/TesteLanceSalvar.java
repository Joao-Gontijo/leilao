package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLanceSalvar {
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
	
	@Test
	public void deveSalvarLance() {
		browser.get("http://localhost:8080/leilao/cadastro-lance.html");
		WebElement comboBoxLeilao = browser.findElement(By.name("cbx-leilao"));
		WebElement comboBoxParticipante = browser.findElement(By.name("cbx-nome"));
		WebElement campoValor = browser.findElement(By.name("input-valor"));
		WebElement botaoSalvar = browser.findElement(By.name("btn-salva"));
		
		comboBoxLeilao.sendKeys("Nintendo");
		comboBoxParticipante.sendKeys("Meu nome");
		campoValor.sendKeys("55");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		botaoSalvar.click();
	}
}
