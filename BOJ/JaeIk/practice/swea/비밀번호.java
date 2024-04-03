package BOJ.JaeIk.practice.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 비밀번호
{
    static List<Integer> list;
    static int n;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            list = new ArrayList<>();
            for(int i=0; i<str.length(); i++) {
                list.add(str.charAt(i)-'0');
            }

            getAnswer();

            String answer = "";
            for(int num : list) {
                answer += String.valueOf(num);
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static void getAnswer() {
        boolean flag = true;

        while(true) {
            for(int i=0; i<list.size()-1; i++) {
                if(list.get(i) == list.get(i+1)) {
                    list.remove(i);
                    list.remove(i);
                }
            }

            int count = 0;
            for(int i=0; i<list.size()-1; i++) {
                if(list.get(i) != list.get(i+1)) {
                    count++;
                }
            }
            if(count+1 == list.size())return;
        }
    }
}
