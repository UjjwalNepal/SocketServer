/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.handler.ClientListener;

/**
 *
 * @author Ujjwal
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 1500;
        try{
             
            System.out.println("The Server is listening from "+ port);
            ServerSocket server = new ServerSocket(port);
            while(true){
                Socket client = server.accept();
                System.out.println("connection request from "+client.getInetAddress().getHostAddress()+" "+client.getInetAddress().getHostName());
                ClientListener cl = new ClientListener(client);
                cl.start();    
            }   
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
