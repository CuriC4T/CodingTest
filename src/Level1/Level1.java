package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Level1 {

    // 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
    // 알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
    // 3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
    // 알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
    // 5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
    public int[] lottoMaxMin(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int result = 0;
        int zero = 0;

        for (int num : lottos) {
            if (num == 0) {
                zero++;
            } else {
                for (int num1 : win_nums) {
                    if (num == num1) {
                        result++;
                        break;
                    }
                }
            }

        }

        if (result + zero == 0) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (result + zero);
        }

        if (result < 2) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - result;
        }
        return answer;
    }

    // numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return
    public int addNoNum(int[] numbers) {
        int answer = 45;
        for (int temp : numbers) {
            answer -= temp;
        }
        return answer;
    }

    public int[] getReportResult(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> reportedCount = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            reportMap.putIfAbsent(temp[0], new HashSet<String>() {
                {
                    add(temp[1]);
                }
            });
            reportMap.get(temp[0]).add(temp[1]);
            reportedCount.putIfAbsent(temp[1], reportedCount.getOrDefault(temp[1], 0) + 1);
        }

        for (String name : reportedCount.keySet()) {
            System.out.println(name);
            Integer count = reportedCount.get(name);
            if (count >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reportMap.containsKey(id_list[i]) && reportMap.get(id_list[i]).contains(name)) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }

    public int[] testResult(int[] answers) {
        int[] a = new int[] { 1, 2, 3, 4, 5 };
           int[] b = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
           int[] c = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
           int[] count = new int[3];
           for (int i = 0; i < answers.length; i++) {
   
               if (a[i % 5] == answers[i]) {
                   count[0]++;
               }
               if (b[i % 8] == answers[i]) {
                   count[1]++;
               }
               if (c[i % 10] == answers[i]) {
                   count[2]++;
               }
           }
           ArrayList<Integer> list = new ArrayList<>();
           
           int max = Math.max(count[0],Math.max(count[1],count[2]));
           if(max == count[0])list.add(1);
           if(max == count[1])list.add(2);
           if(max == count[2])list.add(3);
           
           int[] answer = new int[list.size()];
           for(int i =0;i<list.size();i++){
               answer[i]=list.get(i);
           }
           
           return answer;
       }

    public String findLoser(String[] participant, String[] completion) {
        List<String> participantList = Arrays.asList(participant);
        List<String> completionList = Arrays.asList(completion);
        Collections.sort(participantList);
        Collections.sort(completionList);

        for (int i = 0; i < completionList.size(); i++) {

            System.out.println(completionList.get(i) + " " + participantList.get(i));
            if (completionList.get(i) != participantList.get(i)) {
                return participantList.get(i);
            }

        }
        return participantList.get(participantList.size() - 1);
    }

    // 아래와 같이 hashmap도 가능
    public String findLoser2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion)
            hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    public int[] removeSameNum(int[] arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack();
        stack.push(arr[0]);
        for(int i = 1 ;i<arr.length;i++){
            if(stack.peek()!=arr[i]){
                stack.push(arr[i]);
            }
        }

        answer = new int[stack.size()];
        for(int l = 0 ;l<answer.length;l++ ){
             answer[answer.length-1-l]=stack.pop();
        }

        return answer;
    }

    public String find2016(int a, int b) {
        int[] day = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        int result = 0;
        int month = a - 1;
         String answer = "";
        for(int i = 0 ;i<month;i++){
            result +=day[i];
        }
        result+=b-1;
        switch(result%7){
            case 0 :
                answer ="FRI";
                break;
                case 1 :
                answer ="SAT";
                break;
                case 2 :
                answer ="SUN";
                break;
                case 3 :
                answer ="MON";
                break;
                case 4 :
                answer ="TUE";
                break;
                case 5 :
                answer ="WED";
                break;
                case 6 :
                answer ="THU";
                break;
        }
        
       
        return answer;
    }
}
