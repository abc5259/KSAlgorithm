package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27172 {
    static int LIMIT = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] players = new int[N + 1];

        boolean[] exists = new boolean[LIMIT];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxVar = 0;
        for (int i = 1; i <= N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            exists[players[i]] = true;

            if (maxVar < players[i]) {
                maxVar = players[i];
            }
        }

        int[] scores = new int[LIMIT];

        for (int i = 1; i <= N; i++) {
            for (int j = players[i] * 2; j <= maxVar; j += players[i]) {
                if (exists[j]) {
                    scores[j]--;
                    scores[players[i]]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(scores[players[i]]).append(" ");
        }
        System.out.println(sb);
    }
}
// G4 수 나누기 게임 에라토스테네스의 체
// 브루트포스로 접근했다가 N이 100만 으로 시간초과를 야기하는 문제이다
// 에라토스테네스의 체를 통해서 구했다.
// 일단 1_000_001 까지 해서 존재하는 배열을 만들었다. player가 가지고 잇는 카드를 존재 여부를 가지고 가장 큰값을 가졌다
// 그리고 player 카드의 배수부터 가장 큰값까지 반복문을 만들어서 player[i] 만큼 더하는건데
// score로 값을 분기처리했다.
