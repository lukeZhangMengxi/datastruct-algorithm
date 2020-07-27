package patterns.topological_sort.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
    int value;
    List<Node> next;
    Node(int v) {
        this.value = v;
        this.next = new ArrayList<>();
    }
}

interface Solution {
    List<Integer> sort(int vertices, int[][] edges);
}

class GreedyDFS implements Solution {

    private void dfs(int cur, Map<Integer, Node> graph, Set<Integer> visited, List<Integer> order) {
        visited.add(cur);
        for (Node node: graph.get(cur).next) {
            if (!visited.contains(node.value)) {
                dfs(node.value, graph, visited, order);
            }
        }
        order.add(0, cur);
    }

    @Override
    @SuppressWarnings("serial")
    public List<Integer> sort(int vertices, int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>() {{
            for (int[] e: edges) {
                if (!this.containsKey(e[0])) this.put(e[0], new Node(e[0]));
                if (!this.containsKey(e[1])) this.put(e[1], new Node(e[1]));
                this.get(e[0]).next.add(this.get(e[1]));
            }
        }};
        
        return new LinkedList<>() {{
            Set<Integer> visited = new HashSet<>();
            for (int nv: graph.keySet()) {
                if (!visited.contains(nv)) dfs(nv, graph, visited, this);
            }
        }};
    }

}

class InDegreeCounter implements Solution {

    @Override
    @SuppressWarnings("serial")
    public List<Integer> sort(int vertices, int[][] edges) {

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjacencyGraph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            adjacencyGraph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            adjacencyGraph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
            }

        Queue<Integer> sources = new LinkedList<>() {{
            for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
                if (entry.getValue() == 0) this.add(entry.getKey());
            }
        }};

        return new ArrayList<>() {{

            while (!sources.isEmpty()) {
                int vertex = sources.poll();
                this.add(vertex);

                List<Integer> children = adjacencyGraph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sources.add(child);
                }
            }
        }};
        
    }

}
