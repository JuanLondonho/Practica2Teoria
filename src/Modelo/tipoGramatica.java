/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author carolina
 */
public class tipoGramatica {

    public void tipo(String[][] gramatica) {
        
        int contT=0;
        int contN=0;
        int contNula=0;
      

        for (int i = 0; i < gramatica.length; i++) {
            if(!(gramatica[i][1].charAt(0)=='<')&&(gramatica[i][1].charAt(gramatica[i][1].length()-1)=='>')){
                if(gramatica[i][1].charAt(0)=='*'){
                    contNula=contNula+1;
                    
                }else
                    if(!(gramatica[i][1].charAt(1)=='<')){
                        
                        
                    }
            }else
                System.out.println("ba");
                //ll1

        }

    }
    
}
    

