/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

/**
 *
 * @author Alumnos
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> liga;
    
     Nodo(T dato){
      this.info = dato;
      this.liga = null;
    }
     
     Nodo(){
      
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getLiga() {
        return liga;
    }

    public void setLiga(Nodo<T> liga) {
        this.liga = liga;
    }
    
}
