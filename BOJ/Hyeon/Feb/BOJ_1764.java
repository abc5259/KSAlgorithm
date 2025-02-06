package BOJ.Hyeon.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            } else {
                set.add(name);
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
// 1764 듣보잡
// 자료구조, 해쉬셋 사용했다.
// 일단 키값이랑 밸류가 같이 있는 해쉬맵보단 중복이 허용안되는 해쉬 셋이 더 나았다.
// 포함되어 있는 여부를 확인하고 오름차순으로 정렬해야돼서 어레이 리스트로 만들었다.
// 포함안되면 셋에 넣고 중복값이면 어레이에 넣는다.