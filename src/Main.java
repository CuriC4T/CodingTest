import Level2.*;
import Level3.BFS;
public class Main {
    public static void main(String[] args){
        System.out.println("Coding Test Project");

        Level2 Level2 = new Level2();
        //Level2.MaxPrice("100-200*300-500+20");

        StackEx stackEx = new StackEx();
        // int[] progressTest = Level2.progressesTest(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1,1,1,1,1,1});
        // for (int i : progressTest) {
        //     System.out.print(i+" ");
        // }

        HeapEX heapEX = new HeapEX();
        // int result = heapEX.printPriority_2(new int[]{2,1,3,2}, 2);
        // println(result);

        //미해결
        // boolean result = Level2.checkPrefix(new String[]{"334","123","12","592","1222"});
        // println(result);

    
        //
        SortEX sortEX = new SortEX();
        //String result = sortEX.makeBigNum(new int[]{10, 0, 0, 15, 9});
        

        // String result = stackEx.makeBigNum("4177252841",4);
        // println(result);
        String[] test = new String[]{"BACDE","CBADF","AEFCB","BDA"};
        test = new String[]{"C","AVCB","BD","B"};
        //int result = stackEx.skillTree("CBD",test);
        //println(result);

        //int result_2 = Level2.nextBigNum_2(6);
        //println(result_2);

        BFS bfs = new BFS();
        //int count = bfs.farthest(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        //println(count);
        
        //long result = Level2.maxExpression("100-200*300-500+20");
        //long result = Level2.maxExpression("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99");
        //long result = Level2.LCM(new int[]{2,6,8,14});
        //int result = Level2.numberSum(2);
        //println(result);

        //int result = bfs.network(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}});
        
        int result = Level2.joyStick("JAZ");
        println(result);

    }

    public static void println(Object data){
        System.out.println(data);
    }
}
// [1, 1, 1, 1, 1, 1] , 3 -> 4 return [2, 3, 3, 2, 9, 3, 3] , 3 -> 6 return 추천드립니다.
// [2, 3, 3, 2, 9, 3, 3] , 3 -> 6 return 로 풀었네요. 감사합니다.
