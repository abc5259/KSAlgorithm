package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] og = new int[N];

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());
            og[i] = X;
            list.add(X);
        }

        ArrayList<Integer> sortedList = new ArrayList<>(new HashSet<>(list));
        Collections.sort(sortedList);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }
        for (int i = 0; i < N; i++) {
            sb.append(map.get(og[i])).append(" ");
        }
        System.out.println(sb);
    }
}

// S2 좌표 압축 정렬
// 일단 풀었는데 점검 필요