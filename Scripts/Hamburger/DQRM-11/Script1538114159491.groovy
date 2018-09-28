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
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger

WebUI.openBrowser('')

//Call valid login custom keyword
CustomKeywords.'utility.login.validLogin'()

WebUI.delay(15)


//Initializing webdriver script
WebDriver driver = DriverFactory.getWebDriver()


WebUI.click(findTestObject('Traderoom/Hamburger'))

WebUI.verifyElementVisible(findTestObject('Traderoom/Order Book'))

WebUI.verifyElementVisible(findTestObject('Traderoom/Trade History'))

WebUI.verifyElementVisible(findTestObject('Traderoom/Depth Chart'))

WebUI.verifyElementVisible(findTestObject('Traderoom/Price Chart'))

WebUI.verifyElementVisible(findTestObject('Traderoom/Order Form'))


WebUI.delay(8)

//Select DropDown Blocks
WebElement OrderBook = driver.findElement(By.xpath("//*[@data-id='orderBook']"))
OrderBook.click()

	if (WebUI.verifyElementNotPresent(findTestObject('Traderoom/Order Book'),10)){
	
	KeywordUtil.markPassed("Passed:Order Book is not visible")
	
		}


WebElement TradeHistory = driver.findElement(By.xpath("//*[@data-id='tradeHistory']"))
TradeHistory.click()
	 
	if (WebUI.verifyElementNotPresent(findTestObject('Traderoom/Trade History'),10)){
		 
	KeywordUtil.markPassed("Passed:Trade History is not visible")
	 
	}
	
WebElement DepthChart = driver.findElement(By.xpath("//*[@data-id='depthChart']"))
	DepthChart.click()
		  
	if (WebUI.verifyElementNotPresent(findTestObject('Traderoom/Depth Chart'),10)){
			  
	KeywordUtil.markPassed("Passed:Depth Chart is not visible")
		  
	}

		 
WebElement PriceChart = driver.findElement(By.xpath("//*[@data-id='priceChart']"))
	PriceChart.click()
			   
	if (WebUI.verifyElementNotPresent(findTestObject('Traderoom/Price Chart'),10)){
				   
	 KeywordUtil.markPassed("Passed:Price Chart is not visible")
			   
	}
	
	 
WebElement OrderForm = driver.findElement(By.xpath("//*[@data-id='orderForm']"))
	 OrderForm.click()
						  
	if (WebUI.verifyElementNotPresent(findTestObject('Traderoom/Order Form'),10)){
							  
	KeywordUtil.markPassed("Passed: Order Form is not visible")
						  
	}