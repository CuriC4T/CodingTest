package Level2;

import java.util.*;

public class StackEx {

    /*
     * 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
     * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을
     * 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지
     * 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
     * 예를 들어, 문자열 S = baabaa 라면
     * b aa baa → bb aa → aa →
     * 의 순서로
     * 문자열을 모두
     * 제거할 수 있으므로 1
     * 을 반환합니다.
     */
    // [ 완료 ]
    public int removePair(String s) {
        if (s.length() < 2) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (char temp : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(temp);
            } else {
                if (stack.peek().equals(temp)) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }

    //큰 수 만들기
    // 주어진 수에서 왼쪽부터 k개의 숫자를 뻇을떄 가장 큰 수는?
    //ex 1231234 3 => 3234
    //!! 정답이긴 한데
    // 스텍을 활용해서 다시 풀어보기
    public String makeBigNum(String number, int k) {
        StringBuffer sb = new StringBuffer();
        int[] nums = new int[number.length()];
        
        int max = -1;
        int maxIndex = -1;
        
        int start = 0;
        int end = k+1;

        for (int i = 0; i < number.length(); i++) {
            nums[i] = Character.getNumericValue(number.charAt(i));
        }
    
        System.out.println(start+" "+end+" "+max);

        for (int i = 0; i < nums.length-k; i++) {
            for (; start < end; start++) {
                if (max < nums[start]) {
                    max = nums[start];
                    maxIndex = start;
                }
            }
            start = maxIndex + 1;
            end++;
            sb.append(max);

            System.out.println(start+" "+end+" "+max);

            max = -1;
        }
        return sb.toString();
    }

    // // 시간 초과
    // public int nextBigNum(int n){
    //     int num = numOfOne(n);
    //     while(true){
    //         int temp = numOfOne(++n);
    //         if(num == temp){
    //             return n;
    //         }
    //     }
        
    // }

    // private int numOfOne(int n){
    //     Stack<Integer> stack = new Stack<>();
    //     int count = 0;
    //     while(n>1){
    //         int i = n%2;
    //         n=n/2;
    //         stack.add(i);
    //     }
    //     stack.add(n);
    //     while(!stack.isEmpty()){
    //         int temp = stack.pop();
    //         if(temp == 1 ) count++;
    //     }
    //     return count ;
    // }

    public int skillTree(String skill, String[] skill_trees) {
        int answer = 0;
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();

        char[] skills = skill.toCharArray();
        for (int j = 0; j < skill_trees.length; j++) {
            for (int i = 0; i < skills.length; i++) {
                int index = skill_trees[j].indexOf(skills[i]);
                stack.push(index);
            }

            int top = stack.pop();
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if (top == -1) {
                    // if (temp > -1) {
                    //     flag = false;
                    //     break;
                    // }
                } else {
                    if(temp == -1){
                        flag = false;
                            break;
                    }else{
                        if (temp > top) {
                            flag = false;
                            break;
                        }
                    }
                    
                }

                top = temp;
            }
            if (flag){
                System.out.println(j);

                answer++;
            }
            flag = true;

            stack.removeAllElements();

        }

        return answer;
    }

    
}
