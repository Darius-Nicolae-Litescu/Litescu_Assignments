package week1corejava.repository;

import week1corejava.entity.Account;
import week1corejava.exception.AccountNotFoundException;

import java.util.List;
import java.util.Set;

public interface Repository {
    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id) throws AccountNotFoundException;

    Account getAccount(Integer id)  throws AccountNotFoundException;

    List<Account> getAllAccounts();


    void updateAccountEmail(Integer accountNumber, String email);

    Account displayMaximumAssuredSumAccount();

    void updateAllMedicalPoliciesByTenProcent();

    List<Account> filterAccountsBasedOnStateAndPolicyName(String state, String policyName);

    List<Account> filterAccountsBasedOnStateAndPremiumAmount(String state, Integer premiumAmount);

    Long countAccountWherePremiumDateIsOver();

    Set<String> storeAccountEmailInSetStringWherePolicyIsNull();
}
