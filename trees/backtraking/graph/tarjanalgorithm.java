import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class tarjanalgorithm {

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 3));


    }

    public static void tarjan(ArrayList<Edge> graph[], int cur, boolean[] visit, int[] dt, int[] low, int time, int pereant) {
        dt[cur] = low[cur] = ++time;
        visit[cur] = true;
        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);
            if (e.dest== pereant) {
                continue;
            }
            if (!visit[e.dest]) {
                tarjan(graph, e.dest, visit, dt, low, time,cur);
                low[cur]=Math.min(low[cur], low[e.dest]);
                if (dt[cur] < low[e.dest]) {
                    System.out.println("the bridge is a ::" +cur + "->" + e.dest);
                }
            }
            if (visit[e.dest] && e.dest != pereant) {
                 low[ cur]=Math.min(low[cur], dt[e.dest]);

            }

        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        boolean[] visit = new boolean[v];
        creategraph(graph);
        int[] dt = new int[v];
        int[] low = new int[v];
        int time = 0;
        int pereant = Integer.MIN_VALUE;
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                tarjan(graph, i, visit, low, dt, time, pereant);
            }
        }
    }
}




