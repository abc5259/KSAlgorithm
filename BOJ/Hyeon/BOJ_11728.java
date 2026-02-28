package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int a : arr) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
// S5 배열 합치기 정렬
// 5분
// 2개의 배열이 주어져있고 각각의 길이는 100만이다
// 200만의 길이를 합쳐서 정렬하면 200만 log 200 만이라 1초이내 가능
// Integer 를 가지는 List 를 Collections.sort 해서 n log n 에 가능하게 함.