package com.air_ticketing;

import java.util.Scanner;

public class Login {
    boolean isAuthenticate(){
        //code for authentication
        Scanner scanner=new Scanner(System.in);
        System.out.println("Login to proceed ...\n");
        System.out.print("Enter Username : ");
        String username = scanner.nextLine();
        System.out.print("Enter Password : ");
        String password = scanner.nextLine();

        if(username.equals("vishal gupta")){
            if(password.equals("vishal@123")){
                return true;
            }else System.out.println("Enter correct Password");

        }else System.out.println("Enter correct Username");
        return false;
    }

}


