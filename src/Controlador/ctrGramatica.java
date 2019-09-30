/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JTable;
import Modelo.*;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ctrGramatica {

    private static ctrGramatica ctr;
    private static tipoGramatica t = new tipoGramatica();
    int numProducciones;
    String[][] gramatica;
    JTable tblGramatica;
    Seleccion s = new Seleccion();
    ctrArchivo ctrA = new ctrArchivo();
    ArrayList<ArrayList<String>> seleccion;

    private synchronized static void crearCtr() {
        if (ctr == null) {
            ctr = new ctrGramatica();
        }
    }

    public static ctrGramatica getCtr() {
        crearCtr();

        return ctr;
    }

    public void entradasTablaF(int x, String[][] grama) {
        numProducciones = x;
        gramatica = new String[x][2];
        gramatica = grama;
    }

    public void entradasTablaM(int x) {
        numProducciones = x;
        gramatica = new String[x][2];
    }

    public JTable crearTabla() {

        tblGramatica = new JTable(numProducciones, 2);//se crea una instacia de la clase JTable
        tblGramatica.getTableHeader().setVisible(false);

        if (gramatica[0][0] == null) {
            return tblGramatica;

        } else {

            for (int i = 0; i < numProducciones; i++) {//Recorre el JTable inicial
                for (int j = 0; j < 2; j++) {

                    tblGramatica.setValueAt(gramatica[i][j], i, j);

                }
            }
            return tblGramatica;
        }

    }

    public void crearMatriz(JTable tblAutomata) {
        for (int i = 0; i < numProducciones; i++) {//Recorre el JTable inicial
            for (int j = 0; j < 2; j++) {
                gramatica[i][j] = (String) tblAutomata.getValueAt(i, j);//Llenar la matriz con los datos ingresados en el jTable

            }

        }

    }

    public void matrizGramatica(JTable seleccionG) {
        seleccion = s.construir(gramatica);
        String selec = "";

        for (int i = 0; i < seleccion.size(); i++) {
            seleccionG.setValueAt(i + 1, i, 0);
            for (int j = 1; j < seleccion.get(i).size(); j++) {
                selec = selec.concat(seleccion.get(i).get(j));
            }
            seleccionG.setValueAt(selec, i, 1);
            selec = "";
        }

    }

    public void tipoGramatica(JLabel result){
        if(s.esDisyunto()){
            result.setText("La gramatica es tipo: "+t.tipo(gramatica));
        }else{
            result.setText("<html>La gramatica era candidata a ser : "+t.tipo(gramatica) +"<br/> pero no lo es dado que su conjunto de selección no es disyunto</html>");
        }
        

    }

}
