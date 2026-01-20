package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int ex = 0;

        while (N > 0) {
            int jari = (int) (9 * Math.pow(10, ex));

            if (N > jari) {
                sum += jari * (ex + 1);
                N -= jari;
            } else {
                sum += N * (ex + 1);
                break;
            }
            ex++;
        }
        System.out.println(sum);
    }
}
// S4 수 이어 쓰기1 구현
// 17분 1등했음~
// 시간 복잡도는 천오백만 이내로 되어야 했고 N은 1억까지 줘서 고민을 했는데
// 9보다 작은 수까지는 1자리 10~99까지는 2자리 100~999는 3자리로 이는 반복문을 돌아서 ex가 0부터 10까지 돌았을때
// N이 그 jari 라는 수보다 크면 jari 만크 N에서 빼고 sum 은 총 길이를 뜻하기에 jari 에다가 현재
// 지수 + 1 값을 곱해서 자릿수를 더한다 9보다 크다면 길이는 9여야되는데 지수는0이라서
// +1 해준것이다.