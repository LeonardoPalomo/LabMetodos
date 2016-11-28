
package Modelo;

import Controlador.ControladorJuegoAdivLaPal;
import java.util.Random;

public class JuegoAdivLaPal {
    
    private String[] palabrasFacil = {"chela","pisco","vodka","trago","droga","porro","verde","pucho","saque","licor","fonda","asado","pelea","usach","plata","ebrio","manco","bajon","mambo","pasta"};
    private String[] palabrasNormal = {"tabaco","hierba","copete","whisky","vomito","fiesta","perreo","viagra","mezcal","fernet","brandy","bebida","comida","tocata","pilsen","queque","resaca","escudo","becker","dorada"};
    private String[] palabrasDificil = {"alcohol","cigarro","absenta","cerveza","carrete","tomanji","cocaina","heroina","extasis","tequila","ginebra","viernes","roncola","piscola","daikiri","horario","cogollo","baltica","cristal","trabajo"};
    
    public String obtenerPalabra(int dificultad){
        String palabra = new String();
        Random ran = new Random();
        int indice = ran.nextInt(20);
        System.out.println("El índice obtenido es "+indice);
        switch (dificultad) {
            case 1:
                palabra = palabrasFacil[indice];
                break;
            case 2:
                palabra = palabrasNormal[indice];
                break;
            case 3:
                palabra = palabrasDificil[indice];
                break;
            default:
                break;
        }
        return palabra;
    }
    
    public char[] revisarIntento(char[] palabraSeparada,char[] intentoUsuario,char[] letrasCorrectas){
        char[] letrasEncontradas = new char[ControladorJuegoAdivLaPal.cantidadLetras];
        for(int i=0;i<ControladorJuegoAdivLaPal.cantidadLetras;i++){
            if(intentoUsuario[i] == palabraSeparada[i]){
                letrasCorrectas[i] = intentoUsuario[i];
            }
            else{
                for(int j=0;j<ControladorJuegoAdivLaPal.cantidadLetras;j++){
                    if(intentoUsuario[i] == palabraSeparada[j]){
                        letrasEncontradas[i] = intentoUsuario[i];
                        break;
                    }
                }
            }
        }
        return letrasEncontradas;
    }
}
    

