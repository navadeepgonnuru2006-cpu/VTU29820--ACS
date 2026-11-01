import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        
        while (!queue.isEmpty()) {
            int current = queue.poll();

            result[index++] = current;

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}
