package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Queue<Customer> q = new LinkedList<>();
        Customer[] cArr = new Customer[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            q.offer(new Customer(id,t));
        }

        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Customer> lateQ = new PriorityQueue<>((a,b) -> {
            return a.c - b.c;
        });

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lateQ.offer(new Customer(id,t,c));
        }

        StringBuffer sb = new StringBuffer();

        int time = 0;
        Loop: while (!q.isEmpty()) {
            Customer curr = q.poll();

            if(curr.t <= T) {
                for(int i=1; i<= curr.t; i++) {
                    time++;
                    sb.append(curr.id+"\n");
                    if(time == W) break Loop;
                }
            }else {
                for(int i=1; i<= T; i++) {
                    time++;
                    sb.append(curr.id+"\n");
                    if(time == W) break Loop;
                }
            }

//                System.out.println("time = " + time);
            while (!lateQ.isEmpty() && lateQ.peek().c <= time) {
                q.offer(lateQ.poll());
            }

            if(curr.t > T) {
                curr.t -= T;
                q.offer(curr);
            }
        }

        System.out.print(sb);
    }
    static class Customer {
        int id,t,c;

        public Customer(int id, int t) {
            this.id = id;
            this.t = t;
        }

        public Customer(int id, int t, int c) {
            this.id = id;
            this.t = t;
            this.c = c;
        }
    }
}
//1 3 10
//1 6
//2
//2 4 2
//3 4 5
