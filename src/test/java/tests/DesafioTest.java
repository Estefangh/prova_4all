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
    private WebDriver navegador;
    private DSL dsl;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        // Abrindo o browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tefag\\Drivers\\chromedriver.exe");

        navegador = new ChromeDriver();
        dsl = new DSL(navegador);
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        // abrindo full screen
        dsl.maximiza();

        // Navegando até a página do desafio
        dsl.navega();
    }

    @Test
    public void testDesafioUm(){
        // Clicar no "Selecione a Categoria"
        dsl.clicaBotao("open-categories-btn");

        // Clicar na categoria "Doces"
        dsl.clicaBotao("category-1");

        //Clicar no botão "Adicionar ao carrinho" para o brigadeiro
        dsl.clicaBotao("add-product-4-btn");

        //Clicar no botão "Adicionar ao carrinho para o Alfajor de chocolate"
        dsl.clicaBotao("add-product-5-btn");

        //Clicar no "Doces"
        dsl.clicaBotao("open-categories-btn");

        //Selecionar "Todos"
        dsl.clicaBotao("category-all");

        //clicar no carrinho
        dsl.clicaBotao("cart-btn");

        //Aumentar a quantidade de brigadeiro pra 4 unidades
        for (int i = 0; i < 3; i++){
            dsl.clicaBotao("add-product-4-qtd");
        }

        //tirar screenshot
        String screenshotArquivo = "C:\\Users\\tefag\\Pictures\\Screenshots4all/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador, screenshotArquivo);

        //clicar em "finalizar compra"
        dsl.clicaBotao("finish-checkout-button");

        //validar a mensagem "Pedido realizado com sucesso!"
        WebElement modal = navegador.findElement(By.className("sc-dNLxif"));
        String textoNaClasse = modal.getText();
        assertEquals("Pedido realizado com sucesso!", textoNaClasse);

        //clicar no botão fechar
        dsl.clicaBotaoClasse("close-modal");
    }

    @Test
    public void testDesafioDois(){
        // Clicar no "Selecione a Categoria"
        dsl.clicaBotao("open-categories-btn");
        //navegador.findElement(By.id("open-categories-btn")).click();

        // Clicar na categoria "Bebidas"
        dsl.clicaBotao("category-0");
        //navegador.findElement(By.id("category-0")).click();

        //Clicar no botão "Adicionar ao carrinho" para Coca-cola lata
        dsl.clicaBotao("add-product-0-btn");
        //navegador.findElement(By.id("add-product-0-btn")).click();

        //Clicar no botão "Adicionar ao carrinho" para Fanta uva lata
        dsl.clicaBotao("add-product-1-btn");
        //navegador.findElement(By.id("add-product-1-btn")).click();

        //Clicar no botão "Adicionar ao carrinho" para Água mineral sem gás
        dsl.clicaBotao("add-product-2-btn");
        //navegador.findElement(By.id("add-product-2-btn")).click();

        //Clicar em "Bebidas"
        dsl.clicaBotao("open-categories-btn");
        //navegador.findElement(By.id("open-categories-btn")).click();

        //Selecionar "Todos"
        dsl.clicaBotao("category-all");
        //navegador.findElement(By.id("category-all")).click();

        //Adicionar o produto "Rissole médio" no carrinho
        dsl.clicaBotao("add-product-3-btn");
        //navegador.findElement(By.id("add-product-3-btn")).click();

        //clicar no carrinho
        dsl.clicaBotao("cart-btn");
        //navegador.findElement(By.id("cart-btn")).click();

        //Aumentar a quantidade do produto "Rossole médio" em 9 unidades
        for (int i = 0; i < 9; i++) {
            dsl.clicaBotao("add-product-3-qtd");
        }
      //  navegador.findElement(By.id("add-product-3-qtd")).click();


        //Diminuir a quantidade do produto "Rissole médio" em 5 unidades
        for (int i = 0; i < 5; i++) {
            dsl.clicaBotao("remove-product-3-qtd");
        }
     //   navegador.findElement(By.id("remove-product-3-qtd")).click();

        //validar o valor total dos produtos
        WebElement preco = navegador.findElement(By.id("price-total-checkout"));
        String valorTotal = preco.getText();
        assertEquals("R$ 36,00", valorTotal);

        //clicar no botão "finalizar compra"
        dsl.clicaBotao("finish-checkout-button");
       // navegador.findElement(By.id("finish-checkout-button")).click();

        //validar a mensagem "Pedido realizado com sucesso!"
        WebElement modal = navegador.findElement(By.className("sc-dNLxif"));
        String textoNaClasse = modal.getText();
        assertEquals("Pedido realizado com sucesso!", textoNaClasse);

        //clicar no botão fechar
        dsl.clicaBotaoClasse("close-modal");
        //navegador.findElement(By.className("close-modal")).click();
    }

    @After
    public void tearDown(){
        //fechando o browser
        navegador.quit();
    }

}