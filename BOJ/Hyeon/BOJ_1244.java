package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[] switches = new int[cnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= cnt; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }


        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                int time = 1;
                while (num * time <= cnt) {
                    switches[num * time] = switches[num * time] == 0 ? 1 : 0;
                    time++;
                }
            } else {
                int lo = num;
                int hi = num;

                while (switches[lo] == switches[hi] && lo > 1 && hi < cnt) {
                    lo--;
                    hi++;
                }
                if (switches[lo] != switches[hi]) {
                    lo++;
                    hi--;
                }

                for (int i = lo; i <= hi; i++) {
                    switches[i] = switches[i] == 0 ? 1 : 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= cnt; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
// S4 스위치 켜고 끄기 시뮬레이션
// 출력 형식을 못 맞추기도 했고 ArrayOutBound도 야기했다
// 점검이 필요할 거 같은데 맞기는 맞았다
// 문제 이해력 필요 출력만 20개단위지 입력은 아니었고 또한 이상하게 인덱스 관리하지말고 반복문 잘 써야한다.