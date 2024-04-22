package com.mycompany.clientservertcp;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Kevin
 */

public class MainServer {

    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      // Crea un nuovo server e apre la porta 2000
      MultiServer server = new MultiServer(2000); 
      // Avvia il server
      server.start();
      
    }
    
}