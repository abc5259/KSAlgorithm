package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10875 {
    static int L, N;
    static Dir[] arr;
    static List<Line> lines = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 상 우 하 좌
    static int[][] dd = {
            {3,1},
            {0,2},
            {1,3},
            {2,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr = new Dir[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char rotate = st.nextToken().charAt(0);
            arr[i] = new Dir(t, rotate);
        }

        int curX = 0, curY = 0, d = 1;
        long result = 0;
        boolean check = true;
        for(int i=0; i<N; i++) {
//            System.out.println("d = " + d);
//            System.out.println(curX + " " + curY);
            Dir dir = arr[i];
            int nx = curX + dx[d]*dir.t;
            int ny = curY + dy[d]*dir.t;
//            System.out.println(nx + " " + ny + '\n');
            if(nx < -L || nx > L) {
//                System.out.println("!!");
//                System.out.println(result);
                if(d==0) {
                    result += (L - curY);
                }
                if(d==2) {
                    result += Math.abs(-L - curY);
                }
                if(d==1) {
                    result += (L - curX);
                }
                if(d==3) {
                    result += Math.abs(-L - curX);
                }
                result++;
                check = false;
                break;
            }
            if(ny < -L || ny > L) {
                if(d==0) {
                    result += (L - curY);
                }
                if(d==2) {
                    result += Math.abs(-L - curY);
                }
                if(d==1) {
                    result += (L - curX);
                }
                if(d==3) {
                    result += Math.abs(-L - curX);
                }
                result++;
                check = false;
                break;
            }
            Line goLine = new Line(curX, curY, nx, ny);
            int min = Integer.MAX_VALUE;
            for(int c=0; c<lines.size()-1; c++) {
                Line line = lines.get(c);
                int[] meet = line.meet(goLine);
                if(meet != null) {
//                    System.out.println(">>>");
//                    System.out.println(Arrays.toString(meet));
                    if(curX == meet[0]) {
                        if(d==0) {
                            min = Math.min(min, (meet[1] - curY));
                        }
                        if(d==2) {
                            min = Math.min(min, Math.abs(meet[1] - curY));
                        }
                        check = false;
                    }
                    if(curY == meet[1]) {
                        if(d==1) {
                            min = Math.min(min, (meet[0] - curX));
                        }
                        if(d==3) {
                            min = Math.min(min, Math.abs(meet[0] - curX));
                        }
                        check = false;
                    }
                }
            }
            if(!check) {
                result += min;
                break;
            }
            curX = nx;
            curY = ny;
            lines.add(goLine);
            if(dir.rotate == 'L') {
                d = dd[d][0];
            }else {
                d = dd[d][1];
            }
            result += dir.t;
        }

        if(check) {
            Line goLine = null;
            int min = Integer.MAX_VALUE;
            if(d == 0) goLine = new Line(curX, curY, curX, L);
            if(d == 2) goLine = new Line(curX, curY, curX, -L);
            if(d == 1) goLine = new Line(curX, curY, L, curY);
            if(d == 3) goLine = new Line(curX, curY, -L, curY);
            for(int c=0; c<lines.size()-1; c++) {
                Line line = lines.get(c);
                int[] meet = line.meet(goLine);
                if(meet != null) {
//                    System.out.println(goLine);
//                    System.out.println(line);
                    if(curX == meet[0]) {
                        if(d==0) {
                            min = Math.min(min, (meet[1] - curY));
                        }
                        if(d==2) {
                            min = Math.min(min, Math.abs(meet[1] - curY));
                        }
                        check = false;
                    }
                    if(curY == meet[1]) {
                        if(d==1) {
                            min = Math.min(min, (meet[0] - curX));
                        }
                        if(d==3) {
                            min = Math.min(min, Math.abs(meet[0] - curX));
                        }
                        check = false;
                    }
                }
//                System.out.println();
            }
            if(!check) {
//                System.out.println(min);
                result += min;
                System.out.println(result);
                return;
            }
            if(d==0) {
                result += (L - curY);
            }
            if(d==2) {
                result += Math.abs(-L - curY);
            }
            if(d==1) {
                result += (L - curX);
            }
            if(d==3) {
                result += Math.abs(-L - curX);
            }
            result++;
        }
        System.out.println(result);
    }
    static class Dir {
        int t;
        char rotate;

        public Dir(int t, char rotate) {
            this.t = t;
            this.rotate = rotate;
        }
    }
    static class Line {
        int startX, startY, endX, endY;

        @Override
        public String toString() {
            return "Line{" +
                    "startX=" + startX +
                    ", startY=" + startY +
                    ", endX=" + endX +
                    ", endY=" + endY +
                    '}';
        }

        public Line(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public int[] meet(Line line) {
            if(isVertical() && line.isHorizontal()) {
                int x = startX;
                int y = line.startY;
                if(contains(x, y) && line.contains(x, y)) {
                    return new int[]{x, y};
                }
            }
            else if(isHorizontal() && line.isVertical()) {
                int x = line.startX;
                int y = startY;
                if(contains(x, y) && line.contains(x, y)) {
                    return new int[]{x, y};
                }
            }
            else if(isVertical() && line.isVertical()) {
                if(startX == line.startX) {
                    if(startY > endY) {
                        if(line.startY > startY && line.contains(startX, startY)) {
                            return new int[]{startX, startY};
                        }
                        if(line.startY < startY && line.contains(endX, endY)) {
                            return new int[]{endX, endY};
                        }
                    }
                    if(startY < endY) {
                        if(line.startY > startY && line.contains(endX, endY)) {
                            return new int[]{endX, endY};
                        }
                        if(line.startY < startY && line.contains(startX, startY)) {
                            return new int[]{startX, startY};
                        }
                    }
                }
            }
            else if(isHorizontal() && line.isHorizontal()) {
                if(startY == line.startY) {
                    if(startX > endX) {
                        if(line.startX > startX && line.contains(startX, startY)) {
                            return new int[]{startX, startY};
                        }
                        if(line.startX < startX && line.contains(endX, endY)) {
                            return new int[]{endX, endY};
                        }
                    }
                    if(startX < endX) {
                        if(line.startX > startX && line.contains(endX, endY)) {
                            return new int[]{endX, endY};
                        }
                        if(line.startX < startX && line.contains(startX, startY)) {
                            return new int[]{startX, startY};
                        }
                    }
                }
            }

            return null;
        }

        private boolean contains(int x, int y) {
            if(startX == endX) {
                if(startY < endY) {
                    return startX == x && startY <= y && endY >= y;
                }else {
                    return startX == x && endY <= y && startY >= y;
                }
            }
            if(startY == endY) {
                if(startX < endX) {
                    return startY == y && startX <= x && endX >= x;
                }else {
                    return startY == y && endX <= x && startX >= x;
                }
            }
            return false;
        }

        private boolean isVertical() {
            return startX == endX;
        }

        // 수평선인지 확인 (y 좌표가 일정)
        private boolean isHorizontal() {
            return startY == endY;
        }
    }
}
//3
//8
//1 L
//1 L
//2 L
//2 L
//1 R
//1 R
//1 R
//1 R
//3
//5
//1 R
//1 L
//1 L
//1 L
//1 R
//11
//100000000
//5
//100000000 L
//100000000 L
//200000000 L
//199999999 L
//199999999 L
//4
//6
//2 L
//1 R
//1 R
//3 R
//2 R
//1 L