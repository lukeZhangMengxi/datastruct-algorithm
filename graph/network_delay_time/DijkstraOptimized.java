package graph.network_delay_time;

import java.util.*;

public class DijkstraOptimized implements Solution {

    private class Graph {
        /*
            Graph structure for this issue
        */
        private class Neighbor {
            int destNode, travelTime;
            Neighbor(int node, int time) {
                destNode = node;
                travelTime = time;
            }
        }
        private Map<Integer, List<Neighbor>> travelGraph;

        private int numOfNodes;

        Graph(int[][] times, int n) {
            numOfNodes = n;

            travelGraph = new HashMap<>();
            for (int[] time: times) {
                int srcNode = time[0];
                int destNode = time[1];
                int timeNeeded = time[2];
                if (!travelGraph.containsKey(srcNode)) {
                    travelGraph.put(srcNode, new ArrayList<>());
                }
                travelGraph.get(srcNode).add(new Neighbor(destNode, timeNeeded));
            }
        }

        /*
            To get earliest travel time for each possible node
        */
        private class UntilNode {
            int node, totalTravelTime;
            UntilNode(int n, int time) {
                node = n;
                totalTravelTime = time;
            }
        }
        public Map<Integer, Integer> getNodeEarliestTravelTime(int originNode, int initialTime) {
            Map<Integer, Integer> rst = new HashMap<>();
            PriorityQueue<UntilNode> heap = new PriorityQueue<>(numOfNodes, (a, b) -> a.totalTravelTime - b.totalTravelTime);
            heap.offer(new UntilNode(originNode, initialTime));

            while (!heap.isEmpty()) {
                UntilNode cur = heap.poll();
                if (rst.containsKey(cur.node)) continue;
                rst.put(cur.node, cur.totalTravelTime);

                if (travelGraph.containsKey(cur.node)) {
                    for (Neighbor nei : travelGraph.get(cur.node)) {
                        // Assume there is no redundant edge
                        if (!rst.containsKey(nei.destNode))
                            heap.offer(new UntilNode(nei.destNode, cur.totalTravelTime + nei.travelTime));
                    }
                }
            }

            return rst;
        }
    }

    @Override
    public int networkDelayTime(int[][] times, int N, int K) {
        Graph g = new Graph(times, N);
        
        Map<Integer, Integer> nodeToReachTime = g.getNodeEarliestTravelTime(K, 0);

        if (nodeToReachTime.size() != N) return -1;

        int rst = -1;
        for (int time: nodeToReachTime.values()) {
            rst = Math.max(rst, time);
        }
        return rst;
    }

}