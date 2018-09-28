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

//Click the Plus button
WebUI.click(findTestObject('Top Bar/Plus Button'))

//Count the number of items
int currency_count = driver.findElements(By.xpath('//div[@class="css-982a56"]//div[@class="css-zg6z2o"]/div')).size()
println('No. of currencies: '+ currency_count)

//Click on each item button
for(i=1;i<=currency_count;i++){
	WebElement select = driver.findElement(By.xpath('//div[@class="css-982a56"]//div[@class="css-zg6z2o"]/div['+i+']'))
	select.click()
	
	String selected = driver.findElement(By.xpath('//div[@class="css-982a56"]//div[@class="css-zg6z2o"]/div['+i+']')).getAttribute('data-id')
	println("Selected currency: " + selected)
	
	WebUI.click(findTestObject("Top Bar/Plus Button"))
	
	//Verify if selected item is displayed in the top left corner
	String topleft_txt = driver.findElement(By.xpath('//div[@class="css-tju6rs"]/span')).getText()
	
	if(topleft_txt.contains(selected)){
		log.logPassed("PASSED: Top Left text is correct")
	}
	else{
		log.logFailed("FAILED: Top Left text is incorrect")
	}
	
	WebUI.click(findTestObject('Top Bar/Plus Button'))
	
}



