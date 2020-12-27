/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author HectorRobles
 */
public class Buscador {
    boolean haySubString(String subTexto, String texto){
        if(subTexto.length() < texto.length()){
            int desicion = subTexto.length();
            int votes = 0;
            int j = 0;
            for(int i = 0; i < texto.length(); i++){
                if(texto.charAt(i) == subTexto.charAt(j)){
                    votes += 1;
                    j += 1;
                }else{
                    votes = 0;
                    j  = 0;
                }
                if(votes == desicion){
                    break;
                }
            }
            if(votes == desicion){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
