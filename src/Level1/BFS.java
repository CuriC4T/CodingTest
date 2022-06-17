package Level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public int farthest(int n, int[][]edge){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(visited, false);
        Arrays.fill(count, 0);

        queue.offer(1);
        visited[0]=true;
        while(!queue.isEmpty()){
            int peek = queue.remove();
            for(int i=0;i<edge.length;i++){
                int temp = edge[i][0];
                System.out.println(temp);

                if(visited[temp-1]==false){
                    //System.out.println(temp);

                    if(peek == temp){
                        visited[temp-1]=true;
                        queue.offer(temp);
                        count[temp-1]++;

                    }
    
                    temp = edge[i][1];
                    if(peek == temp){
                        visited[temp-1]=true;
                        queue.offer(temp);
                        count[temp-1]++;
                    }
                }
                
            }

        }
        int max = -1;
        int answer = 0;
        for (int temp : count) {
            if(temp> max){
                max = temp;
                answer=0;
            }else if(temp == max){
                answer++;
            }
        }
        return answer;
    }
    
}
