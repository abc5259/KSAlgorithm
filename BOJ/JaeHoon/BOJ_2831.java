package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minMen  = new PriorityQueue<>();
        PriorityQueue<Integer> maxMen  = new PriorityQueue<>();
        PriorityQueue<Integer> minWomen  = new PriorityQueue<>();
        PriorityQueue<Integer> maxWomen  = new PriorityQueue<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if(h < 0) {
                minMen.offer(Math.abs(h));
            }else {
                maxMen.offer(h);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if(h < 0) {
                minWomen.offer(Math.abs(h));
            }else {
                maxWomen.offer(h);
            }
        }

        int count = 0;
        while (!minMen.isEmpty() && !maxWomen.isEmpty()) {
            if(minMen.peek() > maxWomen.peek()) {
                count++;
                minMen.poll();
                maxWomen.poll();
            }
            else {
                minMen.poll();
            }
        }

        while (!minWomen.isEmpty() && !maxMen.isEmpty()) {
            if(minWomen.peek() > maxMen.peek()) {
                count++;
                minWomen.poll();
                maxMen.poll();
            }
            else {
                minWomen.poll();
            }
        }

        System.out.println(count);
    }
}
