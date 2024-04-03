/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author mo100
 */
public class Trapperz_Bank {

    public static void main(String[] args) {
        Bank bank = new Bank("Woodroffe Branch");
        if (null != bank.wlcmf) {
            bank.wlcmf.setVisible(true);
        } else {
            System.out.println("Welcome frame is missing!");
        }
        System.out.println("Successfully created " + bank);
    }
}
