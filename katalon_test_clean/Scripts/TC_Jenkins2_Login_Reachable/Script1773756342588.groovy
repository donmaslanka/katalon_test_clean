import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://jenkins2-usw2a.awsc.leadfusion.com/login')

WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(findTestObject('Page_Jenkins/input_Username'), 10)
WebUI.verifyElementPresent(findTestObject('Page_Jenkins/input_Password'), 10)
WebUI.verifyElementPresent(findTestObject('Page_Jenkins/button_SignIn'), 10)

WebUI.closeBrowser()