package CrazyStreams;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Why Optional?
Because the collection might be empty.
 */
public class CrazyStreams {

    private Collection<Account> accounts;

    public CrazyStreams(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    // richest account
    public Optional<Account> findRichestPerson() {
        return accounts.stream()
                .max((a1,a2)->a1.getBalance().compareTo(a2.getBalance()));
    }

    // accounts by birthday month
    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream()
                .filter(a -> a.getBirthday().getMonth().equals(birthdayMonth))
                .collect(Collectors.toList());
    }

    // partition male/female --
    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        return accounts.stream()
                .collect(Collectors.partitioningBy(a -> a.isMale()));
    }

    //  group by email domain
    public Map<String, List<Account>> groupAccountsByEmailDomain() {
        return accounts.stream()
                .collect(Collectors.groupingBy(a ->
                        a.getEmail().substring(a.getEmail().indexOf("@") + 1)
                ));
    }

    // 5️ number of letters in first + last names
    public int getNumOfLettersInFirstAndLastNames() {
        return accounts.stream()
                .mapToInt(a -> a.getFirstName().length() + a.getLastName().length())
                .sum();
    }

    // 6️ total balance
    public BigDecimal calculateTotalBalance() {
        return accounts.stream()
                .map(a -> a.getBalance())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    // 7️sort by first and last names
    public List<Account> sortByFirstAndLastNames() {
        return accounts.stream()
                .sorted(Comparator
                        .comparing((Account a) -> a.getFirstName())
                        .thenComparing(a -> a.getLastName()))
                .collect(Collectors.toList());
    }

    // 8️check email domain exists
    public boolean containsAccountWithEmailDomain(String emailDomain) {
        return accounts.stream()
                .anyMatch(a -> a.getEmail().endsWith(emailDomain));
    }

    //  get balance by email
    public BigDecimal getBalanceByEmail(String email) {
        return accounts.stream()
                .filter(a -> a.getEmail().equals(email))
                .map(a -> a.getBalance())
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Cannot find Account by email=" + email));
    }

    //  map account by id
    public Map<Long, Account> collectAccountsById() {
        return accounts.stream()
                .collect(Collectors.toMap(a -> a.getId(), a -> a));
    }

    //  balances by email for accounts created in year
    public Map<String, BigDecimal> collectBalancesByEmailForAccountsCreatedOn(int year) {
        return accounts.stream()
                .filter(a -> a.getCreationDate().getYear() == year)
                .collect(Collectors.toMap(a -> a.getEmail(), a -> a.getBalance()));
    }

    //  group first names by last name
    public Map<String, Set<String>> groupFirstNamesByLastNames() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getLastName(),
                        Collectors.mapping(a -> a.getFirstName(), Collectors.toSet())
                ));
    }

    //  comma separated first names by birthday month
    public Map<Month, String> groupCommaSeparatedFirstNamesByBirthdayMonth() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getBirthday().getMonth(),
                        Collectors.mapping(a -> a.getFirstName(),
                                Collectors.joining(", "))
                ));
    }

    //  total balance by creation month
    public Map<Month, BigDecimal> groupTotalBalanceByCreationMonth() {
        return accounts.stream()
                .collect(Collectors.groupingBy(
                        a -> a.getCreationDate().getMonth(),
                        Collectors.mapping(a -> a.getBalance(),
                                Collectors.reducing(BigDecimal.ZERO, (x, y) -> x.add(y)))
                ));
    }

    //  character frequency in first names
    public Map<Character, Long> getCharacterFrequencyInFirstNames() {
        return accounts.stream()
                .flatMap(a -> a.getFirstName().chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // character frequency ignoring case
    public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames(int nameLengthBound) {
        return accounts.stream()
                .flatMap(a -> Stream.of(a.getFirstName(), a.getLastName()))
                .filter(name -> name.length() >= nameLengthBound)
                .flatMap(name -> name.toLowerCase()
                        .chars()
                        .mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
