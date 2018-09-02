package com.ranford.functionalities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExecution extends Repository{

	@Test(priority=1)
	public void verify_launch()
	{  
		launch_Application();
	}
	
	@Test(priority=2)
	public void verify_login()
	{
		login_Application();
	}
	
	@Test(priority=3,enabled = false) //enabled is used for explicitly not execute this method
	//@Test(priority=3)
	public void verifyCreateNewBranch()
	{
		clickbranches();
		//createNewBranch();
	}
	
	@DataProvider(name="branch")
	public Object[][]verify_excelContent() throws IOException
	{
		return excelContent("testdata.xls","Sheet1");
	}
	
	@Test(priority=3,dataProvider="branch")
	public void CreateNewBranch(String bname, String address, String zip, String country, String state, String city)
	{
		clickbranches();
		createBranch(bname,address,zip,country,state,city);
	}
	
	@Test(priority=4)
	public void verify_logout()
	{
		logout_Application();
	}
	
}
