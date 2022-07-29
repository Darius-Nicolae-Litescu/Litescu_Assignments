package week1corejava;

import week1corejava.entity.Account;
import week1corejava.entity.ContactDetails;
import week1corejava.entity.Policy;
import week1corejava.repository.Repository;
import week1corejava.repository.RepositoryImpl;
import week1corejava.service.Service;
import week1corejava.service.ServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainRunner {
	private static MainRunner mainRunner = new MainRunner();
	private final UI application;

	MainRunner() {
		Repository repository = new RepositoryImpl();
		Service service = new ServiceImpl(repository);
		application = new UI(service);
	}
	/*   
	 *   Requirement (to be done by stream API only )
	 *   1. Update email on the basis of accountNumber  
	 *   2. display Account based on maximum sumAssuredAmount
	 *   3. update premium amount of all medical policies by 10%
	 *   4. filter accounts based on following 
	 *      4.a) state and policyname
	 *      4.b) state and premiumAmount (higher than certain amount) and total balance
	 *   5. count accounts where premium date is over
	          Note :- use setter method to Set premium date 
			     LocalDate.of()  // is used to create date 
				 LocalDate.now() // is used to get current date
	 *   6. Store account's email in a Set<String> where policy is null
	 *	 
	 *   Note:- Add couple of more records based on requirement
	 * */

	public static void main(String[] args) {

		Policy p1 = new Policy(new Random().nextInt(6000), "Medical Policy-1", 2000, 1500000, LocalDate.of(2015,4,2));
		Policy p2 = new Policy(new Random().nextInt(6000), "Car Policy-1", 2000, 1500000, LocalDate.of(2018,7,2));
		Policy p3 = new Policy(new Random().nextInt(6000), "Medical Policy-2", 2500, 1800000, LocalDate.of(2019,5,2));
		Policy p4 = new Policy(new Random().nextInt(6000), "Term Policy-1", 2000, 15000000, LocalDate.of(2027,8,2));
		Policy p5 = null;

		ContactDetails c1 = new ContactDetails("123-New Delhi", "Delhi", 1212122, "abc@enterprise.com");
		ContactDetails c2 = new ContactDetails("454-New Delhi", "Delhi", 45412122, "xyz@enterprise.com");
		ContactDetails c3 = new ContactDetails("A1-Gurgoan", "Delhi-NCR", 45412122, "a@enterprise.com");
		ContactDetails c4 = new ContactDetails("A2-Gurgoan", "Delhi-NCR", 45412122, "Enterprise@enterprise.com");
		ContactDetails c5 = new ContactDetails("A3-Gurgoan", "Delhi-NCR", 45412122, "darius@mail.dao");


		addAccount(1, "Ramesh", Arrays.asList(p1, p2, p3), 5000, c1);
		addAccount(2, "Mike", Arrays.asList(p1, p4), 15000, c2);
		addAccount(3, "Kirti", Arrays.asList(p1), 25000, c3);
		addAccount(4, "Enterprise", Arrays.asList(p4), 17000, c4);
		addAccount(4, "Darius", Arrays.asList(p5), 17000, c5);

		updateEmailOnAccountNumber();

		displayMaximumAssuredSumAccount();

		updateAllMedicalPoliciesByTenProcent();

		filterAccountsBasedOnStateAndPolicyName();

		filterAccountsBasedOnStateAndPremiumAmount();

		countAccountWherePremiumDateIsOver();

		storeAccountEmailInSetStringWherePolicyIsNull();
	}

	//*   1. Update email on the basis of accountNumber
	public static void updateEmailOnAccountNumber() {
		System.out.println("------ updateEmailOnAccountNumber");
		Integer accountNumber = 1;
		System.out.println("\n");
		mainRunner.application.getAccount(accountNumber);
		mainRunner.application.updateAccountEmail(accountNumber, "new Email@email.com");
		mainRunner.application.getAccount(accountNumber);
	}

	//*   2. display Account based on maximum sumAssuredAmount
	public static void displayMaximumAssuredSumAccount() {
		System.out.println("------ displayMaximumAssuredSumAccount");
		mainRunner.application.displayMaximumAssuredSumAccount();
	}

	//* 3. update premium amount of all medical policies by 10%
	public static void updateAllMedicalPoliciesByTenProcent() {
		System.out.println("------ updateAllMedicalPoliciesByTenProcent");
		System.out.println("------ before 10% increase");
		mainRunner.application.getAllAccounts();
		mainRunner.application.updateAllMedicalPoliciesByTenProcent();
		System.out.println("------ after 10% increase");
		mainRunner.application.getAllAccounts();

	}

	//*   4. filter accounts based on following
	//	 *      4.a) state and policyname
	//	 *      4.b) state and premiumAmount (higher than certain amount) and total balance

	public static void filterAccountsBasedOnStateAndPolicyName(){
		System.out.println("------ filterAccountsBasedOnStateAndPolicyName");
		mainRunner.application.filterAccountsBasedOnStateAndPolicyName("Delhi", "Medical Policy-2");

	}

	public static void filterAccountsBasedOnStateAndPremiumAmount(){
		System.out.println("------ filterAccountsBasedOnStateAndPremiumAmount");
		mainRunner.application.filterAccountsBasedOnStateAndPremiumAmount("Delhi", 2000);

	}

	/*   5. count accounts where premium date is over
	          Note :- use setter method to Set premium date
			     LocalDate.of()  // is used to create date
				 LocalDate.now() // is used to get current date
 	*/

	public static void countAccountWherePremiumDateIsOver(){
		System.out.println("------ countAccountWherePremiumDateIsOver");
		mainRunner.application.countAccountWherePremiumDateIsOver();

	}

	/*
	 *   6. Store account's email in a Set<String> where policy is null
	 */

	public static void storeAccountEmailInSetStringWherePolicyIsNull(){
		System.out.println("------ storeAccountEmailInSetStringWherePolicyIsNull");
		mainRunner.application.storeAccountEmailInSetStringWherePolicyIsNull();
	}

	public static void addAccount(Integer accountNumber, String name, List<Policy> policyList, int balance, ContactDetails contactDetails) {
		Account account = new Account(accountNumber, name, balance, policyList, contactDetails);
		mainRunner.application.addAccount(account);
	}

}
