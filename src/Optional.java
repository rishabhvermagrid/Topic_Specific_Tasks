public class Optional {

}
/*
Pattern 1 — orElseThrow() (Most Common)

Used when data must exist.

Example: Fetch user by ID.

User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found"));

Flow:

findById()
   ↓
Optional<User>
   ↓
if present → return user
if empty → throw exception
Why this is used

Instead of:

User user = userRepository.findById(id);

if(user == null){
    throw new UserNotFoundException();
}

We write:

userRepository.findById(id).orElseThrow(...)

Cleaner and safer.


Pattern 3 — ifPresent() (Execute Code)

Used when you want to run code only if value exists.

Example:

userRepository.findById(id)
        .ifPresent(user -> sendEmail(user));

Meaning:

If user exists → send email
If user missing → do nothing


What map() Means in Optional

map() means:

If value exists → transform it
If value missing → keep it empty

Signature:

Optional<U> map(Function<T, U> mapper)

Meaning:

Optional<T> → Optional<U>
2️⃣ Simple Example

Suppose we have:

Optional<Account> accountOpt = Optional.of(account);

And the account:

Account
  firstName = "Rishabh"
  balance = 5000

Now we want just the balance.

Without map():

if(accountOpt.isPresent()){
    BigDecimal balance = accountOpt.get().getBalance();
}

With map():

Optional<BigDecimal> balance =
        accountOpt.map(a -> a.getBalance());


 */
