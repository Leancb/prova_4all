package codigo;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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


    @Quando("^abri tela do simulador de investimento$")
    public void abreSimulador() {
        System.out.print("aqui");
        navegador = new ChromeDriver();
        navegador.get("https://shopcart-challenge.4all.com/");
        navegador.manage().window().maximize();

    }

    @Entao("^Retorna a tela com resultado$")
    public void retornaSimulacao() throws InterruptedException {

        Thread.sleep(500);
/*
        String var2;

        var2 = navegador.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/a")).getText();

        if (var2 == null) {
            System.out.println("\nErro, algo não funcionou");
        } else {
            Assert.assertTrue(var2.contains("REFAZER A SIMULAÇÃO"));
        }
*/
        navegador.quit();
    }


}
