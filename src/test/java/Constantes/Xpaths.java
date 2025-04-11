package Constantes;

public class Xpaths {
    // Inscription
    public static final String usernameXpath = "//input[@name='usernameRegisterPage']";
    public static final String emailXpath = "//input[@name='emailRegisterPage']";
    public static final String passwordXpath = "//input[@name='passwordRegisterPage']";
    public static final String confirmPasswordXpath = "//input[@name='confirm_passwordRegisterPage']";
    public static final String InvalidMailLabel = "//label[contains(text(),'Your email address')]";
    public static final String ConfirmPasswordXpath  = "//input[@name='confirm_passwordRegisterPage']";
    public static final String registerButton= "//button[@id='register_btn']";
    // Home
    public static final String menuUserId="hrefUserIcon";
    public static final String createAccountXpath="//a[contains(@class,'create-new-account')]";
    public static final String speakersBoxXpath="//div[@class='rowSection']/div[@id='speakersImg']";
    public static final String tabletBoxXpath="//div[@class='rowSection']/div[@id='tabletsImg']";
    public static final String headphonesBoxXpath="//div[@class='rowSection']/div[@id='headphonesImg']";
    public static final String headphonesProductXpath="//a[contains(text(),'Matte Black Headphones')]";
    public static final String increaseButtonXpath="//div[contains(@class,'plus-minus')]//div[contains(@class,'plus')]";
    public static final String decreaseButtonXpath="//div[contains(@class,'plus-minus')]//div[contains(@class,'minus')]";
    public static final String addToCartXpath="//button[@name='save_to_cart']";
    public static final String shoppingCartButton="//a[@id='shoppingCartLink']";
    public static final String editQuantityXpath="//label[contains(text(),'MATTE BLACK HEADPHONES')]/following::a[@class='edit ng-scope']";
    public static final  String shoppingCartQuantity="//a[@id=\"shoppingCartLink\"]/span";
    public static final String description = "//div[@id=\"Description\"]//h1";


}
