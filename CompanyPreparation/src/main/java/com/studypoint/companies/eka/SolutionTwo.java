package com.studypoint.companies.eka;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class SolutionTwo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("AC000", 100000);

        MyThread myThread1 = new MyThread(bankAccount, 3000, 50);
        MyThread myThread2 = new MyThread(bankAccount, 405.30, 70);

        ExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.execute(myThread1);
        executorService.execute(myThread2);
        executorService.shutdown();
    }
}

class MyThread implements Runnable {
    BankAccount bankAccount;
    double deposit;
    double withdraw;
    MyThread(BankAccount bankAccount, double deposit, double withdraw) {
        this.bankAccount=bankAccount;
        this.deposit=deposit;
        this.withdraw=withdraw;
    }
    public void deposit(){
        bankAccount.deposit(deposit);
    }

    public void withdraw(){
        bankAccount.withdraw(withdraw);
    }
    @Override
    public void run() {
        System.out.println("Before deposit " + bankAccount.getBalance());
        deposit();
        System.out.println("After deposit " + bankAccount.getBalance());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        withdraw();
        System.out.println("After withdraw " +bankAccount.getBalance());
    }
}
/* We have two people using a joint bank account at the same time.
The bank account has an initial balance of $100,000. One will deposit $3000 into the bank account,
and then withdraw $50. The other will deposit $405.30 and then withdraw
$70. How will you solve this problem?*/

class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
}
