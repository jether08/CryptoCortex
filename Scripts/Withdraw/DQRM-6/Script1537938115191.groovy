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

//Call Login custom keyword
CustomKeywords.'utility.login.validLogin'()

WebUI.waitForPageLoad(15)

//Click the Deposit button
WebUI.click(findTestObject('Trading Balance/Deposit_Button'))

WebUI.delay(5)

//Count the number of rows in the Transfers table
int rows1 = driver.findElements(By.xpath('//div[@class="css-1pb8vrj"]/div')).size()
println(rows1)

//Click New Withdrawal button
WebUI.click(findTestObject('Transfers/New Withdrawal'))

//Open currency dropdown
WebUI.click(findTestObject('Transfers/Wdraw Currency dropbtn'))

//Select coin
WebElement BTC = driver.findElement(By.xpath('//div[@class="css-15mbd4a"]/div[contains(text(),"BTC")]'))
BTC.click()

//Enter Wallet address
WebUI.setText(findTestObject('Transfers/Wallet Address'), 'wallet1')

//Enter amount to withdraw
WebUI.setText(findTestObject('Transfers/To Withdraw'), '0.1')

//Click Withdraw
WebUI.click(findTestObject('Transfers/Withdraw Btn'))

WebUI.delay(10)

//VALIDATIONS:
//Verify that a new row is added in the table
int rows2 = driver.findElements(By.xpath('//div[@class="css-1pb8vrj"]/div')).size()
println(rows2)
if(rows2==(rows1+1)){
	log.logPassed("PASSED: A new row is added")
}
else{
	log.logFailed("FAILED: No new row added")
}

//Verify that the selected coin is displayed in
String currency = driver.findElement(By.xpath('//div[@class="css-1pb8vrj"]/div[1]/div/div[2]/div')).getText()
if(currency=='BTC'){
	log.logPassed("PASSED: Currency is correct")
}
else{
	log.logFailed("FAILED: Currency is incorrect")
}

//Verify that the newly added row is correct
String transfer_type = driver.findElement(By.xpath('//div[@class="css-1pb8vrj"]/div[1]/div/div[1]/div/div[2]/div')).getText()
if(transfer_type.equalsIgnoreCase('Withdrawal')){
	log.logPassed("PASSED: New row is correct.")
}
else{
	log.logFailed("FAILED: New row is incorrect.")
}





