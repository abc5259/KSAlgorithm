package BOJ.Hyeon.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> strKey = new HashMap<>(N);
        HashMap<Integer, String> intKey = new HashMap<>(N);

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            strKey.put(name, i);
            intKey.put(i, name);
        }

        while (M-- > 0) {
            String str = br.readLine();
            if (strKey.containsKey(str)) {
                sb.append(strKey.get(str)).append("\n");
            } else {
                sb.append(intKey.get(Integer.parseInt(str))).append("\n");
            }
        }
        System.out.println(sb);
    }
}

// hashmap 문제
// 개쉽게 풀었다.
// 포켓몬의 이름과 그에대한 인덱스를 가지고 키와 밸류를 비교해서 계산하는 문제
// 해쉬맵의 경우 키값을 인덱스로 하고 밸류를 값으로 가지는데 포켓몬의 이름을 넣었을 때는 순번인덱스가
// 순번인덱스를 넣었을 경우 포켓몬의 이름이 값으로 출력되어야 한다
// 이름을 키로 가지는 해쉬맵과, 순번을 키로 가지는 해쉬 맵을 통해서 풀었다.