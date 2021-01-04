/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.HashMap;

/**
 *
 * @author hector
 */
public class Diccionario {
    private HashMap<String, String> diccionario;
    public Diccionario(){
        diccionario = new HashMap<>();
        cargaDiccionario();
    }
    public String get(String ingles){
        String espanol = diccionario.get(ingles);
        return espanol;
    }
    public void put(String ingles, String espanol){
        diccionario.put(ingles, espanol);
    }
    private void cargaDiccionario(){
        put("dog", "perro");
        put("boy", "niño");
        put("girl", "niña");
        put("hen", "gallina");
        put("chiken", "pollo");
        put("desk", "escritorio");
        put("table", "mesa, tabla");
        put("telivison", "televisión");
        put("bone", "hueso");
        put("monkey", "mono");
        put("slipper", "chancla");
        put("shoe", "zapato");
        put("boat", "bote");
        put("boot", "bota");
        put("schedule", "horario");
        put("sun", "sol");
        put("moon", "luna");
        put("eclipse", "eclipse");
        put("high", "alto");
        put("low", "bajo");
        put("big", "grande");
        put("small", "pequeño");
    }
}
