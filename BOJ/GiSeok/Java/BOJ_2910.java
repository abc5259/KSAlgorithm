/**
 * 2910 - 빈도 정렬 [실패]
 * 실버3, 정렬, 시도x
 * 
 * 쉽게 봤는데 생각보다 어려웠다.
 * LinkedHashMap에 빈도수를 저장하고 리스트에 keySet을 담아서 정렬. => 여기까지 생각했는데
 * 결국 정렬 방법을 삽질하다가 실패한 문제..
 * Collections.sort()에 정렬 조건만 추가하면 되는건데 직접 정렬을 구현하려 했던 것이 실패의 원인
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BOJ_2910 {
    // 메시지는 숫자 N개로 이루어진 수열
    // 숫자는 C보다 작거나 같음. 숫자 <= C
    // 숫자를 자주 등장하는 빈도순으로 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); st.nextToken();

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }

        ArrayList<Integer> seq = new ArrayList<>(map.keySet());
        Collections.sort(seq, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(map.get(b), map.get(a));
            }
        });

        for (int i = 0; i < seq.size(); i++)
            for (int j = 0; j < map.get(seq.get(i)); j++)
                System.out.print(seq.get(i) + " ");
        System.out.println();
    }
}
