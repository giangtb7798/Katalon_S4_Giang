package commons

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MakeAppointmentCommons {
	@Keyword
	public void inputAppointmentinfo(String facility, String applyHostpitalReadmission, String healthcareProgram, String visitDate, String comment) {
		WebUI.selectOptionByLabel(findTestObject('Page_MakeAppointment/select_Facility'), facility, false)

		if (Boolean.parseBoolean(applyHostpitalReadmission)) {
			WebUI.check(findTestObject('Page_MakeAppointment/input_ApplyHospitalReadmission'))
		}

		WebUI.check(findTestObject('Page_MakeAppointment/radio_HealthcareProgram', [('value') : healthcareProgram]))

		WebUI.sendKeys(findTestObject('Page_MakeAppointment/input_VisitDate'), visitDate)

		WebUI.sendKeys(findTestObject('Page_MakeAppointment/textarea_Comment'), comment)

		WebUI.click(findTestObject('Page_MakeAppointment/button_BookAppointment'))
	}

	@Keyword
	public void verifyAppointment(String facility, String applyHostpitalReadmission, String visitDate, String comment) {
		WebUI.verifyElementText(findTestObject('Page_Confirmation/p_facility'), facility)

		if (Boolean.parseBoolean(applyHostpitalReadmission)) {
			WebUI.verifyElementText(findTestObject('Page_Confirmation/p_hospital_readmission'), 'Yes')
		} else {
			WebUI.verifyElementText(findTestObject('Page_Confirmation/p_hospital_readmission'), 'No')
		}

		WebUI.verifyElementText(findTestObject('Page_Confirmation/p_visit_date'), visitDate)

		WebUI.verifyElementText(findTestObject('Page_Confirmation/p_comment'), comment)
	}
}
