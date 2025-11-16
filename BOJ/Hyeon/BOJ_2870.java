package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class BOJ_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        while (N-- > 0) {
            String str = br.readLine();
            StringBuilder tmp = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                if (isNum(str.charAt(j))) {
                    tmp.append(str.charAt(j));
                } else {
                    if (tmp.length() > 0) {
                        pq.offer(new BigInteger(tmp.toString()));
                        tmp = new StringBuilder();
                    }
                }
            }
            if (tmp.length() > 0) {
                pq.offer(new BigInteger(tmp.toString()));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }

    static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}
// S4 수학숙제 우선순위 큐, BigInteger
// 19분
// trouble shooting
// 100 자리 수라는 조건을 인지 하지 못한채로 Integer 처럼 쓰다가
// 넘버 포멧에러 직면함 그래서 BigInteger 로 바꾸고 더해서 String tmp = ""; 에다가 더해서 객체를 재 생성하면서
// 했었는데 StringBuilder 로 문자열간에 합연산으로 이어지는거는 저걸로 대체하는게 좋은거 같아서 수정했음