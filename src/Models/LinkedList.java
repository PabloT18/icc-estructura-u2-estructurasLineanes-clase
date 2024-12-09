package Models;

import Materia.Models.NodeGeneric;

public class LinkedList<T> {
    private NodeGeneric<T> head; // Referencia al primer nodo de la lista
    private int size = 0; // Contador del número de nodos en la lista

    // Agregar un nuevo elemento al final de la lista
    public void appendToTail(T value) {
        if (head == null) {
            head = new NodeGeneric<>(value);
        } else {
            NodeGeneric<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new NodeGeneric<>(value));
        }
        size++;
    }

    // Buscar el primer elemento que coincide con el valor proporcionado
    public T findByValue(T value) {
        NodeGeneric<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null; // No se encontró el elemento
    }

    // Eliminar el primer nodo que coincide con el valor proporcionado
    public void deleteByValue(T value) {
        if (head == null)
            return;

        // Caso especial: eliminar la cabeza
        if (head.getValue().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    // Imprimir todos los elementos de la lista
    public void print() {
        if (head == null) {
            System.out.println("END");
            return;
        }
        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getValue() + " -> END");
    }

    // Obtener el tamaño de la lista
    public int getSize() {
        return size;
    }

    public NodeGeneric<T> getHead() {
        return head;
    }

    public void setHead(NodeGeneric<T> head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
