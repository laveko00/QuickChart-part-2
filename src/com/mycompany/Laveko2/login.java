/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Laveko2;

/**
 *
 * @author Student
 */
public class login {
   private final String storedUsername = "Lavek_@";
    private final String storedPassword = "Hc&&sec@ke00!";

    
    public boolean loginUser(String username, String password) {

        return username.equals(storedUsername)
                && password.equals(storedPassword);
    }

   
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            return "Login successful.";
             } else {
            return "Username or password incorrect, please try again.";
        }
    }
}


