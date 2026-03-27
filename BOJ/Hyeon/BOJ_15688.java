package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
// S5 수 정렬하기 5 정렬
// 3분
// 쉽게 풀었다.
// 그냥 오름차순하는게 목표였는데 N은 100만이고 근데 그러면 30초이내에 하려면
// N log N이 어야 됐는데 이는 Collections 자료구조를 통해서 가능했다.
// 원시타입의 정렬의 경우 듀얼 피봇으로 최악이면 N^2되는데 Collections 는 timsort 방식으로 최악이어도
// N log N이 되기에 가능했다.