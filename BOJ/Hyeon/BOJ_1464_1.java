package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1464_1 {
    static char[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine().toCharArray();
        char c = word[0];

        for (int i = 1; i < word.length; i++) {
            if (word[i] <= c) {
                c = word[i];
                reverse(0, i - 1);
                reverse(0, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c1 : word) {
            sb.append(c1);
        }
        System.out.print(sb);
    }

    static void reverse(int left, int right) {
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
    }

    static void swap(int a, int b) {
        char tmp = word[a];
        word[a] = word[b];
        word[b] = tmp;
    }
}

// G4 뒤집기 3 reverse