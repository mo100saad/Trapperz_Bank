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

public class Bank {

    private static int client_id = 1000123;
    private ArrayList<Client> clients; //List of clients
    private String name; //Client Name
    private AdminUser admin; //admin object being created
    private String bankFile; //file for client $$
    private boolean recovering = false; 
    //Creating objects for the frames
    public ClientFrame cf;
    public NewClientFrame ncf;
    public FindClientFrame fcf;
    public AccountFrame accf;
    public WelcomeFrame wlcmf;
    public AboutFrame af;

    public Bank(String name) {
        //Making bb local and equal to this
        Bank bb = this;
        //Name is a reference to the current object — the object whose method or constructor is being called.
        this.name = name;
        this.clients = new ArrayList<>();
        admin = new AdminUser("admin", "longfields");
        bankFile = name + ".txt";
        recoverClients();
        System.out.println("\nAll previous users were recovered.");
        //all methods ot call frames.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cf = new ClientFrame(bb);
                cf.setVisible(false);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ncf = new NewClientFrame(bb);
                ncf.setVisible(false);
            }
        });        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fcf = new FindClientFrame(bb);
                fcf.setVisible(false);
            }
        });

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                accf = new AccountFrame(bb, null);
                accf.setVisible(false);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                wlcmf = new WelcomeFrame(bb);
                wlcmf.setVisible(false);
            }
        });
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                af = new AboutFrame(bb);
                af.setVisible(false);
            }
        });
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        System.out.println("All frames created!");
    }
//Method to add client making reference to the Client object
    public Client addClient(String name, int dob_day,
            int dob_month, int dob_year) {
        Client cli;
        
        cli = findClient(name, dob_day, dob_month, dob_year);
        if (cli != null) {
            return cli;
        }
        cli = new Client(name, ++client_id, dob_day, dob_month, dob_year);
        clients.add(cli);

        if (recovering) {
            return cli;
        } 
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(bankFile, true));
            writer.write(cli.getName() + "|"
                    + cli.getDOB_day() + "|"
                    + cli.getDOB_month() + "|"
                    + cli.getDOB_year()
                    + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cli;
    }

    public void removeClient(Client client) {
        System.out.println("Removed client= " + client);
        clients.remove(client);
        client.cleanup();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(bankFile));
            for (Client cli : clients) {
                writer.write(cli.getName() + "|"
                        + cli.getDOB_day() + "|"
                        + cli.getDOB_month() + "|"
                        + cli.getDOB_year()
                        + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client findClient(
            String name,
            int dob_day,
            int dob_month,
            int dob_year) {
        for (Client client : clients) {
            if ((client.getName().equals(name))
                    && (client.getDOB_day() == dob_day)
                    && (client.getDOB_month() == dob_month)
                    && (client.getDOB_year() == dob_year)) {
                return client;
            }
        }
        return null;
    }

    public boolean authenticate_admin(String username, String password) {
        return admin.authenticate(password);
    }

    public String showClients() {
        String ss = "Clients:\n";
        ss += "========\n";
        for (Client client : clients) {
            ss += client.toString();
            ss += "----------------------------\n";
        }
        return ss;
    }

    public void recoverClients() {
        File fr = null;
        Scanner sc;
        File clientFile = null;
        Scanner scClientFile;

        recovering = true;
        try {
            fr = new File(bankFile);
            sc = new Scanner(fr);
        } catch (Exception e) {
            System.out.println("\nBank file not found.\n");
            recovering = false;
            return;
        }

        if (fr.length() == 0) {
            System.out.println("Bank file is empty.");
            recovering = false;
            return;
        }

        while (sc.hasNextLine()) {
            Client user;
            String line = sc.nextLine();
            String[] lineSplit = line.split("\\|");
            user = addClient(lineSplit[0],
                    Integer.parseInt(lineSplit[1]),
                    Integer.parseInt(lineSplit[2]),
                    Integer.parseInt(lineSplit[3]));

            float amount = 0;
            try {
                clientFile = new File(user.getClientFileName());
                scClientFile = new Scanner(clientFile);
                if (clientFile.length() != 0) {
                    line = scClientFile.nextLine();
                    amount = Float.parseFloat(line);
                }
                Account acc;
                acc = user.addAccount("Checking");
                acc.credit(amount);
            } catch (Exception e) {
                System.out.println("\nClient file not found.\n");
            }
            System.out.println(user.toString());
        }
        recovering = false;
    }

    @Override
    public String toString() {
        return "Bank(" + name + ")";
    }
}
