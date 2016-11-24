package Modelo;

import java.util.*;

public class Batalla {
    
   private int turno;
   private Jugador jugador;
   private Personaje[] pjsJugador;
   private Personaje[] pjsCpu;
   private Casilla[][] tablero;
   
   public Batalla(){
       tablero = new Casilla[25][25];
       for(int i=0;i<25;i++){
           for(int j=0;j<25;j++){
               tablero[i][j] = new Casilla();
           }
       }
   }
   
   public void terminarTurno() {}
   
   public int verificarGanador(Personaje[] pjsJugador, Personaje[] pjsCpu) {
      return 0;
   }
   
    public void asignarTerrenos(int areaAsignatura, Random numeroRandom){
        numeroRandom = new Random();
        int cntSuelo = 0;
        int cntBosque = 0;
        int cntRio = 0;
        int maxSuelo = 0;
        int maxBosque = 0;
        int maxRio = 0;
        switch(areaAsignatura){
            case 1://Área Plan Común
                maxSuelo = 469;
                maxRio = 156;
                break;
            case 2://Área Economía
                maxSuelo = 446;
                maxRio = 179;
                break;
            case 3://Área Especialidad
                maxSuelo = 312;
                maxRio = 125;
                maxBosque = 188;
                break;
        }
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                int numero = 0;
                numero = numeroRandom.nextInt(3)+1;
                switch(numero){
                    case 1://Pone un suelo
                        if(cntSuelo < maxSuelo){
                            cntSuelo++;
                            tablero[i][j].setTerreno(1);
                            break;
                        }
                    case 2://Pone un rio
                        if(cntRio < maxRio){
                            cntRio++;
                            tablero[i][j].setTerreno(2);
                            break;
                        }
                    case 3://Pone un bosque
                        if(cntBosque < maxBosque){
                            cntBosque++;
                            tablero[i][j].setTerreno(3);
                            break;
                        }
                    default:
                        j--;
                }
            }
        }
    }

    public void corregirRios(){
        int riosCerca;
        int cntTierra = 0;
        int cntRio = 0;
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                riosCerca = 0;
                if(tablero[i][j].getTerreno() == 2){
                    try{
                        if(tablero[i][j-1].getTerreno() == 2){
                            riosCerca++;
                            }
                        }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i][j+1].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i-1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i+1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    if(riosCerca == 0){
                        cntRio--;
                        tablero[i][j].setTerreno(1);
                        cntTierra++;
                    }
                }
                if(tablero[i][j].getTerreno() == 1 && cntTierra != 0){
                    try{
                        if(tablero[i][j-1].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i][j+1].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i-1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    try{
                        if(tablero[i+1][j].getTerreno() == 2){
                            riosCerca++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                    }
                    if(riosCerca > 0){
                        tablero[i][j].setTerreno(2);
                        cntTierra--;
                        cntRio++;
                    }
                }
            }
        }
    }
    
    public void asignarAlturas(Random distribAltura){
        distribAltura = new Random();
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                int altura=0;
                do{
                    altura = (int)Math.round(distribAltura.nextGaussian()*1+5);
                }while(altura<0||altura>10);
                this.getTablero(i,j).setAltura(altura);
            }
        }
    }
   
    public boolean revisarAlturas(){
        boolean comprobador = true;//Mientras sea cierto, la distribucion es valida
        for(int i=0; i<25; i++){
            if(!comprobador){
                break;
            }
            for(int j=0; j<25; j++){
                int contador = 0;
                try{
                    if(Math.abs(tablero[i][j-1].getAltura() - tablero[i][j].getAltura())>2){//Si la casilla a la izquierda tiene una diferencia de altura mayor o igual a 2
                        contador++;
                        if(contador>=4){//Si ninguna casilla adyacente cumple con la condicion
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i][j+1].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i+1][j].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                    else if(Math.abs(tablero[i-1][j].getAltura() - tablero[i][j].getAltura())>2){
                        contador++;
                        if(contador>=4){
                            comprobador = false;
                            System.out.println("Generando otra vez...");
                            break;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){//Atrapa el error de rango
                }
            }
        }
        return comprobador;
    }
    
    public String ponerRutaImagenesTerreno(int i, int j){
        String ruta = "";
        if(tablero[i][j].getTerreno() == 1){//Tierra
            if(tablero[i][j].getAltura() == 0 || tablero[i][j].getAltura() == 1){
                ruta = "src/Imagen/Tierra01.png";
            }
            else if(tablero[i][j].getAltura() == 2 || tablero[i][j].getAltura() == 3){
                ruta = "src/Imagen/Tierra23.png";
            }
            else if(tablero[i][j].getAltura() == 4 || tablero[i][j].getAltura() == 5){
                ruta = "src/Imagen/Tierra45.png";
            }
            else if(tablero[i][j].getAltura() == 6 || tablero[i][j].getAltura() == 7){
                tablero[i][j].setTerreno(4); //Montaña
                ruta = "src/Imagen/Montania67.png";
            }
            else if(tablero[i][j].getAltura() == 8 || tablero[i][j].getAltura() == 9){
                tablero[i][j].setTerreno(4); //Montaña
                ruta = "src/Imagen/Montania89.png";
            }
            else if(tablero[i][j].getAltura() == 10){
                tablero[i][j].setTerreno(4); //Montaña
                ruta = "src/Imagen/Montania10.png";
            }
        }
        else if(tablero[i][j].getTerreno() == 2){//Río
            if(tablero[i][j].getAltura() <= 5){
                ruta = "src/Imagen/Rio05.png";
            }
            else if(tablero[i][j].getAltura() >= 6){
                ruta = "src/Imagen/Rio610.png";
            }
        }
        else if(tablero[i][j].getTerreno() == 3){//Bosque
            if(tablero[i][j].getAltura() == 0 || tablero[i][j].getAltura() == 1){
                ruta = "src/Imagen/Bosque01.png";
            }
            else if(tablero[i][j].getAltura() == 2 || tablero[i][j].getAltura() == 3){
                ruta = "src/Imagen/Bosque23.png";
            }
            else if(tablero[i][j].getAltura() == 4 || tablero[i][j].getAltura() == 5){
                ruta = "src/Imagen/Bosque45.png";
            }
            else if(tablero[i][j].getAltura() == 6 || tablero[i][j].getAltura() == 7){
                ruta = "src/Imagen/Bosque67.png";
            }
            else if(tablero[i][j].getAltura() == 8 || tablero[i][j].getAltura() == 9){
                ruta = "src/Imagen/Bosque89.png";
            }
            else if(tablero[i][j].getAltura() == 10){
                ruta = "src/Imagen/Bosque10.png";
            }
        }
        return ruta;
    }
    
    public String ponerRutaImagenPersonaje(int i, int j){
        String ruta = "src/Imagen/";
        int rol = tablero[i][j].getPersonaje().getRol();
        switch(rol){
            case 1:
                ruta = ruta+"Guerrero/Guerrero ";
                break;
            case 2:
                ruta = ruta+"Arquero/Arquero ";
                break;
            case 3:
                ruta = ruta+"Ninja/Ninja ";
                break;
            case 4:
                int subRol = tablero[i][j].getPersonaje().getSubRol();
                String subRuta = "Mago ";
                switch(subRol){
                    case 1:
                        subRuta = subRuta+"Humanista/MagoH ";
                        break;
                    case 2:
                        subRuta = subRuta+"Tecnologo/MagoT ";
                        break;
                    case 3:
                        subRuta = subRuta+"Medico/MagoM ";
                        break;
                }
                ruta = ruta+"Mago/"+subRuta;
                break;
        }
        int tipoTerreno = tablero[i][j].getTerreno();
        int altura = tablero[i][j].getAltura();
        switch(tipoTerreno){
            case 1:
                ruta = ruta+"Tierra";
                if(altura == 0 || altura == 1){
                    ruta = ruta+"01 ";
                }
                else if(altura == 2 || altura == 3){
                    ruta = ruta+"23 ";
                }
                else if(altura == 4 || altura == 5){
                    ruta = ruta+"45 ";
                }
                break;
            case 2:
                ruta = ruta+"Rio";
                if(altura <= 5){
                    ruta = ruta+"05 ";
                }
                else if(altura > 5){
                    ruta = ruta+"610 ";
                }
                break;
            case 3:
                ruta = ruta+"Bosque";
                if(altura == 0 || altura == 1){
                    ruta = ruta+"01 ";
                }
                else if(altura == 2 || altura == 3){
                    ruta = ruta+"23 ";
                }
                else if(altura == 4 || altura == 5){
                    ruta = ruta+"45 ";
                }
                else if(altura == 6 || altura == 7){
                    ruta = ruta+"67 ";
                }
                else if(altura == 8 || altura == 9){
                    ruta = ruta+"89 ";
                }
                else if(altura == 10){
                    ruta = ruta+"10 ";
                }
                break;
            case 4:
                ruta = ruta+"Montaña";
                if(altura == 6 || altura == 7){
                    ruta = ruta+"67 ";
                }
                else if(altura == 8 || altura == 9){
                    ruta = ruta+"89 ";
                }
                else if(altura == 10){
                    ruta = ruta+"10 ";
                }
                break;
        }
        boolean alineacion = tablero[i][j].getPersonaje().getEsCpu();
        if(alineacion){
            ruta = ruta+"CPU";
        }
        else{
            ruta = ruta+"PJ";
        }
        ruta = ruta+".png";
        return ruta;
    }

    public Casilla getTablero(int i, int j) {
        return tablero[i][j];
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }
    
    public String ubicarPersonaje(Personaje personaje, int i, int j){
        String ruta = "";
        if(tablero[i][j].getCaminable() && tablero[i][j].getDisponible()){
            tablero[i][j].setPersonaje(personaje);
            ruta = ponerRutaImagenPersonaje(i,j);
        }
        return ruta;
    }
    
    public String[] ubicarPersonajesCpu(Personaje[] personajesCpu){
        String[] paramPonerImagen = new String[personajesCpu.length];
        for(int i=0; i<personajesCpu.length; i++){
            String ruta = "";
            Random numero = new Random();
            boolean comprobador = false;
            int filaRandom;
            int columnaRandom;
            do{
                filaRandom = numero.nextInt(25);
                columnaRandom = numero.nextInt(4)+21;
                if(tablero[filaRandom][columnaRandom].getDisponible() && tablero[filaRandom][columnaRandom].getCaminable()){
                    comprobador = true;
                }
            }while(!comprobador);
            ruta = ubicarPersonaje(personajesCpu[i], filaRandom, columnaRandom);
            ruta = ruta+"-"+filaRandom+"-"+columnaRandom;
            paramPonerImagen[i] = ruta;
        }
        return paramPonerImagen;
    }
    
    public Personaje[] obtenerPersonajesCpu(/*Asignatura ramo*/){ //Método que obtiene los personajes del cpu según la asignatura
        //Pendiente: Implementar método apropiadamente
        Personaje[] personajesCpu;
        personajesCpu = new Personaje[5];
        for(int i=0; i<personajesCpu.length; i++){
            personajesCpu[i] = new Personaje(i+1);
        }
        return personajesCpu;
    }

}