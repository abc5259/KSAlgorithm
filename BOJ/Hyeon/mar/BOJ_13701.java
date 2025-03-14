package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ_13701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet bitSet = new BitSet(5_000_000);

        while (st.hasMoreTokens()) {
            int A = Integer.parseInt(st.nextToken());
            if (!bitSet.get(A)) {
                bitSet.set(A, true);
                sb.append(A).append(" ");
            }
        }
        System.out.println(sb);
    }
}

// G4 중복 제거 BitSet
// 일단 메모리 제한이 8MB 인데 입력값의 크기는 5백만개의 여서 boolean 타입으로 가질 경우 1바이트 * 500만개여서 이는 메모리 초과가 난다.
// 비트 연산을 해야돼서 5백만개를 boolean 타입을 사용하지 않고 1비트 단위로 비트 단위 자료구조를 가지는
// BitSet 을 활용한다 == 5백만개의 데이터 => 5백만비트
// st.hasMoreToken 이런거 활용해서 개수 N개를 반영하고 bitSet 에 값이 있을경우 패스 없으면 출력하는 로직을 짠다.