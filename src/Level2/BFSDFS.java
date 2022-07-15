package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFS {
    int answer = 0;

    public int tartgetNumber(int[] numbers, int target){

        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); 
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }

    public class Data{
        int x;
        int y;
        int count;
        public Data(int x,int y,int count){
            this.x= x;
            this.y= y;
            this.count = count;
        }
    }
    public int findGameMap(int [][] maps){
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] isVisited = new boolean[n][m];
        Queue<Data> queue = new LinkedList<>();

        queue.offer(new Data(0,0,1));
        isVisited[0][0] = true;

        while(!queue.isEmpty()){
            
            Data peek = queue.poll();
            System.out.println(peek.x+" "+peek.y+" "+peek.count);

            if(peek.x==n-1&&peek.y==m-1) return peek.count;
            else{
                for(int i = 0 ; i < 4;i++){
                    int mx = peek.x+dx[i];
                    int my = peek.y+dy[i];

                    if(mx>=0&&mx<n&&my>=0&&my<m){
                        if(isVisited[mx][my]==false&&maps[mx][my]==1){
                            isVisited[mx][my]=true;
                            queue.offer(new Data(mx,my,peek.count+1));
                        }
                            
                    }
                }
            }
        }

        return -1;
    }

    
}
