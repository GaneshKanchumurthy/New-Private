package testgroup.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import testgroup.testcomponents.BaseTest;


public class Errorvalidation extends BaseTest{
	
	@Test (groups = {"error"})
public void wrongCreds() throws InterruptedException {
		login.loggedin("test@gmail.com", "testpass");
		Thread.sleep(1000);
		Assert.assertEquals("Incorrect email or password.", login.errormessage());
	}
	
	@Test (groups = {"error"})
	public void invalidFormat() {
		login.loggedin("test", "testpass");
		Assert.assertEquals("*Enter Valid Email", login.formaterrormessage());
	}

}
