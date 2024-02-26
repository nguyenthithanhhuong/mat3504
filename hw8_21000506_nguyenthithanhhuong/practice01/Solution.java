package hw8_21000506_nguyenthithanhhuong.practice01;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return adjacencyList;
    }
}
