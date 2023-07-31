package BOJ.JaeIk;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] v;

    // 결정 문제
    static boolean Check(int mid) { // mid 높이에 절단기를 위치했을 때 m 이상의 나무를 얻을 수 있는가?
        long sum = 0; // 오버플로우 조심
        for (int i = 0; i < n; i++) {
            if (v[i] > mid) sum += v[i] - mid;
        }
        return sum >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        // 이분 탐색
        int lo = 0, hi = 10000;
        // Checklist
        // 1. Check(lo) = T, Check(hi) = F를 만족하는가?
        // 2. lo는 정답이 될 수 있는 모든 범위를 나타낼 수 있는가? (정답은 0 ~ max(v) - 1라 가능)

        while (lo + 1 < hi) { // lo와 hi 사이에 다른 칸이 존재하는가?
            int mid = (lo + hi) / 2; // 항상 lo < mid < hi를 만족 (평균을 생각해보면 o)

            //sum>=m이면 m의 길이가 낮다는 의미이므로 low를 올린다
            if (Check(mid)) lo = mid;
            else hi = mid;
        }
        System.out.println(lo);
    }
}
