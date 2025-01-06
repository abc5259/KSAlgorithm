/**
 * 1966 - 프린터 큐 [O|00:19:27]
 * 실버3, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1966 {

    static class Paper {
        int order;
        int priority;

        public Paper(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            ArrayDeque<Paper> q = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int find = 0;
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                if (m == i) find = i;
                q.add(new Paper(i, priority));
            }

            int cnt = 0;
            while (true) {
                Paper paper = q.poll();

                if (moreThanPriorityInQueue(q, paper)) {
                    q.add(paper);
                    continue;
                }

                cnt++;
                if (find == paper.order) break;
            }

            System.out.println(cnt);
        }
    }

    private static boolean moreThanPriorityInQueue(ArrayDeque<Paper> q, Paper paper) {
        for (Paper tmp : q) {
            if (tmp.priority > paper.priority) {
                return true;
            }
        }
        return false;
    }
}
