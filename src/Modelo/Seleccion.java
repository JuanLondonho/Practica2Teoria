/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juanclg
 */
public class Seleccion {
    ArrayList<String> nAnulables;
    ArrayList<String> pAnulables;
    ArrayList<ArrayList<String>> pPrimeros;
    ArrayList<ArrayList<String>> nPrimeros;
    
    
    public Seleccion(){
        
    }
    
    public void construir(String[][] matriz){
       nAnulables = new ArrayList<>();
       pAnulables = new ArrayList<>();
       pPrimeros = new ArrayList<>();
       nPrimeros = new ArrayList<>();
       nAnulables(matriz);
       primeros(matriz);
       for(int i=0 ; i<nAnulables.size(); i++){
           System.out.println(nAnulables.get(i));
       }
    }
    
    public void nAnulables(String[][] matriz){
        for(int i=0; i < matriz.length; i++){
            switch (matriz[i][1].charAt(0)) {
                case '*':
                    nAnulables.add(matriz[i][0]);
                    pAnulables.add(""+i);
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
                                    posible = posible.concat("<");
                                    for (int k = j + 1; k < matriz[i][1].length(); k++) {
                                        switch (matriz[i][1].charAt(k)) {
                                            case '>':
                                                posible = posible.concat(">");
                                                posibles.add(posible);
                                                posible = "";
                                                terminar = true;
                                                j = k;
                                                break;
                                            default:
                                                posible = posible.concat("" + matriz[i][1].charAt(k));
                                                break;
                                        }
                                        if (terminar) {
                                            terminar = false;
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
                            terminal = false;
                            boolean anulable= true;
                            for(int j = 0; j < posibles.size(); j++){
                                if(!nAnulables.contains(posibles.get(j))){
                                    anulable = false;
                                    break;
                                }
                            }
                            if(anulable){
                                if(nAnulables.contains(matriz[i][0])){
                                    pAnulables.add(""+i);
                                    break;
                                }else{
                                    nAnulables.add(matriz[i][0]);
                                    pAnulables.add(""+i);
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
    
    public void primeros(String[][] matriz){
        for(int i=0; i<matriz.length; i++){
            pPrimeros.add(new ArrayList<>(Arrays.asList(new String[] {""+i})));
            String noTerminal = matriz[i][0];
            int indice = -1;
            for(int j=0; j < nPrimeros.size(); j++){
                if(nPrimeros.get(j).get(0).equals(noTerminal)){
                    indice=j;
                    break;
                }
            }
            if(indice == -1){
                nPrimeros.add(new ArrayList<>(Arrays.asList(new String[] {noTerminal})));
                indice = nPrimeros.size()-1;
            }
            
            String ladoDerecho = matriz[i][1];
            boolean terminal = false;
            boolean termino = false;
            for(int j=0; j < ladoDerecho.length(); j++){
                switch (ladoDerecho.charAt(j)) {
                   case '<':
                       String posible = "<";
                       for(int k = j+1; k < ladoDerecho.length(); k++){
                           switch (ladoDerecho.charAt(k)) {
                                case '>':
                                    posible = posible.concat(">");
                                    if(!nPrimeros.get(indice).contains(posible)){
                                        nPrimeros.get(indice).add(posible);
                                    }
                                    if(!pPrimeros.get(i).contains(posible)){
                                        pPrimeros.get(i).add(posible);
                                    }
                                    if(!nAnulables.contains(posible)){
                                        terminal = true;
                                    }
                                    termino = true;
                                    j=k;
                                    break;
                                
                                default:
                                   posible = posible.concat(""+ladoDerecho.charAt(k));
                                   break;
                           }
                           if(termino){
                               termino = false;
                               break;
                           }
                       }
                       
                       break;
                   case '*':
                       break;
                   default:
                       if(!nPrimeros.get(indice).contains(""+ladoDerecho.charAt(j))){
                            nPrimeros.get(indice).add(""+ladoDerecho.charAt(j));
                       }
                       if(!pPrimeros.get(i).contains(""+ladoDerecho.charAt(j))){
                            pPrimeros.get(i).add(""+ladoDerecho.charAt(j));
                         }
                       terminal = true;
                       break;
                }
                if(terminal){
                    terminal = false;
                    break;
                }
            } 
        }
        for(int i=0; i < nPrimeros.size(); i++){
            for(int j = 1; j < nPrimeros.get(i).size(); j++){
                String noTerminal = nPrimeros.get(i).get(j);
                if(noTerminal.charAt(0) == '<'){
                    int indice = -1;
                    for(int k = 0; k < nPrimeros.size(); k++){
                        if(nPrimeros.get(k).get(0).equals(noTerminal)){
                            indice = k;
                            break;
                        }
                    }
                    for(int k=1; k<nPrimeros.get(k).size(); k++){
                        String valor = nPrimeros.get(indice).get(k);
                        if(!nPrimeros.get(i).contains(valor)){
                            nPrimeros.get(i).add(valor);
;                        }
                    }
                }
            }
            for(int j = nPrimeros.get(i).size()-1; j > 0; j--){
                String noTerminal = nPrimeros.get(i).get(j);
                if(noTerminal.charAt(0) == '<'){
                    nPrimeros.get(i).remove(j);
                }
            }
        }
        
        for(int i = 0; i < pPrimeros.size(); i++){
            for(int j = pPrimeros.get(i).size()-1; j > 0; j--){
                 String noTerminal = pPrimeros.get(i).get(j);
                 if(noTerminal.charAt(0) == '<'){
                    int indice = -1;
                    for(int k = 0; k < nPrimeros.size(); k++){
                        if(nPrimeros.get(k).get(0).equals(noTerminal)){
                            indice = k;
                            break;
                        }
                    }
                    for(int k=1; k < nPrimeros.get(indice).size(); k++){
                        String valor = nPrimeros.get(indice).get(k);
                        if(!pPrimeros.get(i).contains(valor)){
                            pPrimeros.get(i).add(valor);
                        }
                    }
                    pPrimeros.get(i).remove(j);
                 }
            }
        }
        System.out.println("");
    }
}
