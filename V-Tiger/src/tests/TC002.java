package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class TC002 extends BaseTest {
	
	@Test
	public void clickProjects() {
    HomePage h = new HomePage(driver);
    h.setInput("hello123");
	}
}
