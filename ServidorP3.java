/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger; 

/**
 * 
 * @author Javier Vargas
 */
public class ServidorP3 {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in; //Recibir datos (comunicación)
        DataOutputStream out;//Enviar Datos (comunicación)
        final int PUERTO = 5009;
    
        

        try {
            
            

            servidor = new ServerSocket(PUERTO);
            System.out.println("===========================");
            System.out.println("      SERVIDOR ACTIVO");
            System.out.println("=========================== \n\n");
            while (true) { //While para que el servidor esté siempre "escuchando"
                   
           
                sc = servidor.accept(); //Socket del cliente que siempre estará atento a un llamado del cliente
                System.out.println("¡Cliente conectado!");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                
                    //String mensaje = in.readUTF(); //Se queda a la espera de que el cliente mande algo
                    out.writeUTF("Servidor activo! \n ¿Qué operación desea realizar? \n 1.- Suma    |   2.- Multiplicación  "); //Mensaje que enviaremos al cliente
                    //System.out.println(mensaje);
                    String str = in.readUTF(); //Recibimos la petición del cliente
                   // System.out.println("Opción recibida: " + str);
                    int op = Integer.parseInt(str);

                    if (op == 1) {

                        System.out.println("Opción 1: Suma\n");
                        out.writeUTF("Opcion 1 seleccionada: Suma \n\n Ingrese el primer número: "); //String "Respuesta" en el cliente
                        String numerosuma1 = in.readUTF(); //Recibimos el primer número del cliente
                        int numsuma1 = Integer.parseInt(numerosuma1); //"Convertimos" el 1er string recibido en un entero para poder hacer la suma

                        out.writeUTF("Ingrese el segundo número: ");//
                        String numerosuma2 = in.readUTF(); //Recibimos el segundo número del cliente
                        int numsuma2 = Integer.parseInt(numerosuma2); //"Convertimos" el 2do string recibido en un entero para poder hacer la suma

                        out.writeUTF("La suma es: " + suma(numsuma1, numsuma2) + "\n\n\n"); //Llamamos a la función suma para que haga la operacion
                        // y mandamos el resultado al cliente 
                         System.out.println("¡Cliente desconectado!\n\n");


                    } else if (op == 2) {
                        System.out.println("Opción 2: Multiplicación\n ");
                        out.writeUTF("Opción 2 seleccionada: Multiplicación \n\n Ingrese el primer número: ");
                        //String "Respuesta" en el cliente
                        String numeromulti1 = in.readUTF(); //Recibimos el primer número del cliente
                        int numM1 = Integer.parseInt(numeromulti1); //"Convertimos" el 1er string recibido en un entero para poder hacer la suma

                        out.writeUTF("Ingrese el segundo número: ");//
                        String numeromulti2 = in.readUTF(); //Recibimos el segundo número del cliente
                        int numM2 = Integer.parseInt(numeromulti2); //"Convertimos" el 2do string recibido en un entero para poder hacer la suma

                        out.writeUTF("La multiplicacion es: " + multip(numM1, numM2) + "\n\n\n"); //Llamamos a la función suma para que haga la operacion
                        // y mandamos el resultado al cliente
                         System.out.println("¡Cliente desconectado!\n\n");
                    }
                       
                    sc.close(); // Cerramos el CLIENTE
                    // System.out.println("Cliente desconectado");
                    
                
                
            }
        }catch (IOException ex) {
            Logger.getLogger(ServidorP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        

    
        

    public static int suma(int numsuma1, int numsuma2) {

        int ResSuma = numsuma1 + numsuma2;

        return ResSuma;
    }

    public static int multip(int numM1, int numM2) {

        int ResMulti = numM1 * numM2;
        return ResMulti;
    }
 }

