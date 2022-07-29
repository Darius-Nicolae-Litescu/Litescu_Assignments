package week1corejava.service;

import week1corejava.entity.Account;
import week1corejava.exception.AccountNotFoundException;
import week1corejava.repository.Repository;

import java.util.List;
import java.util.Set;

public class ServiceImpl implements Service {

    private final Repository repository;

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }


    @Override
    public void addAccount(Account account) {
        repository.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        repository.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) throws AccountNotFoundException {
        repository.deleteAccount(id);
    }

    @Override
    public Account getAccount(Integer id) throws AccountNotFoundException {
        return repository.getAccount(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return repository.getAllAccounts();
    }

    @Override
    public void updateAccountEmail(Integer accountNumber, String email) {
        repository.updateAccountEmail(accountNumber, email);
    }

    @Override
    public Account displayMaximumAssuredSumAccount() {
        return repository.displayMaximumAssuredSumAccount();
    }

    @Override
    public void updateAllMedicalPoliciesByTenProcent() {
        repository.updateAllMedicalPoliciesByTenProcent();
    }

    @Override
    public List<Account> filterAccountsBasedOnStateAndPolicyName(String state, String policyName) {
        return repository.filterAccountsBasedOnStateAndPolicyName(state, policyName);
    }

    @Override
    public List<Account> filterAccountsBasedOnStateAndPremiumAmount(String state, Integer premiumAmount) {
        return repository.filterAccountsBasedOnStateAndPremiumAmount(state, premiumAmount);
    }

    @Override
    public Long countAccountWherePremiumDateIsOver() {
        return repository.countAccountWherePremiumDateIsOver();
    }

    @Override
    public Set<String> storeAccountEmailInSetStringWherePolicyIsNull() {
        return repository.storeAccountEmailInSetStringWherePolicyIsNull();
    }
}
