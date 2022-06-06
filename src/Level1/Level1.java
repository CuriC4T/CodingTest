package Level1;

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

    //numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return
    public int addNoNum(int[] numbers) {
        int answer = 45;
        for(int temp : numbers){
            answer -= temp;
        }
        return answer;
    }
}
