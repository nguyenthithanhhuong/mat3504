package hw8_21000506_nguyenthithanhhuong.practice03;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0, adj, visited, result);
        return result;
    }

    private void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }
}
