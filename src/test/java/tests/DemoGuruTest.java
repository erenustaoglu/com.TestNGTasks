package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuruPage;
import utilities.ConfigReader;
import utilities.Driver;


public class DemoGuruTest {


    @Test
    public void test01() {
        //http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(ConfigReader.getProperty("demoGuruUrl"));
        //DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        DemoGuruPage demoGuruPage = new DemoGuruPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(demoGuruPage.bankButton, demoGuruPage.debitAccountBase).perform();
        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.salesButton,demoGuruPage.creditAccountBase).perform();
        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.ilkBesBinButton, demoGuruPage.debitAmountBase).perform();
        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.ikincibesBinButton, demoGuruPage.creditAmountBase).perform();
        //    Perfect butonun goruntulendigini dogrulayin
        Assert.assertTrue(demoGuruPage.perfectButton.isDisplayed());

        Driver.getDriver().close();
    }
}
