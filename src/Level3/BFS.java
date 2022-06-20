package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import Level1.Common;

public class BFS extends Common {

    public int farthest(int n, int[][] edge) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        int answer = 0;
        int count = 0;
        for (int i = 0; i < edge.length; i++) {
            list.add(edge[i]);
        }
        queue.offer(1);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int peek = queue.remove();
            
            for (int j = 0; j < list.size(); j++) {
                int[] temp = list.get(j);
                int x = temp[0];
                int y = temp[1];

                if(peek ==x&&visited[y-1]==false){
                    queue.offer(y);
                    visited[y-1] = true;
                }
                if(peek ==y&&visited[x-1]==false){
                    queue.offer(x);
                    visited[x-1] = true;
                }
                for(boolean isVisited : visited){
                    if(isVisited) count++;
                }
                if(count == visited.length) return answer;

                count = 0;
            }
            answer = queue.size();
        }
        return answer;
    }

}
