package week1corejava.repository;


import week1corejava.entity.Account;
import week1corejava.exception.AccountNotFoundException;
import week1corejava.utils.*;
import java.util.*;
import java.util.stream.Collectors;


public class RepositoryImpl implements Repository {
    private final Map<Integer, Account> accountMap;

    public RepositoryImpl() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    @Override
    public void updateAccount(Account account) {
        Account existingAccount = accountMap.get(account.getAccountNumber());
        existingAccount.setAccountHolderName(account.getAccountHolderName());
        existingAccount.setBalance(account.getBalance());
        existingAccount.setPolicies(account.getPolicies());
        existingAccount.setContactDetails(account.getContactDetails());
        existingAccount.setAccountHolderName(account.getAccountHolderName());
    }

    @Override
    public void deleteAccount(Integer id) throws AccountNotFoundException {
        if (accountMap.containsKey(id)) {
            accountMap.remove(id);
        } else {
            throw new AccountNotFoundException();
        }
    }

    @Override
    public Account getAccount(Integer id) throws AccountNotFoundException {
        if (accountMap.containsKey(id)) {
            return accountMap.get(id);
        } else {
            throw new AccountNotFoundException();
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<Account>(accountMap.values());

    }

    @Override
    public void updateAccountEmail(Integer accountNumber, String email) {
        Account existingAccount = accountMap.get(accountNumber);
        existingAccount.getContactDetails().setEmail(email);
    }

    @Override
    public Account displayMaximumAssuredSumAccount() {
        List<Account> accountList = new ArrayList<>(accountMap.values());
        Optional<Account> account = accountList.stream()
                .filter(account1 -> AccountUtils.checkIfAnyPolicyIsNull(account1.getPolicies()))
                .min((account1, account2) -> {
                    return AccountUtils.getMinimumAmountPolicyFromAccount(account1.getPolicies()).getSumAssuredAmount() -
                            AccountUtils.getMinimumAmountPolicyFromAccount(account2.getPolicies()).getSumAssuredAmount();
                });
        if (account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }

    @Override
    public void updateAllMedicalPoliciesByTenProcent() {
        accountMap.values().stream().forEach(account -> AccountUtils.increaseMedicalPolicyPriceByTenProcent(account.getPolicies()));
    }

    @Override
    public List<Account> filterAccountsBasedOnStateAndPolicyName(String state, String policyName) {
        List<Account> accountList = new ArrayList<>(accountMap.values());
        return accountList.stream().filter((account -> {
            return account.getContactDetails().getState().equals(state) && AccountUtils.checkIfPolicyListContainsPolicyName(account.getPolicies(), policyName);
        })).collect(Collectors.toList());
    }


    @Override
    public List<Account> filterAccountsBasedOnStateAndPremiumAmount(String state, Integer premiumAmount) {
        List<Account> accountList = new ArrayList<>(accountMap.values());
        return accountList.stream().filter((account -> {
            return account.getContactDetails().getState().equals(state) && AccountUtils.checkIfPolicyListContainsPremiumAmount(account.getPolicies(), premiumAmount);
        })).collect(Collectors.toList());
    }

    @Override
    public Long countAccountWherePremiumDateIsOver(){
        List<Account> accountList = new ArrayList<>(accountMap.values());
        return accountList.stream().filter((account -> AccountUtils.checkIfAccountHasExpiredPremiumTime(account))).count();
    }

    @Override
    public Set<String> storeAccountEmailInSetStringWherePolicyIsNull(){
        List<Account> accountList = new ArrayList<>(accountMap.values());
        return accountList.stream()
                .filter(account -> AccountUtils.checkIfAccountHasAnyNullPolicy(account))
                .map(account -> account.getContactDetails().getEmail())
                .collect(Collectors.toSet());
    }
}
