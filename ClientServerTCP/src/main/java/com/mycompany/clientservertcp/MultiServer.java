package com.mycompany.clientservertcp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kevin
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.BindException;
import java.io.*;

public class MultiServer extends Thread {
    
    int porta;
    int n;
    ServerSocket serverSocket;
    
    //Costruttore
    public MultiServer(int porta) {
        this.porta= porta; 
        this.n = 1;
    }
    
    //Metodo principale del thread
    public void run() {
       try {
           // Crea un server socket sulla porta specificata 
          serverSocket = new ServerSocket(porta);
          
          while(true) {
              //Accetta le connessioni in arrivo
           Socket socket = serverSocket.accept();
           System.out.println("connessione accettata a " + socket +"; Client numero :" + n);
           //Viene creato un thread per la gestione del client 
           Server server = new Server(porta, socket, n);
           server.start();
           n++;
      }
          } catch (IOException ex) {
           System.out.println("errore generico del server");
          }
}
    // Chiude il server
    public void termina() {
        try {            
            serverSocket.close(); //chiudo il server
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}