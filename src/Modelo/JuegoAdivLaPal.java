
package Modelo;

import Controlador.ControladorInicialAdivLaPal;
import Controlador.ControladorJuegoAdivLaPal;
import java.util.ArrayList;
import java.util.Random;

public class JuegoAdivLaPal {
    
    private String[] palabrasFacil = {"CHELA","PISCO","VODKA","TRAGO","DROGA","PORRO","VERDE","PUCHO","SAQUE","LICOR","FONDA","ASADO","PELEA","USACH","PLATA","EBRIO","PARTY","BAJON","MAMBO","PASTA"};
    private String[] palabrasNormal = {"TABACO","HIERBA","COPETE","WHISKY","VOMITO","FIESTA","PERREO","VIAGRA","MEZCAL","FERNET","BRANDY","BEBIDA","COMIDA","TOCATA","PILSEN","QUEQUE","RESACA","ESCUDO","BECKER","DORADA"};
    private String[] palabrasDificil = {"ALCOHOL","CIGARRO","ABSENTA","CERVEZA","CARRETE","TOMANJI","COCAINA","HEROINA","EXTASIS","TEQUILA","GINEBRA","VIERNES","RONCOLA","PISCOLA","DAIKIRI","TRAFICO","COGOLLO","BALTICA","CRISTAL","VINACHO"};
    private char[] letrasCorrectas = new char[ControladorJuegoAdivLaPal.cantidadLetras];
    private boolean victoria = false;
    
    public char[] getLetrasCorrectas(){
        return this.letrasCorrectas;
    }
    
    public boolean getVictoria(){
        return this.victoria;
    }
    
    public int getRecompensa(){
        int recompensa = 0;
        switch(ControladorInicialAdivLaPal.dificultad){
            case 1:
                recompensa = 1000;
                break;
            case 2:
                recompensa = 1250;
                break;
            case 3:
                recompensa = 1500;
                break;
        }
        return recompensa;
    }
    
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
    
    public char[][] revisarIntento(char[] palabraSeparada,char[] intentoUsuario){
        for(char letra:intentoUsuario){
            System.out.println("Intento usuario = "+String.valueOf(letra));
        }
        for(char letra:palabraSeparada){
            System.out.println("Letra palabra = "+String.valueOf(letra));
        }
        char[][] resultado = new char[2][ControladorJuegoAdivLaPal.cantidadLetras];
        char[] letrasCorrectas = new char[ControladorJuegoAdivLaPal.cantidadLetras];
        char[] letrasEncontradas = new char[ControladorJuegoAdivLaPal.cantidadLetras];
        ArrayList<Character> letrasPorAdivinar = new ArrayList(); 
        for(int i=0; i<ControladorJuegoAdivLaPal.cantidadLetras; i++){
            if(intentoUsuario[i] == palabraSeparada[i]){
                letrasCorrectas[i] = intentoUsuario[i];
                System.out.println("Letra correcta = "+String.valueOf(letrasCorrectas[i]));
                letrasPorAdivinar.add('\0');
            }
            else{
                letrasPorAdivinar.add(palabraSeparada[i]);
            }
        }
        char[] arrayAuxiliar = new char[intentoUsuario.length];
        for(int k=0; k<arrayAuxiliar.length; k++){
            String letraStr = letrasPorAdivinar.get(k).toString();
            char letraChar = letraStr.charAt(0);
            arrayAuxiliar[k] = letraChar;
        }
        System.out.println("Largo arrayAuxiliar= "+arrayAuxiliar.length);
        for(int j=0;j<arrayAuxiliar.length;j++){
            System.out.println("J="+j);
            if(intentoUsuario[j] != palabraSeparada[j]){
                if(letrasPorAdivinar.contains(intentoUsuario[j])){
                    letrasEncontradas[j] = intentoUsuario[j];
                    System.out.println("Letra encontrada = "+String.valueOf(letrasEncontradas[j]));
                    System.out.println("Letra a remover= "+intentoUsuario[j]);
                    System.out.println("Largo letras por adivinar= "+letrasPorAdivinar.size());
                    Character ch = intentoUsuario[j];
                    letrasPorAdivinar.remove(ch);
                }
            }  
        }
        resultado[0] = letrasCorrectas;
        resultado[1] = letrasEncontradas;
        boolean comprobacionVictoria = true;
        for(int j=0; j<letrasCorrectas.length; j++){
            if(letrasCorrectas[j] != palabraSeparada[j]){
                comprobacionVictoria = false;
            }
        }
        if(comprobacionVictoria){
            this.victoria = true;
        }
        return resultado;
    }
    
    public ArrayList<Integer> ubicarLetraCorrecta(char[] letrasCorrectas){
        ArrayList<Integer> indices = new ArrayList();
        for(int i=0; i<letrasCorrectas.length; i++){
            if(letrasCorrectas[i] != '\0'){
                indices.add(i);
            }
        }
        return indices;
    }
    
    public ArrayList<Integer> ubicarLetrasEncontradas(char[] letrasEncontradas){
        ArrayList<Integer> indices = new ArrayList();
        for(int i=0; i<letrasEncontradas.length; i++){
            if(letrasEncontradas[i] != '\0'){
                indices.add(i);
            }
        }
        return indices;
    }
    
}
    

