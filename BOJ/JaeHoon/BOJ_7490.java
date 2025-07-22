package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

import static java.util.stream.Collectors.toList;

public class BOJ_7490 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dfs(1,"1");
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int num,  String str){
        if(num == N) {
            if(calculate(str) == 0) {
                sb.append(str+"\n");
            }
            return;
        }

        dfs(num+1, str+ ' ' + (num+1));
        dfs(num+1, str+ '+' + (num+1));
        dfs(num+1, str+ '-' + (num+1));
    }

    static int calculate(String str){
        str = str.replaceAll(" ", "");
        Iterator<Integer> it= Arrays.stream(str.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(toList()).iterator();
        int result = it.next();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '+') {
                result += it.next();
            }else if(str.charAt(i) == '-') {
                result -= it.next();
            }
        }
        return result;

    }
}
