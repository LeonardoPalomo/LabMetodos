package Modelo;

import Controlador.ControladorLogin;
import static Modelo.Batalla.errorMovimiento;
import static java.lang.Math.abs;
import java.util.*;
import javax.swing.JOptionPane;

public class Personaje {
   private String nombre;
   private int hpTotal;
   private int hpActual;
   private int manaTotal;
   private int manaActual;
   private int atkCerca;
   private int atkLejos;
   private int spAtkCerca;
   private int spAtkLejos;
   private int def;
   private int spDef;
   private int experiencia;
   private int nivel;
   private int movTotal;
   private int movActual;
   private int ptsTraicion;
   private Equipamiento[] equipamiento = new Equipamiento[6];   //2 armas + 4 partes de armadura -> [0] arma, [1] arma, [2] cabeza, [3] torso, [4] piernas, [5] pies
   private int velocidad;
   private int tipo; //1 alumno, 2 ayudante, 3 profesor
   private int rol; //1 guerrero, 2 arquero, 3 ninja, 4 mago
   private int subRol; //sólo para mago: 1 humanista, 2 tecnologo, 3 medico, 0 para no mago
   private int[] stock = new int[4]; //Array de ints: [0] atkBajo, [1] atkMedio, [2] atkAlto, [3] especial
   private int precio;
   private String dueno;
   private int[] posicion = new int[2];
   private boolean esCpu; //true es cpu, false es del jugador

   //Constructor provisorios
   public Personaje(){
       this.nombre = "null";
       this.hpTotal = 0;
       this.hpActual = hpTotal;
       this.manaTotal = 0;
       this.manaActual = manaTotal;
       this.atkCerca = 0;
       this.atkLejos = 0;
       this.spAtkCerca = 0;
       this.spAtkLejos = 0;
       this.def = 0;
       this.spDef = 0;
       this.experiencia = 0;
       this.nivel = 0;
       this.movTotal = 0;
       this.movActual = movTotal;
       this.ptsTraicion = 0;
       this.velocidad = 0;
       this.tipo = 0;
       this.rol = 0;
       this.subRol = 0;
       this.dueno = "null";
       this.esCpu = true;
   }
   
   public Personaje(String nombre, int rol, int subRol){
       this.nombre = nombre;
       for(int i=0; i<6; i++){
        this.equipamiento[i] = new Equipamiento();
       }
       switch(rol){
           case 1:
               this.hpTotal = 100;
               this.hpActual = hpTotal;
               this.manaTotal = 0;
               this.manaActual = manaTotal;
               this.atkCerca = 20;
               this.atkLejos = 5;
               this.def = 8;
               this.spDef = 6;
               this.nivel = 1;
               this.movTotal = 8;
               this.movActual = movTotal;
               this.velocidad = 10;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 2:
               this.hpTotal = 80;
               this.hpActual = hpTotal;
               this.manaTotal = 0;
               this.manaActual = manaTotal;
               this.atkCerca = 5;
               this.atkLejos = 20;
               this.def = 6;
               this.spDef = 5;
               this.nivel = 1;
               this.movTotal = 15;
               this.movActual = movTotal;
               this.equipamiento[0] = new Equipamiento("Arco Pulento");
               this.velocidad = 11;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 3:
               this.hpTotal = 90;
               this.hpActual = hpTotal;
               this.manaTotal = 10;
               this.manaActual = manaTotal;
               this.atkCerca = 15;
               this.atkLejos = 8;
               this.spAtkCerca = 10;
               this.spAtkLejos = 6;
               this.def = 7;
               this.spDef = 6;
               this.nivel = 1;
               this.movTotal = 10;
               this.movActual = movTotal;
               this.velocidad = 12;
               this.tipo = 1;
               this.rol = rol;
               this.subRol = 0;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
           case 4:
               this.hpTotal = 70;
               this.hpActual = hpTotal;
               this.manaTotal = 30;
               this.manaActual = manaTotal;
               this.atkCerca = 5;
               this.atkLejos = 5;
               this.def = 5;
               this.spDef = 8;
               this.nivel = 1;
               this.movTotal = 6;
               this.movActual = movTotal;
               this.velocidad = 9;
               this.tipo = 1;
               this.rol = rol;
               switch(subRol){
                   case 1:
                       this.spAtkCerca = 20;
                       this.spAtkLejos = 10;
                       break;
                   case 2:
                       this.spAtkCerca = 10;
                       this.spAtkLejos = 20;
                       break;
                   case 3:
                       this.spAtkCerca = 10;
                       this.spAtkLejos = 10;
               }
               this.subRol = subRol;
               this.stock[0] = 3;
               this.stock[1] = 3;
               this.stock[2] = 3;
               this.stock[3] = 1;
               this.esCpu = false;
               this.setDueño(ControladorLogin.usuarioActivo);
               break;
        }
        this.equiparObjetosIniciales();
    }
   
