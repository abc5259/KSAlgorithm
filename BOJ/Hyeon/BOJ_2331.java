package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        set.add(A);
        list.add(A);

        int n = A;
        while (true) {
            int sum = 0;
            while (n > 0) {
                int tmp = n % 10;
                sum += cal(tmp, P);
                n /= 10;
            }
            if (set.contains(sum)) {
                n = sum;
                break;
            } else {
                set.add(sum);
                list.add(sum);
                n = sum;
            }
        }

        int cnt = 0;

        for (int p : list) {
            if (p == n) {
                System.out.println(cnt);
                break;
            }
            cnt++;
        }
    }

    static int cal(int tmp, int P) {
        return (int) Math.pow(tmp, P);
    }
}
// S4 반복수열 구현
// 29분
// 문제 자체의 이해도 어려웠지만 또 중복을 감지하고 size를 리턴해야되었고 중복 수열을 찾기보다 그냥 1번만 중복이되면 끝인걸 뒤늦게 판단했다.
// 일단 A가 9999이고 P가 5일때 9의 5승 *4 해서 236196이 max 이길래 많은 수를 5제곱해서 더해도 9999가 제일 클거같아서
// long 에서 int 로 타입을 바꿨다.
// 중복을 판단해야했기에 SET 자료구조를 쓰고 중복 수열의 근원지를 찾기 위해서
// 배열 리스트로 전체 조회해서 나오자마자 break 하고 지금까지의 size cnt를 리턴했다.