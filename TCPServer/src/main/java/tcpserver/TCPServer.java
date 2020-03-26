/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import lombok.SneakyThrows;
import util.FileUtil;

/**
 *
 * @author virtu
 */
public class TCPServer {
    
    
    @SneakyThrows
    public static void main(String[] args) {
        
       readAsByte();
    }
   
    
    @SneakyThrows
    public static void readAsByte() {
        
         ServerSocket outFirstServerSocker= new ServerSocket(6789);
        
        while (true) {
            System.out.println("Wait Client...");
            Socket connection= outFirstServerSocker.accept();
            System.out.println("Connected");
           
            DataInputStream dataStream=new DataInputStream(connection.getInputStream());
            byte[] arry= readMessage(dataStream);
            FileUtil.writeBytes(arry, "C:\\Users\\virtu\\OneDrive\\Masaüstü\\linux book\\elgiz.jpg");
            
            
        }
        
    }
    
    
      
      @SneakyThrows
      public static byte[] readMessage(DataInputStream din){
          int msgLen=din.readInt();
          byte[] msg=new byte[msgLen];
          din.readFully(msg);
          return msg;
          
      }
    
    
    @SneakyThrows
    public  static void readAsString(){
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
