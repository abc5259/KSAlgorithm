package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Info> p = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            p.offer(new Info(n, num, s));
        }

        StringBuilder sb = new StringBuilder();

        int[] only = new int[101];

        int cnt = 0;
        while (cnt != 3) {
            Info i = p.poll();

            if (only[i.nation]++ < 2) {
                cnt++;
                sb.append(i.nation).append(" ").append(i.num).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Info implements Comparable<Info> {
        int nation;
        int num;
        int score;

        public Info(int nation, int num, int score) {
            this.nation = nation;
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Info p) {
            return p.score - this.score;
        }
    }
}
// S5 아시아 정보올림피아드 구현
// 11분
// 그냥 풀었다.
// 점수 순으로 우선순위 큐를 통해 내림차순 정렬을 한다음에 나라별로 2명까지 가능하기 때문에
// only 배열로 2보다 작은지 체크해서 가능하면 cnt를 증가시켜 cnt의 개수가 3이면 저장된 값들을 출력한다.