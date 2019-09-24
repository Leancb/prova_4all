package codigo;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;


public class prova {

    private WebDriver navegador;
    private String arg1;


    @Dado("^configurei ambiente para acessar URL Chrome$")
    public void configuraDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\leanc\\Documents\\GitHub\\prova_4all\\src\\main\\resources\\chromedriver.exe");
    }


    @Dado("^que configurei ambiente para acessar URL (.*)$")
    public void confiders(String arg1) {
        this.arg1 = arg1;

        String tmp = null;
        String driv = null;

        if (arg1 == "firefox") {

            tmp = "C:\\Users\\leanc\\Documents\\GitHub\\prova_4all\\src\\main\\resources\\geckodriver.exe";
            driv = "webdriver.gecko.driver";

        } else {
            tmp ="C:\\Users\\leanc\\Documents\\GitHub\\prova_4all\\src\\main\\resources\\chromedriver.exe";
            driv ="webdriver.chrome.driver";
         }
        System.setProperty(driv,tmp);
    }


    @Quando("^abri tela da prova 4all")
    public void abreSimulador() {

        navegador = new ChromeDriver();
        navegador.get("https://shopcart-challenge.4all.com/");
        navegador.manage().window().maximize();

    }

    @Quando("^Selecionar categoria Doces")
    public void selecionadoces() throws InterruptedException {
    //Selecionar categoria "Doces" e Adicionar todos os produtos ao carrinho

        navegador.findElement(By.id("open-categories-btn")).click();

        Thread.sleep(300);
        navegador.findElement(By.id("category-1")).click();
        navegador.findElement(By.id("add-product-4-btn")).click();
        navegador.findElement(By.id("add-product-5-btn")).click();


    }

    @Quando("^Selecionar categoria Bebidas")
    public void selecionabebidas() throws InterruptedException {
        //Selecionar categoria bebidas e Adicionar todos os produtos ao carrinho

        navegador.findElement(By.id("open-categories-btn")).click();

        Thread.sleep(300);
        navegador.findElement(By.id("category-0")).click();
        navegador.findElement(By.id("add-product-0-btn")).click();
        navegador.findElement(By.id("add-product-1-btn")).click();
        navegador.findElement(By.id("add-product-2-btn")).click();

    }

    @Quando("^Selecionar categoria Todos")
    public void selecionarTodos() throws InterruptedException {
        navegador.findElement(By.id("open-categories-btn")).click();
        Thread.sleep(300);
        navegador.findElement(By.id("category-all")).click();
    }

    @Quando("^Acessar o carrinho e aumentar em 4 brigadeiros")
    public void acessaCarrinho() throws InterruptedException {
        //Acessar o carrinho ? aumentar a quantidade do produto "Brigadeiro" em 4 unidades
        navegador.findElement(By.id("cart-btn")).click();
        Thread.sleep(300);
        Integer x = 0;

        while ( x < 5 ){
            navegador.findElement(By.id("add-product-4-qtd")).click();
            x++;
        }

    }


    @Quando("^Acidionar Rissole ao carrinho")
    public void adicionaRissole() throws InterruptedException {
        navegador.findElement(By.id("add-product-3-btn")).click();

    }

    @Quando("^Acessar o carrinho e aumentar 9 rissoles e diminuir 5")
    public void acessaCarrinhorissoles() throws InterruptedException {
        //Acessar o carrinho ? aumentar a quantidade do produto "Brigadeiro" em 4 unidades
        navegador.findElement(By.id("cart-btn")).click();
        Thread.sleep(300);

        Integer x = 0;
        while (x < 10){
            navegador.findElement(By.id("add-product-3-qtd")).click();
            x++;
        }
        x = 0;
        while (x < 6){
            navegador.findElement(By.id("remove-product-3-qtd")).click();
            x++;
        }

    }

    @Quando("^Validar o preço total$")
    public void precoTotal() {
        String var = navegador.findElement(By.id("price-total-checkout")).getText();

        if (var == null) {
            System.out.println("\nErro, algo não funcionou");
        } else {
            Assert.assertTrue(var.contains("R$ 36,00"));
        }
    }


    //*[@id="price-total-checkout"]/font/font

    @Quando("^Clicar em finalizar compra")
    public void clkBtnFinalizaCompra() throws InterruptedException {

        navegador.findElement(By.id("finish-checkout-button")).click();
        Thread.sleep(300);
        String txt = navegador.findElement(By.cssSelector("#root > div.ReactModalPortal > div > div")).getText();

        if (txt == null) {
            System.out.println("\nErro, algo não funcionou");
        } else {
            Assert.assertTrue(txt.contains("Pedido realizado com sucesso!"));
        }

        Screenshot.tirar(navegador, "src\\test\\java\\screenshot" + Generator.dataHoraArquivo()+ "CompraFinalizada.png");


    }

    @Quando("^Clicar no botão Fechar$")
    public void btnFechar() {
        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();
    }

    @Entao("^Fecha o Browser$")
    public void fechaBrowser()  {
        navegador.quit();

    }


    @Entao("Selecionar categoria {string}")
    public void selecionarCategoria( String arg0 ) {
    }
}
