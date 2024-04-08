package BOJ.JaeIk.practice.baekjoon;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5430 {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());

            Deque<Integer> list = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for(int i=0; i<size; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            execute(list, command);

            System.out.println(sb);
        }
    }

    static void execute(Deque<Integer> list, String command) {
        sb = new StringBuilder();
        boolean isRight = true;

        for(char c : command.toCharArray()) {
            if(c == 'R') {
                isRight = !isRight;
                continue;
            }

            if(isRight && c=='D') {
                if(list.isEmpty()) {
                    sb.append("error");
                    return;
                }
                list.pollFirst();
            }

            if(!isRight && c=='D') {
                if(list.isEmpty())  {
                    sb.append("error");
                    return;
                }
                list.pollLast();
            }
        }

        sb.append("[");

        if(list.size()>0) {

            if(isRight) {
                sb.append(list.pollFirst());
                while(!list.isEmpty()) {
                    sb.append(","+list.pollFirst());
                }
            }

            if(!isRight) {
                sb.append(list.pollLast());
                while(!list.isEmpty()) {
                    sb.append(","+list.pollLast());
                }
            }
        }

        sb.append("]");
    }
}
