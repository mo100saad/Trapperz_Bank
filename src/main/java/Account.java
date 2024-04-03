/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mo100
 */
public class Account {
  private int number;
  private float balance;
  private String name;

  public Account(String name, int number) {
    this.name = name;
    this.number = number;
    this.balance = 0;
  }

  public float credit(float val) {
    this.balance += val;
    return this.balance;
  }

  public float debit(float val) {
    if (this.balance < val) {
      return this.balance;
    }
    this.balance -= val;
    return this.balance;
  }

  public int getNumber() {
    /* Returns this account's number */
    return number;
  }

  public void setNumber(int number) {
    /* Sets this account's number */
    this.number = number;
  }

  public float getBalance() {
    /* Returns this account's balance */
    return balance;
  }

  public void setBalance(float balance) {
    /* Sets this account's balance */
    this.balance = balance;
  }

  public String getName() {
      //method to return name string
    return name;
  }

  public void setName(String name) {
      //localizes the name
    this.name = name;
  }

  // method to display account details
  public void showAccount() { 
    System.out.println("Name of account holder: " + name);
    System.out.println("Account no.: " + number);
    // System.out.println("Account type: " + acc_type);
    System.out.println("Balance: " + balance);
  }

  @Override
  public String toString() {
    return "Account Number: " + number + "\n" +
           "     Type   : " + name + "\n" +
           "     Balance: $" + String.format("%.02f", balance) + "\n";
  }

}
