package demo;

import org.testng.annotations.*;

public class demo1 {
	@Test
	public void hello() {
		System.out.println("second");
	}

	@Test(dataProvider="getdata")
	public void data(String usr, String ps) {
		System.out.println(usr);
		System.out.println(ps);
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][2];
		data[0][0] = "us1";
		data[0][1] = "ps1";
		data[1][0]="us2";
		data[1][1]="ps2";
		return data;
	}

}
