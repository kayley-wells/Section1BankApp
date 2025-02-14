/**
 * The default constructor sets a unique account id based on the last account id and also sets all the intial values for instance field levels.
 */
public class Account {

    /**
     * The account owner's first and last name.
     */
    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName) {
    }

    /**
     * The current account balance.
     */
    private double balance;

    /**
     * Class variable for maintaining the last account number used.
     */
    private static int lastID = 0;

    /**
     * The unique account number assigned by the default constructor.
     */
    private int id;

    public Account() {
        id = ++lastID;
    }

    public int getID() {
        return id;

    }

    /**
     * Allow retrieval of the current account balance.
     *
     * @return The current account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Allow setting the account owner's first name but only if it's not blank.
     * @param firstName The account owner's first name.
     * @throws IllegalArgumentException Invalid first name! First name can't be null or empty for id: 1
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("Invalid first name! Name can't be blank for id: " + id);
        else
            this.firstName = firstName;


    }

    /**
     * Allow setting the account owner's last name.
     * @param lastName The account owner's last name.
     * @throws IllegalArgumentException Invalid last name! Last name can't be null or empty for id: 1
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Invalid last name! Name can't be blank for id: " + id);
        else
            this.lastName = lastName;
    }

    /**
     * Allows making a deposit for amounts greater than zero.
     * @param amount The amount to add to the account balance.
     * @throws IllegalArgumentException Invalid amount! Amount can't be less than or equal to zero!
     */
    public void deposit(double amount) {
 if (amount <= 0)
     throw new IllegalArgumentException("Invalid Amount! Amount can't be less than or equal to zero!" + amount);
     else
         this.balance += amount;

    }

    /**
     * Allows making a withdrawal for amounts greater than zero and NOT greater than the account balance.
     * @param amount The amount to reduce the account balance.
     * @throws IllegalArgumentException Invalid Amount! Amount can't be less than or equal to zero!
     * @throws IllegalArgumentException Insufficient Funds, please enter a number lower than the amount.
     */
    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid Amount! Amount can't be less than or equal to zero!" + amount);
        else
            this.balance -= amount;
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient Funds, please enter a number lower than the amount." + amount);
        else
            balance -= amount;
    }

    /**
     * General account info (id and name) as a string.
     *
     * @return The account's id and name.
     */
    public String toString() {
        return firstName + " " + lastName;
    }
}
