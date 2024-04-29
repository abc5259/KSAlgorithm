package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append((tc+1)).append(" ");

            for(int i=0; i<n; i++){
                String cmd = br.readLine();
                //연산 1 실행
                if(cmd.charAt(0)=='1'){
                    pq.add(Integer.valueOf(cmd.substring(2)));
                }
                //연산 2 실행
                if(cmd.charAt(0)=='2'){
                    if(!pq.isEmpty()){
                        sb.append(pq.peek()).append(" ");
                        pq.poll();
                    }
                    else if(pq.isEmpty()){
                        sb.append(-1).append(" ");
                    }
                }
            }

            System.out.println(sb);
        }
    }
}