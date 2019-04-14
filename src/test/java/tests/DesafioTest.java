package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DesafioTest {
    @Test
    public void testDesafioUm(){
        // Abrindo o browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tefag\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        // abrindo full screen
        navegador.manage().window().maximize();
        // Navegando até a página do desafio
        navegador.get("https://shopcart-challenge.4all.com/");

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

        //clicar em "finalizar compra"
        navegador.findElement(By.id("finish-checkout-button")).click();

        //validar a mensagem "Pedido realizado com sucesso!"
        WebElement modal = navegador.findElement(By.className("sc-dNLxif"));
        String textoNaClasse = modal.getText();
        assertEquals("Pedido realizado com sucesso!", textoNaClasse);

        //clicar no botão fechar
        navegador.findElement(By.className("close-modal")).click();
        //fechando o browser
        navegador.quit();
    }
}
