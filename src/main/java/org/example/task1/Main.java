package org.example.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static void main() {
        var net = matrixNet();

        for (int i = 0; i < net[0].length; i++) {
            for (int j = 0; j < net[0].length; j++) {
                System.out.printf("%-12s", net[0][i][j] + ", " + net[1][i][j] + "%");
            }
            System.out.println();
        }
        System.out.println();

        print(nodeNet());
    }

    public static void print(Node node) {
        Set<Node> visited = new HashSet<>();
        dfs(node, visited);
    }

    private static void dfs(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        node.show();
        for (Edge edge : node.edges) {
            dfs(edge.node, visited);
        }
    }

    private static Integer[][][] matrixNet() {
        return new Integer[][][]{
                {//пропускная способность
                        {0, 1500, 2000, 1000, 0, 0},
                        {1500, 0, 0, 0, 0, 1500},
                        {2000, 0, 0, 0, 900, 500},
                        {1000, 0, 0, 0, 2500, 0},
                        {0, 0, 900, 2500, 0, 300},
                        {0, 1500, 500, 0, 300, 0}
                },
                {//процент потерь
                        {0, 90, 10, 50, 0, 0},
                        {90, 0, 0, 0, 0, 60},
                        {10, 0, 0, 0, 5, 20},
                        {50, 0, 0, 0, 1, 0},
                        {0, 0, 5, 1, 0, 85},
                        {0, 60, 20, 0, 85, 0}
                }
        };
    }

    private static Node nodeNet() {
        // создаём узлы
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        // соединяем их
        A.connect(B, 1500, 90);
        A.connect(C, 2000, 10);
        A.connect(D, 1000, 50);
        B.connect(F, 1500, 60);
        C.connect(E, 900, 5);
        C.connect(F, 500, 20);
        D.connect(E, 2500, 1);
        E.connect(F, 300, 85);

        //возвращаем ссылку на первый
        return A;
    }
}

class Node {
    String name;
    List<Edge> edges = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void connect(Node other, int cap, int loss) {
        edges.add(new Edge(other, cap, loss));
        other.edges.add(new Edge(this, cap, loss)); // двусторонняя связь
    }

    public void show() {
        System.out.print(name + " -> ");
        for (Edge f : edges) {
            System.out.print(f + " | ");
        }
        System.out.println();
    }
}

class Edge {
    Node node;
    Integer capacity;
    Integer percent;

    public Edge(Node node, Integer capacity, Integer percent) {
        this.node = node;
        this.capacity = capacity;
        this.percent = percent;
    }

    @Override
    public String toString() {
        return node.name + "(" + capacity + ", " + percent + "%)";
    }
}
