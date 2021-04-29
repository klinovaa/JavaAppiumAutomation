package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            ADD_TO_CREATED_LIST = "//*[@resource-id='org.wikipedia:id/item_container']//*[@text='{NAME_OF_FOLDER}']";

    /* TEMPLATE METHODS */
    private static String getCreatedListXpathByName(String name_of_folder)
    {
        return ADD_TO_CREATED_LIST.replace("{NAME_OF_FOLDER}", name_of_folder);
    }
    /* TEMPLATE METHODS */


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Can't find article title on page", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Can't find the end of article", 20);
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON), "Can't find button to open article options", 5);
        this.waitForElementAndClick(By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON), "Can't find option to add article to reading list", 5);
        this.waitForElementAndClick(By.id(ADD_TO_MY_LIST_OVERLAY), "Can't find 'Got it' tip overlay", 5);
        this.waitForElementAndClear(By.id(MY_LIST_NAME_INPUT), "Can't find input to set name of articles folder", 5);
        this.waitForElementAndSendKeys(By.id(MY_LIST_NAME_INPUT), name_of_folder, "Can't put text into articles folder input", 5);
        this.waitForElementAndClick(By.xpath(MY_LIST_OK_BUTTON), "Can't press OK button", 5);
    }

    public void addArticleToCreatedList(String name_of_folder)
    {
        this.waitForElementAndClick(By.xpath(OPTIONS_BUTTON), "Can't find button to open article options", 5);
        this.waitForElementAndClick(By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON), "Can't find option to add article to reading list", 5);
        String folder_name_xpath = getCreatedListXpathByName(name_of_folder);
        this.waitForElementAndClick(By.xpath(folder_name_xpath), "Can't find created folder '" + name_of_folder + "' while adding article to reading list", 5);
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(By.xpath(CLOSE_ARTICLE_BUTTON), "Can't close article, can't find X link", 5);
    }

    public void assertArticleTitle()
    {
        this.assertElementPresent(By.xpath(TITLE), "Can't find article title");
    }

}
