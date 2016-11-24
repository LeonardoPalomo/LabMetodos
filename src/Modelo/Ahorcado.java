package Modelo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    
    final private String[] ANIMAL = {"perro", "gato", "caballo"};
    final private String[] CIUDAD = {"santiago", "rancagua", "iquique"};
    final private String[] PAIS = {"chile", "argentina", "canada"};
    final public String[][] PALABRA = {ANIMAL, CIUDAD, PAIS};
    private int intentos = 6;
    private int victoria = 0;
    private static int conjunto;
    private ArrayList<String> usados = new ArrayList();
    private ArrayList<String> resuelto = new ArrayList();
    private int recompensa = 1000;
    
    //constructores
    Random rn = new Random();
    Scanner reader = new Scanner(System.in);
    //String seleccion = seleccionarPalabra(PALABRA);
    //ArrayList<String> separados = new ArrayList(Arrays.asList(this.seleccion.split(""))); //palabra separada por letras (Strings)
    
    /** Selecciona una palabra de un arreglo 
     * @param palabra, arreglo de palabras para elegir
     * @param conjunto para entrar en la categoria que se desea
     * @return seleccion, una palabra al azar del arreglo ingresado
     */
    public String seleccionarPalabra(String[][] palabra, int conjunto){
        String[] dominio = palabra[conjunto];
        int indice;
        indice = rn.nextInt(dominio.length);
        String seleccion = dominio[indice];
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
            if(letra.equals(palabra.get(i))){
                encriptado.set(i, letra);

            }
        }
        
        if(!encriptado.contains("-")){
            victoria = 1;            
            }
        
        return encriptado;
    }
    
    /** función que verifica si la letra ingresada ya ha sido utilizada, si está 
     * en la palabra a adivinar o no lo está.
     * @param letra, que es un String de largo 1
     * @param separados letras de la palabra
     * @return un mensaje de verificación (String)
    */
    public String verificar(String letra, ArrayList<String> separados){
        String caso;
        letra = letra.replaceAll("[^a-zA-Z]+","");
        
        if (letra.length() != 1){
            caso = "Ingrese una letra válida";
            return caso;
        }
        
        if(usados.contains(letra + " ")){   //equivalente al for in de python
            caso = "letra ya ingresada.";
            return caso;
        }
        
        //la letra no ha sido utilizada, puede o no puede estar en la palabra a adivinar
        else{
            //si está...
            if(separados.contains(letra)){
                caso = "Acierto!";
                usados.add(letra + " ");
                
                return caso;
            }
            //si no está...
            else{
                intentos = intentos - 1;
                caso = "Fallaste!";
                usados.add(letra + " ");
                return caso;
            }    
            
        }
    }
    /**
     * Funcion que cuenta la cantidad de letras en todo un arreglo de strings
     * @param palabras, el arreglo que contiene todas las palabras del conjunto
     * @return un arreglo de enteros, posicion corresponde al abecedario y el valor la cantidad de la letra
     */
    public int[] cantidadLetras(String[] palabras){
        int[] cantidades = new int[25];
        int i;
        int j;
        String[] aux;
        for(i=0;i<palabras.length;i++){
            aux = palabras[i].split("");
            for(j=0;j<aux.length; j++){
                switch (aux[j]) {
                    case "a":
                        cantidades[0] += 1;
                        break;
                    case "b":
                        cantidades[1] += 1;
                        break;
                    case "c":
                        cantidades[2] += 1;
                        break;
                    case "d":
                        cantidades[3] += 1;
                        break;
                    case "e":
                        cantidades[4] += 1;
                        break;
                    case "f":
                        cantidades[5] += 1;
                        break;
                    case "g":
                        cantidades[6] += 1;
                        break;
                    case "h":
                        cantidades[7] += 1;
                        break;
                    case "i":
                        cantidades[8] += 1;
                        break;
                    case "j":
                        cantidades[9] += 1;
                        break;
                    case "k":
                        cantidades[10] += 1;
                        break;
                    case "l":
                        cantidades[11] += 1;
                        break;
                    case "m":
                        cantidades[12] += 1;
                        break;
                    case "n":
                        cantidades[13] += 1;
                        break;
                    case "o":
                        cantidades[14] += 1;
                        break;
                    case "p":
                        cantidades[15] += 1;
                        break;
                    case "q":
                        cantidades[16] += 1;
                        break;
                    case "r":
                        cantidades[17] += 1;
                        break;
                    case "s":
                        cantidades[18] += 1;
                        break;
                    case "t":
                        cantidades[19] += 1;
                        break;
                    case "u":
                        cantidades[20] += 1;
                        break;
                    case "v":
                        cantidades[21] += 1;
                        break;
                    case "w":
                        cantidades[22] += 1;
                        break;
                    case "x":
                        cantidades[23] += 1;
                        break;
                    case "y":
                        cantidades[24] += 1;
                        break;
                    case "z":
                        cantidades[25] += 1;
                        break;
                    default:
                        break;
                }
                
            }
        
        }
        return cantidades;
    }
    
    /**
     * Funcion que determina que letra es la mas repetida
     * @param cantidades, el arreglo obtenido en la funcion cantidadLetras
     * @return la letra(String)
     */
    public String seleccionarLetra(int[] cantidades){
        int i;
        int posicion = 0;
        int mayor = 0;
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String[] abecedario = letras.split("");
        for(i=0;i<cantidades.length;i++){
            if (cantidades[i] > mayor){
                mayor = cantidades[i];
                posicion = i;
            }
        }
        return abecedario[posicion];
    }
    
    /**VER DESPUES SI SE BORRA
     * funcion que retorna la posicion de una letra en el arreglo
     * @param letra
     * @return posicion
     */
    public int posicion(String letra){
        int i;
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String[] abecedario = letras.split("");
        for(i=0;i<abecedario.length;i++){
            if (abecedario[i].equals(letra)){
                return i;
            }
        }
        return 0;
    }
    
    /**VER DESPUES SI SE BORRA
     * Funcion que retorna las posiciones en que esta la letra en la palabra
     * @param letra
     * @param palabra
     * @return arraylist con las posiciones
     */
    public ArrayList<Integer> posiciones(String letra, ArrayList<String> palabra){
        ArrayList<Integer> aux = new ArrayList();
        int i;
        for(i=0;i<palabra.size();i++){
            if(palabra.get(i).equals(letra)){
                aux.add(i);
            }
        }
        System.out.println(aux);
        return aux;
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

    
    public int getRecompensa(){
        return this.recompensa;
    }
    
    public void setRecompensa(int resta){
        this.recompensa = recompensa - resta;
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
    
    public void setConjunto(int numero){
        conjunto = numero;
    }
    
    public int getConjunto(){
        return conjunto;
    }

}