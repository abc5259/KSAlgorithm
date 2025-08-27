package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Edu[] edus = new Edu[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            edus[i] = new Edu(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edus, (a,b) -> {
            if(a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(edus[0].end);
        for(int i=1; i<N; i++) {
            Edu edu = edus[i];
            if(pq.peek() <= edu.start) {
                pq.poll();
            }
            pq.add(edus[i].end);
        }

        System.out.println(pq.size());
    }

    public static class Edu {
        int start, end;
        public Edu(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
