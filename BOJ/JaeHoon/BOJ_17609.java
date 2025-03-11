package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String s = br.readLine();
            int l = 0;
            int r = s.length()-1;
            boolean flag = true;
            int removeL = -1;
            int removeR = -1;
            while (l < r) {
                if(s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }
                else {
                    removeL = l;
                    removeR = r;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(0).append('\n');
            }else {
                l = 0;
                r = s.length()-1;
                flag = true;
                while (l < r) {
                    if(removeL == l) {
                        l++;
                        continue;
                    }
                    if(s.charAt(l) == s.charAt(r)) {
                        l++;
                        r--;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                   sb.append(1).append('\n');
                }else {
                    l = 0;
                    r = s.length()-1;
                    flag = true;
                    while (l < r) {
                        if(removeR == r) {
                            r--;
                            continue;
                        }
                        if(s.charAt(l) == s.charAt(r)) {
                            l++;
                            r--;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        sb.append(1).append('\n');
                    }else {
                        sb.append(2).append('\n');
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
