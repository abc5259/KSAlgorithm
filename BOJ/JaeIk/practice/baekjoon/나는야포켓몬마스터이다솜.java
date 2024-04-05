package BOJ.JaeIk.practice.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 나는야포켓몬마스터이다솜
{
    static int n, m;
    static Map<Integer, String> ency1;
    static Map<String, Integer> ency2;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ency1 = new HashMap<Integer, String>();
        ency2 = new HashMap<String, Integer>();
        for(int i=1; i<=n; i++) {
            String name = br.readLine();

            ency1.put(i, name);
            ency2.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            String question = br.readLine();

            //입력이 숫자일 때
            if(isNumeric(question)) {
                sb.append(ency1.get(Integer.parseInt(question))).append("\n");
            }
            //아닐 때
            else {
                sb.append(ency2.get(question)).append("\n");
            }
        }

        System.out.print(sb.toString());

    }

    static boolean isNumeric(String str) {
        for(char c : str.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}