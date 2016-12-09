
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
                recompensa = 500;
                break;
            case 2:
                recompensa = 750;
                break;
            case 3:
                recompensa = 1000;
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
        ArrayList<Integer> indicesAdivinados = new ArrayList(); 
        for(int i=0; i<ControladorJuegoAdivLaPal.cantidadLetras; i++){
            if(intentoUsuario[i] == palabraSeparada[i]){
                letrasCorrectas[i] = intentoUsuario[i];
                System.out.println("Letra correcta = "+String.valueOf(letrasCorrectas[i]));
                indicesAdivinados.add(i);
            }
        }
        for(int j=0;j<ControladorJuegoAdivLaPal.cantidadLetras;j++){
            for(int k=0;k<ControladorJuegoAdivLaPal.cantidadLetras;k++){
                if(intentoUsuario[j] == palabraSeparada[k]){
                    if(!indicesAdivinados.contains(k)){
                        letrasEncontradas[j] = intentoUsuario[j];
                        System.out.println("Letra encontrada = "+String.valueOf(letrasEncontradas[j]));
                        break;
                    }
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
    

