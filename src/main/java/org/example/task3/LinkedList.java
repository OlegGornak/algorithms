package org.example.task3;

public class LinkedList<T> {
    Node<T> first;
    Node<T> last;
    int size = 0;

    public Node<T> addLast(T data) {
        var newNode = new Node<>(data);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
        return newNode;
    }

    public Node<T> addFirst(T data) {
        var newNode = new Node<>(data);
        if (first == null) {
            first = last = newNode;
        } else {
            first.previous = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
        return newNode;
    }

    public String getValues() {
        String result = null;
        Node<T> currentNode = null;
        while (true) {
            if (currentNode == null) {
                currentNode = first;
            } else {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                break;
            }
            result = (result == null ? "" : result + ", ") + currentNode.value.toString();
        }
        return result;
    }
    
    public Node<T> insertAfter(Node<T> node, T data) {
        if (node == null) return null;

        var newNode = new Node<>(data);
        newNode.next = node.next;
        node.next = newNode;
        newNode.previous = node;
        size++;

        return newNode;
    }

    public boolean isExist(T data) {
        return this.indexOf(data) != -1;
    }

    public Integer indexOf(T data) {
        int index = 1;

        Node<T> currentNode = first;
        while (true) {
            if (index > size) {
                return -1;
            }
            if (currentNode.value.equals(data)) {
                return index;
            } else {
                currentNode = currentNode.next;
                index++;
            }
        }
    }

    public Node<T> set(Node<T> node, T data) {
        node.value = data;
        return node;
    }

    public void removeFirst() {
        if (first != null) {
            if (first.next == null) {
                last = first = null;
            } else {
                first.next.previous = null;
                first = first.next;
            }
            size--;
        }
    }

    public void removeLast() {
        if (last != null) {
            if (last.previous == null) {
                last = first = null;
            } else {
                last.previous.next = null;
                last = last.previous;
            }
            size--;
        }
    }


    public void remove(Node<T> node) {
        if (node != null) {
            if (node.value.equals(first.value)) {
                removeFirst();
            } else if (node.value.equals(last.value)) {
                removeLast();
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
                size--;
            }
        }
    }
}
