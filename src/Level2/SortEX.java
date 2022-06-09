package Level2;

import java.util.Arrays;
import java.util.Collections;

public class SortEX {



    //각 숫자를 문자열로 하여서 concat 했을 때 가장 큰 수
    // Arrays.sort의 compare 이용
    // 두 문자열을 합친 후 compare로 비교 후 
    public String makeBigNum(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        // Arrays.sort(nums, Collections.reverseOrder());

        Arrays.sort(nums, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO: Argument validation (nullity, length)
                System.out.println((s1+s2)+" "+(s2+s1));
                System.out.println((s2+s1).compareTo((s1+s2))); // 양수가 나오면 두 값을 swap
                return (s2+s1).compareTo((s1+s2));

                // int tmp = s2.charAt(0) - s1.charAt(0);
                // if(tmp == 0){
                //     // System.out.println(s1+" "+s2+" "+s1.compareTo(s2));
                //     // int compare = (s1+s2).compareTo(s2+s1);
                //     if(s1.length()>s2.length()){
                //         if(s1.charAt(s1.length()-1)-s2.charAt(0)>0){
                //             return -1;
                //         }else{
                //             return 1;
                //         }
                //     }else if(s2.length()>s1.length()){
                //         if(s2.charAt(s2.length()-1)-s1.charAt(0)>0){
                //             return -1;
                //         }else{
                //             return 1;
                //         }
                //     }else{
                //         return s2.compareTo(s1);
                //     }
                    
                // }
                // System.out.println(tmp);

                // return tmp;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String answer= sb.toString();
        if(answer.startsWith("0"))return "0";
        return sb.toString();
    }

}
