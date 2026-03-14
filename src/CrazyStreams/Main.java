package CrazyStreams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(
                1L,
                "Rishabh",
                "Verma",
                "rishabh@gmail.com",
                true,
                new BigDecimal("5000"),
                LocalDate.of(1998, Month.JANUARY, 10),
                LocalDate.of(2023, Month.MARCH, 5)
        ));

        accounts.add(new Account(
                2L,
                "Amit",
                "Sharma",
                "amit@yahoo.com",
                true,
                new BigDecimal("17000"),
                LocalDate.of(1997, Month.FEBRUARY, 12),
                LocalDate.of(2022, Month.JULY, 20)
        ));

        accounts.add(new Account(
                3L,
                "Priya",
                "Singh",
                "priya@gmail.com",
                false,
                new BigDecimal("9000"),
                LocalDate.of(1999, Month.JANUARY, 25),
                LocalDate.of(2023, Month.JANUARY, 15)
        ));

        CrazyStreams crazyStreams = new CrazyStreams(accounts);

        // richest account
        System.out.println("Richest Person:");
        System.out.println(crazyStreams.findRichestPerson());

        // accounts born in January
        System.out.println("\nAccounts born in January:");
        System.out.println(crazyStreams.findAccountsByBirthdayMonth(Month.JANUARY));

        // partition male / female
        System.out.println("\nMale / Female Partition:");
        System.out.println(crazyStreams.partitionMaleAccounts());

        // group by email domain
        System.out.println("\nAccounts by Email Domain:");
        System.out.println(crazyStreams.groupAccountsByEmailDomain());

        // number of letters
        System.out.println("\nTotal letters in names:");
        System.out.println(crazyStreams.getNumOfLettersInFirstAndLastNames());

        // total balance
        System.out.println("\nTotal Balance:");
        System.out.println(crazyStreams.calculateTotalBalance());

        // sorted accounts
        System.out.println("\nSorted Accounts:");
        System.out.println(crazyStreams.sortByFirstAndLastNames());

        // email domain exists
        System.out.println("\nContains gmail domain:");
        System.out.println(crazyStreams.containsAccountWithEmailDomain("gmail.com"));

        // balance by email
        System.out.println("\nBalance by Email:");
        System.out.println(crazyStreams.getBalanceByEmail("priya@gmail.com"));

        // collect by id
        System.out.println("\nAccounts by ID:");
        System.out.println(crazyStreams.collectAccountsById());

        // balances by email for accounts created in 2023
        System.out.println("\nBalances of accounts created in 2023:");
        System.out.println(crazyStreams.collectBalancesByEmailForAccountsCreatedOn(2023));

        // group first names by last name
        System.out.println("\nFirst names grouped by last name:");
        System.out.println(crazyStreams.groupFirstNamesByLastNames());

        // first names by birthday month
        System.out.println("\nFirst names by birthday month:");
        System.out.println(crazyStreams.groupCommaSeparatedFirstNamesByBirthdayMonth());

        // balance by creation month
        System.out.println("\nTotal balance by creation month:");
        System.out.println(crazyStreams.groupTotalBalanceByCreationMonth());

        // character frequency
        System.out.println("\nCharacter frequency in first names:");
        System.out.println(crazyStreams.getCharacterFrequencyInFirstNames());

        // character frequency ignoring case
        System.out.println("\nCharacter frequency ignoring case:");
        System.out.println(crazyStreams.getCharacterFrequencyIgnoreCaseInFirstAndLastNames(3));
    }
}
