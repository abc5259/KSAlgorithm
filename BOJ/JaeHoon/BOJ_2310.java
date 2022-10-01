package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2310 {
  static Room[] rooms;
  static boolean[] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      if(N == 0) break;
      rooms = new Room[N+1];
      isVisit = new boolean[N+1];
      for(int i=1; i<=N; i++) {
        st = new StringTokenizer(br.readLine());
        String type = st.nextToken();
        int cost = Integer.parseInt(st.nextToken());
        rooms[i] = new Room(type, cost);
        int door;
        while((door = Integer.parseInt(st.nextToken())) != 0) {
          rooms[i].doors.add(door);
        } 
      }
      sb.append(dfs(rooms[1], 0, 1, N) ? "Yes" : "No").append('\n');
    }
    System.out.println(sb);
  }
  static public boolean dfs(Room room, int cost, int index, int N) {
    int nextCost = cost;
    if(room.type.equals("T")) {
      if(cost < room.cost) return false;
      else nextCost -= room.cost;
    }

    if(index == N) {
      return true;
    }


    if(room.type.equals("L")) {
      if(cost < room.cost) nextCost = room.cost;
    }
    for(int nextIndex: room.doors) {
      if(!isVisit[nextIndex]) {
        isVisit[nextIndex] = true;
        if(dfs(rooms[nextIndex], nextCost, nextIndex, N)) 
          return true;
        isVisit[nextIndex] = false;
      }
    }
    return false;
  }
  static class Room {
    String type;
    int cost;
    ArrayList<Integer> doors = new ArrayList<>();
    Room(String type,int cost) {
      this.type = type;
      this.cost = cost;
    }
  }
}
