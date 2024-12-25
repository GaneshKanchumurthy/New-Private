package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo2 {
	@Test(groups = { "testrun" })
	public void stat1() {
		System.out.println("test");
	}
	

	@AfterTest
	public void stat2() {
		System.out.println("aftertest");
	}

	@BeforeTest(groups = { "testrun" })
	public void stat3() {
		System.out.println("beforetest");
	}

	@BeforeClass
	public void stat4() {
		System.out.println("beforeclass");
	}

	@AfterClass
	public void stst5() {
		System.out.println("afterclass");
	}

	@AfterSuite
	public void stat6() {
		System.out.println("aftersuite");

	}

	@BeforeSuite
	public void stat7() {
		System.out.println("beforesuite");
	}
	@Test
	public void stat9() {
		System.out.println("dependent");
	}
	@Test(dependsOnMethods= {"stat9"})
	public void a() {
		System.out.println("dependson");
	}
	@Parameters({"URL"})
	@Test
	public void param(String abc) {
		System.out.println(abc);
	}
}
