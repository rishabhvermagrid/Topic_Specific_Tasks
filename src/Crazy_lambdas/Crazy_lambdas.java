package Crazy_lambdas;

import java.util.*;

class Account{
    private int ac_no;
    private String name;

    public int getAc_no() {
        return ac_no;
    }

    public void setAc_no(int ac_no) {
        this.ac_no = ac_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account(String name, int ac_no) {
        this.ac_no = ac_no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{ac_no=" + ac_no + ", name='" + name + "'}";
    }
}
public class Crazy_lambdas {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Anjali",111));
        accounts.add(new Account("Dinesh",121));
        accounts.add(new Account("Mahesh",141));
        accounts.add(new Account("Mukesh",211));
        accounts.add(new Account("Rishabh",101));
        /*
        Collections.sort(accounts,new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        */

        //simplified using lambda expression
        accounts.sort((a1, a2) -> a1.getName().compareTo(a2.getName()));

        System.out.println(accounts);
    }
}
/*
Collections.sort() requires two parameters when using a Comparator:
Collections.sort(List<T> list, Comparator<? super T> c)

Java prints objects using their toString() method. Since your Account class does not
override toString(), the output will look something like
[Account@3f99bd52, Account@4f023edb, Account@3a71f4dd ...]

These are just memory references, not the actual data.
 */