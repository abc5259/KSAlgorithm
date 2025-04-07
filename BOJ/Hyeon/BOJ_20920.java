package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> sorted = new ArrayList<>(map.keySet());
        sorted.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Objects.equals(map.get(o1), map.get(o2))) {
                    if (o2.length() == o1.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return map.get(o2) - map.get(o1);
            }
        });

        for (String s : sorted) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}

// S3 영단어 암기는 괴로워 정렬
// 일단 정렬조건이 자주나오는거 == map 으로 방문 횟수 점검 getOrDefault (키, 0) + 1
// 그리고 필요한게 key값만 필요하니까 map에서 키값을 빼내서 == map.keySet() 을 통해서 list를 만들고
// 리스트에서 정렬조건을 통해서 list foreach 문 만든다.