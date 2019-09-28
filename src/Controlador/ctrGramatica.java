/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JTable;
import Modelo.*;

/**
 *
 * @author juanclg
 */
public class ctrGramatica {
    private static ctrGramatica ctr;
    int numProducciones;
    String[][] gramatica;
    JTable tblGramatica;
    Seleccion s = new Seleccion();
 
//    public String[][] gramatica;
//    
//    public ctrGramatica(){
//        this.gramatica = gramatica;
//    }
//    
//    public void gramatica(String[][] gramatica){
//        this.gramatica = gramatica;
//        
//    }
      private synchronized static void crearCtr() {
        if (ctr == null) {
            ctr = new ctrGramatica();
        }
    }

    public static ctrGramatica getCtr() {
        crearCtr();

        return ctr;
    }
    
     public void entradasTabla(int x) {
        numProducciones= x;
        gramatica = new String[numProducciones][2];
    }
    
     public JTable crearTabla() {

        tblGramatica = new JTable(numProducciones, 2);//se crea una instacia de la clase JTable
        tblGramatica.getTableHeader().setVisible(false);

        return tblGramatica;
    }
     
     public String [][] matrizGramatica(JTable gramaticaV){
        for (int i = 0; i <numProducciones; i++) {//Recorre el JTable inicial
           for (int j = 0; j < 2; j++) {
                gramatica[i][j] = (String) gramaticaV.getValueAt(i, j);//Llenar la matriz con los datos ingresados en el jTable
            }
        }
        
        s.construir(gramatica);
        
        return gramatica;
    }
     
     
}
