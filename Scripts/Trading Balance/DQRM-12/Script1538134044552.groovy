import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.xml.internal.ws.spi.db.RepeatedElementBridge.BaseCollectionHandler

import internal.GlobalVariable as GlobalVariable

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.openqa.selenium.By

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

//Call valid login keyword
CustomKeywords.'utility.login.validLogin'()

WebUI.delay(15)

//Click Currency dropdown button
//WebUI.click(findTestObject('Trading Balance/Currency dropbtn'))

//List <WebElement> coins = driver.findElements(By.xpath('//div[@class="css-wupi9h"]/div/div/div[3]/div/div[1]/div'))
//println(coins.get(0).getText())

for(i=1;i<=6;i++){
		
	//Initial count of selected currencies
	int selected1 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
	println("Selected currencies initial count: "+ selected1)
	
	switch(i){
		case 1:
				
			//Click Currency dropdown button
			WebUI.click(findTestObject('Trading Balance/Currency dropbtn'))
				
			//Select BCH
			WebElement BCH = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"BCH")]'))
			BCH.click()
			
			//Get the position of BCH
			WebElement preceding = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"BCH")]/preceding-sibling::div[@class'))
			println(preceding.getText())
			
			
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
							
			//Verify that BCH is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/BCH"), 3)
			
			//Verify that the order is correct
				
			break;
			
		case 2:
				
			//Select XRP
			WebElement XRP = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"XRP")]'))
			XRP.click()
			
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
						
			//Verify that XRP is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/XRP"), 3)
		
			//Verify that the order is correct
			
			break;
			
		case 3:
			
			//Select BTC
			WebElement BTC = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"BTC")]'))
			BTC.click()
			
			BTC.click()
			
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
						
			//Verify that BTC is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/BTC"), 3)
			
			//Verify that the order is correct
			
			break;
			
		case 4:
					
			//Select BTG
			WebElement BTG = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"BTG")]'))
			BTG.click()
						
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
			
			//Verify that BTG is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/BTG"), 3)
			
			//Verify that the order is correct
			
			break;
			
		case 5:
						
			//Select ETH 
			WebElement ETH = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"ETH")]'))
			ETH.click()
					
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
				
			//Verify that ETH is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/ETH"), 3)
			
			//Verify that the order is correct
			
			break;
			
		case 6:
						
			//Select LTC
			WebElement LTC = driver.findElement(By.xpath('//div[@class="css-11f51v5"]/div//div[contains(text(),"LTC")]'))
			LTC.click()
			
			//Verify that the count of selected currencies is incremented
			int selected2 = driver.findElements(By.xpath('//div[@class="css-1cfh8ii"]/div')).size()
			if(selected2==selected1+1){
				println("PASSED: Count of selected currencies is increased")
			}
			else{
				println("FAILED: No addition on selected currencies")
			}
						
			//Verify that LTC is visible in the Trading Balance
			WebUI.verifyElementPresent(findTestObject("Trading Balance/LTC"), 3)
			
			//Verify that the order is correct
			
			break;
					
	}//end of switch
}//end of loop




