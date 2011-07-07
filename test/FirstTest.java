/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import junit.framework.Test;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.util.List;
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
    public void testHome()throws Exception{
//        assertEquals(1, 1);
        WebClient wc = new WebClient();
        wc.setJavaScriptEnabled(false);
        HtmlPage page = (HtmlPage) wc.getPage("http://friendseat.com");
        String myURL = page.getFullyQualifiedUrl("")+"";
        assertEquals("http://friendseat.com/", myURL);
        assertEquals("HTTP status response",200,page.getWebResponse().getStatusCode());
        assertTrue(page.getWebResponse().getLoadTime()<10000);

    }

    @Test
    public void testLogin()throws Exception{
        WebClient wc = new WebClient();
	wc.setJavaScriptEnabled(false);
	HtmlPage newP = (HtmlPage) wc.getPage("http://friendseat.com/login.php");

	HtmlForm form = newP.getFormByName("frm");
	HtmlTextInput user = (HtmlTextInput) form.getInputByName("txtName");
	user.setValueAttribute("aevans@friendseat.com");
	HtmlPasswordInput pass = (HtmlPasswordInput) form.getInputByName("txtPassword");
	pass.setValueAttribute("yahyah1");
	HtmlSubmitInput submit = (HtmlSubmitInput) form.getInputByName("btnSubmit");
	HtmlPage page = (HtmlPage) submit.click();
//		System.out.println(page.asText());
        assertTrue("Load time",page.getWebResponse().getLoadTime()<10000);
	assertTrue("Check Avatar on Header",page.asXml().contains("user-is-logged"));
	assertTrue("Check Image avatar",page.asXml().contains("http://graph.facebook.com/507423116/picture"));
        assertTrue("Check Profile Image",page.asXml().contains("user_photo/thumbnail400/242__friendseat_antonioevans.jpg"));
        List<HtmlImage> feedImgPath = (List<HtmlImage>) page.getByXPath("id('feedtab')/x:div[2]/div[1]/a/img");
        assertTrue("Check Feed Tab Images",feedImgPath.size()>0);
        wc.closeAllWindows();
    }

}