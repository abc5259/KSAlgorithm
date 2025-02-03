package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int currL = 0;
        Deque<State> deque = new ArrayDeque<>();
        while (!q.isEmpty() || !deque.isEmpty()) {
            time++;
            int size = deque.size();
            for(int i=0; i<size; i++) {
                State state = deque.pollFirst();
                if(state.dist + 1 <= W) {
                    state.dist += 1;
                    deque.offerLast(state);
                }
                else currL -= state.l;
            }
            if (!q.isEmpty() && currL + q.peek() <= L) {
                int l = q.poll();
                deque.offerLast(new State(l, 1));
                currL += l;
            }
        }
        System.out.println(time);
    }
    static class State {
        int l, dist;

        public State(int l, int dist) {
            this.l = l;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "State{" +
                    "l=" + l +
                    ", dist=" + dist +
                    '}';
        }
    }
}
