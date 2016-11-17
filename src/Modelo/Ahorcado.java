/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    
    final private String[] PALABRA = {"perro", "gato", "caballo"};
    final private ArrayList<String> ABECEDARIO = new ArrayList();
    private int intentos = 6;
    private int victoria = 0;
    private ArrayList<String> usados = new ArrayList();
    private ArrayList<String> resuelto = new ArrayList();
    private String letra;
    
    //constructores
    static Random rn = new Random();
    static Scanner reader = new Scanner(System.in);
    String seleccion = seleccionarPalabra(PALABRA);
    ArrayList<String> separados = new ArrayList(Arrays.asList(this.seleccion.split(""))); //palabra separada por letras (Strings)
    
    /** Selecciona una palabra de un arreglo 
     * @param palabra, arreglo de palabras para elegir
     * @return seleccion, una palabra al azar del arreglo ingresado
     */
    public String seleccionarPalabra(String[] palabra){
        int indice = rn.nextInt(palabra.length);
        String seleccion = palabra[indice];
        return seleccion;
    
    }
    
    
    /** Calcula la cantidad de letras de la palabra para resolver, actualizando cada vez 
     * que el usuario acierte
     * @param palabra, un String
     * @return un ArrayList<String> con las palabras acertadas
    */
    public ArrayList<String> inicializar(String palabra){
        for(int i = 0; i < palabra.length(); i++){
            resuelto.add("-");
        }
        return resuelto;
    }
    
    /**
     * funcion que va "desencriptando" la palabra
     * @param letra, String de largo 1 elegido por el usuario
     * @param encriptado, arraylist de la palabra encriptada
     * @param palabra, arraylist de la palabra a adivinar
     * @return un arraylist desencriptado. cambia la variable "victoria" por 1
    */
    public ArrayList<String> actualizar(String letra, ArrayList<String> encriptado, ArrayList<String> palabra){
        
        for(int i = 0; i < palabra.size(); i++){
            if(letra == palabra.get(i)){
                encriptado.set(i, letra);
            }
        }
        
        if(!encriptado.contains("-")){
            victoria = 1;            
            }
        
        return encriptado;
    }
    
    /** obtiene la letra ingresada por el usuario
     * @param letra
     * @return una letra (String)
    */
    public String obtenerLetra(String letra){
        
        char aux;
        System.out.println("ingrese una letra: ");
        aux = letra.charAt(0);
        
        if (letra.length() != 1){
            return "Ingrese una letra válida";
        }
        else if ((aux <= 65 && aux >= 90) || (aux <= 97 && aux >= 122)){
            return "Ingrese una letra válida";
        }
        
        return "letra inválida";
    
    }
    
    /** función que verifica si la letra ingresada ya ha sido utilizada, si está 
     * en la palabra a adivinar o no lo está.
     * @param letra, que es un String de largo 1
     * @return un mensaje de verificación (String)
    */
    public String verificar(String letra){
        letra = letra.toLowerCase();
        
        if(usados.contains(letra + " ")){   //equivalente al for in de python

            
            String caso = "letra ya ingresada.";
            return caso;
        }
        
        //la letra no ha sido utilizada, puede o no puede estar en la palabra a adivinar
        else{
            //si está...
            if(separados.contains(letra)){
                String caso = "Acierto!";
                usados.add(letra + " ");
                
                return caso;
            }
            //si no está...
            else{
                intentos = intentos - 1;
                String caso = "Fallaste!";
                usados.add(letra + " ");
                return caso;
            }    
            
        }
    }
    
    public String getPalabra(){
        return this.seleccion;
    }
    
    public String getUsados(){
        return this.arraylisttostring(usados);
    }
    
    public int getIntentos(){
        return this.intentos;
    }
    
    public int getVictoria(){
        return this.victoria;
    }
    
    public String[] getPALABRA(){
        return this.PALABRA;
    }
    
    public void setPalabra(String palabra) {
        this.seleccion = palabra;
    } 
    
    /**
     * Funcion que convierte arraylist en String
     * @param arreglo
     * @return un String
     */
    public String arraylisttostring(ArrayList<String> arreglo){
        String palabra = "";
        for(int i=1; i <= arreglo.size(); i++){
            palabra = palabra + arreglo.get(i-1);
        
        }
        return palabra;
    }
    

}
