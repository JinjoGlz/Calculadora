/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author Jinjo
 */
public class Utilidades {
    private static String[] operadores={"(",")","^","*","/","+","-"};
    
    public static ArrayList<String> convertir(String a){
        ArrayList<String> expresion = new ArrayList<>();
        char[] xpres= a.toCharArray();
        String numero="";
        for (int i = 0; i < xpres.length; i++) {
           if(Character.isDigit(xpres[i])||xpres[i]=='.'){
               numero=numero+xpres[i];
           }else{
               if(!numero.equals("")){
                   expresion.add(numero);
                   numero="";
               }String b="";
               b=b+xpres[i];
               expresion.add(b);
           }
        }
        return expresion;
    }
    
    public static boolean isOperador(String a){
        boolean b=false;
        for (int i = 0; i < operadores.length; i++) {
            if(a.equals(a)){
                b=true;
                break;
            }
        }
        return b;
    }
    
    public static boolean isLessPriority(String a, String b){
        String[] operadores={a,b};
        int[] valores=new int[2];
        for (int i = 0; i < operadores.length; i++) {
            switch(operadores[i]){
                case "^":
                    valores[i] = -1;
                    break;
                case "*":
                    valores[i] = -2;
                    break;
                case "/":
                    valores[i] = -2;
                    break;
                case "+":
                    valores[i]= -3;
                    break;
                case "-":
                    valores[i] = -3;
                    break;
                case "(":
                    valores[i] = 0;
                    break;
                case ")":
                    valores[i] = 0;
                    break;

            }
        }
        return valores[0]<=valores[1];
    }
}
