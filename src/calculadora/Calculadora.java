/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

import java.util.ArrayList;

/**
 *
 * @author Alumnos
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
     public static ColaLigada<String> convertirPostfija(String infija) throws Exception {
        ColaLigada<String> colaPostfija = new ColaLigada<>();
        PilaLigada<String> pila = new PilaLigada<>();
        ArrayList<String> separada= Utilidades.convertir(infija);
        for(int i=0; i<separada.size();i++) {
            String letra = separada.get(i);
            if (letra.equals("(")) {
                pila.push(letra);
            } else {
                if (letra.equals(")")) {
                    while (!pila.peek().equals("(")) {
                        colaPostfija.push(pila.pop());
                    }
                    pila.pop();
                } else {
                    if (!Utilidades.isOperador(letra)) {
                        colaPostfija.push(letra);
                    } else {
                        while (!pila.vacia() && Utilidades.isLessPriority(letra, pila.peek()) && !pila.peek().equals("(")) {
                            colaPostfija.push(pila.pop());
                        }
                        pila.push(letra);
                    }
                }
            }
        }
        while (!pila.vacia()) {
            colaPostfija.push(pila.pop());
        }

        return colaPostfija;
    }
    
    public static void main(String[] args) throws Exception {
        String s="3+5*(1-9+4)";
        ArrayList<String> a= Utilidades.convertir(s);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
            
        }
        ColaLigada<String>posfija= convertirPostfija(s);
        System.out.println(posfija);
        
    }
    
}
