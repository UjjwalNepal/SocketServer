/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Ujjwal
 */
public class ClientListener extends Thread{
    private Socket client;
    public ClientListener (Socket client){
        this.client=client;
    }

    @Override
    public void run() {
        
       
            try{
                PrintStream output = new PrintStream(client.getOutputStream());
                output.print("Welcome to the server \n");
                output.print("Only way of exiting from server is press yy and enter \n");
                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
                    String line = input.readLine();
                     if(line.equalsIgnoreCase("yy")){
                       System.exit(0);
                    }else{
                        Process p = new ProcessBuilder(line).start();
                     }
                    System.out.println(line);
                
                output.flush();
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
    }
    
}
