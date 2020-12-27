/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author hrmha
 */
public class TestBuscador {
    public static void main(String[] args) {
        Buscador finder = new Buscador();
        String texto = "";
        String subTexto = "";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
        texto = "Hola mundo";
        subTexto = "Hola";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
        texto = "Hola mundo";
        subTexto = "Hols";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
        texto = "Hola mundo";
        subTexto = "mundo";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
        texto = "Hola mundo";
        subTexto = "Mundo";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
        texto = "Hola";
        subTexto = "Hola mundo";
        System.out.print("Texto base: \"" + texto + "\" ");
        System.out.print("Texto a buscar: \"" + subTexto + "\" ");
        System.out.println(finder.haySubString(subTexto, texto));
    }
}