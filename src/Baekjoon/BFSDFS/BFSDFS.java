import java.util.ArrayList;
import java.util.Stack;

class BFSDFS {
    public void BFSAndDFS_1260(int N, int M, int V, int[][] data) {
        boolean[] visited = new boolean[N + 1];
        int[][] edge = new int[N+1][N+1];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < data.length;i++){
            edge[data[i][0]][data[i][1]]= 1;
            edge[data[i][1]][data[i][0]]= 1;
        }


        stack.push(V);
        visited[V] = true;
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(visited[top]!=true){
                visited[top]=true;
                for(int i = 0 ;i<data.length;i++){
                    int temp = data[i][1];
                    //if(temp)
                }
            }

        }
    }
}