package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int size = 1;
        while (K > size) {
            size *= 2;
        }
        int cnt = 0;

        if (size != K) {
            String binary = Integer.toBinaryString(K);
            cnt = binary.lastIndexOf('1') + 1;
        }
        System.out.println(size + " " + cnt);
    }
}
// S2 초콜릿 식사 2진수
// 34분
// 일단 최소한의 커팅이기에 size 가 안자르고 할 수 있는게 베스트다 이는 주어진 size 즉 N이 K와 같은 상황이고
// size 는 K보다 커야되고 최소 커팅이기에 K의 가장 앞 비트보다 늘어난 자리의 값을 가져야 한다 예를들어 6이라면 110 인데 size 는 1000 이 되어야 한다
// 왜냐하면 적게 나누고 가져갈 수 있기 떄문
// 그런데 size 와 K가 다르다면 이진수로 K를 변환하고 이진수의 가장 끝 1 비트를 찾아서 그자리값을 반환한다 이는 자르는 횟수이다.