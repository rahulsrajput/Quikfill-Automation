package automation;

public class Runner {

	public static void main(String[] args) throws Throwable {		
		QuickFill quickfill = new QuickFill();
		quickfill.launch();
		quickfill.createAccount(true);
		quickfill.login();	
		quickfill.profileFill();
		quickfill.createApplication();
		quickfill.addressFill();
		quickfill.programOfStudy();
		quickfill.acadmicQualification();
		quickfill.EnglishProficiency();
		quickfill.WorkExperience();
		quickfill.SupportingDocumentation();
		quickfill.References();
		quickfill.Funding();
		quickfill.AdditionalStudySupportNeeds();
		quickfill.ApplicantNominee();
		quickfill.ApplicationChecklist();
		quickfill.ApplicationDeclaration();
		quickfill.quit();
		
	}

}
