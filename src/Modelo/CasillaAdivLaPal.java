
package Modelo;

public class CasillaAdivLaPal {
    
    private String icono;
    private String letra;
    
    public CasillaAdivLaPal(){
        icono = "FondoCasilla";
    }
    
    public void setIcono(String nombreIcono){
        this.icono = nombreIcono;
    }
    
    public void setLetra(String letra){
        this.letra = letra;
    }
    
    public String getLetra(){
        return this.letra;
    }
    
    public String getIcono(){
        return this.icono;
    }
}
