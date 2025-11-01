package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            file = file.substring(file.indexOf('.') + 1);

            map.put(file, map.getOrDefault(file, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.print(sb);
    }
}
// S3 파일 정리 HashMap
// 걍했다.