package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;

        while (true) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (num % arr[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= 3) {
                System.out.println(num);
                break;
            }
            num++;
        }
    }
}
// B1 적어도 대부분의 배수 완전탐색
// 6분
// 일단 그냥 한 수에 3개이상의 되는 배수를 구하고
// 5개 밖에 없길래 완탐으로 돌렸다 시간복잡도는 2초이길래 넉넉하다고 판단,, 근데 더 좋은 코드가 없을까 고민