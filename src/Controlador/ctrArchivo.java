/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author carolina
 */
public class ctrArchivo {
    
    public int tamañoArchivo(String ruta) throws FileNotFoundException, IOException{     
        FileReader fr = null;
        try {

            File archivo = new File(ruta);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            int cont = 0;
          
            while ((br.readLine()) != null) {
                cont = cont + 1;
            }
            System.out.println();

            return cont;

        } finally {

            fr.close();
            

        }
       
        
    }

    public String[][] procesarArchivo(int cont,String ruta) throws FileNotFoundException, IOException {
        String g[][];
        FileReader fr = null;
       
        try {

            File archivo = new File(ruta);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            int i = 0;
            String linea;

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            g = new String[cont][2];
            

            while (((linea = br.readLine()) != null) && i < cont) {
                
                g[i][0] = linea.substring(0, 3);
                g[i][1] = linea.substring(3, linea.length());

                i++;

            }
            return g;

        } finally {

            fr.close();
            

        }
        
        
    }
}
