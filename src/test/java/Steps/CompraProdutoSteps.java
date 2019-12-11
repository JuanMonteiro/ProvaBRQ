package Steps;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Pages.BasePage;
import Utilidade.HighLight;
import Utilidade.ProcuraElemento;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import utils.ProcessamentoArquivos;
import utils.evidencia.Evidencia;
import utils.evidencia.EvidenciaIterator;

public class CompraProdutoSteps extends BasePage {

	BasePage BS = new BasePage();
	ProcuraElemento element = new ProcuraElemento();
	String txt = "";
	String CompararMsg = "";
	String Protocolo = "";
	HighLight high = new HighLight();
	String abrir = "";
	String Funcional = "";
	String Ambiente = "";
	String UsuarioObtido = "";
	String SenhaObtida = "";
	String NovaSenhaGerada = "";
	String CategoriaProcedimentoAux = "";
	String CRMProtocolo = "";
	String AssuntoCRM = "";
	String MotivoCRM = "";
	String OcorrenciaCRM = "";
	String UrlAux = "";
	String SMS = "";
	String NomeArquivoAux = "";
	String EmailEsperado = "";
	String MetodoPagamentoAux = "";

	ProcessamentoArquivos EscolhaArquivos = new ProcessamentoArquivos();

	@Dado("^que eu execute o cenario \"([^\"]*)\"$")
	public void queEuExecuteOCenario(String Cenario) throws Throwable {
		abrir = Cenario;

	}

	@Dado("^que acesse o link \"([^\"]*)\"$")
	public void queAcesseOLink(String Url) throws Throwable {
		// Thread.sleep(7000);
		// Runtime.getRuntime().exec("src/test/resources/Others/Login.exe");
		BS.setUP(Url);

	}

	@Entao("^deve ser salvo o pdf de evidencia$")
	public void deveSerSalvoOPdfDeEvidencia() throws Throwable {
		EvidenciaIterator.finishEvidencia(false);
		driver.close();

	}

