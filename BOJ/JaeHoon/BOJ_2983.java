package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_2983 {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int ad() {
            return x - y;
        }

        public int bc() {
            return x + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node other = (Node) o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    static class AdComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            int cmp = Integer.compare(a.ad(), b.ad());
            if (cmp != 0) return cmp;
            cmp = Integer.compare(a.x, b.x);
            if (cmp != 0) return cmp;
            return Integer.compare(a.y, b.y);
        }
    }

    static class BcComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            int cmp = Integer.compare(a.bc(), b.bc());
            if (cmp != 0) return cmp;
            cmp = Integer.compare(a.x, b.x);
            if (cmp != 0) return cmp;
            return Integer.compare(a.y, b.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String dir = br.readLine();

        TreeSet<Node> ad = new TreeSet<>(new AdComparator());
        TreeSet<Node> bc = new TreeSet<>(new BcComparator());

        int xpos = 0, ypos = 0;
        // 첫 좌표부터 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node node = new Node(x, y);
            ad.add(node);
            bc.add(node);
            if (i == 0) {
                xpos = x;
                ypos = y;
            }
        }

        // 방향 문자열에 따라 이동 처리
        for (int i = 0; i < dir.length(); i++) {
            int curx = xpos;
            int cury = ypos;
            char d = dir.charAt(i);

            if (d == 'A') {
                Node current = new Node(curx, cury);
                // ad에서 현재 노드보다 큰 원소 중 첫번째(다음 원소)
                Node nextNode = ad.higher(current);
                if (nextNode == null) continue;
                // 같은 (x-y) 값인지 검사
                if (nextNode.ad() != current.ad()) continue;
                // 현재 좌표 삭제 후 다음 좌표로 이동
                ad.remove(current);
                bc.remove(current);
                xpos = nextNode.x;
                ypos = nextNode.y;
            } else if (d == 'B') {
                Node current = new Node(curx, cury);
                // bc에서 현재 노드보다 큰 원소 중 첫번째
                Node nextNode = bc.higher(current);
                if (nextNode == null) continue;
                if (nextNode.bc() != current.bc()) continue;
                ad.remove(current);
                bc.remove(current);
                xpos = nextNode.x;
                ypos = nextNode.y;
            } else if (d == 'C') {
                Node current = new Node(curx, cury);
                // bc에서 현재 노드보다 작은 원소 중 가장 큰(이전 원소)
                Node prevNode = bc.lower(current);
                if (prevNode == null) continue;
                if (prevNode.bc() != current.bc()) continue;
                ad.remove(current);
                bc.remove(current);
                xpos = prevNode.x;
                ypos = prevNode.y;
            } else if (d == 'D') {
                Node current = new Node(curx, cury);
                // ad에서 현재 노드보다 작은 원소 중 가장 큰(이전 원소)
                Node prevNode = ad.lower(current);
                if (prevNode == null) continue;
                if (prevNode.ad() != current.ad()) continue;
                ad.remove(current);
                bc.remove(current);
                xpos = prevNode.x;
                ypos = prevNode.y;
            }
        }

        System.out.println(xpos + " " + ypos);
    }
}
