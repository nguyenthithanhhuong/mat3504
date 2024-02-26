package hw8_21000506_nguyenthithanhhuong.practice04;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int currentNode = queue.removeFirst();
            result.add(currentNode);

            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}
