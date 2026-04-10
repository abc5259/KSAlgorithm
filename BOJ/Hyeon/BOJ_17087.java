package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int firstA = Integer.parseInt(st.nextToken());
        int gcd = Math.abs(S - firstA);

        for (int i = 1; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            int diff = Math.abs(S - A);
            gcd = getGCD(gcd, diff);
        }

        System.out.println(gcd);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
// S2 숨바꼭질 6 유클리드 호제법
// 24분
// 풀이를 다 풀고나서 내가 잘못풀어서 헷갈림 최대값을 구한다는 텍스트 때문에 Math.max를 함 계속해서 GCD를 구하는거자체가
// 최대공약수인데.
// 최대공약수를 구하는 문제.
// N개의 A 와 S 간의 간격을 구하는데 최대공약수로 해서 D 만큼 가게끔 반복 그래서
// 오름차 정렬하고 맨 앞 간격 01 과 12 의 간격을 구해서 이에 대한 최대 gcd 를 구함
// 그리고 23간의 간격으로 gcd를 연산해가면서 최대값을 반환
// N이 10만이라서 O(N*GCD) 라고 생각했음. 또 N이 1일때 abs 연산으로 조기반환함.
// 개선된 풀이
// 굳이 배열쓰지말고 S 와 A 를 그때그때 비교하는 방식으로? GCD 연산.이러면 정렬이 필요없고