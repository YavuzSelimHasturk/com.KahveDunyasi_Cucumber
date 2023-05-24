package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.KahveDunyasi_Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


import static org.junit.Assert.assertTrue;

public class KahveDunyasi_Mobil {

    KahveDunyasi_Pages pages = new KahveDunyasi_Pages();
    final static Logger logger = LogManager.getLogger(KahveDunyasi_Mobil.class);

    @Given("user opens the Kahve Dunyasi app")
    public void user_opens_the_kahve_dunyasi_app() {
        Driver.getAppiumDriver();
    logger.info("Kahve Dunyasi app opened");

    }

    @And("verify that the app opens correctly")
    public void verifyThatTheAppOpensCorrectly() {
        if (pages.getLogoGiris().isDisplayed()) {
            for (int i = 0; i < 5; i++) {
                ReusableMethods.touchAction(950, 1350, 115, 1335);
            }
        }

        pages.getButtonOk().click();
        assertTrue(pages.getSectionEntry().isDisplayed());

        logger.info("Kahve Dunyasi app opened correctly");
    }

    @And("click on the Hazir Al tab from the sub tabs")
    public void clickOnTheHazirAlTabFromTheSubTabs() {
        pages.getButtonHazirAl().click();
        logger.info("Hazir al tab clicked");

    }

    @And("choose the store to buy the product")
    public void chooseTheStoreToBuyTheProduct() throws IOException {
        ReusableMethods.wait(2);
        if (pages.getIconIntro().isDisplayed()) {
            for (int i = 0; i < 4; i++) {
                ReusableMethods.touchAction(1000, 1350, 100, 1350);
            }
        }
        pages.getButtonOk().click();

        pages.getButtonPermissionDeny().click();
        ReusableMethods.wait(2);
        pages.getSearchView().click();

        ReusableMethods.scrollWithUiScrollable("Kahve Dünyası - Ataşehir Migros");

        logger.info("Store selected");

    }

    @And("choose the product to order")
    public void chooseTheProductToOrder() {
        pages.getLinkTurkKahvesi().click();
        logger.info("Order selected");
    }

    @And("chooses the size, sugar, quantity of the product to be ordered and adds the product to the cart")
    public void choosesTheSizeSugarQuantityOfTheProductToBeOrderedAndAddsTheProductToTheCart() {
        pages.getCoffeeSize().click();
        ReusableMethods.scrollWithUiScrollable("Az Şekerli");
        pages.getQuantityCoffee().click();
        pages.getQuantityCoffee().click();
        pages.getQuantityCoffee().click();
        pages.getButtonSepeteEkle().click();
        ReusableMethods.wait(3);
        pages.getPhoneNumberBox().click();
        pages.enterPhoneNumber(ConfigReader.getProperty("phoneNumber"));
        pages.getPhoneNumberBox().click();
        pages.getButtonDevamEt().click();
        ReusableMethods.waitForClickablility(pages.getButtonIzinVer(),30);
        ReusableMethods.scrollWithUiScrollable("İzin ver");
        ReusableMethods.touchActionClick(524, 2168);
        pages.getButtonSepeteEkle().click();

        logger.info("Size, sugar, quantity of the product selected and product added the cart ");
    }

    @And("verify that the product has been added to the cart")
    public void verifyThatTheProductHasBeenAddedToTheCart() {
        assertTrue(pages.getButtonSepeteGit().isDisplayed());

        logger.info("Verified that the product has been added to the cart");
    }

    @And("goes to the cart and finish the process")
    public void goesToTheCartAndStartsThePurchaseProcess() {
        pages.getButtonSepeteGit().click();

        logger.info("Goes to the cart and finished the process");
        Driver.quitAppiumDriver();
    }
}
