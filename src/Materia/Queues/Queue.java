package Materia.Queues;

import java.util.NoSuchElementException;

import Materia.Models.Node;

public class Queue {

    private Node front; // Nodo al frente de la cola
    private Node rear; // Node al final de la cola

    // Creamos una cola con nodos vacios.
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Metodo para encolar nodos
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Desencolar
    public Node dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola esta vacia");
        }
        Node node = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return node;
    }

    // devuelve
    public Node peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
