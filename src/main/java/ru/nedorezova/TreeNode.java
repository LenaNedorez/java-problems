package ru.nedorezova;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return toArray().toString();
    }

    public List<Integer> toArray() {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this); // Начинаем с корневого узла

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Извлекаем первый элемент
            result.add(node.val); // Добавляем значение узла в результат

            // Добавляем дочерние узлы в очередь, если они есть
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}