	@Dado("que eu escolha o tipo de roupa produto para comprar e Categoria da roupa")
	public void queEuEscolhaOTipoDeRoupaProdutoParaComprarECategoriaDaRoupa() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//a[@title='Dresses'])[2]", "click", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("(//a[@title='Dresses'])[2]")));
		txt = "Dado que eu escolha o tipo de roupa produto para comprar";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("(//a[@title='Dresses'])[2]")));
		Thread.sleep(900);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,350)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//img[@width='125'])[3]", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("(//img[@width='125'])[3]")));
		txt = "Dado que eu escolha a Categoria da roupa produto para comprar";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("(//img[@width='125'])[3]")));
		Thread.sleep(900);

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//img[@width='125'])[3]", "click", "", 30));

	}

	@Entao("deve ser demonstrado os produtos da categoria selecionada")
	public void deveSerDemonstradoOsProdutosDaCategoriaSelecionada() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,250)", "");

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//div[@class='content_scene_cat_bg']", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//div[@class='content_scene_cat_bg']")));
		txt = "Entao deve ser demonstrado os produtos da categoria selecionada";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//div[@class='content_scene_cat_bg']")));
		Thread.sleep(900);

	}

	@Quando("eu escolher o produto desejado")
	public void euEscolherOProdutoDesejado() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,350)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//i[@class='icon-th-list']", "click", "", 30));

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Add to cart')])[1]", "exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Add to cart')])[1]")));
		txt = "Quando eu escolher o produto desejado";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Add to cart')])[1]")));
		Thread.sleep(900);

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Add to cart')])[1]", "click", "", 30));

	}

	@Entao("deve ser demonstrado o Modal para CheckOut")
	public void deveSerDemonstradoOModalParaCheckOut() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath",
				"//h2[contains(.,'Product successfully added to your shopping cart')]", "exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//h2[contains(.,'Product successfully added to your shopping cart')]")));
		txt = "Entao deve ser demonstrado o Modal para CheckOut";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//h2[contains(.,'Product successfully added to your shopping cart')]")));
		Thread.sleep(900);

	}

	@Dado("que eu click no botao Proceed to checkout")
	public void queEuClickNoBotaoProceedToCheckout() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Proceed to checkout')]",
				"exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")));
		txt = "Dado que eu click no botao Proceed to checkout";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")));
		Thread.sleep(900);

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Proceed to checkout')]", "click", "", 30));

	}

	@Entao("deve ser demonstrado o sumario da compra")
	public void deveSerDemonstradoOSumarioDaCompra() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//h1[@id='cart_title']", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//h1[@id='cart_title']")));
		txt = "Entao deve ser demonstrado o sumario da compra";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//h1[@id='cart_title']")));
		Thread.sleep(900);

	}

	@Dado("que eu click no botao Proceed to checkout sumario")
	public void queEuClickNoBotaoProceedToCheckoutSumario() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Proceed to checkout')])[2]",
				"exists", "", 30));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,450)", "");

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")));
		txt = "Dado que eu click no botao Proceed to checkout sumario";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")));
		Thread.sleep(900);

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Proceed to checkout')])[2]",
				"click", "", 30));

	}

	@Entao("deve ser demonstrado o campo para criacao de conta")
	public void deveSerDemonstradoOCampoParaCriacaoDeConta() throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//h3[contains(.,'Create an account')]", "exists", "", 30));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,400)", "");

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//h3[contains(.,'Create an account')]")));
		txt = "Entao deve ser demonstrado o campo para criacao de conta";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//h3[contains(.,'Create an account')]")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo Email com {string}")
	public void queEuPreenchaOCampoEmailCom(String Email) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='email_create']", "send", Email, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='email_create']")));
		txt = "Dado que eu preencha o campo Email com " + Email;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='email_create']")));
		Thread.sleep(900);

		EmailEsperado = Email;

	}

	@Quando("eu click no botao Create an account")
	public void euClickNoBotaoCreateAnAccount() throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Create an account')]", "exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'Create an account')]")));
		txt = "Quando eu click no botao Create an account";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'Create an account')]")));
		Thread.sleep(900);

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Create an account')]", "click", "", 30));

	}

	@Entao("deve ser demonstrado os demais campos para preenchimento")
	public void deveSerDemonstradoOsDemaisCamposParaPreenchimento() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//h3[contains(.,'Your personal information')]",
				"exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//h3[contains(.,'Your personal information')]")));
		txt = "Entao deve ser demonstrado os demais campos para preenchimento";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//h3[contains(.,'Your personal information')]")));
		Thread.sleep(900);

	}

	@Dado("que eu selecione Tittle com {string}")
	public void queEuSelecioneTittleCom(String Title) throws Throwable {

		if (Title.equals("Mr.")) {

			assertEquals(true,
					element.ProcuraElemento(driver, "xpath", "//label[contains(.,'Mr.')]", "exists", "", 30));

			new HighLight().highlightElement(driver, driver.findElement(By.xpath("//label[contains(.,'Mr.')]")));
			txt = "Dado que eu selecione Tittle com " + Title;
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//label[contains(.,'Mr.')]")));
			Thread.sleep(900);

			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//label[contains(.,'Mr.')]", "click", "", 30));
		}

		else {
			assertEquals(true,
					element.ProcuraElemento(driver, "xpath", "//label[contains(.,'Mrs.')]", "exists", "", 30));

			new HighLight().highlightElement(driver, driver.findElement(By.xpath("//label[contains(.,'Mrs.')]")));
			txt = "Quando eu clicar no botao Confirmar";
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//label[contains(.,'Mrs.')]")));
			Thread.sleep(900);

			assertEquals(true,
					element.ProcuraElemento(driver, "xpath", "//label[contains(.,'Mrs.')]", "click", "", 30));

		}

	}

	@Dado("que eu preencha o campo FirstName com {string}")
	public void queEuPreenchaOCampoFirstNameCom(String FirstName) throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[@id='customer_firstname']", "send", FirstName, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='customer_firstname']")));
		txt = "Dado que eu preencha o campo FirstName com " + FirstName;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='customer_firstname']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo LastName com {string}")
	public void queEuPreenchaOCampoLastNameCom(String LastName) throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[@id='customer_lastname']", "send", LastName, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='customer_lastname']")));
		txt = "Dado que eu preencha o campo LastName com " + LastName;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='customer_lastname']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo senha com {string}")
	public void queEuPreenchaOCampoSenhaCom(String Password) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='passwd']", "send", Password, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='passwd']")));
		txt = "Dado que eu preencha o campo senha com " + Password;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='passwd']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo FirstName Adress com {string}")
	public void queEuPreenchaOCampoFirstNameAdressCom(String FirstNameAdress) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='firstname']", "clear", "", 30));

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[@id='firstname']", "send", FirstNameAdress, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='firstname']")));
		txt = "Dado que eu preencha o campo FirstName Adress com " + FirstNameAdress;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='firstname']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo LastName Adress com {string}")
	public void queEuPreenchaOCampoLastNameAdressCom(String LastNameAdress) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='lastname']", "clear", "", 30));

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[@id='lastname']", "send", LastNameAdress, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='lastname']")));
		txt = "Dado que eu preencha o campo LastName Adress com " + LastNameAdress;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='lastname']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo Adress com {string}")
	public void queEuPreenchaOCampoAdressCom(String Adress) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='address1']", "clear", "", 30));

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='address1']", "send", Adress, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='address1']")));
		txt = "Dado que eu preencha o campo Adress com " + Adress;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='address1']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo City com {string}")
	public void queEuPreenchaOCampoCityCom(String City) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,300)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='city']", "send", City, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='city']")));
		txt = "Dado que eu preencha o campo City com " + City;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='city']")));
		Thread.sleep(900);

	}

	@Dado("que eu selecione no campo State a opcao {string}")
	public void queEuSelecioneNoCampoStateAOpcao(String States) throws Throwable {

		Select State = new Select(driver.findElement(By.xpath("//select[contains(@name,'id_state')]")));
		State.selectByVisibleText("Alaska");
		State.selectByIndex(2);

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//select[contains(@name,'id_state')]")));
		txt = "Dado que eu selecione no campo State a opcao " + States;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//select[contains(@name,'id_state')]")));
		Thread.sleep(900);

	}

	@Dado("que eu prencha o campo Zip com {string}")
	public void queEuPrenchaOCampoZipCom(String ZipCode) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,300)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='postcode']", "send", ZipCode, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='postcode']")));
		txt = "Dado que eu prencha o campo Zip com " + ZipCode;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='postcode']")));
		Thread.sleep(900);

	}

	@Dado("que eu selecione no campo Country a opcao {string}")
	public void queEuSelecioneNoCampoCountryAOpcao(String string) throws Throwable {

		Select State = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		State.selectByVisibleText("United States");
		State.selectByIndex(1);

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//select[@id='id_country']")));
		txt = "Dado que eu selecione no campo Country a opcao " + string;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//select[@id='id_country']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha o campo MobilePhone com {string}")
	public void queEuPreenchaOCampoMobilePhoneCom(String MobilePhone) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,300)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[@id='phone_mobile']", "clear", "", 30));

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[@id='phone_mobile']", "send", MobilePhone, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[@id='phone_mobile']")));
		txt = "Dado que eu preencha o campo MobilePhone com " + MobilePhone;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[@id='phone_mobile']")));
		Thread.sleep(900);

	}

	@Dado("que eu preencha Assign an Adress com {string}")
	public void queEuPreenchaAssignAnAdressCom(String OtherAdress) throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//input[contains(@id,'alias')]", "clear", "", 30));

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//input[contains(@id,'alias')]", "send", OtherAdress, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//input[contains(@id,'alias')]")));
		txt = "Dado que eu preencha Assign an Adress com " + OtherAdress;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//input[contains(@id,'alias')]")));
		Thread.sleep(900);

	}

	@Quando("eu clicar no botao Register")
	public void euClicarNoBotaoRegister() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,200)", "");

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Register')]", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//span[contains(.,'Register')]")));
		txt = "Quando eu clicar no botao Register";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//span[contains(.,'Register')]")));
		Thread.sleep(900);

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//span[contains(.,'Register')]", "click", "", 30));

	}

	@Entao("deve ser demonstrado a tela de confirmacao de entrega")
	public void deveSerDemonstradoATelaDeConfirmacaoDeEntrega() throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//label[@for='id_address_delivery']", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//label[@for='id_address_delivery']")));
		txt = "Entao deve ser demonstrado a tela de confirmacao de entrega";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//label[@for='id_address_delivery']")));
		Thread.sleep(900);

	}

	@Entao("valido se o endereco esta correto")
	public void validoSeOEnderecoEstaCorreto() throws Throwable {

	}

	@Dado("que eu preencha o campo Comentario sobre o pedido com {string}")
	public void queEuPreenchaOCampoComentarioSobreOPedidoCom(String ComentarioPedido) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,400)", "");

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//textarea[@cols='60']", "send", ComentarioPedido, 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//textarea[@cols='60']")));
		txt = "Dado que eu preencha o campo Comentario sobre o pedido com " + ComentarioPedido;
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//textarea[@cols='60']")));
		Thread.sleep(900);

	}

	@Quando("eu clicar no botao Proceed to checkout")
	public void euClicarNoBotaoProceedToCheckout() throws Throwable {

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Proceed to checkout')])[2]",
				"exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")));
		txt = "Quando eu clicar no botao Proceed to checkout";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")));
		Thread.sleep(900);

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "(//span[contains(.,'Proceed to checkout')])[2]",
				"click", "", 30));

	}

	@Dado("que eu click em  Aceite o termo")
	public void queEuClickEmAceiteOTermo() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,400)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//label[@for='cgv']", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//label[@for='cgv']")));
		txt = "Dado que eu click em  Aceite o termo";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//label[@for='cgv']")));
		Thread.sleep(900);

		assertEquals(true, element.ProcuraElemento(driver, "xpath", "//label[@for='cgv']", "click", "", 30));

	}

	@Entao("deve ser demonstrado o valor da compra")
	public void deveSerDemonstradoOValorDaCompra() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,400)", "");

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(@id,'total_price')]", "exists", "", 30));

		new HighLight().highlightElement(driver, driver.findElement(By.xpath("//span[contains(@id,'total_price')]")));
		txt = "Entao deve ser demonstrado o valor da compra";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//span[contains(@id,'total_price')]")));
		Thread.sleep(900);
	}

	@Dado("que eu selecione o metodo de pagamento {string}")
	public void queEuSelecioneOMetodoDePagamento(String MetodoPagamento) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,100)", "");

		MetodoPagamentoAux = MetodoPagamento;

		if (MetodoPagamento.equals("Cheque")) {

			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//a[@class='cheque']", "exists", "", 30));

			new HighLight().highlightElement(driver, driver.findElement(By.xpath("//a[@class='cheque']")));
			txt = "Dado que eu selecione o metodo de pagamento " + MetodoPagamento;
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//a[@class='cheque']")));
			Thread.sleep(900);

			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//a[@class='cheque']", "click", "", 30));
		}

		else {
			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//a[@class='bankwire']", "exists", "", 30));

			new HighLight().highlightElement(driver, driver.findElement(By.xpath("//a[@class='bankwire']")));
			txt = "Dado que eu selecione o metodo de pagamento " + MetodoPagamento;
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver, driver.findElement(By.xpath("//a[@class='bankwire']")));
			Thread.sleep(900);

			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//a[@class='bankwire']", "click", "", 30));

		}

	}

	@Entao("deve ser demonstrado a confirmacao do pedido")
	public void deveSerDemonstradoAConfirmacaoDoPedido() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,300)", "");

		if (MetodoPagamentoAux.equals("Cheque")) {

			assertEquals(true,
					element.ProcuraElemento(driver, "xpath", "//h3[contains(.,'Check payment')]", "exists", "", 30));

			new HighLight().highlightElement(driver, driver.findElement(By.xpath("//h3[contains(.,'Check payment')]")));
			txt = "Entao deve ser demonstrado a confirmacao do pedido";
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver,
					driver.findElement(By.xpath("//h3[contains(.,'Check payment')]")));
			Thread.sleep(900);

		}

		else {
			assertEquals(true, element.ProcuraElemento(driver, "xpath", "//h3[contains(.,'Bank-wire payment.')]",
					"exists", "", 30));

			new HighLight().highlightElement(driver,
					driver.findElement(By.xpath("//h3[contains(.,'Bank-wire payment.')]")));
			txt = "Quando eu clicar no botao Confirmar";
			Evidencia.addPrintPassed(txt);

			new HighLight().UnhighlightElement(driver,
					driver.findElement(By.xpath("//h3[contains(.,'Bank-wire payment.')]")));
			Thread.sleep(900);

		}

	}

	@Dado("que eu confirme meu pedido")
	public void queEuConfirmeMeuPedido() throws Throwable {

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'I confirm my order')]", "exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'I confirm my order')]")));
		txt = "Dado que eu confirme meu pedido";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//span[contains(.,'I confirm my order')]")));
		Thread.sleep(900);

		assertEquals(true,
				element.ProcuraElemento(driver, "xpath", "//span[contains(.,'I confirm my order')]", "click", "", 30));

	}

	@Entao("valido se o pedido foi confirmado")
	public void validoSeOPedidoFoiConfirmado() throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,300)", "");

		assertEquals(true, element.ProcuraElemento(driver, "xpath",
				"//p[@class='alert alert-success']", "exists", "", 30));

		new HighLight().highlightElement(driver,
				driver.findElement(By.xpath("//p[@class='alert alert-success']")));
		txt = "Entao valido se o pedido foi confirmado";
		Evidencia.addPrintPassed(txt);

		new HighLight().UnhighlightElement(driver,
				driver.findElement(By.xpath("//p[@class='alert alert-success']")));
		Thread.sleep(900);

	}
	
	@Dado("^Funcionalidade \"([^\"]*)\"$")
	public void funcionalidade(String Funcionalidade) throws Throwable {
		Funcional = Funcionalidade;
		new Evidencia(abrir, Funcional, Ambiente);
	}

	@Dado("Ambiente {string}")
	public void ambiente(String Amb) throws Throwable {
		Ambiente = Amb;
	}


}
