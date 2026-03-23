package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
    static int k;
    static char[] sign;
    static String min, max;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        visit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            dfs(i, 0, String.valueOf(i));
            visit[i] = false;
        }
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int n, int idx, String v) {
        if (idx == k) {
            if (min == null) {
                min = v;
            }
            max = v;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                if (check(n, i, sign[idx])) {
                    visit[i] = true;
                    dfs(i, idx + 1, v + i);
                    visit[i] = false;
                }
            }
        }
    }

    static boolean check(int a, int b, char op) {
        return op == '<' ? a < b : a > b;
    }
}
// S1 부등호 백트래킹
// 22분
// 걍 풀었다 문제보자마자 깊이가 10정도고 최소값이 0으로 시작할경우 값에도 0을 붙여줘야됐다.
// 그래서 Integer.parseInt 못쓸거라고 생각 왜냐하면 0 생략하고 정수로 바꾸니까 해결책으로 String.valueOf 도입
// 또 0부터 9까지 중복없다는거보니까 각각 다른 수를 써야되기에 dfs 로 하고 쓴 수로 이어나가다가
// 가지치기 당하면 취소하고 다시 방문 처리 안하기위해 백트래킹으로 설정했다
// 그래서 가장 큰 수를 문자열 9876543210 작은 수를 0123456789 로 해서
// 비교할 현재숫자, 깊이, 지금까지 누적된 문자열로 해서 dfs 를 돌렸다
// 0부터 9까지 반복문으로 시작값을 정하고 이 시작값 또한 백트래킹으로 설정
// 그당 기저사례는 깊이가 해당됐을 때 설정해둔 문자열고 compareTo 연산으로 해서 값 갱신
// 부등호를 if 조건으로 2개 분기해서 반복문으로 백트래킹으로 진행.
// 개선된 풀이
// 1. String 배열 대신 char
// 2. min 은 가장 처음 가지는 값 즉 null 일때 저장하면 끝 max 는 계속해서 갱신 하면됨.
// 3. check 로 따로 빼서 분기문을 1개로 죽임