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
public class ColaLigada<T> {
    private ListaLigada<T> lista = new ListaLigada<T>();
       
    public ColaLigada(){
    
}
   public void push(T dato){
       lista.insertarFinal(dato);
   }
   
   public T pop()throws Exception{
      
       if(lista.getInicio().getInfo()==null){
           throw new Exception("Cola Vacia");
       }else{
           T dato=lista.getInicio().getInfo();
           lista.borrarInicio();
           return dato;
       }
   }
   
   public T Peak()throws Exception{
       if(lista.getInicio().getInfo()==null){
           throw new Exception("Pila Vacia");
       }else{
           return lista.getInicio().getInfo();
       }
   }
}
