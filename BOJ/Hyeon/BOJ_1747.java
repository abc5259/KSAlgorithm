package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1747 {
    private static final int LIMIT = 1_500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] notPrime = new boolean[LIMIT];

        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i * i < LIMIT; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        for (int i = N; i < LIMIT; i++) {
            if (!notPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int lo = 0;
        int hi = str.length() - 1;

        while (lo < hi) {
            if (str.charAt(lo) == str.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// S1 소수&팰린드롬 수학
// 10분
// 일단 소수를 구하기와 팰린드롬을 구하는건데 문제 조건상 N 보다 크거나 같은 수를 해야됐다
// N의 최대는 100만 이었기 떄문에 100만이상의 수에서 팰린드롬과 소수가 되는 수를 최악으로 고려해서 접근했다
// 그래서 notPrime 배열을 통해서 현재 false 인 즉 소수 인 값이 나오면
// 소수의 배수를 다 소수 아닌 취급을 하면되거든? 일단 0과 1은 소수가 아니니까 true 처리를 하고
// 2는 소수이니까 2의 배수를 소수 취급하면되는데 만약 LIMIT 가 3이면 2의 배수가 없으니 안해도돼서
// 2의 제곱 보다 큰 리미트일 때만 조건문을 걸어서 2의 제곱부터 시작해서 2만큼씩 증가해서 해당 배수들을 모두
// notPrime의 true 로 만들어버리고 N 부터 LIMIT 까지의 수중에서 조건이 먼저 통과되면 출력
// palindrome 은 그냥 투 포인터로 접근했다. 값이 100만이상이라 O(1) 로 고려