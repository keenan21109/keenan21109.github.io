/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Keenan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of UsernameandPasswords to get login information
        UsernameandPasswords usernameandpasswords = new UsernameandPasswords();
        
        // Create the login page with the provided login information
        LoginPage loginPage = new LoginPage(usernameandpasswords.getLoginInfo());
    }
}
