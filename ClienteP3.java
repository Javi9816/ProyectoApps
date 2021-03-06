/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.Scanner;

/**
 *
 *
 *
 *
 * @author Javier Vargas
 */
public class ClienteP3 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        //201.141.20.151
        final String HOST = "127.0.0.1"; //Declaramos el host local de nuestra computadora
        final int PUERTO = 5009;  //Declaramos el puerto de comunicación
        DataInputStream in; 
        DataOutputStream out;

        try {

            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream()); //Hacemos la conexión con los sockets del
            out = new DataOutputStream(sc.getOutputStream()); //código del servidor

            //out.writeUTF("Hola mundo desde el cliente");//Escribimos un mensaje al servidor
            //numC = out.WriteInt();
            String mensaje = in.readUTF(); //Recibimos el mensaje que viene desde el servidor
            System.out.println(mensaje); //Imprimimos

            Scanner S = new Scanner(System.in); //Ingresamos nuestra opcion
            String str = S.next();
            out.writeUTF(str); //Enviamos al servidor nuestra opcion

            //__________________SUMA_________________________
            //-----------------Recibimos respuesta del servidor para ingresar el primer número-----//
            String Respuesta1 = in.readUTF(); //Recibimos la respuesta´para ingresar el
            //primer número de la suma
            System.out.println(Respuesta1); //Imprime la respuesta
            //String Bucle = in.readUTF(); 

            //--------Bloque para ingresar el primer número y enviarlo al servidor-------//
            Scanner N1 = new Scanner(System.in);
            String n1 = S.next();
            out.writeUTF(n1); //Enviamos el número al servidor
            //---------------------------------------------------------------//

            //-------------------- Recibimos respuesta del servidor para introducir el segundo número
            String Respuesta2 = in.readUTF(); //Recibimos la respuesta para ingresar el
            // segundo número de la suma      
            System.out.println(Respuesta2); //Imprime la respuesta enviada del servidor

            //-------Bloque para ingresar el segundo número y enviarlo al servidor
            Scanner N2 = new Scanner(System.in);
            String n2 = S.next();
            out.writeUTF(n2); //Enviamos el número al servidor

            String RespuestaSuma = in.readUTF();//Recibimos la suma total, desde el servidor
            System.out.println(RespuestaSuma);

            //____________MULTIPLICACION_____________________
            String RespuestaM1 = in.readUTF(); //Recibimos la respuesta´para ingresar el
            //primer número de la suma
            System.out.println(RespuestaM1); //Imprime la respuesta

            //--------Bloque para ingresar el primer número y enviarlo al servidor-------//
            Scanner M1 = new Scanner(System.in);
            String m1 = S.next();
            out.writeUTF(m1); //Enviamos el número al servidor
            //---------------------------------------------------------------//

            //-------------------- Recibimos respuesta del servidor para introducir el segundo número
            String RespuestaM2 = in.readUTF(); //Recibimos la respuesta para ingresar el
            // segundo número de la suma      
            System.out.println(RespuestaM2); //Imprime la respuesta enviada del servidor

            //-------Bloque para ingresar el segundo número y enviarlo al servidor
            Scanner M2 = new Scanner(System.in);
            String m2 = S.next();
            out.writeUTF(m2); //Enviamos el número al servidor

            String RespuestaMultiplicacion = in.readUTF();//Recibimos la suma total, desde el servidor
            System.out.println(RespuestaMultiplicacion);

            sc.close(); //Cerramos EL SERVIDOR

        } catch (IOException ex) {
            Logger.getLogger(ClienteP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
