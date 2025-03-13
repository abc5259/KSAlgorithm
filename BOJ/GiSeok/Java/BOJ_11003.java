/**
 * [P5 자료구조] 최솟값 찾기 - X
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_11003 {

    private static class Tmp {
        int value, idx;

        public Tmp(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayDeque<Tmp> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            Tmp tmp = new Tmp(Integer.parseInt(st.nextToken()), i);

            while (!q.isEmpty() && q.peekLast().value > tmp.value) q.pollLast();

            q.add(tmp);

            if (q.getFirst().idx < (i - l + 1)) q.poll();
            bw.write(q.getFirst().value + " ");
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
