package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BitSet setA = new BitSet(100_000_000);
        BitSet setB = new BitSet(100_000_000);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            setA.set(a, true);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(st.nextToken());
            setB.set(b, true);
        }

        setA.xor(setB);

        System.out.println(setA.cardinality());
    }
}

//S4 대칭 차집합 BitSet
// BitSet 자료구조 얘는 boolean 과 같은 비트 연산을 할 때 boolean 타입은 1바이트인데 0,1 만 사용하는
// 1비트 연산으로도 가능하게 끔하기 위해 BitSet 자료구조를 활용
// 일단 2개의 비트셋을 자료구조로 가져서 원소를 담고 비트셋끼리 비트연산을 할 수 있다
// HashSet을 통해서도 값이 이미 있으면 그 갯수를 세서 전체 개수에서 뺄 수도 있다.