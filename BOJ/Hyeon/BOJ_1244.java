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
                changeMale(switches, num);
            } else {
                changeFemale(switches, num);
            }
        }
        printSwitch(cnt, switches);
    }

    private static void changeMale(int[] switches, int num) {
        for (int i = num; i < switches.length; i += num) {
            toggleSwitch(switches, i);
        }
    }

    private static void changeFemale(int[] switches, int num) {
        toggleSwitch(switches, num);
        int lo = num - 1;
        int hi = num + 1;
        while (lo >= 1 && hi < switches.length && switches[lo] == switches[hi]) {
            toggleSwitch(switches, lo--);
            toggleSwitch(switches, hi++);
        }
    }

    private static void toggleSwitch(int[] switches, int idx) {
        switches[idx] ^= 1; // 0이면 1로 1이면 0으로
    }

    private static void printSwitch(int cnt, int[] switches) {
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

// refactor
// 일단 메소드 추출해서 남자와 여자를 갈랐고 스위치를 변경하는 메소드 출력문 메소드로 나눴따
// 스위치는 bitset을 사용해서 ^=1로 1이면 0으로 만들고 0이면 1로 만들게 하였다.
// female과 달리 male은 그냥 반복문 돌려서 += 증감식으로 배수 사용했다.
// 여자는 최초 num 자리 스위치 하고 -1 +1 마다 while 반복문 돌려서 스위치를 껏다.