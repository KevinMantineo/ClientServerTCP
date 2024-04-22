package com.mycompany.clientservertcp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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


public class Server extends Thread {
    private Socket Socket;
    private int nPorta;
    private int numeroClient;
    private  boolean connessione = true;
    String Datiricevuti;
    
        //Costruttore
      public Server(int porta, Socket socket, int n) {
        this.nPorta=nPorta;
        this.Socket = socket;
        this.numeroClient = n;
    }
     
    //avvio dei server
    @Override  
    public void run() {
        while(connessione) {
    leggi();     // Legge i dati dal client 
    scrivi();    // Invia la risposta al client
        }
    chiudi();    // Chiude la connesione 
    } 
        
    // Legge i dati inviati dal client 
    public void leggi() {
        try {
            InputStream inputStream = Socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            Datiricevuti = in.readLine();
                       
            System.out.println("Dati sono stati ricevuti dal client numero " + numeroClient + ": " + Datiricevuti );
            
            //metodo per chiudere la comunicazione
            if(Datiricevuti.equals("STOP")) {
            connessione = false;
            }
        } catch (IOException e) {
            System.err.println("errore nella ricreazione dei dati dal client");
            chiudi();
            connessione = false;
        } 
    }

    //Invia dati al client
    public void scrivi() {
    try {
      OutputStream outputStream = Socket.getOutputStream();
      PrintWriter out = new PrintWriter(outputStream, true);
       if (connessione == true) {
           
            out.println("dati inviati correttamente; sei il client numero " + numeroClient);
            
      } else {
         out.println("chiusura connessione in corso...");
      }       
    } catch (IOException e) {
            System.err.println("errore nell'invio della risposta");
            System.err.println(e);
        }
    }
    //Chiude la connesione 
    public void chiudi() {
        try {           
            System.out.println("chiusura connessione del client numero " + numeroClient);
            Socket.close(); 
        } catch (IOException e) {
            System.err.println(e);
        } 
      
    }

      
      
}