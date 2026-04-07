package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(scores);

        long total = 0;
        for (int i = 1; i <= N; i++) {
            total += Math.abs(i - scores.get(i - 1));
        }

        System.out.println(total);
    }
}
// S3 등수 매기기 그리디
// 10분
// 일단 풀었다
// N 명의 입력을 받아서 오름차로 정렬한다음에 각 인덱스와 등수의 차이를
// abs 연산으로 long 으로 누적합해서 구했다.
// trouble shooting
// long total = (1 + N) * N / 2 에 대해서 각 전체등수 1,2,3,4,5 와 예상등수 1,2,3,1,5를 해서
// 3을 가지려했는데 2,2,2 를 예상하면 상쇄되길래 트러블로 찾음. 반례
