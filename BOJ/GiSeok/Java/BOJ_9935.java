package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> deque2 = new ArrayDeque<>();
        String str = br.readLine();
        String bomb = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            boolean isBomb = true;
            deque.addFirst(str.charAt(i));

            if (deque.size() >= bomb.length()) {
                for (int j = bomb.length()-1; j >= 0; j--) {
                    if (deque.peekFirst() == bomb.charAt(j))
                        deque2.addFirst(deque.removeFirst());
                    else {
                        isBomb = false;
                        break;
                    }
                }

                if (!isBomb) {
                    while (!deque2.isEmpty())
                        deque.addFirst(deque2.removeFirst());
                } else {
                    while (!deque2.isEmpty())
                        deque2.pop();
                }
            }
        }

        if (deque.isEmpty())
            bw.write("FRULA");
        else {
            while (!deque.isEmpty())
                bw.write(deque.removeLast());
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}