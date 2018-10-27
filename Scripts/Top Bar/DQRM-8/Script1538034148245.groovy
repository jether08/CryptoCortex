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

//Call valid login keyword
CustomKeywords.'utility.login.validLogin'()

//Initializing webdriver script
WebDriver driver = DriverFactory.getWebDriver()

WebUI.delay(20)

//Create a collection for all currencies in the top bar
List <WebElement> collection = driver.findElements(By.xpath("//*[@class='css-lzlahb']/div"))

int count = collection.size()
println(count)


for(int i=1;i<=count;i++) {
	
//Select the currency
WebElement selectCoin = driver.findElement(By.xpath("//*[@class='css-lzlahb']/div["+i+"]"))
selectCoin.click()

 
//Get what the currency is
String coin = selectCoin.getText()
println(coin)


WebElement ChartingHeader = driver.findElement(By.xpath("//*[@class='css-1i244z1']"))
String header = ChartingHeader.getText() 
println(header)



	if (coin.contains(header)){
		KeywordUtil.markPassed("Passed: Top selected coin is same with charting header")

		}

	else{	
		KeywordUtil.markFailed("Failed")
	
		}
}



