package graph.union_find;

import java.util.Arrays;

public class CycleDetect2 {
    private int numV, numE;
    private int[][] edges;
    private int[] parent;

    CycleDetect2(int v, int e) {
        numV = v;
        numE = e;
        edges = new int[numE][];
        parent = new int[numV];
        Arrays.fill(parent, -1);
    }

    int find(int v) {
        if (parent[v] == -1) return v;
        else return find(parent[v]);
    }

    void union(int v1, int v2) {
        int set1 = find(v1);
        int set2 = find(v2);
        parent[set1] = set2;
    }

    boolean isCycle() {
        for (int[] e : edges) {
            int set1 = find(e[0]);
            int set2 = find(e[1]);

            if (set1 == set2) return true;

            union(set1, set2);
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetect2 g2 = new CycleDetect2(3, 2);

        g2.edges[0] = new int[] {0, 1};
        g2.edges[1] = new int[] {1, 2};
        // g2.edges[2] = new int[] {2, 1};

        if (g2.isCycle()) System.out.println("The graph contains cycle");
        else System.out.println("No cycle in the graph");
    }
}