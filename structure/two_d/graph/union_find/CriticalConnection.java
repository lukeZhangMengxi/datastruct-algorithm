package structure.two_d.graph.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnection {

    public static List<List<Integer>> cc(int n, List<List<Integer>> connections) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        for (int i = 0; i < connections.size(); i++) {
            if (!isConnected(connections, n, i)) {
                rst.add(new ArrayList<Integer>(Arrays.asList(connections.get(i).get(0), connections.get(i).get(1))));
            }
        }
        return rst;
    }

    public static boolean isConnected(List<List<Integer>> connections, int n, int cut) {
        UF uf = new UF(n);
        for (int i = 0; i < connections.size(); i++) {
            if (i == cut)
                continue;
            List<Integer> conn = connections.get(i);

            int setId0 = uf.find(conn.get(0));
            int setId1 = uf.find(conn.get(1));
            if (setId0 != setId1)
                uf.union(setId0, setId1);
        }

        return uf.size == 1;
    }

    @SuppressWarnings("serial")
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>() {{
            this.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
            this.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
            // this.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        }};

        List<List<Integer>> criticalConns = cc(3, edges);

        System.out.println(criticalConns.size());
    }
}

class UF {
    int[] id, weight;
    int size;

    UF(int n) {
        id = new int[n];
        weight = new int[n];
        size = n;

        for (int i=0; i<n; i++) {
            id[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int p) {
        while (id[p] != id[id[p]]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return id[p];
    }

    public void union(int p, int q) {
        int pp = find(p);
        int qq = find(q);

        if (weight[pp] < weight[qq]) {
            id[p] = qq;
            weight[qq] += weight[pp];
        } else {
            id[q] = pp;
            weight[pp] += weight[qq];
        }
        size--;
    }
}