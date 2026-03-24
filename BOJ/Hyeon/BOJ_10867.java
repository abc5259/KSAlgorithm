package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
// S5 중복빼고 정렬하기 HashSet
// 5분
// 그냥 중복을 뺀다길래 말그대로 중복 제거하는 자료구조 Set 을 쓰고
// 또 오름차순 정렬인데 N이 10만까지 가능해서 최악이어도 N log N 을 쓰기위해
// Collcetions.sort 사용