import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges,
                                          int[][] blueEdges) {

        
        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }

        
        for (int[] edge : redEdges) {
            red[edge[0]].add(edge[1]);
        }

        
        for (int[] edge : blueEdges) {
            blue[edge[0]].add(edge[1]);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        
        
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        
        
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        visited[0][0] = true;
        visited[0][1] = true;

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int node = current[0];
                int color = current[1];

                if (answer[node] == -1) {
                    answer[node] = distance;
                }

                
                if (color == 0) {
                    for (int next : blue[node]) {

                        if (!visited[next][1]) {
                            visited[next][1] = true;
                            queue.offer(new int[]{next, 1});
                        }
                    }
                }

                
                else {
                    for (int next : red[node]) {

                        if (!visited[next][0]) {
                            visited[next][0] = true;
                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }

            distance++;
        }

        return answer;
    }
}
