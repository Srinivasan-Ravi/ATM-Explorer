import java.util.Scanner;

public class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int inputPin = scanner.nextInt();

        if (account.validatePin(inputPin)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("ATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Change PIN");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful. Current Balance: " + account.getBalance());
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        if (account.withdraw(withdrawalAmount)) {
                            System.out.println("Withdrawal successful. Current Balance: " + account.getBalance());
                        }
                        break;
                    case 4:
                        System.out.print("Enter new PIN: ");
                        int newPin = scanner.nextInt();
                        account.changePin(newPin);
                        System.out.println("PIN changed successfully.");
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Account account = new Account("12345678", 1234, 1000.0);
        ATM atm = new ATM(account);
        atm.start();
    }
}
