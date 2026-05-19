package org.example.task3;

public class Node<T> {
    T value;
    Node<T> previous;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
