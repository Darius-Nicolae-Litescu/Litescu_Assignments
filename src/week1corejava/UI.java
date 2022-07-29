package week1corejava;

import week1corejava.entity.Account;
import week1corejava.exception.AccountNotFoundException;
import week1corejava.service.Service;

import java.util.List;
import java.util.Set;

public class UI {

    private final Service service;

    public UI(Service service) {
        this.service = service;
    }

    public void addAccount(Account account) {
        service.addAccount(account);
        System.out.println(account + " | added");
    }

    public void updateAccount(Account account) {
        service.updateAccount(account);
        System.out.println(account + " | update");
    }

    public void updateAccountEmail(Integer accountNumber, String email) {
        service.updateAccountEmail(accountNumber, email);
        System.out.println(accountNumber + " | update email");
    }

    public void deleteAccount(Integer id) {
        try {
            service.deleteAccount(id);
            System.out.println(id + " | deleted");
        } catch (AccountNotFoundException exception) {
            System.out.println("User with id:" + id + " not found");
        }
    }

    public void getAccount(Integer id) {
        try {
            Account account = service.getAccount(id);
            System.out.println(account + " | get");
        } catch (AccountNotFoundException exception) {
            System.out.println("User with id:" + id + " not found");
        }
    }

    public void displayMaximumAssuredSumAccount(){
        Account account = service.displayMaximumAssuredSumAccount();
        System.out.println("Maximum assured sum account is " + account);
    }

    public void filterAccountsBasedOnStateAndPolicyName(String state, String policyName){
        List<Account> accounts = service.filterAccountsBasedOnStateAndPolicyName(state, policyName);
        System.out.println(accounts);
    }

    public void filterAccountsBasedOnStateAndPremiumAmount(String state, Integer premiumAmount){
        List<Account> accounts = service.filterAccountsBasedOnStateAndPremiumAmount(state, premiumAmount);
        System.out.println(accounts);
    }

    public void countAccountWherePremiumDateIsOver(){
        Long numberOfAccounts = service.countAccountWherePremiumDateIsOver();
        System.out.println("Number of account where Premium date is over: " + numberOfAccounts );
    }
    public void updateAllMedicalPoliciesByTenProcent() {
        service.updateAllMedicalPoliciesByTenProcent();
    }

    public void storeAccountEmailInSetStringWherePolicyIsNull(){
        Set<String> accountsWithAnyNullPolicy = service.storeAccountEmailInSetStringWherePolicyIsNull();
        System.out.println(accountsWithAnyNullPolicy);
    }

    public void getAllAccounts() {
        List<Account> accounts = service.getAllAccounts();
        System.out.println(accounts + " | all accounts");
    }


}
