package datastructures.graph;

import java.util.*;

public class Diameter {
    static class Solution {
        Solution() {

        }

        boolean[] visited = new boolean[]{};

        public int treeDiameter(int[][] edges) {
            int diameter = 0;
            String s = "";
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], x -> new ArrayList<Integer>()).add(edge[1]);
            }
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[1], x -> new ArrayList<Integer>()).add(edge[0]);
            }
            visited = new boolean[graph.keySet().size()];

            System.out.println(graph);
            visited[0] = true;
            for (Integer node : graph.keySet()) {
                System.out.println("node" + node);
                //   int depth = dfs(node, graph, 0 , 0 );
                //    System.out.println("Dep" + depth);
                visited = new boolean[graph.keySet().size()];
            }
            return diameter;
        }


        public static void main(String args[]) {
            Solution x = new Solution();
            int[][] val = new int[][]{new int[]{0, 1}, new int[]{0, 2}};
            x.treeDiameter(val);

        }
    }
}



