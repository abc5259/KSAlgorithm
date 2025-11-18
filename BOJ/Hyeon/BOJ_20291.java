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
            String tmp = br.readLine();
            String file = tmp.substring(tmp.indexOf('.') + 1);

            map.put(file, map.getOrDefault(file, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String name : list) {
            sb.append(name).append(" ").append(map.get(name)).append("\n");
        }
        System.out.print(sb);
    }
}
// S3 파일 정리 HashMap 복습
// 7분
// 그냥 HashMap으로 만들어서 문자열과 반복 회수를 센다음에
// 오름차순 정렬이 중요했는데 바로 List 에 다가 KeySet을 옮겨두고 여기서
// Collection 정렬을 해버려서 사용했다.