import Level2.*;
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
        

        String result = stackEx.makeBigNum("4177252841",4);
        println(result);
    }

    public static void println(Object data){
        System.out.println(data);
    }
}
// [1, 1, 1, 1, 1, 1] , 3 -> 4 return [2, 3, 3, 2, 9, 3, 3] , 3 -> 6 return 추천드립니다.
// [2, 3, 3, 2, 9, 3, 3] , 3 -> 6 return 로 풀었네요. 감사합니다.
