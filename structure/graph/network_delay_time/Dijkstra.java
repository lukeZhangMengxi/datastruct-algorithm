package structure.graph.network_delay_time;

import java.util.*;

public class Dijkstra implements Solution {

    @Override
    public int networkDelayTime(int[][] times, int N, int K) {
        Graph g = new Graph(times);
        
        Map<Integer, Integer> nodeToReachTime = g.getNodesEarliestReachTime(N, K, 0);

        int rst = -1;
        for (int time: nodeToReachTime.values()) {
            if (time == Integer.MAX_VALUE) return -1;
            else rst = Math.max(rst, time);
        }
        return rst;
    }

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

        private Map<Integer, Integer> nodeToTime;
        private void setNodeToTime(int numOfNodes, int originNode, int time) {
            nodeToTime.put(originNode, time);

            boolean[] seen = new boolean[numOfNodes+1];
            while (true) {
                int candNode = -1;
                int candTime = Integer.MAX_VALUE;
                for (int i=1; i<=numOfNodes; i++) {
                    if (!seen[i] && nodeToTime.get(i) < candTime) {
                        candTime = nodeToTime.get(i);
                        candNode = i;
                    }
                }

                if (candNode < 0) break;

                seen[candNode] = true;
                if (records.containsKey(candNode)) {
                    for (Record r : records.get(candNode)) {
                        nodeToTime.put(r.destNode, candTime + r.time);
                    }
                }
            }
        }

        public Map<Integer, Integer> getNodesEarliestReachTime(int numOfNodes, int originNode, int time) {
            nodeToTime = new HashMap<Integer, Integer>() {{
                for (int i=1; i<=numOfNodes; i++)
                    this.put(i, Integer.MAX_VALUE);
            }};

            setNodeToTime(numOfNodes, originNode, time);
            
            return nodeToTime;
        }
    }

}