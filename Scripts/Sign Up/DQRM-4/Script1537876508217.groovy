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


//Navigate to Sign Up page
WebUI.navigateToUrl(GlobalVariable.newSingupUrl)

WebUI.waitForPageLoad(10)

//Initializing webdriver script
WebDriver driver = DriverFactory.getWebDriver()

WebUI.executeJavaScript('window.open();', [])
currentWindow =  WebUI.getWindowIndex()

println(currentWindow)

//Go in to new tab
WebUI.switchToWindowIndex(currentWindow + 1)
WebUI.navigateToUrl('https://temp-mail.org/en/')

//Get Email address generated in temp-mail
IDmail = WebUI.getAttribute(findTestObject('Signup Page/EmailGen'),'value')

//Print generated email address
println(IDmail)

WebUI.delay(3)

WebUI.refresh()

//Switch back to DQR site
WebUI.switchToWindowIndex(currentWindow)

WebUI.delay(3)


//Enter given name
//WebUI.setText(findTestObject('Signup Page/Given Name'), 'Dummy1')

//Enter middle name
//WebUI.setText(findTestObject('Signup Page/Middle Name'), 'Middle')

//Enter Surname
//WebUI.setText(findTestObject('Signup Page/Surname'), 'Test')


//Enter email address
WebUI.setText(findTestObject('Signup Page/Email'), IDmail)

//Enter Phone number
//WebUI.setText(findTestObject('Signup Page/Phone'), '0109001')

//Enter Country: Open the country dropdown, select United States
WebUI.click(findTestObject('Signup Page/Country button'))
driver.findElement(By.xpath('//div[contains(text(),"United States")]')).click()

//Enter State
//WebUI.setText(findTestObject('Signup Page/State'), "NY")

//Enter City
//WebUI.setText(findTestObject('Signup Page/City'), "New York")

//enter Street address
//WebUI.setText(findTestObject('Signup Page/Street'), "123 St.")

//Enter Postal code
//WebUI.setText(findTestObject('Signup Page/PostCode'), "8888")

//Enter Password
WebUI.setMaskedText(findTestObject('Signup Page/Password'), "dqr-private.com")

//Enter Confirm Password
WebUI.setMaskedText(findTestObject('Signup Page/Confirm Password'), "dqr-private.com")

WebUI.delay(3)

//Check Terms of Use checkbox
driver.findElement(By.xpath("//form/div[9]/div[1]/div/div[1]/div/div/label/div")).click();

//Check Private Policy checkbox
driver.findElement(By.xpath('//form/div[9]/div[1]/div/div[2]/div/div/label/div')).click()

//Check Years older checkbox
driver.findElement(By.xpath('//form/div[9]/div[1]/div/div[3]/div/div/label/div')).click()

//Click Signup
WebUI.click(findTestObject('Signup Page/Signup button'))

//Validation 1: Box with data
WebUI.verifyElementPresent(findTestObject('Signup Page/Signup Success Box'), 10)

//Validation 2: Confirm Email hyperlink 
WebUI.verifyElementPresent(findTestObject('Signup Page/ReqConfirm Link'), 3)


