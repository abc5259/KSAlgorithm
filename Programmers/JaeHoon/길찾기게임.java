package Programmers.JaeHoon;
import java.util.*;
public class 길찾기게임 {
  
  static ArrayList<Integer> pre = new ArrayList<>(); 
  static ArrayList<Integer> post = new ArrayList<>();
  static ArrayList<Queue<Edge>> arr;
  static int N;
  public ArrayList<ArrayList<Integer>> solution(int[][] nodeinfo) {
      Edge[] edges = new Edge[nodeinfo.length];
      N = nodeinfo.length;
      for(int i=0; i<nodeinfo.length; i++) {
          edges[i] = new Edge(nodeinfo[i][0],nodeinfo[i][1],i+1);
      }
      Arrays.sort(edges, (Edge a, Edge b) -> {
          if(a.y == b.y) return a.x - b.x;
          return b.y - a.y;
      });
      
      
      arr = new ArrayList<>();
      Queue<Edge> q = new LinkedList<>();
      q.offer(edges[0]);
      for(int i=1; i<N; i++) {
          if(q.peek().y != edges[i].y) {
              arr.add(q);
              q = new LinkedList<>();
              q.offer(edges[i]);
          }else {
              q.offer(edges[i]);
          }
          
      }
      arr.add(q);
      
      int maxLevel = arr.size();
      
      for(int i=1; i<maxLevel; i++) {
          while(!arr.get(i).isEmpty()) {
              Edge curr = arr.get(i).poll();
              getTree(edges[0], curr);
          }
      }
      
      preorder(edges[0]);
      postorder(edges[0]);
      ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
      answer.add(pre);
      answer.add(post);
      return answer;
  }
  public void preorder(Edge node) {
      pre.add(node.v);
      if(node.left != null)
          preorder(node.left);
      if(node.right != null)
          preorder(node.right);
  }
  public void postorder(Edge node) {
      if(node.left != null)
          postorder(node.left);
      if(node.right != null)
          postorder(node.right);
      post.add(node.v);
  }
  public void getTree(Edge node,Edge edge) {
      if(edge.x < node.x) {
          if(node.left != null)
              getTree(node.left,edge);
          else
              node.left = edge;
          return;
      }else {
          if(node.right != null)
              getTree(node.right,edge);
          else
              node.right = edge;
          return;
      }
  }
  static class Edge {
      int x,y,v;
      Edge left = null;
      Edge right = null;
      Edge(int x, int y, int v) {
          this.x = x;
          this.y = y;
          this.v = v;
      }
  }
}
