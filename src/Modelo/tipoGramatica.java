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
    
    public tipoGramatica(){
        
    }

    public String tipo(String[][] gramatica) {
        
        String tipo = "Especial";
        boolean terminar = false;
        boolean nula = false;
      

        for(int i = 0; i < gramatica.length; i++){
            int contT=0;
            int contN=0;
            for(int j = 0; j < gramatica[i][1].length(); j++){
                switch(gramatica[i][1].charAt(j)){
                    case '<': 
                        for(int k = j+1; k < gramatica[i][1].length(); k++){
                            switch(gramatica[i][1].charAt(k)){
                                case '>':
                                    contN++;
                                    terminar = true;
                                    j=k;
                                    break;
                                default: 
                                    break;
                            }
                            if(terminar){
                                terminar = false;
                                break;
                            }
                        }
                        break;
                        
                    case '*':
                        nula=true;
                        break;
                        
                    default:
                        contT++;
                        break;
                }
            }
            if(gramatica[i][1].charAt(0) == '<'){
                if(contT==0 && contN == 1){
                    tipo = "Lineal por la derecha";
                }else{
                    tipo = "LL1";
                    return tipo;
                }
            }else{
                if(contN == 1 && contT > 1 && gramatica[i][1].charAt(gramatica[i][1].length()-1) == '>'){
                    if(!tipo.equals("Lineal por la derecha") ){
                        tipo = "S";
                    }
                }else if(contN ==1 && contT ==1){
                    
                }
                else{
                    if(contN > 1 || (gramatica[i][1].charAt(gramatica[i][1].length()-1) != '>' && gramatica[i][1].length() > 1)){
                        if(nula){
                            tipo = "Q";
                        }else{
                           tipo = "S"; 
                        }
                    }else if(nula){
                        if(tipo.equals("S")){
                             tipo = "Q";
                        }
                    }else{
                        tipo = "S";
                    }
                    
                }
            }
        }
        System.out.println(tipo);
        return tipo;
    }
    
}
    

