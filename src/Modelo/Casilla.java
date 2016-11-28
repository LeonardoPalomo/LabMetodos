
package Modelo;

public class Casilla{
    private int tipo; //1 es tierra; 2 es rio; 3 es bosque; 4 es montaña.
    private int altura;
    private boolean caminable; //false si es río
    private boolean disponible; //false si hay un personaje en esta ubicación
    private Personaje personaje; //el personaje ubicado en esta casilla
    private int[] posicion = new int[2];
    
    //Constructor
    public Casilla(){
        this.disponible = true;
        this.altura = 0;
        this.caminable = true;
        this.tipo = 1;      
        this.personaje = null;
    }
    //Sobrecarga constructor
    public Casilla(int tipoC, int alturaC, boolean caminableC, boolean disponibleC){
        this.disponible = disponibleC;
        this.altura = alturaC;
        this.caminable = caminableC;
        this.tipo = tipoC;     
    }
    
    public void setAltura(int altura){
        this.altura = altura;
    }
    public int getAltura(){
        return this.altura;
    }
    public void setTerreno(int terreno){
        this.tipo = terreno;
        if(terreno == 2){
            this.caminable = false;
        }
        else{
            this.caminable = true;
        }
    }
    public int getTerreno(){
        return this.tipo;
    }
    public void setDisponible(boolean disponibilidad){
        this.disponible = disponibilidad;
    }
    public boolean getDisponible(){
        return this.disponible;
    }
    public void setCaminable(boolean caminabilidad){
        this.caminable = caminabilidad;
    }
    public boolean getCaminable(){
        return this.caminable;
    }
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
        this.disponible = false;
    }
    //Sobrecarga
    public void setPersonaje(){
        this.personaje = null;
        this.disponible = true;
    }
    public Personaje getPersonaje() {
        return personaje;
    }
    
    public void setPosicion(int i, int j){
        this.posicion[0] = i;
        this.posicion[1] = j;
    }
    public int[] getPosicion(){
        return this.posicion;
    }
}
