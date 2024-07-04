package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(i < K) {
                if(!map.containsKey(arr[i])) {
                    sum++;
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }


        int l = 0;
        int r = K - 1;
        int max = map.containsKey(C) ? sum : sum + 1;
        while (l < N) {

            map.put(arr[l], map.get(arr[l]) - 1);
            if(map.get(arr[l]) == 0) sum--;
            l++;
            r = (r + 1) % N;
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if(map.get(arr[r]) == 1) sum++;

            if(map.get(C) == 0) max = Math.max(max, sum+1);
            else max = Math.max(max, sum);


        }

        System.out.println(max);
    }
}
