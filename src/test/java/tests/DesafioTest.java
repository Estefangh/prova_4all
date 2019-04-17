package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

public class DesafioTest {
    public WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        // Abrindo o browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tefag\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        // abrindo full screen
        navegador.manage().window().maximize();

        // Navegando até a página do desafio
        navegador.get("https://shopcart-challenge.4all.com/");
    }


    @Test
    public void testDesafioUm(){
        // Clicar no "Selecione a Categoria"
        navegador.findElement(By.id("open-categories-btn")).click();

        // Clicar na categoria "Doces"
        navegador.findElement(By.id("category-1")).click();

        //Clicar no botão "Adicionar ao carrinho" para o brigadeiro
        navegador.findElement(By.id("add-product-4-btn")).click();

        //Clicar no botão "Adicionar ao carrinho para o Alfajor de chocolate"
        navegador.findElement(By.id("add-product-5-btn")).click();

        //Clicar no "Doces"
        navegador.findElement(By.id("open-categories-btn")).click();

        //Selecionar "Todos"
        navegador.findElement(By.id("category-all")).click();

        //clicar no carrinho
        navegador.findElement(By.id("cart-btn")).click();

        //Aumentar a quantidade de brigadeiro pra 4 unidades
        navegador.findElement(By.id("add-product-4-qtd")).click();
        navegador.findElement(By.id("add-product-4-qtd")).click();
        navegador.findElement(By.id("add-product-4-qtd")).click();

        //tirar screenshot
        String screenshotArquivo = "C:\\Users\\tefag\\Pictures\\Screenshots4all/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //clicar em "finalizar compra"
        navegador.findElement(By.id("finish-checkout-button")).click();

        //validar a mensagem "Pedido realizado com sucesso!"
        WebElement modal = navegador.findElement(By.className("sc-dNLxif"));
        String textoNaClasse = modal.getText();
        assertEquals("Pedido realizado com sucesso!", textoNaClasse);

        //clicar no botão fechar
        navegador.findElement(By.className("close-modal")).click();
    }

    @Test
    public void testDesafioDois(){
        // Clicar no "Selecione a Categoria"
        navegador.findElement(By.id("open-categories-btn")).click();

        // Clicar na categoria "Bebidas"
        navegador.findElement(By.id("category-0")).click();

        //Clicar no botão "Adicionar ao carrinho" para o brigadeiro
        navegador.findElement(By.id("add-product-0-btn")).click();

        //Clicar no botão "Adicionar ao carrinho para o Alfajor de chocolate"
        navegador.findElement(By.id("add-product-1-btn")).click();

        //Clicar no botão "Adicionar ao carrinho para o Alfajor de chocolate"
        navegador.findElement(By.id("add-product-2-btn")).click();

        //Clicar em "Bebidas"
        navegador.findElement(By.id("open-categories-btn")).click();

        //Selecionar "Todos"
        navegador.findElement(By.id("category-all")).click();

        //Adicionar o produto "Rissole médio" no carrinho
        navegador.findElement(By.id("add-product-3-btn")).click();

        //clicar no carrinho
        navegador.findElement(By.id("cart-btn")).click();

        //Aumentar a quantidade do produto "Rossole médio" em 9 unidades
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();
        navegador.findElement(By.id("add-product-3-qtd")).click();

        //Diminuir a quantidade do produto "Rissole médio" em 5 unidades
        navegador.findElement(By.id("remove-product-3-qtd")).click();
        navegador.findElement(By.id("remove-product-3-qtd")).click();
        navegador.findElement(By.id("remove-product-3-qtd")).click();
        navegador.findElement(By.id("remove-product-3-qtd")).click();

        //validar o valor total dos produtos
        WebElement preco = navegador.findElement(By.id("price-total-checkout"));
        String valorTotal = preco.getText();
        assertEquals("R$ 36,00", valorTotal);

        //clicar no botão "finalizar compra"
        navegador.findElement(By.id("finish-checkout-button")).click();

        //validar a mensagem "Pedido realizado com sucesso!"
        WebElement modal = navegador.findElement(By.className("sc-dNLxif"));
        String textoNaClasse = modal.getText();
        assertEquals("Pedido realizado com sucesso!", textoNaClasse);

        //clicar no botão fechar
        navegador.findElement(By.className("close-modal")).click();
    }

    @After
    public void tearDown(){
        //fechando o browser
        navegador.quit();
    }

}
