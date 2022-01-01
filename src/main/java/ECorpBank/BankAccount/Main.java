package ECorpBank.BankAccount;

public class Main {
    public static void main(String[] args) {
        Client Caio = new Client();
        Caio.setName("Caio");
        Caio.setPassword("123456");
        Caio.setEmail("caiolombello@gmail.com");
        Caio.setDocument("06201167064");
        Caio.setPhone("(14)998252394");
        System.out.println(Caio.getPassword());
        System.out.println(Caio.getEmail());
        System.out.println(Caio.getDocument());
        System.out.println(Caio.getPhone());
        System.out.println(Caio.getType());


        Account checkingAccount = new CheckingAccount(Caio);
        Account savingsAccount = new SavingsAccount(Caio);

        checkingAccount.deposit(100);
        checkingAccount.transfer(100, savingsAccount);

        checkingAccount.printExtract();
        savingsAccount.printExtract();
    }
}
