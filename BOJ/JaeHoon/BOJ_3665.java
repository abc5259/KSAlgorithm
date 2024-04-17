package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int i=0; i<N; i++) {
                map.put(arr[i], new HashSet<>());
                for(int j=i+1; j<N; j++) {
                    map.get(arr[i]).add(arr[j]);
                }
            }

            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(map.get(a).contains(b)) {
                    //a가 b보다 작년 등수가 큰 경우
                    map.get(a).remove(b);
                    map.get(b).add(a);
                }
                else if(map.get(b).contains(a)) {
                    //b가 a보다 작년 등수가 큰 경우
                    map.get(b).remove(a);
                    map.get(a).add(b);
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

             map.forEach((key, value) -> {
                 pq.offer(new int[]{key, value.size()});
             });


             StringBuilder sb2 = new StringBuilder();

             boolean isOk = true;
             int expectedCnt = N-1;
             while (!pq.isEmpty()) {
                 int[] curr = pq.poll();
                 sb2.append(curr[0]).append(" ");
                 if(curr[1] == expectedCnt) {
                     expectedCnt--;
                 }else {
                     isOk = false;
                     break;
                 }
             }

             if(!isOk) {
                 sb.append("IMPOSSIBLE").append("\n");
             }else {
                 sb.append(sb2).append("\n");
             }


        }

        System.out.println(sb);

    }
}
