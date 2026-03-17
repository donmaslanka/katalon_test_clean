import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String baseUrl = System.getenv('TARGET_URL') ?: 'https://jenkins2-usw2a.awsc.leadfusion.com/login'

WebUI.comment("Opening URL: ${baseUrl}")
WebUI.openBrowser('')
WebUI.setViewPortSize(1440, 900)
WebUI.navigateToUrl(baseUrl)
WebUI.waitForPageLoad(30)
WebUI.verifyMatch(WebUI.getUrl(), '.*login.*', true)
WebUI.verifyTextPresent('Sign in', false, FailureHandling.OPTIONAL)
WebUI.takeScreenshot()
WebUI.closeBrowser()
