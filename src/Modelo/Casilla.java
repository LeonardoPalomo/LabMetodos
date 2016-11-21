
package Modelo;
/**
 *
 * @author Usuario
 */
public class Casilla{
    private int tipo; //1 es tierra; 2 es rio; 3 es bosque; 4 es montaña.
    private int altura;
    private boolean caminable;
    private boolean disponible;
    
    //Constructor
    public Casilla(){
        this.disponible = true;
        this.altura = 0;
        this.caminable = true;
        this.tipo = 1;      
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
}
