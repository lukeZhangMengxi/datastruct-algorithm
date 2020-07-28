package patterns.topological_sort.dependent_tasks_scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface Solution {
    List<Integer> getOrderedTasks(int numOfTask, int[][] dependency);    
}

class GreedyDFS implements Solution {

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curTask, List<Integer> result) {
        visited[curTask] = true;

        if (graph.containsKey(curTask)) {
            for (int nextTask: graph.get(curTask)) {
                if (!visited[nextTask]) dfs(graph, visited, nextTask, result);
            }
        }

        result.add(0, curTask);
    }

    @Override
    @SuppressWarnings("serial")
    public List<Integer> getOrderedTasks(int numOfTask, int[][] dependency) {
        Map<Integer, List<Integer>> adjacencyGraph = new HashMap<>(){{
            for (int[] e: dependency) {
                if (!this.containsKey(e[0])) 
                    this.put(e[0], new ArrayList<>());

                this.get(e[0]).add(e[1]);
            }
        }};

        boolean[] visited = new boolean[numOfTask];

        return new LinkedList<>() {{
            for (int task=0; task<numOfTask; task++) {
                if (!visited[task]) dfs(adjacencyGraph, visited, task, this);
            }
        }};
    }

}
