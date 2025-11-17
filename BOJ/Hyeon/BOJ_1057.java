package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansoo = Integer.parseInt(st.nextToken());

        int round = 0;
        while (jimin != hansoo) {
            jimin = (jimin + 1) / 2;
            hansoo = (hansoo + 1) / 2;
            round++;
        }
        System.out.println(round);
    }
}
// S4 토너먼트 완전탐색
// 14분
// 일단 이런 아이디어를 생각해내는게 어려운데,,
// 그려가다보니 규칙을 찾은 케이스
// 왜냐하면 1이랑 2 도 1차이고 8이랑 9도 1차이인데 라운드는 1이랑 4였다
// 그래서 보니까 숫자가 같아져야 만난다고 쳤을 때 다음 라운드로 가면 내가 1 2 붙어서 이겼다면 그대로 1이고 3 4 붙었다면
// 2로 가게 된다 왜냐하면 칸은 다땡겨서 하기 때문에 그래서 3 4가 2가 되려면 /2이고 1 /2가 1이되려면 +1 나누기 2길래 이 규칙을 사용했다.