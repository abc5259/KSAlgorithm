package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9017 {
    static int[] arr;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            scores = new int[N];
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, List<Integer>> scoreMap = new HashMap<>();
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int score = 1;
            for(int i=0; i<N; i++) {
                if(map.get(arr[i]) == 6) {
                    scores[i] = score;
                    List<Integer> list = scoreMap.getOrDefault(arr[i], new ArrayList<>());
                    list.add(score);
                    scoreMap.put(arr[i], list);
                    score++;
                }
            }

            List<int[]> result = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry : scoreMap.entrySet()) {
                int sum = 0;
                List<Integer> values = entry.getValue();
                for(int i=0; i<4; i++) {
                    sum += values.get(i);
                }
                result.add(new int[]{entry.getKey(), sum, values.get(4)});
            }

            for (int[] ints : result) {
                System.out.println("team: " + ints[0] + " sum = " + ints[1] + " 5번째: " + ints[2]);
            }

            result.sort((a,b) -> {
                if(a[1] == b[1]) return a[2] - b[2];
                return a[1] - b[1];
            });

            sb.append(result.get(0)[0]).append('\n');
        }
        System.out.print(sb);
    }
}
//1
//18
//1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1