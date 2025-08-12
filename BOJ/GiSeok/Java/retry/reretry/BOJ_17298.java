package BOJ.GiSeok.Java.retry.reretry;

// 00:16:46 G4
import java.util.*;
import java.io.*;

public class BOJ_17298 {

    static class Pair {
        int num, order;

        public Pair(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        Deque<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int 숫자 = Integer.parseInt(st.nextToken());

            if (q.isEmpty()) {
                q.push(new Pair(숫자, i));
                continue;
            }

            while (!q.isEmpty() && q.peek().num < 숫자) {
                Pair p = q.pop();
                nge[p.order] = 숫자;
            }
            q.push(new Pair(숫자, i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(nge[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}
