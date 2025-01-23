package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String removeS = br.readLine();
        int[] sArr = new int[10];
        int[] removeSArr = new int[10];

        for(int i=0; i<s.length(); i++) {
            sArr[s.charAt(i)-'0']++;
        }
        for(int i=0; i<removeS.length(); i++) {
            removeSArr[removeS.charAt(i)-'0']++;
            sArr[removeS.charAt(i)-'0']--;
        }

        int size = s.length() - removeS.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for(int n=9; n>=0; n--) {
                if(sArr[n]<=0) continue;
                int idx = s.indexOf(n+'0');
                int[] count = new int[10];

                for(int j=0; j<idx; j++) {
                    count[s.charAt(j) - '0']++;
                }

                boolean flag = true;
                for(int j=0; j<10; j++) {
                    if(removeSArr[j] < count[j]) {
                        flag = false;
                        break;
                    }
                }

                if(!flag) continue;

                sb.append(n);
                for(int j=0; j<idx; j++) {
                    removeSArr[s.charAt(j) - '0']--;
                }
                sArr[n]--;
                s = s.substring(idx+1);
                break;
            }
        }

        System.out.println(sb);
    }
}
