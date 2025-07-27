package MainPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import until.Basepage;

import javax.swing.*;

public class Main extends Basepage {
    public Main(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@id='content']//a)[2]")
    WebElement Butten_Remove_Elements;
    @FindBy(xpath = "//h3[normalize-space(text())='Add/Remove Elements']")
    WebElement Verifi_Remove_Elements;
    @FindBy(xpath = "//div[@class='example']//button[1]")
    WebElement Click_on_Butten_Add;
    @FindBy(xpath = "//button[text()='Add Element']/following-sibling::div")
    WebElement Delete;
    @FindBy(xpath = "//a[normalize-space(text())='Checkboxes']")
    WebElement CheckBoxes;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    WebElement Checkbox1;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement Checkbox2;
    @FindBy(xpath = "//div[@class='example']//div[1]")
    WebElement Boxs;
    @FindBy(xpath = "//a[normalize-space(text())='Context Menu']")
    WebElement Page;
    @FindBy(xpath = "//div[@id='content']//script[1]")
    WebElement Allert;
    @FindBy(xpath = "//a[normalize-space(text())='About']")
    WebElement Disappearing_Elements;
    @FindBy(xpath = "//a[normalize-space(text())='Disappearing Elements']")
    WebElement Clickon_Disappearing_Elements;
    @FindBy(xpath = "//h1[normalize-space(text())='Not Found']")
    WebElement Not_Found;
    @FindBy(xpath = "//a[normalize-space(text())='Drag and Drop']")
    WebElement Link_Drag;
    @FindBy(xpath = "//a[normalize-space(text())='Dropdown']")
    WebElement Link_Dropdown;
    @FindBy(id = "dropdown")
    WebElement Select;

    @FindBy(xpath = "//option[@disabled='disabled']")
    WebElement Select_opti;

    public Main Link_Disappearing_Elements() {
        click(Clickon_Disappearing_Elements);
        return this;
    }

    public Main Limk_Drop_Down() {
        click(Link_Dropdown);
        return this;
    }
    public Main verifi_Clic_koption(){
        Assertions.assertTrue(isElementVisible(Select));
        return this;
    }

    public Main Drop_down_list() {
       click(Link_Dropdown);
       click(Select_opti);
        Select select = new Select(Select);
        select.selectByVisibleText("Option 1");
        return this;
    }
    public Main List_drop_2(){
        click(Link_Dropdown);
        click(Select_opti);
        Select select = new Select(Select);
        select.selectByVisibleText("Option 2");
        return this;
    }

    public Main Drag_Drop() {

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        String script = """
                    const src = arguments[0], tgt = arguments[1];
                    const dataTransfer = new DataTransfer();
                    src.dispatchEvent(new DragEvent('dragstart', { dataTransfer }));
                    tgt.dispatchEvent(new DragEvent('drop', { dataTransfer }));
                    src.dispatchEvent(new DragEvent('dragend', { dataTransfer }));
                """;

        ((JavascriptExecutor) driver).executeScript(script, source, target);
        return this;
    }

    public Main verifi_hold_sector() {
        Assertions.assertEquals(driver.findElement(By.id("column-a")).getText(), "B");
        Assertions.assertEquals(driver.findElement(By.id("column-b")).getText(), "A");

        return this;
    }


    public Main Link_Drag_Drop() {
        click(Link_Drag);
        return this;
    }

    public Main verifiClickAbaut() {
        Assertions.assertTrue(isElementVisible(Not_Found));
        return this;
    }

    public Main Clickon_Disappearing_Elements() {
        click(Disappearing_Elements);
        return this;
    }


    public Main Clickon_Remove_Elements() {
        click(Butten_Remove_Elements);
        return new Main(driver);
    }

    public Main verifiClick(String text) {
        pause(500);
        Assertions.assertTrue(isContainsText(text, Verifi_Remove_Elements));
        return this;
    }

    public Main Butten_Add() {
        click(Click_on_Butten_Add);
        click(Click_on_Butten_Add);
        click(Click_on_Butten_Add);
        return this;
    }

    public Main Butten_Delete(String text) {
        Assertions.assertTrue(isContainsText(text, Delete));
        return this;
    }

    public Main Click_on_Delete() {
        click(Delete);
        click(Delete);
        click(Delete);
        return this;
    }

    public Main Click_on_Check_bokc() {
        click(CheckBoxes);
        return this;
    }

    public Main Check_boxes(String[] boxs) {
//        click(Checkbox1);
//        click(Checkbox2);
        for (int i = 0; i < boxs.length; i++) {
            if (boxs[i].equals(" checkbox 1")) {
                click(Checkbox1);

            }
            if (boxs[i].equals("checkbox 2")) {
                click(Checkbox2);
            }

        }
        return this;
    }

    public Main Clikc_on_Right_box() {
        Click_Page_Menu();
        new Actions(driver).contextClick(Boxs);
        return this;
    }

    public Main Click_Page_Menu() {
        click(Page);
        return this;
    }

    public Main veriviRightClick() {
        Assertions.assertTrue(isElementVisible(Allert));
        return this;
    }
}

