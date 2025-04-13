package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        int K = Integer.parseInt(br.readLine());

        Map<String, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == '0') zeroCnt++;
            }

            if (K >= zeroCnt && zeroCnt % 2 == K % 2) {
                patternMap.put(board[i], patternMap.getOrDefault(board[i], 0) + 1);
            }
        }

        ArrayList<String> patterns = new ArrayList<>(patternMap.keySet());
        Collections.sort(patterns, (o1, o2) -> patternMap.get(o2).compareTo(patternMap.get(o1)));

        if (patternMap.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(patternMap.get(patterns.get(0)));
        }
    }
}
