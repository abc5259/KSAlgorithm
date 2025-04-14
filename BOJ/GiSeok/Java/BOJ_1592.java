package BOJ.GiSeok.Java;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_1592 {

    private static int[] friends;
    private static int n, m, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        friends = new int[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.add(i);

        int ans = 0;
        friends[1]++;
        while (!isFinished()) {
            int turn = q.peek();

           if (friends[turn] % 2 == 0) {
               for (int i = 0; i < l; i++) {
                   q.addFirst(q.pollLast());
               }

               friends[q.peek()]++;
            } else {
               for (int i = 0; i < l; i++) {
                   q.add(q.poll());
               }
               friends[q.peek()]++;
            }

            ans++;
        }

        System.out.println(ans);
    }

    public static boolean isFinished() {
        for (int i = 1; i <= n; i++) {
            if (friends[i] == m) return true;;
        }

        return false;
    }
}
