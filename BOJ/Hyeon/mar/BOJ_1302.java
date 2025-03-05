package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String bookname = br.readLine();
            map.put(bookname, map.getOrDefault(bookname, 0) + 1);
        }

        String res = null;

        int max = 0;
        for (String s : map.keySet()) {
            if (max < map.get(s)) {
                res = s;
                max = map.get(s);
            } else if (max == map.get(s)) {
                if (res.compareTo(s) > 0) {
                    res = s;
                    max = map.get(s);
                }
            }
        }
        System.out.println(res);
    }
}

// S4 베스트셀러 해쉬맵
// 일단 로직을 고민을 많이했는데 map의 메소드와 이런것에 익숙해져야 한다
// getOrDefault 이거 배워서 잘 써먹고 있다. 잘 이해했다
// 그리고 map.keySet을 통해서 키값들만 문자열로 받는 반복문을 만들었다.
// 여기서 해당 키값의 밸류가 크면 그걸 최종값으로 지정하고 같을 경우 현재까지의 밸류가 가장 큰 키값과
// 입력받은 키값을 compareTo로 비교한다.