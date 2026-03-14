package CrazyStreams;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean male;
    private BigDecimal balance;
    private LocalDate birthday;
    private LocalDate creationDate;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", male=" + male +
                ", balance=" + balance +
                ", birthday=" + birthday +
                ", creationDate=" + creationDate +
                '}';
    }

    public Account(Long id, String firstName, String lastName, String email,
                   boolean male, BigDecimal balance, LocalDate birthday, LocalDate creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.male = male;
        this.balance = balance;
        this.birthday = birthday;
        this.creationDate = creationDate;
    }

    public Account() {
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isMale() {
        return male;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
