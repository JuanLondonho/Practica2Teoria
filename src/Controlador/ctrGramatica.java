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
    ctrArchivo ctrA=new ctrArchivo();
    tipoGramatica t = new tipoGramatica();

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

     public void entradasTablaF(int x, String [][] grama) {
        numProducciones= x;
        gramatica = new String[x][2];
        gramatica=grama;
        for (int i = 0; i < numProducciones; i++) {//Recorre el JTable inicial
            for (int j = 0; j < 2; j++) {

                System.out.println("BUU:"+gramatica[i][j]);

            }
        }

    }

     public void entradasTablaM(int x) {
       numProducciones= x;
       gramatica = new String[x][2];
         System.out.println("holi");


    }

     public JTable crearTabla() {

        tblGramatica = new JTable(numProducciones, 2);//se crea una instacia de la clase JTable
        tblGramatica.getTableHeader().setVisible(false);

        if(gramatica[0][0]==null){
            return tblGramatica;
//            for (int i = 0; i < numProducciones; i++) {//Recorre el JTable inicial
//                for (int j = 0; j < 2; j++) {
//
//                gramatica[i][j]=(String) gramaticaIn.getValueAt(i, j);
//
//            }

        }

        else{


        for (int i = 0; i < numProducciones; i++) {//Recorre el JTable inicial
            for (int j = 0; j < 2; j++) {

                tblGramatica.setValueAt(gramatica[i][j], i, j);

            }
        }
        return tblGramatica;
        }


    }




    public void matrizGramatica() {
        s.construir(gramatica);
        t.tipo(gramatica);
    }

}
