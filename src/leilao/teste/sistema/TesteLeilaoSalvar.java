package leilao.teste.sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLeilaoSalvar {

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
	public void deveSalvarLeilao() {
		browser.get("http://localhost:8080/leilao/cadastro-leilao.html");
		WebElement campoDescricao = browser.findElement(By.name("input-descricao"));
		WebElement campoDataCriacao = browser.findElement(By.name("input-data-criacao"));
		WebElement campoValorInicial = browser.findElement(By.name("input-valor-inicial"));
		WebElement campoSituacao = browser.findElement(By.name("situacao"));
		WebElement botaoSalva = browser.findElement(By.name("btn-salva"));
		
		campoDescricao.sendKeys("Teste de Leilao 2");
		campoDataCriacao.sendKeys("26102020");
		campoValorInicial.sendKeys("1000");
		campoSituacao.sendKeys("fechado");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		botaoSalva.click();
	}
}