   public Personaje(int i){
       this.nombre = "Genérico "+i;
       this.hpTotal = i*10;
       this.hpActual = hpTotal;
       this.manaTotal = i*5;
       this.manaActual = manaTotal;
       this.atkCerca = i*2;
       this.atkLejos = (int)Math.round(i*1.5);
       this.spAtkCerca = (int)Math.round(i*2.5);
       this.spAtkLejos = i;
       this.def = (int)Math.round(i/2);
       this.spDef = i;
       this.nivel = i;
       this.movTotal = 10-i;
       this.movActual = movTotal;
       this.ptsTraicion = 0;
       this.velocidad = i;
       this.tipo = (i % 3)+1;
       this.rol = (i<4)?i:4;
       this.subRol = (i<4)?0:i-3;
       this.stock[0] = 3;
       this.stock[1] = 3;
       this.stock[2] = 3;
       this.stock[3] = 1;
       this.esCpu = true;
       setDueño();
   }
   
   /**public Personaje(int hp, int mana, int atkCerca, int atkLejos, int def){
       this.hpTotal = hp;
       this.manaTotal = mana;
       this.atkCerca = atkCerca;
       this.atkLejos = atkLejos;
       this.def = def;
   }**/

    public String[] getDatosSelPj(){
        String[] datos = new String[15];
        datos[0] = this.getNombre();
        datos[1] = String.valueOf(this.getNivel());
        datos[2] = String.valueOf(this.getExperiencia());
        String tipo = "";
        switch(this.getTipo()){
            case 1:
                tipo = "Alumno";
                break;
            case 2:
                tipo = "Ayudante";
                break;
            case 3:
                tipo = "Profesor";
                break;
        }
        datos[3] = tipo;
        String rol = "";
        switch(this.getRol()){
            case 1:
                rol = "Guerrero";
                break;
            case 2:
                rol = "Arquero";
                break;
            case 3:
                rol = "Ninja";
                break;
            case 4:
                rol = "Mago";
                break;
        }
        datos[4] = rol;
        String subRol = "";
        switch(this.getSubRol()){
            case 1:
                subRol = "Humanista";
                break;
            case 2:
                subRol = "Tecnólogo";
                break;
            case 3:
                subRol = "Médico";
                break;
            case 0:
                subRol = "";
                break;
        }
        datos[5] = subRol;
        datos[6] = String.valueOf(this.getHpTotal());
        datos[7] = String.valueOf(this.getManaTotal());
        datos[8] = String.valueOf(this.getAtkCerca());
        datos[9] = String.valueOf(this.getAtkLejos());
        datos[10] = String.valueOf(this.getSpAtkCerca());
        datos[11] = String.valueOf(this.getSpAtkLejos());
        datos[12] = String.valueOf(this.getDef());
        datos[13] = String.valueOf(this.getSpDef());
        datos[14] = String.valueOf(this.getVelocidad());
        return datos;
    }
   
