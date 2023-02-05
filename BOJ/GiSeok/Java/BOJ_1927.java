package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class heap {
    public ArrayList<Integer> p = new ArrayList<>();
    int size = 0;

    public heap() {
        p.add(0);
    }

    public void insert(int n) {
        p.add(n);
        int here = ++size;

        while ((here != 1) && (n < p.get(here/2))) {
            Collections.swap(p, here/2, here);
            here /= 2;
        }
    }

    public int delete() {
        int n = p.get(1);
        Collections.swap(p, 1, size);
        p.remove(size);
        size-=1;

        int parent = 1;
        while (true) {
            int child = parent*2;

            if (child+1 <= size && p.get(child) > p.get(child+1))
                child++;

            if (child > size || p.get(child) > p.get(parent))
                break;

            Collections.swap(p, child, parent);
            parent = child;
        }

        return n;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
}

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int in;

        heap pq = new heap();

        for (int i = 0; i < N; i++) {
            in = Integer.parseInt(br.readLine());

            switch (in) {
                case 0:
                    if (!pq.isEmpty())
                        System.out.println(pq.delete());
                    else
                        System.out.println(0);
                    
                    break;

                default:
                    pq.insert(in);
            }
            
        }
    }
}
