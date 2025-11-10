package Programmers.Hyeon.lv1;

import java.util.Arrays;

public class K번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];
            int cnt = 0;

            for (int[] c : commands) {
                int i = c[0] - 1;
                int j = c[1] - 1;
                int k = c[2] - 1;

                int[] tmp = new int[j - i + 1];

                for (int idx = 0; idx < tmp.length; idx++) {
                    tmp[idx] = array[i++];
                }
                Arrays.sort(tmp);
                answer[cnt++] = tmp[k];
            }
            return answer;
        }
    }
}
// lv1 K번째수 정렬
// 4분
// 그냥 입력값 그대로 정렬하고 범위 신경만 써서 0 인덱스화 시켜서 -1 시킨다음
// 바깥의 배열에게 값을 복사해서 리턴해주면 끝났다.
