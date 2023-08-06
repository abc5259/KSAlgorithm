package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Ticket> waitStack = new Stack<>();
        Queue<Ticket> lineQ = new LinkedList<>();
        PriorityQueue<Ticket> pq = new PriorityQueue<>((a,b) -> {
            if(a.c == b.c) return a.num - b.num;
            return a.c - b.c;
        });

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                String[] s = st.nextToken().split("-");
                Ticket ticket = new Ticket(s[0].charAt(0), Integer.parseInt(s[1]));
                lineQ.add(ticket);
                pq.add(ticket);
            }
        }

        while (!pq.isEmpty()) {

            if(!waitStack.isEmpty() && !lineQ.isEmpty()) {
                Ticket linePeek = lineQ.peek();
                Ticket waitPeek = waitStack.peek();
                Ticket pqPeek = pq.peek();

                if(linePeek.equals(pqPeek)) {
                    lineQ.poll();
                    pq.poll();
                }
                else if(waitPeek.equals(pqPeek)) {
                    waitStack.pop();
                    pq.poll();
                }
                else {
                    waitStack.push(lineQ.poll());
                }
            }
            else if(!lineQ.isEmpty()) {
                Ticket linePeek = lineQ.peek();
                Ticket pqPeek = pq.peek();

                if(linePeek.equals(pqPeek)) {
                    lineQ.poll();
                    pq.poll();
                }
                else {
                    waitStack.push(lineQ.poll());
                }
            }
            else if(!waitStack.isEmpty()) {
                Ticket waitPeek = waitStack.peek();
                Ticket pqPeek = pq.peek();

                if(waitPeek.equals(pqPeek)) {
                    waitStack.pop();
                    pq.poll();
                }
                else break;
            }
            else {
                break;
            }
        }

        System.out.println(pq.isEmpty() ? "GOOD" : "BAD");

    }
    static class Ticket {
        char c;
        int num;

        public Ticket(char c, int num) {
            this.c = c;
            this.num = num;
        }

        public boolean equals(Ticket t) {
            return this.c == t.c && this.num == t.num;
        }
    }
}
