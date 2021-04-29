package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject
{
    public static final String
            FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']",
            ARTICLE_BY_DESCRIPTION_TPL = "//*[@text='{DESCRIPTION}']",
            ARTICLE_TITLE = "org.wikipedia:id/page_list_item_title";

    /* TEMPLATE METHODS */
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getSaveArticleXpathByDescription(String article_description)
    {
        return ARTICLE_BY_DESCRIPTION_TPL.replace("{DESCRIPTION}", article_description);
    }
    /* TEMPLATE METHODS */


    public MyListsPageObject (AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(By.xpath(folder_name_xpath), "Can't find folder by name " + name_of_folder, 5);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Can't find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath), "Saved article still present with title " + article_title, 15);
    }

    public void waitForArticleToAppearByDescription(String article_description)
    {
        String article_xpath = getSaveArticleXpathByDescription(article_description);
        this.waitForElementPresent(By.xpath(article_xpath), "Can't find saved article by description " + article_description, 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(By.xpath(article_xpath), "Can't find saved article");

        this.waitForArticleToDisappearByTitle(article_title);
    }

    public String getArticleTitle()
    {
        return this.waitForElementAndGetAttribute(By.id(ARTICLE_TITLE), "text", "Can't find title of article when article is in reading list", 15);
    }

    public void openArticleByDescription(String article_description)
    {
        String article_name_xpath = getFolderXpathByName(article_description);
        this.waitForElementAndClick(By.xpath(article_name_xpath), "Can't find title by description " + article_description, 5);
    }
}
