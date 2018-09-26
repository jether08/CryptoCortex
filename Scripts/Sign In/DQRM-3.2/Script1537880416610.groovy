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
WebUI.navigateToUrl(GlobalVariable.LoginUrl)

WebUI.waitForPageLoad(15)

//1. EMPTY FIELDS VALIDATION
WebUI.click(findTestObject('Login Page/Sign in')) //Click Sign in button while fields are empty
WebUI.verifyTextPresent('Invalid credentials', true) //Verify error message

//2. INCORRECT USERNAME VALIDATION
WebUI.setText(findTestObject('Login Page/Username'), 'Tester1') //Enter incorrect username
WebUI.setText(findTestObject('Login Page/Password'), GlobalVariable.password) //Enter correct password
WebUI.click(findTestObject('Login Page/Sign in')) //Click Sign in button
WebUI.verifyTextPresent('Invalid credentials', true) //Verify error message

//3. INCORRECT PASSWORD VALIDATION
WebUI.setText(findTestObject('Login Page/Username'), GlobalVariable.username) //Enter correct username
WebUI.setText(findTestObject('Login Page/Password'), 'password123') //Enter incorrect password
WebUI.click(findTestObject('Login Page/Sign in')) //Click Sign in button
WebUI.verifyTextPresent('Invalid credentials', true) //Verify error message

