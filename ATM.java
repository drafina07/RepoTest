class InvalidPINException extends Exception {
    InvalidPINException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class WithdrawalLimitException extends Exception {
    WithdrawalLimitException(String message) {
        super(message);
    }
}

public class ATM {
    private static double balance = 10000;
    private static final int correctPIN = 1234;
    private static final double dailyLimit = 5000;
    private static double withdrawnToday = 0;

    static void verifyPIN(int pin) throws InvalidPINException {
        if (pin != correctPIN) {
            throw new InvalidPINException("Invalid PIN!");
        }
    }

    static double checkBalance() {
        return balance;
    }

    static void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive!");
        }
        balance += amount;
    }

    static void withdraw(double amount) throws InvalidAmountException, WithdrawalLimitException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new InvalidAmountException("Insufficient balance!");
        }
        if (withdrawnToday + amount > dailyLimit) {
            throw new WithdrawalLimitException("Daily withdrawal limit exceeded!");
        }
        balance -= amount;
        withdrawnToday += amount;
    }

    public static void main(String[] args) {
        try {
            // Step 1: Verify PIN
            verifyPIN(1234);

            // Step 2: Balance enquiry
            System.out.println("Current Balance: " + checkBalance());

            // Step 3: Deposit
            deposit(2000);
            System.out.println("Balance after deposit: " + checkBalance());

            // Step 4: Withdraw
            withdraw(3000);
            System.out.println("Balance after withdrawal: " + checkBalance());

            // Step 5: Try exceeding limit
            withdraw(2500); // should throw WithdrawalLimitException
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
