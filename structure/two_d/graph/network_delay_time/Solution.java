package structure.two_d.graph.network_delay_time;

public interface Solution {
    // times: [srcNode][destNode] = time needed
    // N: number of nodes
    // K: source of the signal
    public int networkDelayTime(int[][] times, int N, int K);
}
