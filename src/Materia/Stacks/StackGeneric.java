package Materia.Stacks;

import java.util.EmptyStackException;

import Materia.Models.NodeGeneric;

public class StackGeneric<T> {

    private NodeGeneric<T> top; // Nodo Generico
    private int size; // Variable tamanio O(1)

    // Crea una Pila instanciando el nodo top como null y el tamanio en 0
    public StackGeneric() {
        this.top = null;
        this.size = 0;
    }

    // Metodo para agegar un elemento a la pila
    public void push(T data) {
        NodeGeneric<T> newNode = new NodeGeneric<>(data); // Crea un nuevo nodo con el dato
        newNode.setNext(top);
        top = newNode;
        size++;
        // if (isEmpty()) { // Si la pila esta vacia
        // top = newNode; // El nodo top sera el nuevo nodo
        // } else { // Si la pila no esta vacia
        // newNode.setNext(top); // El siguiente del nuevo nodo sera el nodo top
        // top = newNode; // El nodo top sera el nuevo nodo
        // }
        // size++; // Incrementa el tamanio
    }

    // Metodo para retirar un elemento de la pila
    public T pop() {
        if (isEmpty()) { // Si la pila esta vacia
            throw new EmptyStackException(); // Lanza una excepcion
        }
        T value = top.getValue(); // Obtiene el valor del nodo top
        top = top.getNext(); // El nodo top sera el siguiente nodo
        size--; // Decrementa el tamanio
        return value; // Retorna el valor
    }

    public NodeGeneric<T> popNode() {
        if (isEmpty()) { // Si la pila esta vacia
            throw new EmptyStackException(); // Lanza una excepcion
        }
        NodeGeneric<T> value = top; // Obtiene el valor del nodo top
        top = top.getNext(); // El nodo top sera el siguiente nodo
        size--; // Decrementa el tamanio
        return value; // Retorna el valor
    }

    // Metodo que retorna el valor del node de la cima.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public NodeGeneric peekNode() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {

        return size;
    }

    public void printStakc() {
        NodeGeneric<T> current = top;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

}
