package Constante;

public class Xpath {
    public static final String menuUserBy = "//a[@id='menuUserLink']";
    public static final String createNewAccountBy = "//a[contains(text(),'CREATE NEW ACCOUNT')]";

    public static final String usernameBy         = "//input[@name='usernameRegisterPage']"; // Added username field locator
    public static final String firstNameBy        = "//input[@name='first_nameRegisterPage']";
    public static final String lastNameBy         = "//input[@name='last_nameRegisterPage']";
    public static final String emailBy            = "//input[@name='emailRegisterPage']";
    public static final String passwordBy         = "//input[@name='passwordRegisterPage']";
    public static final String confirmPasswordBy  = "//input[@name='confirm_passwordRegisterPage']";
    public static final String phoneBy            = "//input[@name='phone_numberRegisterPage']";
    public static final String countryOptionMrBy  = "//select[@name='countryListboxRegisterPage']/option[text()='Marocco']";
    public static final String cityBy             = "//input[@name='cityRegisterPage']";
    public static final String addressBy          = "//input[@name='addressRegisterPage']";
    public static final String regionBy           = "//input[@name='state_/_province_/_regionRegisterPage']";
    public static final String postalCodeBy       = "//input[@name='postal_codeRegisterPage']";
    public static final String agreeCheckboxBy    = "//input[@name='i_agree']";
    public static final String registerBtnBy      = "//button[@id='register_btn']";

    public static final String menuUserLoggedBy   = "//a[@id='menuUserLink' and contains(text(),usernameBy)]";
    public static final String cartIconBy         = "//a[@id='shoppingCartLink']/*[name()='svg']";

    public static final String cartContainerBy = "//table[@class='fixedTableEdgeCompatibility']";
    public static final String clickOnProductBy = "//h3[@class='ng-binding']";
    public static final String removeButtonBy = "//a[contains(@class, 'remove red ng-scope')]";
    public static final String categorySpeakersBy = "//div[@id='speakersImg']";
    public static final String firstProductBy     = "//img[@id='20']";
    public static final String firstProductAddBy  ="//button[@name='save_to_cart']";

//    public static final String categoryLaptopsBy  = "//div[@id='laptopsImg']";
//    public static final String categoryHeadPBy = "//div[@id='headphonesImg']";
//    public static final String cartCounterBy      = "//span[@class='cart_quantity']";
//    public static final String secondProductBy = "//img[@id=15]";
//    public static final String secondProductAddBy  ="//button[@name='save_to_cart']";
//    public static final String thirdProductBy = "//img[@id=16]";
//    public static final String thirdProductAddBy  ="//button[@name='save_to_cart']";

}
