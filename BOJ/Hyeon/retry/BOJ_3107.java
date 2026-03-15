package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String front = "";
        String back = "";

        if (line.contains("::")) {
            int idx = line.indexOf("::");
            front = line.substring(0, idx);
            back = line.substring(idx + 2);
        } else {
            front = line;
        }

        String[] frontArr = front.isEmpty() ? new String[0] : front.split(":");
        String[] backArr = back.isEmpty() ? new String[0] : back.split(":");

        String[] address = new String[8];
        for (int i = 0; i < 8; i++) {
            address[i] = "0000";
        }

        for (int i = 0; i < frontArr.length; i++) {
            address[i] = fillZero(frontArr[i]);
        }

        int backIdx = 7;
        for (int i = backArr.length - 1; i >= 0; i--) {
            address[backIdx--] = fillZero(backArr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(address[i]);
            if (i < 7) {
                sb.append(":");
            }
        }
        System.out.println(sb);
    }

    static String fillZero(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 4) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
// S1 IPv6 문자열
// 1시간
// 다시 풀어라