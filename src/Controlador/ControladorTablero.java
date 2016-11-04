package Controlador;
import Modelo.Casilla;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;



public class ControladorTablero extends JPanel{
    
   public Casilla[][] terreno = new Casilla[25][25];
   
   // Constructor
   public ControladorTablero(JPanel panel, ActionListener a){
       panel.setLayout(new GridLayout(25,25));
       for (int i = 0; i<25; i++){
           //Ese print se ocupa para msotrar el tablero en caso de que haya un
           //error al mostrar el tablero
           //System.out.println(i);
           for(int j = 0; j<25; j++){
               terreno[i][j] = new Casilla();
               terreno[i][j].addActionListener(a);
               terreno[i][j].setBorderPainted(true);
               //Este print es para lo mismo que el de arriba, pero este muestra
               //las filas
               //System.out.println(j);
               panel.add(terreno[i][j]);
               
           }
       }
   }
   
}