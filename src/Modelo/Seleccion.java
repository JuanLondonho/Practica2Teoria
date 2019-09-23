/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author juanclg
 */
public class Seleccion {
    ArrayList<String> nAnulables = new ArrayList<>();
    
    public Seleccion(){
        
    }
    
    public String[][] construir(String[][] matriz){
       nAnulables(matriz);
       String parteDerecha;
       for(int i = 0; i < matriz.length; i++){
           parteDerecha = matriz[i][1];
           if(true){
               
           }
       } 
      return null;
    }
    
    public void nAnulables(String[][] matriz){
        for(int i=0; i < matriz.length; i++){
            switch (matriz[i][1].charAt(0)) {
                case '*':
                    nAnulables.add(matriz[i][0]);
                    break;
                default:
                    break;
            }
        }
        if(nAnulables.size() > 0){
            for(int i=0; i < matriz.length; i++){
                switch (matriz[i][1].charAt(0)) {
                    case '<':
                        boolean terminar = false;
                        boolean terminal = false;
                        ArrayList<String> posibles = new ArrayList<>();
                        String posible = "";
                        for (int j = 0; j < matriz[i][1].length(); j++) {
                            switch (matriz[i][1].charAt(j)) {
                                case '<':
                                    posible.concat("<");
                                    for (int k = j + 1; k < matriz[i][1].length(); k++) {
                                        switch (matriz[i][1].charAt(k)) {
                                            case '>':
                                                posible.concat(">");
                                                posibles.add(posible);
                                                terminar = true;
                                                j = k;
                                                break;
                                            default:
                                                posible.concat("" + matriz[i][1].charAt(k));
                                                k++;
                                                break;
                                        }
                                        if (terminar) {
                                            break;
                                        }
                                    }
                                    break;
                                default:
                                    terminal = true;
                                    break;
                            }
                            if(terminal){
                                break;
                            }
                        }

                        if(!terminal){
                            boolean anulable= true;
                            for(int j = 0; i < posibles.size(); j++){
                                if(!nAnulables.contains(posibles.get(j))){
                                    anulable = false;
                                    break;
                                }
                            }
                            if(anulable){
                                if(nAnulables.contains(matriz[i][0])){
                                    break;
                                }else{
                                    nAnulables.add(matriz[i][0]);
                                    i=-1;
                                }
                            }
                        }
                        break;

                    default:
                        break;
                }
            }
        }
        
    }
}
