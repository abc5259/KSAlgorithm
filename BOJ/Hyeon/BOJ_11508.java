package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> milk = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            milk.add(Integer.parseInt(br.readLine()));
        }
        milk.sort(Collections.reverseOrder());

        int cost = 0;
        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 == 0) {
                continue;
            }
            cost += milk.get(i);
        }
        System.out.print(cost);
    }
}
// S4 2+1 세일 그리디
// 걍 풀었다.
// 일단 잘 봐야될 게 문제를 잘 읽어봐야함 문제에서 제시해준 예시랑
// 문제에서 구하고자 하는 답이랑 달랐음 왜냐하면 예시는 그냥값을 구하는 방법이었는데
// 정답은 최소비용을 구하고 싶었기 때문에 원래 오름차로 풀다가 안돼서 봤더니
// 내림차가 필요했던 풀이였다.
// 개선
// 근데 그냥 내가 브레이크 문 해서 조건 분기로 연산을 했는데
// 쉽게 생각하면 3번째 index 마다 연산을 안하면 그만이다.