package com.spartaglobal.seleniumpractice.Tests;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.seleniumpractice.Pages.Homepage;
import com.spartaglobal.seleniumpractice.SeleniumConfig.SeleniumConfig;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private static Homepage homepage;
    private static SeleniumConfig seleniumConfig;

    @BeforeClass
    public static void setup(){
        seleniumConfig = new SeleniumConfig("chrome","D:\\Docs\\Engineering43\\Engineering43\\chromedriver_win32\\chromedriver.exe");
        homepage = new Homepage(seleniumConfig.getDriver());
    }
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }

    @Test
    public void TestHomepageNavigation(){
        homepage.goToHomepage();
    }

//    @Test
//    public void TestMinimisePopup(){
//        homepage.goToHomepage().minimisePopup();
//    }

    @Test
    public void TestDestination(){
        homepage.goToHomepage().enterDestination().submitSearch();
       Assert.assertEquals("https://www.phptravels.net/thhotels/search/null/null/2/0" , seleniumConfig.getDriver().getCurrentUrl());
    }

    @Test
    public void TestSearchResults(){
        homepage.goToHomepage().enterDestination().selectCheckIn().selectCheckOut().submitSearch();
    }

    @Test
    public void TestFirstBlogLink(){
        homepage.goToHomepage().clickBlogLink1();
        Assert.assertEquals("https://www.phptravels.net/blog/pooja-godi", seleniumConfig.getDriver().getCurrentUrl());
    }

    @Test
    public void TestSecondBlogLink(){
        homepage.goToHomepage().clickBlogLink2();
        Assert.assertEquals("https://www.phptravels.net/blog/Virgin-Gorda-beaches-and-lobste",seleniumConfig.getDriver().getCurrentUrl());
    }

    @Test
    public void TestThirdBlogLink(){
        homepage.goToHomepage().waitForElement().clickBlogLink3();

        Assert.assertEquals("https://www.phptravels.net/blog/Fiercely-Independent-Cultures",seleniumConfig.getDriver().getCurrentUrl());
    }
}
