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

//Call Login custom keyword
CustomKeywords.'utility.login.validLogin'()

WebUI.waitForPageLoad(15)

//Click the Deposit button
WebUI.click(findTestObject('Trading Balance/Deposit Button'))

//Click New Withdrawal button
WebUI.click(findTestObject('Transfers/New Withdrawal'))

//Open currency dropdown
WebUI.click(findTestObject('Transfers/Wdraw Currency dropbtn'))

//Select currency
WebElement BTC = driver.findElement(By.xpath('//div[@class="css-15mbd4a"]/div[contains(text(),"BTC")]'))
BTC.click()


