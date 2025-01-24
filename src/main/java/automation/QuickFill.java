package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickFill {
	
	static WebDriver driver = new FirefoxDriver();
	
	
	public void launch() throws Throwable {
		// Launch url
		driver.get("https://myapplication.leedsbeckett.ac.uk/SignIn?ReturnUrl=%2F");
		Thread.sleep(3000);
		
	}
	
	
	public void createAccount(Boolean a) {
		if (a) {
			driver.findElement(By.xpath("//a[normalize-space()='Create Account']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kycivy@logsmarter.net");		
			driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Qkycivy@logsmarter.net");
			driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Qkycivy@logsmarter.net");
			driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		}
	}

	
	public void login () {
		try {
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("qylilubu@asciibinder.net");		
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Qqylilubu@asciibinder.net");
			driver.findElement(By.xpath("//button[@id='submit-signin-local']")).click();
			Thread.sleep(5000);
		} 
		catch (Exception e) {
			System.out.println("An error occur" + e.getMessage());
		}		
	}
	
	
	public void profileFill() throws Throwable {
		WebElement title = driver.findElement(By.id("py3ip_fnd_title")); // Dropdown Element
		Select selectTitle = new Select(title);	// Select class variable
		selectTitle.selectByVisibleText("Mr");	// Title
		driver.findElement(By.xpath("//input[@aria-describedby='birthdate_description']")).sendKeys("30/06/2005");	// DOB
		driver.findElement(By.xpath("//input[@title='First Name is a required field.']")).sendKeys("RahuL");	// First Name
		driver.findElement(By.xpath("//input[@title='Last Name is a required field.']")).sendKeys("RaJput");	// Last Name
		System.out.println(selectTitle.getFirstSelectedOption().getText());
		if (selectTitle.getFirstSelectedOption().getText().equals("Mr"))
		{
			//	Select the gender
			WebElement gender = driver.findElement(By.id("gendercode")); // Dropdown Element
			Select selectGender = new Select(gender); // Select class variable
			selectGender.selectByVisibleText("Man");  // Gender
		}
		else {
			//	Select the gender
			WebElement gender = driver.findElement(By.id("gendercode")); // Dropdown Element
			Select selectGender = new Select(gender); // Select class variable
			selectGender.selectByVisibleText("Woman");  // Gender
		}
		WebElement Country = driver.findElement(By.id("py3ip_app_countryofbirthid")); // Dropdown Element
		Select selectCountry = new Select(Country); // Select class variable
		selectCountry.selectByVisibleText("India");	// Country
		
		WebElement nationality = driver.findElement(By.id("py3ip_app_primarynationalityid")); // Dropdown Element
		Select selectNationality = new Select(nationality); // Select class variable
		selectNationality.selectByVisibleText("India");	// Nationality Country
		
		driver.findElement(By.xpath("//input[@value='Save & Return']")).click();

		Thread.sleep(3000);
	}
	
	
	public void createApplication() throws Throwable {
		driver.findElement(By.cssSelector("input[value='Create New Application']")).click();
		Thread.sleep(4000);
		WebElement pResidence = driver.findElement(By.id("py3_domicileid")); // Dropdown Element
		Select selectPresidence = new Select(pResidence); // Select class variable
		selectPresidence.selectByVisibleText("India");	// pResidence Country
		
		Thread.sleep(2000);
		WebElement ResidentialStatus = driver.findElement(By.id("py3ip_app_residentialstatus")); // Dropdown Element
		Select selectResidentialStatus = new Select(ResidentialStatus); // Select class variable
		selectResidentialStatus.selectByVisibleText("International (Overseas)");	// Residential Status
		
		driver.findElement(By.id("py3ip_app_passportnumber")).sendKeys("878785255511");	// Passport Number
		driver.findElement(By.xpath("(//input[@class='form-control' and @placeholder=\"dd/mm/yyyy\"])[3]")).sendKeys("30/06/2055");	// Passport Expiry

		Thread.sleep(2000);
		WebElement PassportCountry = driver.findElement(By.id("py3ip_app_passportcountryoforiginid")); // Dropdown Element
		Select selectPassportCountry = new Select(PassportCountry); // Select class variable
		selectPassportCountry.selectByVisibleText("India");	// Passport Country
		
		Thread.sleep(2000);
		WebElement CountryCode = driver.findElement(By.id("py3ip_fnd_mobilecallingcodeid")); // Dropdown Element
		Select selectCountryCode = new Select(CountryCode); // Select class variable
		selectCountryCode.selectByVisibleText("+91");	// Country Code
		
		driver.findElement(By.id("py3ip_fnd_contactmobilephone")).sendKeys("9109682215");	// Number

//		Thread.sleep(2000);
//		WebElement Ethnicity = driver.findElement(By.xpath("//select[contains(@id,'py3ip_fnd_ethnicityid')]")); // Dropdown Element
//		Select selectEthnicity = new Select(Ethnicity); // Select class variable
//		if (selectNationality.getFirstSelectedOption().getText().equals("India")) {
//			selectEthnicity.selectByVisibleText("Asian/Asian British - Indian"); // Ethnicity
//		}
//		else {
//			selectEthnicity.selectByVisibleText("Asian/Asian British - Indian"); // Ethnicity
//		}
		
		Thread.sleep(2000);
		WebElement HighestQualification = driver.findElement(By.id("py3_highestqualificationonentry")); // Dropdown Element
		Select selectHighestQualification = new Select(HighestQualification); // Select class variable
		selectHighestQualification.selectByVisibleText("Professional Graduate Certificate in Education");	// HighestQualification 
		
		Thread.sleep(2000);
		WebElement ImmigrationStatus = driver.findElement(By.id("py3_immigrationpermissiontostudyinuk")); // Dropdown Element
		Select selectImmigrationStatus = new Select(ImmigrationStatus); // Select class variable
		selectImmigrationStatus.selectByVisibleText("No");	// ImmigrationStatus
		if (selectImmigrationStatus.getFirstSelectedOption().getText().equals("No")) {
			WebElement ImmigrationStatusWhy = driver.findElement(By.id("py3_nopermissionsreqreason")); // Dropdown Element
			Select selectImmigrationStatusWhy = new Select(ImmigrationStatusWhy); // Select class variable
			selectImmigrationStatusWhy.selectByVisibleText("A member of my family is a British citizen");	// ImmigrationStatusWhy
		}
		else {
			// will do that
		}
		
		int agentInvolve = 0;
		if (agentInvolve == 0) {
			WebElement noAgentInvolve = driver.findElement(By.id("py3_isagentinvolved_0"));
			noAgentInvolve.click();
		}
		else {		
			WebElement yesAgentInvolve = driver.findElement(By.id("py3_isagentinvolved_1"));
			yesAgentInvolve.click();
		}
		
		driver.findElement(By.id("btnGoNext")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void addressFill() throws Throwable {
		WebElement Country1 = driver.findElement(By.id("py3ip_fnd_permcountryid")); // Dropdown Element
		Select selectCountry1 = new Select(Country1); // Select class variable
		selectCountry1.selectByVisibleText("India");	// ImmigrationStatusWhy
		driver.findElement(By.id("address1_postalcode")).sendKeys("9109");	// Postal code
		driver.findElement(By.id("address1_line1")).sendKeys("Indore Madhya Pradesh");	// Address
		driver.findElement(By.id("address1_city")).sendKeys("Indore");	// city
		driver.findElement(By.xpath("(//input[@class='form-control' and @placeholder=\"dd/mm/yyyy\"])[1]")).sendKeys("30/06/2005");	// From Date
		driver.findElement(By.xpath("(//input[@class='form-control' and @placeholder=\"dd/mm/yyyy\"])[2]")).sendKeys("30/06/2025");	// To Date
		driver.findElement(By.id("btnGoNext")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void programOfStudy() throws Throwable {
		WebElement StudyType = driver.findElement(By.id("ddlCourseType")); // Dropdown Element
		Select selectStudyType = new Select(StudyType); // Select class variable
		selectStudyType.selectByVisibleText("Undergraduate");	// StudyType
		Thread.sleep(2000);

		
		WebElement AcademicYearOfEntry = driver.findElement(By.id("ddlYearofEntry")); // Dropdown Element
		Select selectAcademicYearOfEntry = new Select(AcademicYearOfEntry); // Select class variable
		selectAcademicYearOfEntry.selectByVisibleText("2025/26 Autumn Entry");	// AcademicYearOfEntry
		Thread.sleep(2000);

		
		WebElement  DistanceLearning = driver.findElement(By.id("ddlDistanceLearning")); // Dropdown Element
		Select selectDistanceLearning = new Select(DistanceLearning); // Select class variable
		selectDistanceLearning.selectByVisibleText("No");	// DistanceLearning
		Thread.sleep(2000);

		
		WebElement  ModeofAttendance = driver.findElement(By.id("ddlModeOfAttendance")); // Dropdown Element
		Select selectModeofAttendance = new Select(ModeofAttendance); // Select class variable
		selectModeofAttendance.selectByVisibleText("Full Time");	// DistanceLearning
		Thread.sleep(2000);

		
		driver.findElement(By.id("txtCourseTitle")).sendKeys("Computer");
		driver.findElement(By.id("btnFindCourse")).click();
		Thread.sleep(15000);

		
		// Locate the table body
		WebElement courseTable = driver.findElement(By.tagName("tbody"));
		// Get all rows
		List<WebElement> rows = courseTable.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(1).findElements(By.tagName("td")); // Get columns of the target row
		System.out.println(columns.size());
		WebElement submitButton = columns.get(1).findElement(By.xpath("(//input[@id='lnkBtnSelect'])[1]"));
        // Wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        // Scroll into view and click the submit button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click(); // Click the submit button in the targeted row
		Thread.sleep(2000);

		
		driver.findElement(By.id("btnGoNext")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void acadmicQualification() throws Throwable {
		// clicking on add new button
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(3000);
				
		// dropdown element
		WebElement qualification =  driver.findElement(By.cssSelector("#py3_academicqualificationtype"));	
		// select class to interact with dropdown
		Select select = new Select(qualification);
		// Selecting by visible text
		select.selectByVisibleText("A Lvl Double Award (Reformed)");
		
		// dropdown element
		WebElement country = driver.findElement(By.xpath("//select[@id='ddlCountry']"));
		Select select1 = new Select(country);
		select1.selectByVisibleText("India");
		
		// Institute name
		driver.findElement(By.xpath("//input[@id='py3ip_app_centrename']")).sendKeys("IIST");
		
		// Title
		driver.findElement(By.xpath("//input[@id='py3ip_app_name']")).sendKeys("CSE");
		
		//Start Date
		driver.findElement(By.xpath("(//input[contains(@class,'form-control') and @placeholder=\"dd/mm/yyyy\"])[1]")).sendKeys("02/02/2024");
		
		boolean courseCompleted = false;
		if (courseCompleted) {
			// completion date
			driver.findElement(By.xpath("(//input[contains(@class,'form-control') and @placeholder=\"dd/mm/yyyy\"])[3]")).sendKeys("02/02/2025");
		}
		else {
			//End Date
			driver.findElement(By.xpath("(//input[contains(@class,'form-control') and @placeholder=\"dd/mm/yyyy\"])[2]")).sendKeys("02/02/2025");
		}
		
		// Predicted Grade
		driver.findElement(By.xpath("//input[@title='The predicted results for the qualification if known']")).sendKeys("7.9");
		
		Thread.sleep(2000);
		// File Upload
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(25000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void EnglishProficiency () throws Throwable {
		driver.findElement(By.xpath("//a[normalize-space()='Add New']")).click();
		
		WebElement QualificationType = driver.findElement(By.xpath("//select[@title='Choose your English language qualification from the list']"));
		Select selectQualificationType = new Select(QualificationType);
		selectQualificationType.selectByVisibleText("IELTS (International English Language Testing System)");
		
		driver.findElement(By.id("py3ip_app_centrename")).sendKeys("Indore center");
		driver.findElement(By.id("py3ip_app_languagecentrenumber")).sendKeys("912986881");
		driver.findElement(By.id("py3ip_app_reference")).sendKeys("45454545");
		Boolean englishCourseCompleted = false;
		if (englishCourseCompleted) {
			driver.findElement(By.id("//input[@value='1']")).click();
		}
		else {
			driver.findElement(By.id("py3ip_app_predictedgrade")).sendKeys("7.9");
			driver.findElement(By.xpath("//tbody/tr[10]/td[1]/div[2]/div[1]/input[1]")).sendKeys("02/02/2024");
			driver.findElement(By.xpath("//tbody/tr[11]/td[1]/div[2]/div[1]/input[1]")).sendKeys("04/05/2024");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void WorkExperience() throws Throwable {
		// Work Experience
		driver.findElement(By.xpath("(//a[normalize-space()='Add New Work Experience'])[1]")).click();
		driver.findElement(By.xpath("//input[@title='The name of your employer where you gained work experience']")).sendKeys("Admitkard");
		driver.findElement(By.xpath("//input[@title='Your job title at the above organisation']")).sendKeys("PQE");
		WebElement ExperienceType = driver.findElement(By.xpath("//select[@title='Please include relevant work experience gained, e.g, nursing, primary education.']"));
		Select selectExperienceType = new Select(ExperienceType);
		selectExperienceType.selectByVisibleText("Internship");
		
		WebElement WorkTime = driver.findElement(By.xpath("(//select[contains(@class,'form-control picklist')])[2]"));
		Select selectWorkTime = new Select(WorkTime);
		selectWorkTime.selectByVisibleText("Full Time");
		
		driver.findElement(By.xpath("//tbody/tr[5]/td[1]/div[2]/div[1]/input[1]")).sendKeys("18/12/2024");
		driver.findElement(By.xpath("//tbody/tr[6]/td[1]/div[2]/div[1]/input[1]")).sendKeys("18/7/2025");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void SupportingDocumentation() throws Throwable {
		driver.findElement(By.xpath("//textarea[@class='textarea form-control ']")).sendKeys("hello.............");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(5000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void References() throws Throwable {
		driver.findElement(By.xpath("//a[normalize-space()='Add New']")).click();
		WebElement RefreeTitle = driver.findElement(By.xpath("(//select[@required='required'])[1]"));
		Select selectRefreeTitle = new Select(RefreeTitle);
		selectRefreeTitle.selectByVisibleText("Mr");
		
		driver.findElement(By.xpath("//tbody/tr[4]/td[1]/div[2]/input[1]")).sendKeys("Jay");
		driver.findElement(By.xpath("//tbody/tr[5]/td[1]/div[2]/input[1]")).sendKeys("Malekar");
		driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("jay@gmail.com");

		WebElement RefereeType = driver.findElement(By.xpath("//select[@title='Please state if your referee is a doctor, teacher, employer etc']"));
		Select selectRefereeType = new Select(RefereeType);
		selectRefereeType.selectByVisibleText("Statement of Support");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void Funding() throws Throwable {
		WebElement FundingType = driver.findElement(By.xpath("//select[@class='form-control picklist ']"));
		Select selectFundingType = new Select(FundingType);
		selectFundingType.selectByVisibleText("Self Funded - myself or my family");	
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[2]/input[1]")).sendKeys("Father");
		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Indore Madhya Pradesh");
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("Indore");
		driver.findElement(By.xpath("(//input[@id='py3_sponsorpostcode'])[1]")).sendKeys("452009");
		
		WebElement FundingCountry = driver.findElement(By.xpath("//select[@id='py3_sponsorcountryid']")); // Dropdown Element
		Select selectFundingCountry = new Select(FundingCountry); // Select class variable
		selectFundingCountry.selectByVisibleText("India");	// Country
		
		WebElement CallingCode = driver.findElement(By.xpath("//select[@id='py3_sponsorcallingcodeid']")); // Dropdown Element
		Select selectCallingCode = new Select(CallingCode); // Select class variable
		selectCallingCode.selectByVisibleText("+91");	// Country Code
		
		driver.findElement(By.id("py3_sponsortelephone")).sendKeys("9109682215");	// Number
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("father@gmail.com");	// email
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Gi-Admin\\Documents\\Rahul Rajput Certificate.pdf");
		Thread.sleep(15000);
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void AdditionalStudySupportNeeds () throws Throwable {
		WebElement disabledPerson = driver.findElement(By.xpath("//select[@class='form-control picklist ']")); // Dropdown Element
		Select selectdisabledPerson = new Select(disabledPerson); // Select class variable
		selectdisabledPerson.selectByVisibleText("No");	// disabledPerson
		
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void ApplicantNominee() throws Throwable {
		driver.findElement(By.cssSelector("input[value='0'][type='radio']")).click();
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(3000);
	}
	
	
	public void ApplicationChecklist () throws Throwable {
		driver.findElement(By.id("NextButton")).click();	// go to next page
		Thread.sleep(5000);
	}
	
	
	public void ApplicationDeclaration() {
		
	}
	
	public void quit() {
		driver.quit();
	}
}
