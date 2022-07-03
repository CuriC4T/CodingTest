package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


    //완료
    //i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
    //[[1, 1, 0], [1, 1, 0], [0, 0, 1]] =>2

    public int network(int n ,int[][] computers){
        int answer = 0;
        boolean[] visited = new boolean[n];
        Stack stack = new Stack<Integer>();
        for(int i = 0 ;i<n;i++){
            if(visited[i]==false){
                stack.push(i);
                while(!stack.isEmpty()){
                    int top = (Integer)stack.pop();
                    visited[top]=true;
                    for(int j = 0 ;j<n;j++){
                        if(computers[top][j]==1 && visited[j]==false){
                            stack.push(j);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;

    }

}