    public String getNombre() {
        return nombre;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public int getHpActual() {
        return hpActual;
    }
    
    public void setHpActual(int hp){
        this.hpActual = hp;
    }

    public int getManaTotal() {
        return manaTotal;
    }

    public int getManaActual() {
        return manaActual;
    }

    public int getAtkCerca() {
        return atkCerca;
    }

    public int getAtkLejos() {
        return atkLejos;
    }

    public int getSpAtkCerca() {
        return spAtkCerca;
    }

    public int getSpAtkLejos() {
        return spAtkLejos;
    }

    public int getDef() {
        return def;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMovTotal() {
        return movTotal;
    }

    public int getMovActual() {
        return movActual;
    }

    public int getPtsTraicion() {
        return ptsTraicion;
    }

    public Equipamiento[] getEquipamiento() {
        return equipamiento;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getTipo() {
        return tipo;
    }

    public int getRol() {
        return rol;
    }

    public int getSubRol() {
        return subRol;
    }

    public int[] getStock() {
        return stock;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDueno() {
        return dueno;
    }

    public boolean getEsCpu() {
        return esCpu;
    }
    
    public int[] getPosicion(){
        return posicion;
    }
    
    public void setDueño(String dueño){
        if(this.esCpu){
            this.dueno = "CPU";
        }
        else{
            this.dueno = dueño;
        }
    }
    //Sobrecarga
    public void setDueño(){
        this.dueno = "CPU";
    }
    
    public void setPosicion(int[] posicion){
        this.posicion = posicion;
    }
    //Sobrecarga
    public void setPosicion(int i, int j){
        this.posicion[0] = i;
        this.posicion[1] = j;
    }
    
    public void restarMovActual(){
        this.movActual--;
    }
    
    /*
    public boolean tieneArmaLargoAlcance(){
        boolean comprobador = false;
        if(){
        
        }
        return comprobador;
    }
    */
    //Metodo que calcula el daño los daños realizados al atacante y al atacado(en ese orden) segun las victorias y derrotas del duelo
    public ArrayList<Integer> atacarCerca(Personaje atacado, int victorias, int derrotas) {
        ArrayList<Integer> daños = new ArrayList();
        int damageSalida = 0;
        int damageEntrada = 0;
        for(int victoria=0; victoria<victorias; victoria++){//Segun las victorias, calcula el daño a realizar al atacado
            int damage = this.atkCerca - atacado.def;
            if(damage<0){
                damage = 0;
            }
            else{
                damageSalida += damage;
            }
        }
        for(int derrota=0; derrota<derrotas; derrota++){//Segun las derrotas, calcula el daño a realizar al atacante
            int damage = atacado.atkCerca - this.def;
            if(damage<0){
                damage = 0;
            }
            else{
               damageEntrada += damage; 
            }
        }
        daños.add(damageEntrada);
        daños.add(damageSalida);
        return daños;
    }
    public ArrayList<Integer> ataquesCpu(){
        int stockGeneralBajo = this.stock[0];
        int stockGeneralMedio = this.stock[1]; 
        int stockGeneralAlto = this.stock[2]; 
        int stockGeneralEspecial = this.stock[3]; 
        Random rnd = new Random();
        ArrayList<Integer> eleccion = new ArrayList();
        for(int k=0; k<7; k++){
            boolean verificador;
            int i;
            do{
                i = (int)(rnd.nextDouble()*4 + 0);
                if(this.stock[i]>0){
                    verificador = true;
                }
            }
            while(verificador = false);
            this.stock[i] = this.stock[i] - 1;
            eleccion.add(i);
        }
        this.stock[0] = stockGeneralBajo;
        this.stock[1] = stockGeneralMedio;
        this.stock[2] = stockGeneralAlto;
        this.stock[3] = stockGeneralEspecial;
        return eleccion;
   }
    /*
   
    * Funcion que verifica si es posible el ataque a larga distancia
    * @param posObjetivo arreglo que indica la posicion del objetivo
     * @return true si se puede o false si no se puede
    
    public boolean verificarAtacarLejos(int[] posObjetivo) {
       int difFila; //diferencia de fila
       int difColumna; //diferencia de columna
       int suma;
       difColumna = abs(posicion[1] - posObjetivo[1]);
       difFila = abs(posicion[0] - posObjetivo[0]);
       suma = difFila + difColumna;
       return suma == 5 || suma == 6 || suma == 7 || suma == 8;
    }
   
   
    * Funcion que verifica si es posible el ataque a corto alcance
    * @param posObjetivo arreglo que indica la posicion del objetivo
    * @return 
    
    public boolean verificarAtacarCorto(int[] posObjetivo) {
       int difFila; //diferencia de fila
       int difColumna; //diferencia de columna
       int suma;
       difFila = abs(posicion[1] - posObjetivo[1]); //no estoy seguro si es this.posicion
       difColumna = abs(posicion[0] - posObjetivo[0]);
       suma = difFila + difColumna;
       return suma == 1 || suma == 2;
    }
    */

   /**
    * Funcion que calcula el tipo de ataque a realizar en función de la distancia del objetivo
    * @param posObjetivo arreglo que indica la posicion del objetivo
    * @return tipoAtaque número que representa el tipo de ataque -1 cerca, 2 lejos, 0 nada
    */
    public int calcularRangoAtaque(int[] posObjetivo){
        int tipoAtaque = 0; //No está dentro del rango de ataque
        int difFila; //diferencia de fila
        int difColumna; //diferencia de columna
        int suma;
        difColumna = abs(posicion[1] - posObjetivo[1]);
        difFila = abs(posicion[0] - posObjetivo[0]);
        suma = difFila + difColumna;
        if(suma == 1 || suma == 2){
            tipoAtaque = 1; //Corto alcance
        }
        else if(suma == 5 || suma == 6 || suma == 7 || suma == 8){
            tipoAtaque = 2; //Largo alcance
        }
        return tipoAtaque;
    }
    
   /**
    * Funcion que realiza el ataque lejos
    * @param def la defensa del personaje objetivo 
     * @param terreno el tipo de terreno en que se encuentra el personaje objetivo
    * @return el daño realizado (restar despues con el hp)
    */
    public int atacarLejos(int def,int terreno){
        Random chance = new Random();
        int damage;
        int fallo;
        if(terreno == 3){
            fallo = chance.nextInt(5);
        }
        else{
            fallo = 1;
        }
        if(fallo == 0){
            damage = -1;
        }
        else{
            damage = this.atkLejos - def;
            if (damage < 0){
                damage = 0;
            }
        }
        
        return damage;
    }
    
    public int aplicarDaño(int daño){
        this.hpActual = hpActual - daño;
        if(hpActual < 0){
            hpActual = 0;
        }
        return hpActual;
    }
  
    public boolean mover(int i, int j, boolean comprobAltura){
        boolean comprobador = false;
        if(this.movActual == 0){
            Batalla.errorMovimiento = "Al personaje "+this.getNombre()+" no le quedan puntos de movimiento";
            System.out.println(Batalla.errorMovimiento);
            JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Puntos de movimiento insuficientes",
                      JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(comprobAltura){
                this.posicion[0] = i;
                this.posicion[1] = j;
                this.movActual--;
                comprobador = true;
            }
            else{
                System.out.println(Batalla.errorMovimiento);
                JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Movimiento no permitido",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        return comprobador;
    }
    
    public boolean moverMago(int i, int j, boolean comprobarRio){
        boolean comprobador = false;
        if(this.movActual == 0){
            Batalla.errorMovimiento = "Al personaje "+this.getNombre()+" no le quedan puntos de movimiento";
            System.out.println(Batalla.errorMovimiento);
            JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Puntos de movimiento insuficientes",
                      JOptionPane.ERROR_MESSAGE);
            }
        else{         
            if(posicion[0] == i && posicion[1] == j){
                comprobador = false;
                Batalla.errorMovimiento = "Estás intentando moverte a tu misma casilla... ._.";
                System.out.println(Batalla.errorMovimiento);
                JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Movimiento no permitido",
                    JOptionPane.ERROR_MESSAGE);
            }
            else{
                int difFila; //diferencia de fila
                int difColumna; //diferencia de columna
                int suma;
                difFila = abs(this.posicion[0] - i);
                difColumna = abs(this.posicion[1] - j);
                suma = difFila + difColumna;
                if(suma <= movActual && comprobarRio){
                    this.posicion[0] = i;
                    this.posicion[1] = j;
                    this.movActual = this.movActual - suma;
                    comprobador = true;            
                }
                else{
                    if(!comprobarRio){
                        Batalla.errorMovimiento = "La casilla seleccionada no es válida";
                        System.out.println(Batalla.errorMovimiento);
                        JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Movimiento no permitido",
                            JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Batalla.errorMovimiento = "Puntos de movimiento insuficientes";
                        System.out.println(Batalla.errorMovimiento);
                        JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Movimiento no permitido",
                            JOptionPane.ERROR_MESSAGE);
                    }    
                }
            } 
        }
        return comprobador;
    }
      
    public boolean moverNinja(int i, int j, boolean comprobAltura){
        boolean comprobador = false;
        if(this.movActual == 0){
            Batalla.errorMovimiento = "Al personaje "+this.getNombre()+" no le quedan puntos de movimiento";
            System.out.println(Batalla.errorMovimiento);
            JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Puntos de movimiento insuficientes",
                      JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(comprobAltura){
                this.posicion[0] = i;
                this.posicion[1] = j;
                this.movActual--;
                comprobador = true;
            }
            else{
                System.out.println(Batalla.errorMovimiento);
                JOptionPane.showMessageDialog(null,Batalla.errorMovimiento,"Modelo Personaje - Movimiento no permitido",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        return comprobador;
    }
    /**
     * Funcion que permite el movimiento de la cpu
     * @param posicion, arreglo que indica la posicion actual del personajeCPU
     * @param direccion entero que indica a donde moverse 0:arriba 1:derecha 2:abajo 3:izquierda 4:imposible
     * @return la nueva posicion
     */
    /*public int[] moverCPU(int[] posicion, int direccion){
        int[] nuevaPosicion = new int[2];
        switch(direccion){
            case 0:
                nuevaPosicion[0] = posicion[0] + 1;
            case 1:
                nuevaPosicion[1] = posicion[1] + 1;
            case 2:
                nuevaPosicion[0] = posicion[0] - 1;
            case 3:
                nuevaPosicion[1] = posicion[1] - 1;
        
        }
        return nuevaPosicion;

    }*/

    public void equiparObjetosIniciales(){
        for(int i=0; i<6; i++){
            if(this.equipamiento[i] != null){
                this.atkCerca += equipamiento[i].getBonusAtkCerca();
                this.atkLejos += equipamiento[i].getBonusAtkLejos();
                this.spAtkCerca += equipamiento[i].getBonusSpAtkCerca();
                this.spAtkLejos += equipamiento[i].getBonusSpAtkLejos();
                this.def += equipamiento[i].getBonusDef();
                this.spDef += equipamiento[i].getBonusSpDef();
                this.hpTotal += equipamiento[i].getBonusVida();
                this.manaTotal += equipamiento[i].getBonusMana();
                this.movTotal += equipamiento[i].getBonusMov();
                this.velocidad += equipamiento[i].getBonusSpeed();
            }
        }
    }
    //Metodo que indica el recorrido que debe hacer la Cpu para alcanzar a un enemigo
    public ArrayList<int[]> moverCpu(int[] posicionCpu, Casilla[][] tablero, int[] objetivo){
        ArrayList<int[]> recorrido = new ArrayList();//Recorrido al reves(desde el personaje objetivo hasta la posicion de la Cpu)
        ArrayList<ArrayList<int[]>> abierto = new ArrayList();//Estados abiertos (Lista de listas de arreglos de enteros de largo 2) (Estado actual es el primer arreglo de enteros de cada lista de la lista)
        ArrayList<ArrayList<int[]>> cerrado = new ArrayList();//Estados cerrados
        //Se crea el estado inicial (Arreglo de 2 posiciones)
        boolean sePuede = true;
        //Esto es para el caso de que hayan mas de 9 enemigos
        /*if(this.posibleAcercar(tablero, objetivo[0], objetivo[1])){
            sePuede = true;
        }*/
        if(sePuede){
        ArrayList<int[]> eInicial = new ArrayList();
        int[] inicial = posicionCpu;
        eInicial.add(inicial);
        eInicial.add(inicial);//Se agrega 2 veces por que no hay estado anterior al inicial
        abierto.add(eInicial);//Se agrega el primer estado
        //Se crea un verificador de que si en alguna transicion se llega al personaje enemigo
        boolean verificadorMaximo = false;
        //------------------------ 
        do{
            //Se obtiene el primer elemento de la lista de estados abiertos
            ArrayList<int[]> estadoActual = abierto.get(0);
            //Posiciones x,y del estado actual
            int posicionX = estadoActual.get(0)[0];
            int posicionY = estadoActual.get(0)[1];
            int[] posicionActual = new int[2];
            posicionActual[0] = posicionX;
            posicionActual[1] = posicionY;
            //Transiciones
            //----------------------------------
            //Coordenadas de la casilla a revisar
            int nuevaPosicionX;
            int nuevaPosicionY;
            //Posicion [x-1,y] (arriba)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX-1;
                int varY = posicionY;
            if(posicionX-1>=0 && posicionX-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+1,y] (Abajo)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX+1;
                int varY = posicionY;
            if(posicionX+1>=0 && posicionX+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-1] (Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-1;
                int var = posicionX;
            if(posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+1] (Derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+1;
                int var = posicionX;
            if(posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0] == nuevaPosicionX && abierto.get(i).get(0)[1] == nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x-1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY-1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x-1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY+1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY-1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY+1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x-2,y](Muy arriba)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX-2;
            if(posicionX-2>=0 && posicionX-2<25){
                nuevaPosicionX = posicionX-2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+2,y](Muy Abajo)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX+2;
            if(posicionX+2>=0 && posicionX+2<25){
                nuevaPosicionX = posicionX+2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-2] (Muy Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-2;
                int var = posicionX;
            if(posicionY-2>=0 && posicionY-2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+2] (Muy derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+2;
                int var = posicionX;
            if(posicionY+2>=0 && posicionY+2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Luego de realizar las transiciones, se cierra el estado y se elimina de los abiertos
            cerrado.add(abierto.get(0));
            abierto.remove(0);
        }
        while(verificadorMaximo==false || abierto.size()==0);
        }
        else{//Si el compadre esta rodeado
            int[] objetivoN = this.nuevoObjetivo(tablero, objetivo);
            ArrayList<int[]> recorridoN = this.moverCpu(posicionCpu, tablero, objetivoN);
            return recorridoN;
        }
        //Se crea la lista con las posiciones de camino
        if(abierto.size()==0){
            System.out.println("No hay salida uwu");
            return null;
        }
        ArrayList<int[]> ultimoEstado = cerrado.get(cerrado.size()-1);
        //Ultimo estado obtenido correctamente
        //System.out.println("Ultimo Estado(actual): "+ultimoEstado.get(0)[0]+","+ultimoEstado.get(0)[1]);
        //System.out.println("Ultimo Estado(Anterior): "+ultimoEstado.get(1)[0]+","+ultimoEstado.get(1)[1]);
        recorrido.add(ultimoEstado.get(0));

        this.obtenerRecorrido(ultimoEstado, cerrado, recorrido);
        //Se da vuelta las casillas recorrido
        Collections.reverse(recorrido);//Funcion que da vuelta una lista
        //Se elimina la posicion inicial del recorrido
        recorrido.remove(0);
        return recorrido;
    }
    
    //metodo recursivo que entrega el recorrido al reves del movimiento de la Cpu
    public void obtenerRecorrido(ArrayList<int[]> estado, ArrayList<ArrayList<int[]>> estados, ArrayList<int[]> recorrido){
        ArrayList<int[]> respuesta = new ArrayList();
        //Se busca el estado anterior
        int[] anterior = estado.get(1);
        //Se agrega al recorrido
        recorrido.add(anterior);
        for(int i=0; i<estados.size(); i++){
            if(estados.get(i).get(0)[0]==anterior[0] && estados.get(i).get(0)[1] == anterior[1]){
                respuesta = estados.get(i);
                //System.out.println("SE creo respuesta y es el estado n°: "+i);
            }
        }
        //Si no es el estado inicial, se llama de nuevo a la funcion
        if(respuesta.get(0)[0]!=respuesta.get(1)[0] || respuesta.get(0)[1]!=respuesta.get(1)[1]){//
            this.obtenerRecorrido(respuesta, estados, recorrido);
        }
    }
    
    //Inteligencia del movimiento del ninja----¡¡¡¡OJOOO!!!
    //---> Al implementarlo, se debe comprobar la posicion en la que quedara luego de gastar todos sus puntos de movimiento,
    //--->en el caso de que sea un rio, se posiciona en ella casilla anterior, la forma de  hacer esto es:
    //--->if(tablero[recorrido.get(recorrido.size()-1)[0]][recorrido.get(recorrido.size()-1)[1]].getCaminable()== false){
    //--->   recorrido.remove(recorrido.size()-1);
    //--->}
    public ArrayList<int[]> moverCpuMago(int[] posicionCpu, Casilla[][] tablero, int[] objetivo){
        ArrayList<int[]> recorrido = new ArrayList();//Recorrido al reves(desde el personaje objetivo hasta la posicion de la Cpu)
        ArrayList<ArrayList<int[]>> abierto = new ArrayList();//Estados abiertos (Lista de listas de arreglos de enteros de largo 2) (Estado actual es el primer arreglo de enteros de cada lista de la lista)
        ArrayList<ArrayList<int[]>> cerrado = new ArrayList();//Estados cerrados
        boolean sePuede = true;
        //Esto es para el caso de que hayan mas de 9 enemigos
        /*if(this.posibleAcercar(tablero, objetivo[0], objetivo[1])){
            sePuede = true;
        }*/
        //Se crea el estado inicial (Arreglo de 2 posiciones)
        ArrayList<int[]> eInicial = new ArrayList();
        int[] inicial = posicionCpu;
        eInicial.add(inicial);
        eInicial.add(inicial);//Se agrega 2 veces por que no hay estado anterior al inicial
        abierto.add(eInicial);//Se agrega el primer estado
        //Se crea un verificador de que si en alguna transicion se llega a algun personaje enemigo
        boolean verificadorMaximo = false;
        if(sePuede){
        do{
            //Se obtiene el primer elemento de la lista de estados abiertos
            ArrayList<int[]> estadoActual = abierto.get(0);
            //Posiciones x,y del estado actual
            int posicionX = estadoActual.get(0)[0];
            int posicionY = estadoActual.get(0)[1];
            int[] posicionActual = new int[2];
            posicionActual[0] = posicionX;
            posicionActual[1] = posicionY;
            //Transiciones
            //----------------------------------
            //Coordenadas de la casilla a revisar
            int nuevaPosicionX;
            int nuevaPosicionY;
            //Posicion [x-1,y] (arriba)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX-1;
                int varY = posicionY;
            if(posicionX-1>=0 && posicionX-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura no necesaria por ser mago.
                //System.out.println("dif altura:"+abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())));
                //if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella no necesaria por ser mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("arribaaaaa");
                            }
                        }
                    //}    
                //}
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+1,y] (Abajo)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX+1;
                int varY = posicionY;
            if(posicionX+1>=0 && posicionX+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura no necesaria por ser mago.
                //System.out.println("dif altura:"+abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())));
                //if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella no nesesaria por ser mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("aabajooooooo");
                            }
                        }
                    //}    
                //}
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-1] (Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-1;
                int var = posicionX;
            if(posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura no necesaria por ser mago.
                //System.out.println("dif altura:"+abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())));
                //if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ellano necesaria por ser mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("izquierdaaaaaaa");
                            }
                        }
                    //}    
                //}
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+1] (Derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+1;
                int var = posicionX;
            if(posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura no necesaria por ser mago.
                //System.out.println("dif altura:"+abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())));
                //if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0] == nuevaPosicionX && abierto.get(i).get(0)[1] == nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("derechaaaaa");
                            }
                        }
                    //}    
                //}
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //--------
            try{
                //Posicion [x-1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY-1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x-1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY+1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY-1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY+1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x-2,y](Muy arriba)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX-2;
            if(posicionX-2>=0 && posicionX-2<25){
                nuevaPosicionX = posicionX-2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+2,y](Muy Abajo)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX+2;
            if(posicionX+2>=0 && posicionX+2<25){
                nuevaPosicionX = posicionX+2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-2] (Muy Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-2;
                int var = posicionX;
            if(posicionY-2>=0 && posicionY-2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+2] (Muy derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+2;
                int var = posicionX;
            if(posicionY+2>=0 && posicionY+2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //--------
            //Luego de realizar las transiciones, se cierra el estado y se elimina de los abiertos
            cerrado.add(abierto.get(0));
            abierto.remove(0);
        }
        while(verificadorMaximo==false || abierto.size()==0);
        }
        else{//Si el compadre esta rodeado
            int[] objetivoN = this.nuevoObjetivo(tablero, objetivo);
            ArrayList<int[]> recorridoN = this.moverCpu(posicionCpu, tablero, objetivoN);
            return recorridoN;
        }
        //Se crea la lista con las posiciones de camino
        if(abierto.size()==0){
            System.out.println("No hay salida uwu");
            return null;
        }
        ArrayList<int[]> ultimoEstado = cerrado.get(cerrado.size()-1);
        //Ultimo estado obtenido correctamente
        //System.out.println("Ultimo Estado(actual): "+ultimoEstado.get(0)[0]+","+ultimoEstado.get(0)[1]);
        //System.out.println("Ultimo Estado(Anterior): "+ultimoEstado.get(1)[0]+","+ultimoEstado.get(1)[1]);
        recorrido.add(ultimoEstado.get(0));

        this.obtenerRecorrido(ultimoEstado, cerrado, recorrido);
        //Se da vuelta las casillas recorrido
        Collections.reverse(recorrido);//Funcion que da vuelta una lista
        //Se elimina la posicion inicial del recorrido
        recorrido.remove(0);
        if(tablero[recorrido.get(recorrido.size()-1)[0]][recorrido.get(recorrido.size()-1)[1]].getCaminable()== false){
            recorrido.remove(recorrido.size()-1);
        }
        return recorrido;
    }
    
    //Inteligencia del movimiento del ninja----¡¡¡¡OJOOO!!!
    //---> Al implementarlo, se debe comprobar la posicion en la que quedara luego de gastar todos sus puntos de movimiento,
    //--->en el caso de que sea un rio, se posiciona en ella casilla anterior, la forma de  hacer esto es:
    //--->if(tablero[recorrido.get(recorrido.size()-1)[0]][recorrido.get(recorrido.size()-1)[1]].getCaminable()== false){
    //--->   recorrido.remove(recorrido.size()-1);
    //--->}
    public ArrayList<int[]> moverCpuNinja(int[] posicionCpu, Casilla[][] tablero, int[] objetivo){
        ArrayList<int[]> recorrido = new ArrayList();//Recorrido al reves(desde el personaje objetivo hasta la posicion de la Cpu)
        ArrayList<ArrayList<int[]>> abierto = new ArrayList();//Estados abiertos (Lista de listas de arreglos de enteros de largo 2) (Estado actual es el primer arreglo de enteros de cada lista de la lista)
        ArrayList<ArrayList<int[]>> cerrado = new ArrayList();//Estados cerrados
        boolean sePuede = true;
        //Esto es para el caso de que hayan mas de 9 enemigos
        /*if(this.posibleAcercar(tablero, objetivo[0], objetivo[1])){
            sePuede = true;
        }*/
        //Se crea el estado inicial (Arreglo de 2 posiciones)
        ArrayList<int[]> eInicial = new ArrayList();
        int[] inicial = posicionCpu;
        eInicial.add(inicial);
        eInicial.add(inicial);//Se agrega 2 veces por que no hay estado anterior al inicial
        abierto.add(eInicial);//Se agrega el primer estado
        //Se crea un verificador de que si en alguna transicion se llega a algun personaje enemigo
        boolean verificadorMaximo = false;
        //-----------------------
        if(sePuede){
        do{
            //Se obtiene el primer elemento de la lista de estados abiertos
            ArrayList<int[]> estadoActual = abierto.get(0);
            //Posiciones x,y del estado actual
            int posicionX = estadoActual.get(0)[0];
            int posicionY = estadoActual.get(0)[1];
            int[] posicionActual = new int[2];
            posicionActual[0] = posicionX;
            posicionActual[1] = posicionY;
            //Transiciones
            //----------------------------------
            //Coordenadas de la casilla a revisar
            int nuevaPosicionX;
            int nuevaPosicionY;
            //Posicion [x-1,y] (arriba)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX-1;
                int varY = posicionY;
            if(posicionX-1>=0 && posicionX-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella no necesaria ya que es un mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("arribaaaaa");
                            }
                        }
                    //}    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+1,y] (Abajo)
            //Verificacion de que no se sale del rango
            try{
                int var = posicionX+1;
                int varY = posicionY;
            if(posicionX+1>=0 && posicionX+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ellano necesaria ya que es un mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("aabajooooooo");
                            }
                        }
                    //}    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-1] (Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-1;
                int var = posicionX;
            if(posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ellano necesaria ya que es un mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("izquierdaaaaaaa");
                            }
                        }
                    //}    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+1] (Derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+1;
                int var = posicionX;
            if(posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ellano necesaria ya que es un mago.
                    //System.out.println("caminable:"+tablero[nuevaPosicionX][nuevaPosicionY].getCaminable());
                    //if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0] == nuevaPosicionX && abierto.get(i).get(0)[1] == nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                                //System.out.println("derechaaaaa");
                            }
                        }
                    //}    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //--------
            try{
                //Posicion [x-1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY-1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x-1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX-1;
                int varY = posicionY+1;
                if(posicionX-1>=0 && posicionX-1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX-1;
                nuevaPosicionY = posicionY+1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y-1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY-1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY-1>=0 && posicionY-1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            try{
                //Posicion [x+1,y+1] (Derecha)
                //Verificacion de que no se sale del rango
                int var = posicionX+1;
                int varY = posicionY+1;
                if(posicionX+1>=0 && posicionX+1<25 && posicionY+1>=0 && posicionY+1<25){
                nuevaPosicionX = posicionX+1;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x-2,y](Muy arriba)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX-2;
            if(posicionX-2>=0 && posicionX-2<25){
                nuevaPosicionX = posicionX-2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x+2,y](Muy Abajo)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY;
                int var = posicionX+2;
            if(posicionX+2>=0 && posicionX+2<25){
                nuevaPosicionX = posicionX+2;
                nuevaPosicionY = posicionY;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y-2] (Muy Izquierda)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY-2;
                int var = posicionX;
            if(posicionY-2>=0 && posicionY-2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //Posicion [x,y+2] (Muy derecha)
            //Verificacion de que no se sale del rango
            try{
                int varY = posicionY+2;
                int var = posicionX;
            if(posicionY+2>=0 && posicionY+2<25){
                nuevaPosicionX = posicionX;
                nuevaPosicionY = posicionY-1;
                //Verificacion de la altura.
                if(abs((tablero[posicionX][posicionY].getAltura())-(tablero[nuevaPosicionX][nuevaPosicionY].getAltura())) <= 2){
                    //Verificacion de que si se puede caminar sobre ella.
                    if(tablero[nuevaPosicionX][nuevaPosicionY].getCaminable()==true){
                        //Verificacion en la casilla esta algun personaje enemigo
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==false){
                            if(tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[0]==objetivo[0] && tablero[nuevaPosicionX][nuevaPosicionY].getPosicion()[1]==objetivo[1]){
                                verificadorMaximo = true;
                            }
                        }
                        //Verificacion de si hay un personaje posicionado en la casilla
                        if(tablero[nuevaPosicionX][nuevaPosicionY].getDisponible()==true){
                            //Verificacion de que no es estado abierto ni cerrado(no se ha pasado por ahi)
                            boolean verificador = true;
                            for(int i = 0; i<abierto.size(); i++){
                                if(abierto.get(i).get(0)[0]==nuevaPosicionX && abierto.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            for(int i = 0; i<cerrado.size(); i++){
                                if(cerrado.get(i).get(0)[0]==nuevaPosicionX && cerrado.get(i).get(0)[1]==nuevaPosicionY){
                                    verificador = false;
                                }
                            }
                            //Fin verificacion
                            //-----------------
                            if(verificador==true){
                                //Creacion de nuevo estado
                                ArrayList<int[]> nuevoEstado = new ArrayList();
                                //Nueva posicion actual del estado
                                int[] nuevaPosicion = new int[2];
                                nuevaPosicion[0] = nuevaPosicionX;
                                nuevaPosicion[1] = nuevaPosicionY;
                                //Se agrega la posicion actual y la anterior al nuevo estado(en ese orden)
                                nuevoEstado.add(nuevaPosicion);
                                nuevoEstado.add(posicionActual);
                                //Se añade como un nuevo estado abierto
                                abierto.add(nuevoEstado);
                            }
                        }
                    }    
                }
            }
            }
            catch(ArrayIndexOutOfBoundsException e){
            }
            //--------
            //Luego de realizar las transiciones, se cierra el estado y se elimina de los abiertos
            cerrado.add(abierto.get(0));
            abierto.remove(0);
        }
        while(verificadorMaximo==false || abierto.size()==0);
        }
        else{//Si el compadre esta rodeado
            int[] objetivoN = this.nuevoObjetivo(tablero, objetivo);
            ArrayList<int[]> recorridoN = this.moverCpu(posicionCpu, tablero, objetivoN);
            return recorridoN;
        }
        //Se crea la lista con las posiciones de camino
        if(abierto.size()==0){
            System.out.println("No hay salida uwu");
            return null;
        }
        ArrayList<int[]> ultimoEstado = cerrado.get(cerrado.size()-1);
        //Ultimo estado obtenido correctamente
        //System.out.println("Ultimo Estado(actual): "+ultimoEstado.get(0)[0]+","+ultimoEstado.get(0)[1]);
        //System.out.println("Ultimo Estado(Anterior): "+ultimoEstado.get(1)[0]+","+ultimoEstado.get(1)[1]);
        recorrido.add(ultimoEstado.get(0));

        this.obtenerRecorrido(ultimoEstado, cerrado, recorrido);
        //Se da vuelta las casillas recorrido
        Collections.reverse(recorrido);//Funcion que da vuelta una lista
        //Se elimina la posicion inicial del recorrido
        recorrido.remove(0);
        //Si la ultima posicion del recorrido es un rio, se posiciona una casilla antes
        if(tablero[recorrido.get(recorrido.size()-1)[0]][recorrido.get(recorrido.size()-1)[1]].getCaminable()== false){
            recorrido.remove(recorrido.size()-1);
        }
        return recorrido;
    }
    
    
    //Metodo que encuentra al personaje no Cpu con menor vida
    public int[] personajeMasChalla(Casilla[][] tablero){
        int[] masChalla= new int[2];
        int challa = 100000;
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                if(tablero[i][j].getDisponible()==false){//Si hay un personaje en la casilla
                    if(tablero[i][j].getPersonaje().getEsCpu()==false){//Si el personaje es un enemigo
                        if(tablero[i][j].getPersonaje().getHpActual()<challa){//Si el personaje encontrado la menor vida
                            masChalla = tablero[i][j].getPersonaje().getPosicion();
                        }
                    }
                }
            }
        }
        return masChalla;
    }
    public boolean posibleAcercar(Casilla[][] tablero, int i, int j){
        boolean respuesta = false;
        if(tablero[i-1][j].getDisponible() && tablero[i-1][j].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i+1][j].getDisponible() && tablero[i+1][j].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i][j-1].getDisponible() && tablero[i][j-1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i][j+1].getDisponible() && tablero[i][j+1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i-1][j-1].getDisponible() && tablero[i-1][j-1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i-1][j+1].getDisponible() && tablero[i-1][j+1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i+1][j-1].getDisponible() && tablero[i+1][j-1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i+1][j+1].getDisponible() && tablero[i+1][j+1].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i-2][j].getDisponible() && tablero[i-2][j].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i+2][j].getDisponible() && tablero[i-1][j].getCaminable()){
            respuesta = true;
        }
        else if(tablero[i][j-2].getDisponible() && tablero[i][j-2].getCaminable()){
            respuesta = true;
        }
        return respuesta;
    }
    public int[] nuevoObjetivo(Casilla[][] tablero, int[] objetivo){
        int[] objetivoN = new int[2];
        boolean verificador = false;
        for(int i=0; i<25; i++){
            for(int j=0; j<25; j++){
                if(tablero[i][j].getDisponible()==false){//Si hay un personaje en la casilla
                    if(tablero[i][j].getPersonaje().getEsCpu()==false){//Si el personaje es un enemigo
                        if(!(objetivo[0]==i) || (objetivo[1]==j)){//Si el personaje encontrado la menor vida
                            objetivo[0] = i;
                            objetivo[1] = j;
                            verificador = true;
                            break;
                        }
                    }
                }
            }
            if(verificador){
                break;
            }
        }
        return objetivo;
    }
    public void resetMov(){
        this.movActual = this.movTotal;
    }
    
    public void recuperarMana(){
        if(this.manaActual < this.manaTotal){
            int recuperacionMana = (int)this.manaTotal/5;
            if(this.manaTotal - this.manaActual < recuperacionMana){
                this.manaActual = this.manaTotal;
            }
            else{
                this.manaActual += recuperacionMana;
            }
        }
    }
    
}
