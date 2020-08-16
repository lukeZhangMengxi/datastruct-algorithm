package structure.two_d.graph.union_find;

import java.util.Arrays;

class CycleDetect {
    private final int numOfV, numOfE;
    Edge edges[];

    class Edge {
        int src, dest;
    }

    CycleDetect(final int v, final int e) {
        numOfV = v;
        numOfE = e;
        edges = new Edge[numOfE];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new Edge();
    }

    int find(final int[] parent, final int i) {
        if (parent[i] == -1)
            return i;

        return find(parent, parent[i]);
    }

    void union(final int[] parent, final int x, final int y) {
        final int xSet = find(parent, x);
        final int ySet = find(parent, y);

        parent[xSet] = ySet;
    }

    boolean isCycle() {
        final int[] parent = new int[this.numOfV];
        Arrays.fill(parent, -1);

        for (final Edge e : this.edges) {
            final int x = find(parent, e.src);
            final int y = find(parent, e.dest);

            if (x == y) return true;

            union(parent, x, y);
        }

        return false;
    }

    public static void main (String[] args) {
        CycleDetect graph = new CycleDetect(4, 3);
        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;

        if (graph.isCycle())
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }
}
