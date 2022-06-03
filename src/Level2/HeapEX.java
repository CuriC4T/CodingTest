package Level2;

import java.util.*;

public class HeapEX {
    /*
     * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어
     * 새로운 음식을 만듭니다.
     * 
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
     * 
     * [1, 2, 3, 9, 10, 12] 7 2
     * 입출력 예 설명
     * 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
     * 새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
     * 가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
     * 
     * 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
     * 새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
     * 가진 음식의 스코빌 지수 = [13, 9, 10, 12]
     * 
     * 모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
     */
    public int getScoville(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int temp : scoville) {
            priorityQueue.offer(temp);
        }

        while (priorityQueue.peek() < K) {
            try {
                int newFood = priorityQueue.remove() + (2 * priorityQueue.remove());
                priorityQueue.offer(newFood);
                answer++;
            } catch (NoSuchElementException e) {
                return -1;
            }
        }

        return answer;
    }

}
