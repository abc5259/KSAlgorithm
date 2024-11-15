/**
 * 2164 - 카드2(S4) [O|00:03:10]
 * 자료구조, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) q.add(i);

        while (q.size() != 1) {
            q.pop();
            q.add(q.pop());
        }

        System.out.println(q.pop());
    }
}
