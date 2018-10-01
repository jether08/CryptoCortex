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
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()
KeywordLogger log = new KeywordLogger()

//Call valid login keyword
CustomKeywords.'utility.login.validLogin'()

WebUI.delay(5)

//Click Deposit button
WebUI.click(findTestObject('Trading Balance/Deposit_Button'))


WebUI.delay(5)

//Count the number of rows in the Transfers table
int rows1 = driver.findElements(By.xpath('//div[@class="css-1pb8vrj"]/div')).size()
println(rows1)


//Click New Deposit
WebUI.click(findTestObject('Transfers/New Deposit'))


//Open currency dropdown
WebUI.click(findTestObject('Transfers/Wdraw Currency dropbtn'))

//Select coin
WebElement coin = driver.findElement(By.xpath('//div[@class="css-15mbd4a"]/div[contains(text(),"ETH")]'))
coin.click()

WebUI.delay(3)

String selectedcoin = driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).getAttribute("value")

println (selectedcoin)


//Click Deposit
WebUI.click(findTestObject('Transfers/Deposit button'))

WebUI.delay(5)

//VALIDATIONS:
//Verify that a new field is added in
int rows2 = driver.findElements(By.xpath('//div[@class="css-1pb8vrj"]/div')).size()
println(rows2)
if(rows2==(rows1+1)){
	log.logPassed("PASSED: A new row is added")
}
else{
	log.logFailed("FAILED: No new row added")
}
	
WebUI.delay(3)

//Verify that the selected coin is displayed in
String currency = driver.findElement(By.xpath('//div[@class="css-1pb8vrj"]/div[1]/div/div[2]/div')).getText()
if(currency==selectedcoin){
	log.logPassed("PASSED: Currency is correct")
}
else{
	log.logFailed("FAILED: Currency is incorrect")
}


WebUI.delay(3)

//Verify that the newly added row is correct
String transfer_type = driver.findElement(By.xpath('//div[@class="css-1pb8vrj"]/div[1]/div/div[1]/div/div[2]/div')).getText()
if(transfer_type.equalsIgnoreCase('Deposit')){
	log.logPassed("PASSED: New row is correct.")
}
else{
	log.logFailed("FAILED: New row is incorrect.")
}

