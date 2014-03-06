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
public class ListaLigada<T> {
     private Nodo<T> inicio;

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }
    
    public void insertarInicio(T dato){
        Nodo<T> t= new Nodo<>(dato);
        t.setLiga(inicio);
        inicio=t;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevo= new Nodo<T>(dato);
        Nodo<T> aux = inicio;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            while (aux.getLiga() != null) {
                aux = aux.getLiga();
            }
            aux.setLiga(nuevo);
            }
    }
    
    public void borrar(int index){
        Nodo<T> aux=inicio;
        Nodo<T> aux2=inicio.getLiga().getLiga();
        int cont=1;
        while(cont !=index){
                aux=aux.getLiga();
                aux2=aux2.getLiga();
                cont++;
            }
        aux.setLiga(aux2);
    }
    
    public void borrarInicio(){
         
            inicio = inicio.getLiga();
    }
    
    public void borrarFinal(){
         Nodo<T> aux = inicio;
        Nodo<T> anterior = null;
        while (aux.getLiga() != null) {
                anterior = aux;
                aux = aux.getLiga();
            }
            anterior.setLiga(null);
    }
    
    public void mostrar(){
        Nodo<T> aux=inicio;
        while(aux!=null){
            System.out.println(aux.getInfo());
            aux=aux.getLiga();
        }
    }
    
    public ListaLigada<T> invertirLista(){
        ListaLigada<T> respuesta=new ListaLigada<> ();
        Nodo<T> aux=inicio;
        while(aux!=null){
            respuesta.insertarInicio(aux.getInfo());
            aux=aux.getLiga();
        }
        return respuesta;
    }
    
    public boolean buscar(T dato){
        boolean resultado=false;
        Nodo<T> aux=inicio;
        while(aux!=null){
            if(aux.getInfo().equals(dato)){
                resultado=true;
            }
            aux=aux.getLiga();
        }
        return resultado;
    }
    
    public void insertarAntesde(T dato, T nuevo){
        Nodo<T> actual = inicio;
        Nodo<T> anterior = null;
        boolean band = false;
        while (actual!=null && !band) {
            if (!actual.getInfo().equals(dato)) {
                anterior = actual;
                actual = actual.getLiga();
            } else {
                band = true;
            }

        }
        if (band) {
            Nodo<T> nodo = new Nodo<>(nuevo);
            
                anterior.setLiga(nodo);
                nodo.setLiga(actual);
            
    }
    }
}
