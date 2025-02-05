package ru.nedorezova;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountNodes {

    //Необходимо реализовать метод, который на вход принимает класс Node
    //и посчитает общее количество переданных в метод Node.
    //Известно, что в классе Node может находится список таких же Node.
    //Известно, что Node не могут циклически зависеть друг от друга и повторяться в зависимостях.

    public static void main(String[] args) {
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        node1.setNodes(List.of(node6, node7));
        node3.setNodes(List.of(node5));
        node4.setNodes(List.of(node1, node2));

        node.setNodes(List.of(node4, node3, node8));

        System.out.println(countNodes(node));
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        Set<Node> visited = new HashSet<>();
        return countNodesRecursive(root, visited);
    }

    private static int countNodesRecursive(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return 0;
        }

        visited.add(node);
        int count = 1;

        if (node.getNodes() != null) {
            for (Node child : node.getNodes()) {
                count += countNodesRecursive(child, visited);
            }
        }
        return count;
    }

    static class Node {
        private List<Node> nodes;

        public void setNodes(List<Node> nodes) {
            this.nodes = nodes;
        }

        public List<Node> getNodes() {
            return nodes;
        }
    }
}
