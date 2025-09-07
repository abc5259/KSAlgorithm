package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_11058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> milk = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            milk.add(Integer.parseInt(br.readLine()));
        }

        milk.sort(Collections.reverseOrder());

        int cost = 0;

        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 == 0) {
                continue;
            }
            cost += milk.get(i);
        }

        System.out.print(cost);
    }
}
// S4 2+1 세일 그리디
// 걍 풀었다.
