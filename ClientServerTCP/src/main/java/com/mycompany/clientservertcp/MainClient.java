package com.mycompany.clientservertcp;


/**
 *
 * @author Kevin
 */
public class MainClient {
    public static void main(String[] args) {
        //Crea un client con nome Kevin e colore Blu
        Client client= new Client("Kevin","blu");
        // Connette il client all'indirizzo IP 127.0.0.1 e porta 2000
        client.connetti("127.0.0.1",2000);
        //Avvia il thread del client
        client.start();
    }
}