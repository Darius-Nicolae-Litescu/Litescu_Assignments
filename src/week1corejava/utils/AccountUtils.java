package week1corejava.utils;

import week1corejava.entity.Account;
import week1corejava.entity.Policy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AccountUtils {

    public static Policy getMinimumAmountPolicyFromAccount(List<Policy> policies) {
        if (policies != null) {
            Optional<Policy> policyOptional = policies.stream()
                    .filter(policy -> policy != null)
                    .max((policy1, policy2) -> policy1.getSumAssuredAmount() - policy2.getSumAssuredAmount());
            if (policyOptional.isPresent()) {
                return policyOptional.get();
            } else {
                return null;
            }
        }
        return null;
    }

    public static boolean checkIfAnyPolicyIsNull(List<Policy> policies){
        return policies.stream().anyMatch((policy -> policy == null));

    }

    public static void increaseMedicalPolicyPriceByTenProcent(List<Policy> policies) {
        policies.stream()
                .filter(policy -> policy != null)
                .filter(policy -> policy.getPolicyName().startsWith("Medical"))
                .forEach(policy -> policy.setPremiumAmount(getPercentageFromNumber(policy.getPremiumAmount(), 110)));
    }

    public static boolean checkIfPolicyListContainsPolicyName(List<Policy> policies, String policyName) {
        return policies.stream()
                .anyMatch((policy -> policy.getPolicyName().equals(policyName)));
    }

    public static boolean checkIfPolicyListContainsPremiumAmount(List<Policy> policies, Integer premiumAmount) {
        return policies.stream()
                .anyMatch((policy -> policy.getPremiumAmount() == premiumAmount));
    }

    public static boolean checkIfAccountHasExpiredPremiumTime(Account account) {
        return account.getPolicies().stream()
                .filter(Objects::nonNull)
                .anyMatch((policy -> policy.getPremiumDate().compareTo(LocalDate.now()) < 0));
    }

    public static boolean checkIfAccountHasAnyNullPolicy(Account account) {
        return account.getPolicies().stream().anyMatch((policy -> policy == null));
    }

    public static int getPercentageFromNumber(int number, int procent) {
        int resultingNumber = (number / 100) * procent;
        System.out.println("Increased " + number + " to " + resultingNumber);
        return resultingNumber;
    }
}
