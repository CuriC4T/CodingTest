package Level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* 
연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
*/

class SetEX {
    public int ponketmon(int[] nums) {
        int answer = nums.length / 2;

        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        List temp = Arrays.asList(integers);
        HashSet<Integer> hash = new HashSet<Integer>(temp);

        if (hash.size() < answer) {
            answer = hash.size();
        }
        return answer;
    }
}