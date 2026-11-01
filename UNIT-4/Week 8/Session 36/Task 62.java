import java.util.*;

class Solution {

    public int[] sortItems(int n, int m, int[] group,
                           List<List<Integer>> beforeItems) {

        
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        
        for (int i = 0; i < n; i++) {

            for (int prev : beforeItems.get(i)) {

                if (group[prev] == group[i]) {
                    itemGraph.get(prev).add(i);
                    itemIndegree[i]++;
                } else {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        
        List<Integer> groupOrder =
            topologicalSort(groupGraph, groupIndegree, m);

        if (groupOrder.size() != m) {
            return new int[0];
        }

        
        List<Integer> itemOrder =
            topologicalSort(itemGraph, itemIndegree, n);

        if (itemOrder.size() != n) {
            return new int[0];
        }

        
        List<List<Integer>> groupedItems = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            groupedItems.add(new ArrayList<>());
        }

        for (int item : itemOrder) {
            groupedItems.get(group[item]).add(item);
        }

        
        int[] result = new int[n];
        int index = 0;

        for (int g : groupOrder) {
            for (int item : groupedItems.get(g)) {
                result[index++] = item;
            }
        }

        return result;
    }

    
    private List<Integer> topologicalSort(
        List<List<Integer>> graph,
        int[] indegree,
        int size) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();
            order.add(current);

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order;
    }
}
