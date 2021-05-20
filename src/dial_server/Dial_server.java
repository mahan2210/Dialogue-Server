/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dial_server;

import java.io.*;
import java.net.*;

/**
 *
 * @author Asus
 */
public class Dial_server {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for client");
     ServerSocket ss = new ServerSocket(2177);
     Socket soc = ss.accept();
     System.out.println("Connection Established");
     DataInputStream din = new DataInputStream(soc.getInputStream());
        DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
        String str = in.readLine();//wait for the user to enter the string
       
        while(!str.equalsIgnoreCase("stop")){
            str = din.readUTF();
            System.out.println("Client says: "+str);
            
            str = in.readLine();
            dout.flush();
            dout.writeUTF(str);
            
        }
        dout.close();
        soc.close();
        ss.close();
    }
}
    

