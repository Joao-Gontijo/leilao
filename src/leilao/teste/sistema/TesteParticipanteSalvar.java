package leilao.teste.sistema;

import javax.servlet.annotation.WebServlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;

public class TesteParticipanteSalvar {
	
	private WebDriver browser;
	
	@Before
	public void nome() {
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
		WebElement inputSalva = browser.findElement(By.name("btn-salva"));
		campoDeNome.sendKeys("Meu nome");
		campoDeCpf.sendKeys("00055577788");
		campoDeDataNascimento.sendKeys("10032020");
		inputSalva.submit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
