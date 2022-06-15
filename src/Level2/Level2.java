package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

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

    // 길이 정렬 안되어있어서 순차로 startsWith 사용하면 안됨
    // + 이중 포문 비교는 효율성에서 걸림
    public boolean checkPrefix(String[] phone_book) {
        // 효율성 3,4번 걸림
        // if (phone_book.length == 1)
        // return false;
        // Arrays.sort(phone_book);
        // for (int i = 0; i < phone_book.length; i++) {
        // for (int j = i + 1; j < phone_book.length; j++) {
        // if (phone_book[j].startsWith(phone_book[i])) {
        // return false;
        // }
        // }
        // }

        // Arrays.sort(phone_book, new Comparator<String>(){};

        return true;
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

    public int nextBigNum_2(int n) {
        String binaryString = Integer.toBinaryString(n);
        char[] binary;

        int count = 0;

        int index = binaryString.lastIndexOf("01");

        System.out.println(binaryString + " " + index);

        if (index == -1) {
            binary = new char[binaryString.length() + 1];
            binary[0] = 1;
            binary[1] = 0;
            for (int l = 2; l < binaryString.length(); l++) {
                binary[l] = 1;
            }
        } else {
            binary = binaryString.toCharArray();

            binary[index] = 1;
            binary[index + 1] = 0;
            if (index + 2 < binary.length) {
                for (int j = index + 2; j < binary.length; j++) {
                    if (binary[j] == 1) {
                        count++;
                        binary[j] = 0;
                    }
                }
                for (int k = binary.length - 1; k < (binary.length - count); k--) {
                    binary[k] = 1;
                }
            }
        }
        System.out.println(binary[0]);

        return Integer.parseInt(new String(binary));

    }

    
}