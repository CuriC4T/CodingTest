package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level2 {
    public Level2() {
        System.out.println("Level2 Test");
    }

    public void MaxPrice(String expression) {
        int max = -1;
        int count = 0;
        ArrayList<String[]> arrayList = new ArrayList<>();
        ArrayList<Character> data = new ArrayList<>();
        if (expression.contains("*")) {
            count++;
        }
        if (expression.contains("+")) {
            count++;
        }
        if (expression.contains("-")) {
            count++;
        }
        String[] test = expression.split("\\D");
        String[] test1 = expression.split("\\d");
        System.out.println(test.length);

        for (char temp : expression.toCharArray()) {
            data.add(temp);
        }
        // arrayList.add(new String[]{"*,-,+"});
        arrayList.add(new String[] { "*,+,-" });
        // arrayList.add(new String[]{"+,-,*"});
        // arrayList.add(new String[]{"+,*,+"});
        // arrayList.add(new String[]{"-,*,+"});
        // arrayList.add(new String[]{"-,+,*"});
        for (int i = 0; i < arrayList.size(); i++) {
            int result = Math.abs(sum_MaxPrice(data, arrayList.get(i)));
            if (max < result) {
                max = result;
            }
        }

        System.out.println("result: " + max);
    }

    private int sum_MaxPrice(ArrayList<Character> data, String[] strings) {
        int size = strings.length;
        for (int i = 0; i < size; i++) {
            String ex = strings[i];
            System.out.println(ex + " " + data.contains(ex.charAt(0)));
            while (data.contains(ex.charAt(0))) {
                if (data.size() < 2)
                    break;
                int index = data.indexOf(ex.charAt(0));
                int first = Integer.valueOf(data.get(index - 1).toString());
                int second = Integer.valueOf(data.get(index + 1).toString());
                System.out.println(index + " " + first + " " + second);
                data.remove(index - 1);
                data.remove(index - 1);
                data.remove(index - 1);
                switch (ex) {
                    case "*":
                        System.out.println((first * second));
                        data.add(index - 1, String.valueOf(first * second).charAt(0));
                        System.out.println(data.get(0));
                        System.out.println(data.get(index - 1));
                        break;
                    case "-":
                        System.out.println(first - second);
                        data.add(index - 1, String.valueOf(first - second).charAt(0));
                        break;
                    case "+":
                        data.add(index - 1, String.valueOf(first + second).charAt(0));
                        break;
                }
            }

        }

        return String.valueOf(data.get(0)).charAt(0);
    }

    /*
     * 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는
     * 기능이 배포될 때 함께 배포됩니다.
     * 
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가
     * 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     */
    // (int)Math.ceil((100-progress)/(double)speeds[i]) 해당 부분의 "올림" 호출이 필요
    // speeds를 double로 형변환하지 않으면 올림의 의미가 없음(자연수/자연수이기에)
    // [ 완료 ]
    public int[] progressesTest(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;

        int limit = (int) Math.ceil((100 - progresses[0]) / (double) speeds[0]); // 최초 제한일

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int temp = (int) Math.ceil((100 - progress) / (double) speeds[i]);
            if (limit < temp) { // 제한일 넘으면 동시에 해결 불가. 이전에 처리할 수 있는 일의 갯수를 배열에 저장
                arrayList.add(count);
                count = 1;
                limit = temp;
            } else { // 동시에 처리 가능
                count++;
            }
        }
        arrayList.add(count); // 마지막 업무까지 저장

        // ArrayList -> int Array
        answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i).intValue();
        }

        return answer;
    }

    // String S = "No one could disentangle correctly";
    // String W[] = S.split(" ");
    // Arrays.sort(W, new java.util.Comparator<String>() {
    // @Override
    // public int compare(String s1, String s2) {
    // // TODO: Argument validation (nullity, length)
    // return s1.length() - s2.length();// comparision
    // }
    // });

    // 시간초과
    public int nextBigNum(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char temp : binaryString.toCharArray()) {
            if (temp == '1') {
                count++;
            }
        }
        System.out.println(count);
        while (true) {
            int temp_count = 0;
            String binaryString_2 = Integer.toBinaryString(++n);
            for (char temp : binaryString_2.toCharArray()) {
                if (temp == '1') {
                    temp_count++;
                }
            }
            if (count == temp_count)
                return n;

        }
    }

    // 테스트 110 -> 1001 걸렸음
    // 해결
    // bitCount()와
    // int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) /
    // postPattern) >> 2;
    // return n + postPattern | smallPattern;
    // 참고
    public int nextBigNum_2(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] binarys = binaryString.toCharArray();
        int count = 0;
        int index = binaryString.lastIndexOf("01");
        System.out.println(binaryString);

        if (index == -1) {
            char[] temp = new char[binarys.length + 1];
            Arrays.fill(temp, '0');
            for (int i = 1; i < binarys.length; i++) {
                if (binarys[i] == '1') {
                    count++;
                }
            }
            for (int i = temp.length - 1; i > temp.length - count - 1; i--) {
                temp[i] = '1';
            }

            temp[0] = '1';
            temp[1] = '0';
            // if(binarys[1]=='0'){
            // for(int k = 2 ;k<temp.length;k++){
            // temp[k] = '0';
            // }
            // }else{
            // for(int k = 2 ;k<temp.length;k++){
            // temp[k] = '1';
            // }
            // }

            binarys = temp;
        } else {
            if (binarys.length > index + 1) {
                for (int i = index + 2; i < binarys.length; i++) {
                    if (binarys[i] == '1') {
                        count++;
                        binarys[i] = '0';
                    }
                }

                for (int j = binarys.length - 1; j > binarys.length - count - 1; j--) {
                    binarys[j] = '1';
                }
            }

            binarys[index] = '1';
            binarys[index + 1] = '0';

        }
        System.out.println(String.valueOf(binarys));

        System.out.println(Integer.parseInt(String.valueOf(binarys), 2));
        return Integer.parseInt(String.valueOf(binarys), 2);

    }

    public long maxExpression(String expression) {
        long max = -1;
        String[] pattern = new String[] { "*-+", "-*+", "-+*", "*+-", "+*-", "+-*" };
        ArrayList<Character> operator = new ArrayList();
        ArrayList<String> operand = new ArrayList<>();

        ArrayList<Character> operator_orgin = new ArrayList();
        ArrayList<String> operand_orgin = new ArrayList<>();

        String[] temp = expression.split("[+\\-*]");

        for (String tmp : temp) {
            operand_orgin.add(tmp);
        }
        String[] temp_2 = expression.split("[0-9]+");
        for (int i = 1 ; i< temp_2.length; i++ ) {
            operator_orgin.add(temp_2[i].charAt(0));
        }

        for (int i = 0; i < pattern.length; i++) {
            operator.addAll(operator_orgin);
            operand.addAll(operand_orgin);
            for(int j = 0 ;j<3;j++){
                char oper = pattern[i].charAt(j);
                int index = operator.indexOf(oper);
                while (index != -1) {
                    String a = operand.remove(index);
                    String b = operand.remove(index);
                    operator.remove(index);
                    String result = calcurate(a, b, oper);
                    operand.add(index,result);
                    index = operator.indexOf(oper);
                }
            }
            long result = Long.valueOf(operand.remove(0));
            result = Math.abs(result);
            if (max < result) {
                max = result;
            }

        }

        // System.out.println(temp[2]);
        return max;
    }

    private String calcurate(String a, String b, char operator) {
        long result = -1;
        long a_int = Long.valueOf(a);
        long b_int = Long.valueOf(b);
        switch (operator) {
            case '+':
                result = a_int + b_int;
                break;
            case '-':
                result = a_int - b_int;
                break;
            case '*':
                result = a_int * b_int;
                break;
        }
        return String.valueOf(result);
    }

    //a*b/gcd = lcm
    public long LCM(int[] arr){
        long[] arrLong = new long[arr.length];
        for(int i = 0 ;i<arr.length;i++){
            arrLong[i]=(long)arr[i];
        }
        long lcm = -1;
        if(arrLong.length==1) return arrLong[0];
        for(int i = 0 ;i<arrLong.length-1;i++){
            Arrays.sort(arrLong);
            long gcm = GCD(arrLong[i], arrLong[i+1]);
            lcm = (arrLong[i]*arrLong[i+1])/gcm;
            arrLong[i+1] = lcm;
        }
        return arrLong[arrLong.length-1];

    }
    private long GCD(long a, long b){
        long remain = -1;
        do{
            remain = b%a;
            b=a;
            a=remain;
        }while(remain !=0);
        return b;
    }

    // class NLCM {
    //     public long nlcm(int[] num) {
    //         long answer = num[0],g;
    //     for(int i=1;i<num.length;i++){
    //       g=gcd(answer,num[i]);
    //             answer=g*(answer/g)*(num[i]/g);
    //     }
    //         return answer;
    //     }
    //     public long gcd(long a,long b){
    //     if(a>b)
    //       return (a%b==0)? b:gcd(b,a%b);
    //     else 
    //       return (b%a==0)? a:gcd(a,b%a);
    //   }

    // }

    public long makeMinNum(int []A, int []B){
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ;i<A.length;i++){
            sum += A[i]*B[B.length-i-1];
        }
        return sum;
    }

    public String findMaxMin(String s){
        String[] strings = s.split(" ");
        int[] intArray = new int[strings.length];
        for(int i = 0 ; i < strings.length;i++){
            intArray[i]=Integer.valueOf(strings[i]);
        }
        Arrays.sort(intArray);
        StringBuilder sb = new StringBuilder();
        sb.append(intArray[0]+" "+intArray[intArray.length-1]);
        return sb.toString();
    }

    //정답인데 
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 
    //주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있음

    public int numberSum(int n){
        int answer = 0;
        int sum = 0;
        if(n<3) return 1;
        for(int i = 1 ; i<= (n/2)+1 ;i++){
            for(int j = i ;j<= (n/2)+1 ;j++){
                sum += j;
                if(sum > n){
                    break;
                }else if(sum == n){
                    System.out.println(i);
                    answer++;
                    break;
                }
            }
            sum = 0;
        }
        answer++;
        return answer;

         // int answer = 0;
    //     for (int i = 1; i <= num; i += 2) {
    //         if (num % i == 0) {
    //             answer++;
    //         }
    //     }
    //     return answer;
    }

    public int tuple(String[][] relation){
        int answer = 0;
        String base="안";
        int[] indexs = new int[relation[0].length];
        Arrays.fill(indexs, -1);
        boolean flag = true;
        if(relation[0].length==1){
            return relation.length;
        }
        for(int i = 0 ;i<relation.length;i++){
            base = relation[i][0];
            for(int j = 1 ;j<relation[i].length;j++){
                String temp = relation[i][j];
                if(temp.compareTo(base)==0){
                    indexs[i] = j;
                    //같은 행에 두 개가 같은 경우
                    for(int k = i+1 ;k<relation.length;i++){
                        //if(relation[][])
                    }
                    flag = false;
                    break;
                }
                
            }
            if(flag){
                answer++;
            }else{
                flag = true;
            }
        }
        return answer;
    }

    public int joyStick(String name){
        int answer = 0;
        int length = name.length();
        char[] charArray = name.toCharArray();
        char A = 'A';
        for(int i = 0 ;i<length;i++){
            while(A==charArray[i]){
                if(A=='Z'){
                    A='Z';
                }else{
                    A++;
                }
                answer++;
            }
            answer++;
        }

        return answer;
    }

   

}