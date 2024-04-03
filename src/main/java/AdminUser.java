/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mo100
 */
public class AdminUser {
    private String username;
    private String password;
    
    public AdminUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}

