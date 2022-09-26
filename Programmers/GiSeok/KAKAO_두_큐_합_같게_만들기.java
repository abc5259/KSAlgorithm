package Programmers.GiSeok;

public class KAKAO_두_큐_합_같게_만들기 {
    class Solution {
        public static long queueSum(int[] queue) {
            long sum = 0;
            for (int num: queue) {
                sum += num;
            }

            return sum;
        }

        public int solution(int[] queue1, int[] queue2) {
            int answer = 0;
            long sum1 = queueSum(queue1);
            long sum2 = queueSum(queue2);

            int idx1 = 0;
            int idx2 = 0;

            if ((sum1 + sum2) % 2 == 1) return -1;
            for (int i = 0; i < queue1.length; i++) {
                if ((sum1 + sum2) / 2 < queue1[i] || (sum1 + sum2) / 2 < queue2[i]) {
                    return -1;
                }
            }

            while (true) {
                if (sum1 == sum2) {
                    break;
                } else if (sum1 > sum2) {
                    if (idx1 < queue1.length) {
                        sum1 -= queue1[idx1];
                        sum2 += queue1[idx1++];
                    } else {
                        sum1 -= queue2[idx1 - queue1.length];
                        sum2 += queue2[idx1 - queue1.length];
                        idx1 += 1;
                        // index 길이가 길이*2면 모든 경우의 수를 해본 것과 같다.
                        if (idx1 == queue1.length*2) return -1;
                    }
                } else {
                    if (idx2 < queue2.length) {
                        sum1 += queue2[idx2];
                        sum2 -= queue2[idx2++];
                    } else {
                        sum1 += queue1[idx2 - queue2.length];
                        sum2 -= queue1[idx2 - queue2.length];
                        idx2 += 1;
                        if (idx2 == queue1.length*2) return -1;
                    }
                }
                answer += 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] t1_queue1 = {3, 2, 7, 2};
        int[] t1_queue2 = {4, 6, 5, 1};

        int[] t2_queue1 = {1, 2, 1, 2};
        int[] t2_queue2 = {1, 10, 1, 2};
        
        KAKAO_두_큐_합_같게_만들기 cases = new KAKAO_두_큐_합_같게_만들기();
        KAKAO_두_큐_합_같게_만들기.Solution tcase = cases.new Solution();

        System.out.println(tcase.solution(t1_queue1, t1_queue2));
        System.out.println(tcase.solution(t2_queue1, t2_queue2));
    }
}