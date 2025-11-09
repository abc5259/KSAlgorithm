package Programmers.JaeHoon.level2;

import java.util.*;

public class 충돌위험_찾기 {

  class Solution {
    static class Point {
        int r,c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            return this.hashCode() == o.hashCode();
        }
        
        @Override
        public int hashCode() {
            return r * 100 + c;
        }
    }
    
    static class Robot{
        int time;
        Point p;
        Robot(int time, Point p) {
            this.time = time;
            this.p = p;
        }
        Robot(int time, int r, int c) {
            this.time = time;
            this.p = new Point(r, c);
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Point[] pArr = new Point[points.length + 1];
        for(int i=0; i<points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pArr[i+1] = p;
        }
        Queue<Robot> pq = new PriorityQueue<>((a,b) -> {
            return a.time - b.time;
        });
        for(int[] route: routes) {
            int prev = route[0];
            int time = 0;
            pq.offer(new Robot(time, pArr[prev]));
            for(int i=1; i<route.length; i++) {
                int curr = route[i];
                Point prevPoint = pArr[prev];
                Point currPoint = pArr[curr];
                int r = prevPoint.r - currPoint.r;
                int c = prevPoint.c - currPoint.c;
                int currR = prevPoint.r;
                int currC = prevPoint.c;
                if(r < 0) {
                    while(currR != currPoint.r) {
                        pq.offer(new Robot(++time, ++currR, currC));   
                    }
                }
                if (r > 0) {
                    while(currR != currPoint.r) {
                        pq.offer(new Robot(++time, --currR, currC));   
                    }
                }
                if(c < 0) {
                    while(currC != currPoint.c) {
                        pq.offer(new Robot(++time, currR, ++currC));   
                    }
                }
                if (c > 0) {
                    while(currC != currPoint.c) {
                        pq.offer(new Robot(++time, currR, --currC));   
                    }
                }
                prev = curr;
            }
        }
        int currT = 0;
        while(!pq.isEmpty()) {
            Map<Point, Integer> map = new HashMap<>();
            
            while(!pq.isEmpty() && pq.peek().time == currT) {
                Robot r = pq.poll();
                map.put(r.p, map.getOrDefault(r.p, 0) + 1);
                if(map.get(r.p) == 2) {
                    answer++;
                }
            }
            currT++;
        }
        return answer;
    }
  }
}
