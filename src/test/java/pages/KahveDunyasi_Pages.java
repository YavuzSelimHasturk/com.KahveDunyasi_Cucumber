package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KahveDunyasi_Pages {
    public KahveDunyasi_Pages() {
        PageFactory.initElements((WebDriver)Driver.getAppiumDriver(),this);
    }

    @FindBy(id = "com.kahvedunyasi.app:id/iv_intro_icon")
    WebElement logoGiris;

    public WebElement getLogoGiris() {
        return logoGiris;
    }

    @FindBy(id = "com.kahvedunyasi.app:id/btn_intro_ok")
    WebElement buttonOk;

    public WebElement getButtonOk() {
        return buttonOk;
    }
    @FindBy(id ="com.kahvedunyasi.app:id/llCardviewHack")
    WebElement sectionEntry;

    public WebElement getSectionEntry() {
        return sectionEntry;
    }

    @FindBy(id="com.kahvedunyasi.app:id/takeAwayIV")
    WebElement buttonHazirAl;

    public WebElement getButtonHazirAl() {
        return buttonHazirAl;
    }

    @FindBy(id = "com.kahvedunyasi.app:id/iv_intro_icon")
    WebElement iconIntro;

    public WebElement getIconIntro() {
        return iconIntro;
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    WebElement buttonPermissionDeny;

    public WebElement getButtonPermissionDeny() {
        return buttonPermissionDeny;
    }

    @FindBy(id = "com.kahvedunyasi.app:id/clickableSearchView")
    WebElement searchView;

    public WebElement getSearchView() {
        return searchView;
    }

    public void setSearchView(WebElement searchView) {
        this.searchView = searchView;
    }

    @FindBy(xpath = "//*[@text='Türk Kahvesi']")
    WebElement linkTurkKahvesi;


    public WebElement getLinkTurkKahvesi() {
        return linkTurkKahvesi;
    }

    @FindBy(id = "com.kahvedunyasi.app:id/constraint_coffee_image")
    WebElement coffeeSize;

    public WebElement getCoffeeSize() {
        return coffeeSize;
    }
    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[4]")
    WebElement quantityCoffee;

    public WebElement getQuantityCoffee() {
        return quantityCoffee;
    }

    @FindBy(id="com.kahvedunyasi.app:id/fl_add_basket")
    WebElement buttonSepeteEkle;

    public WebElement getButtonSepeteEkle() {
        return buttonSepeteEkle;
    }
    @FindBy(id="com.kahvedunyasi.app:id/etPhone")
    WebElement phoneNumberBox;

    public void enterPhoneNumber (String phoneNumber){
        phoneNumberBox.sendKeys(phoneNumber);
    }

    public WebElement getPhoneNumberBox() {
        return phoneNumberBox;
    }

    @FindBy(id="com.google.android.gms:id/positive_button")
    WebElement buttonIzinVer;

    public WebElement getButtonIzinVer() {
        return buttonIzinVer;
    }

      @FindBy(id="com.kahvedunyasi.app:id/btNext2")
    WebElement buttonDevamEt;

    public WebElement getButtonDevamEt() {
        return buttonDevamEt;
    }
    @FindBy(id = "com.kahvedunyasi.app:id/btn_go_to_basket")
     WebElement buttonSepeteGit;
    public WebElement getButtonSepeteGit() {
        return buttonSepeteGit;
    }
}
