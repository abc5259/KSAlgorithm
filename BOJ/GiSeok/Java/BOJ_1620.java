/**
 * 1620 - 나는야 포켓몬 마스터 이다솜, 시도3
 * 구현, 실버4
 * 처음에 ArrayList에 넣고, 입력받은 문제가 숫자면 인덱스로 활용해서 포켓몬 이름을 출력하고,
 * 포켓몬 이름을 입력받으면 해당 포켓몬 이름의 인덱스를 indexOf 함수로 찾아 출력하는 알고리즘을 작성했음.
 * 그런데, indexOf의 시간복잡도는 O(n)이기 때문에 M번 반복하면서 N번 반복하게 된다. 그럼 N, M의 최대 범위는 100,000이므로 100,000 * 100,000
 * = 100억으로 시간 초과가 뜬다.
 * 그래서 map을 이용하기로 했음. map의 경우 key로 value를 찾는 get의 시간복잡도는 O(1)이기 때문이다.
 * 그럼 최대 10만 + 10만 = 20만으로 해결이 가능하다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> pokemon = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            pokemon.put(s, String.valueOf(i + 1));
            pokemon.put(String.valueOf(i + 1), s);
        }

        for (int i = 0; i < M; i++) {
            String whatIsPokemon = br.readLine();
            System.out.println(pokemon.get(whatIsPokemon));
        }
    }
}
