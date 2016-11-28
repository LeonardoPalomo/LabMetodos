
package Modelo;

import Controlador.ControladorJuegoAdivLaPal;

public class TableroAdivLaPal {
    
    private final int totalIntentos = 5;
    private CasillaAdivLaPal[][] matrizTablero;
    
    public TableroAdivLaPal(int cantidadLetras){
        matrizTablero = new CasillaAdivLaPal[totalIntentos][ControladorJuegoAdivLaPal.cantidadLetras];
        for (int i=0; i<totalIntentos; i++){
            for (int j=0; j<ControladorJuegoAdivLaPal.cantidadLetras; j++){
                matrizTablero[i][j] = new CasillaAdivLaPal();
            }
        }
        
    }
    
}
