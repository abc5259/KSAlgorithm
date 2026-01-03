package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solve[] arr = new Solve[8];
        int[] res = new int[5];

        for (int i = 0; i < 8; i++) {
            arr[i] = new Solve(Integer.parseInt(br.readLine()), i + 1);
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 3; i < 8; i++) {
            sum += arr[i].score;
            res[i - 3] = arr[i].idx;
        }
        Arrays.sort(res);

        StringBuilder sb = new StringBuilder();
        for (int idx : res) {
            sb.append(idx).append(" ");
        }

        System.out.println(sum);
        System.out.println(sb);
    }

    static class Solve implements Comparable<Solve> {
        int score;
        int idx;

        Solve(int score, int idx) {
            this.score = score;
            this.idx = idx;
        }

        public int compareTo(Solve s) {
            return this.score - s.score;
        }
    }
}
// S5 점수 계산 정렬
// 5분
// 이전에는 그냥 입력값이 8개로 정해져있길래 오름차순임을 감안해서 정렬한다음 가장 상위의 값을
// 더해버리고 거기에다가 순차적으로 정렬된 값과 오리지널을 비교해서 인덱스를 출력했는데
// 값과 인덱스를 동시에 관리하며 정렬하는 Comparable로 해결했다
// 그래서 오름차순 정렬 2개 값에 대한 정렬과 인덱스로 관리했다.