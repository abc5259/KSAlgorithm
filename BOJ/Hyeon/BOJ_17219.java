package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        while (M-- > 0) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}

// S4 17219 HashMap
// 개쉽게 풀었다. 그냥 풀었음
// 사이트 주소가 키 , 비밀번호가 밸류로 해서
// 해당 키값을 입력받아 그에 대한 비밀번호를 출력하기만 하면된다.