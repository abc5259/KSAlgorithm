package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_9440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            ArrayList<Integer> zeros = new ArrayList<>();
            ArrayList<Integer> nonZeros = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    zeros.add(num);
                } else {
                    nonZeros.add(num);
                }
            }
            Collections.sort(nonZeros);

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            sb1.append(nonZeros.get(0));
            sb2.append(nonZeros.get(1));

            ArrayList<Integer> remain = new ArrayList<>();

            for (int i = 0; i < zeros.size(); i++) {
                remain.add(0);
            }
            for (int i = 2; i < nonZeros.size(); i++) {
                remain.add(nonZeros.get(i));
            }

            for (int i = 0; i < remain.size(); i++) {
                if (i % 2 == 0) {
                    sb1.append(remain.get(i));
                } else {
                    sb2.append(remain.get(i));
                }
            }
            int sum = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
// S2 숫자 더하기 그리디
// 새롭게 다시 풀었다. 5 0 0 0 1 9 라는 반례를 통해서 다시금 이해하게 되었다
// 1. (분리 후 정렬) 0이랑 0이 아닌 수를 분리해서 오름차순 정렬 한
// 2. (리더 선정) 다음에 0이 아닌수는 무조건 2개이상이기에 2개를 각각의 StringBuilder에 리더로 사용하고
// 3. (나머지 배분) zero 랑 나머지 nonZero 수를 remain 이라는 리스트에 저장해서 이를
// sb1 과 sb2 에 적절히 배치하고 연산해서 숫자를 더한다.