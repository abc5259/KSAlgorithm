package BOJ.JaeIk.practice.baekjoon;

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1927 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty())System.out.println(0);
                else System.out.println(pq.remove());
            }else {
                pq.add(input);
            }
        }
    }
}
