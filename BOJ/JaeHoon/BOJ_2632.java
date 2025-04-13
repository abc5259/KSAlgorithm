package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[M];
        int[] B = new int[N];

        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> aSum = new ArrayList<>();
        ArrayList<Integer> bSum = new ArrayList<>();
        Map<Integer, Integer> aSumMap = new HashMap<>();
        int answer = 0;
        int sum = A[0];
        aSum.add(sum);
        aSumMap.put(sum, 1);
        if (sum == size) answer++;
        for (int i = 1; i < M; i++) {
            sum += A[i];
            aSum.add(sum);
            if (sum == size) answer++;
            aSumMap.put(sum, aSumMap.getOrDefault(sum, 0) + 1);
        }
        for (int i = 1; i < M; i++) {
            sum = A[i];
            aSum.add(sum);
            int idx = (i + 1) % M;
            if (sum == size) answer++;
            aSumMap.put(sum, aSumMap.getOrDefault(sum, 0) + 1);
            while (idx != i - 1) {
                sum += A[idx];
                aSum.add(sum);
                idx = (idx + 1) % M;
                if (sum == size) answer++;
                aSumMap.put(sum, aSumMap.getOrDefault(sum, 0) + 1);
            }
        }
        sum = B[0];
        bSum.add(sum);
        if (sum == size) answer++;
        for (int i = 1; i < N; i++) {
            sum += B[i];
            bSum.add(sum);
            if (sum == size) answer++;

        }
        for (int i = 1; i < N; i++) {
            sum = B[i];
            bSum.add(sum);
            int idx = (i + 1) % N;
            if (sum == size) answer++;

            while (idx != i - 1) {
                sum += B[idx];
                bSum.add(sum);
                idx = (idx + 1) % N;
                if (sum == size) answer++;
            }
        }
        Collections.sort(aSum);

        for (int i = 0; i < bSum.size(); i++) {
            int findV = size - bSum.get(i);
            if (findV <= 0) continue;
            answer += aSumMap.getOrDefault(findV, 0);
        }
        System.out.println(answer);

    }
}
