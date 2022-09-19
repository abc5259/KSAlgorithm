package Programmers.JaeHoon;

import java.util.*;

public class 무지의_먹방_라이브 {
  public static void main(String[] args){
    
  }
  class Solution {
    class Food implements Comparable<Food>{
        int time,num;
        Food(int num,int time) {
            this.time = time;
            this.num = num;
        }
        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }
    public int solution(int[] food_times, long k) {
        long sum = 0;
        PriorityQueue<Food> q = new PriorityQueue<>();
        for(int i=0; i<food_times.length; i++) {
            sum += food_times[i];
            q.offer(new Food(i+1,food_times[i]));
        }
        
        if(sum <= k) return -1;
        
        long prevTime = 0;
        long total = 0;
        long N = food_times.length;
        
        while(total + ((q.peek().time - prevTime) * N) <= k) {
            Food food = q.poll();
            total += (food.time - prevTime) * N;
            N -= 1;
            prevTime = food.time;
        }
            
            
        ArrayList<Food> foods = new ArrayList<>();

        while(!q.isEmpty()) {
            foods.add(q.poll());
        }
            
        Collections.sort(foods,(Food a, Food b) -> {
            return a.num - b.num;
        });
        
        return foods.get((int)((k - total) % N)).num;
    }
  }
}
