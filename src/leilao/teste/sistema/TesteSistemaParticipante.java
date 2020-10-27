package leilao.teste.sistema;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteSistemaParticipante {
	
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
	public void deveCadastrarParticipante() {
		browser.get("http://localhost:8080/leilao/cadastro-participante.html");
		WebElement campoDeNome = browser.findElement(By.name("input-nome"));
		WebElement campoDeCpf = browser.findElement(By.name("input-cpf"));
		WebElement campoDeDataNascimento = browser.findElement(By.name("input-dataNascimento"));
		WebElement botaoSalva = browser.findElement(By.name("btn-salva"));
		campoDeNome.sendKeys("Teste Sistema 2");
		campoDeCpf.sendKeys("4567891230"); 	//bug! cpf repetido passa no teste
											//mas não salva no banco
		campoDeDataNascimento.sendKeys("05122000");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		botaoSalva.submit();
	}
	
	@Test
	public void deveBuscarPorParticipante() {
		browser.get("http://localhost:8080/leilao/participante.html?");
		WebElement botaoBuscar = browser.findElement(By.name("btn-buscar"));
		botaoBuscar.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean existe = browser.getPageSource().contains("Editar");
		assertTrue(existe);
	}
}
