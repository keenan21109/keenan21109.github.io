/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.course.writecustomerlist;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class WriteCustomerList {

    public static void main(String[] args) throws IOException {
  
        Scanner keyboard = new Scanner (System.in);
        
            System.out.println("enter ID");
            String ID= keyboard.nextLine();
            System.out.println("enter Name");
            String Name= keyboard.nextLine();
            System.out.println("enter Surname");
            String Surname = keyboard.nextLine();
            System.out.println("enter balance");
            double balance = keyboard.nextDouble();
            
        String filePath = "CustomerList";
        
        try(BufferedWriter list = new BufferedWriter(new FileWriter(filePath,true))) 
        {
            list.write("ID: "+ID);
            list.newLine();
            list.write("Name: "+Name);
            list.newLine();
            list.write("Surname: "+Surname);
            list.newLine();
            list.write("Balance: "+balance);
            list.newLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        //We are going to read and print the file.
        try(BufferedReader search = new BufferedReader(new FileReader(filePath)))
        {
            String Line;
            //line==searcher.read())!=null
            while((Line=search.readLine())!=null)
            {
                System.out.println(Line);
            }
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
