package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();

        HashSet<String> map = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                map.add(s.substring(i, j));
            }
        }
        System.out.println(map.size());
    }
}

// S3 서로 다른 부분 문자열의 개수 해쉬셋
// 걍 쉽게 풀었다
// 해당 부분문자열 == 부분집합의 종류를 묻는데 중복을 제외한다
// 근데 Map  써서 getOrdefault 스려고 했는데 그냥 중복제외이기도 하고 사이즈만 구하면되니까
// 밸류값을 리턴받는 map이 아닌 set을 사용했다.