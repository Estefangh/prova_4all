package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

    private WebDriver navegador;

    public DSL(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void clicaBotao(String id_campo){
        navegador.findElement(By.id(id_campo)).click();
    }

    public void clicaBotaoClasse(String classe){
        navegador.findElement(By.className(classe)).click();
    }

    public void maximiza(){
        navegador.manage().window().maximize();
    }

    public void navega(){
        navegador.get("https://shopcart-challenge.4all.com/");
    }
}
