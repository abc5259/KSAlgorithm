package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2170 {

    static class Node {
        long start;
        long end;

        public Node(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return Math.toIntExact(o1.end - o2.end);
            }

            return Math.toIntExact(o1.start - o2.start);
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());
            q.add(new Node(start, end));
        }

        long ans = 0;

        Node first = q.poll();
        long start = first.start;
        long end = first.end;
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.start > end) {
                ans += end - start;

                start = node.start;
                end = node.end;
            } else {
                if (node.end > end) end = node.end;
            }

        }

        ans += end - start;
        System.out.println(ans);
    }
}
