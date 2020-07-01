package structure.graph.network_delay_time;

import java.util.*;

public class DFS implements Solution {

    private class Graph {
        private class Record {
            int destNode, time;
            Record(int node, int t) {
                destNode = node;
                time = t;
            }
        }
        Map<Integer, List<Record>> records;

        Graph(int[][] times) {
            records = new HashMap<>();
            for (int[] edge: times) {
                int srcNode = edge[0];
                int destNode = edge[1];
                int time = edge[2];
                if (!records.containsKey(srcNode)) records.put(srcNode, new ArrayList<>());
                records.get(srcNode).add(new Record(destNode, time));
            }
        }

        public void sortRecordsByTime() {
            for (int srcNode : records.keySet()) {
                Collections.sort(records.get(srcNode), (a, b) -> a.time - b.time);
            }
        }

        private Map<Integer, Integer> nodeToTime;
        private void dfs(int node, int time) {
            if (time >= nodeToTime.get(node)) return;   // visited
            nodeToTime.put(node, time);
            if (records.containsKey(node)) {
                // Broadcast to neighbors
                for (Record r : records.get(node)) {
                    dfs(r.destNode, time + r.time);
                }
            }
        }

        public Map<Integer, Integer> getNodesEarliestReachTime(int numOfNodes, int node, int time) {
            nodeToTime = new HashMap<Integer, Integer>() {{
                for (int i=1; i<=numOfNodes; i++)
                    this.put(i, Integer.MAX_VALUE);
            }};

            dfs(node, time);
            
            return nodeToTime;
        }
    }

    @Override
    public int networkDelayTime(int[][] times, int N, int K) {
        Graph g = new Graph(times);
        g.sortRecordsByTime();

        Map<Integer, Integer> nodeToReachTime = g.getNodesEarliestReachTime(N, K, 0);

        int rst = -1;
        for (int time: nodeToReachTime.values()) {
            if (time == Integer.MAX_VALUE) return -1;
            else rst = Math.max(rst, time);
        }
        return rst;
    }

}