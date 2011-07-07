/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import junit.framework.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Angelo
 */
public class FirstTest {

    public FirstTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestHome()throws Exception{
//        assertEquals(1, 1);
        WebClient wc = new WebClient();
        wc.setJavaScriptEnabled(false);
        HtmlPage page = (HtmlPage) wc.getPage("http://friendseat.com");
        String myURL = page.getFullyQualifiedUrl("")+"";
        assertEquals("http://friendseat.com/", myURL);
        assertEquals("HTTP status response",200,page.getWebResponse().getStatusCode());
        assertTrue(page.getWebResponse().getLoadTime()<10000);

    }

}