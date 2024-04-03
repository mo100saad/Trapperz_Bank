/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mo100
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.nio.file.*;

public class Client {

    private int id;
    private String name;
    private int dob_day;
    private int dob_month;
    private int dob_year;
    private ArrayList<Account> accounts;
    private int account_number = 1000;
    private String clientFile;

    public Client(String name, int id, int dob_day, int dob_month, int dob_year) {
        this.accounts = new ArrayList<>();
        this.name = name;
        this.id = id;
        this.dob_day = dob_day;
        this.dob_month = dob_month;
        this.dob_year = dob_year;
        this.clientFile = name + dob_day + dob_month + dob_year + ".txt";
    }

    public Account addAccount(String name) {
        Account acc = new Account(name, ++account_number);
        accounts.add(acc);
        return acc;
    }

    public void deleteAccount(int acc_number) {
        Account faccount = null;
        for (Account account : accounts) {
            if (account.getNumber() == acc_number) {
                faccount = account;
                break;
            }
        }
        if (faccount != null) {
            System.out.println("Removed account= " + faccount);
            accounts.remove(faccount);
        }
    }

    public String getClientFileName() {
        return clientFile;
    }

    public Account getAccount(int Id) {
        for (Account account : accounts) {
            if (account.getNumber() == Id) {
                return account;
            }
        }
        return (addAccount("Checking"));
    }

    public float debitAccount(Account acc,
            float amount) {
        float balance = 0;

        balance = acc.debit(amount);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(clientFile));
            writer.write(Float.toString(balance));
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error!!");
        }

        return balance;
    }

    public float creditAccount(Account acc,
            float amount) {

        float balance = 0;
        balance = acc.credit(amount);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(clientFile));
            writer.write(Float.toString(balance));
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error!!");
        }
        return balance;
    }

    public void cleanup() {
        try {
            // Delete the file
            boolean isDeleted = Files.deleteIfExists(
                    Paths.get(clientFile)
            );

            // check the status
            if (isDeleted) {
                System.out.println("File is successfully deleted!");
            } else {
                System.out.println("Sorry, the file was not deleted.");
            }
        } // If the input directory is not empty
        catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty!");
        } // If some I/O error occurred
        catch (IOException e) {
            System.out.println("I/O error occurred");
        }
        deleteAccount(1001);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDOB_day() {
        return dob_day;
    }

    public int getDOB_month() {
        return dob_month;
    }

    public int getDOB_year() {
        return dob_year;
    }

    @Override
    public String toString() {
        int i = 1;
        String ret = "Client(ID=" + id + "):\n";
        ret += " Name: " + name + "\n";
        ret += " DOB: " + dob_day + "/" + dob_month + "/" + dob_year + "\n";
        ret += " Accounts:\n";
        for (Account account : accounts) {
            ret += "  " + i + ". " + account.toString();
            ++i;
        }
        if (i == 1) {
            ret += "None\n";
        }
        return ret;
    }
}
