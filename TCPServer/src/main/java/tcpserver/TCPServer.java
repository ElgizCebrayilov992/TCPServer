/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author virtu
 */
public class TCPServer {
    
    public static void main(String[] args) throws Exception{
        
        ServerSocket outFirstServerSocker= new ServerSocket(6789);
        
        while (true) {
            
            Socket connection= outFirstServerSocker.accept();
            
            InputStream is=connection.getInputStream();
            
            InputStreamReader reader=new InputStreamReader(is);
            
            BufferedReader bReader=new BufferedReader(reader);
            
            String messageFromClient=bReader.readLine();
            
            System.out.println("message from client"+messageFromClient);
        }
    }
    
}
