package Level2;

import java.util.ArrayList;
import java.util.HashSet;

public class Bruth_Force{
    public int[] carpet(int brown, int yellow) {
        int[] answer = new int[2];
         if(yellow==1){
            answer[0] = 3;
            answer[1] = 3;
        }else{
             for(int i = 1 ;i <= yellow/2;i++){
            int a = yellow/i;
            if((a*i)==yellow){
                if(((a+2)*(i+2))==(brown+yellow)){
                    answer[0] = Math.max(a+2,i+2);
                    answer[1] = Math.min(a+2,i+2);
                    break;
                }
            }

        }
         }
        
        return answer;
    }

    HashSet<Integer> outputSet = new HashSet<>();
    public int findPrimary(String numbers){
        int answer =0;
        int[] nums = new int[numbers.length()];
        
        for(int i = 0 ;i<numbers.length();i++){
            nums[i]=numbers.charAt(i)-'0';
        }

        System.out.println(numbers.substring(0, numbers.length()-1));
        
        return answer;
    }

    public void permutation(int[] array, int r,int depth){
        if(depth == r){
            
        }
    }


    public void permutaionTest(){
        int[] permutations = new int[]{1,3,2,4};


    }
}