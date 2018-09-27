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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

WebUI.openBrowser('')

WebDriver driver = DriverFactory.getWebDriver()

//Call valid login keyword
CustomKeywords.'utility.login.validLogin'()

//Click Deposit button
WebUI.click(findTestObject('Trading Balance/Deposit Button'))

//Click New Deposit
WebUI.click(findTestObject('Transfers/New Deposit'))

//Select coin
WebElement BTC = driver.findElement(By.xpath('//div[@class="css-15mbd4a"]/div[contains(text(),"BTC")]'))
BTC.click()

//Click Deposit
WebUI.click(findTestObject('Transfers/Deposit button'))

//VALIDATIONS:
//Verify that a new field is added in


//Verify that selected coin is added in


//Verify that a new field is added in the table
