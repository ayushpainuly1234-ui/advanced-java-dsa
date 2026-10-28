import java.util.*;

public class aliendictionary {

   public static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static String findOrder(String[] words) {

        int V = 26;

        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[V];
        boolean[] present = new boolean[V];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int ch = words[i].charAt(j) - 'a';
                present[ch] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {

                int c1 = w1.charAt(j) - 'a';
                int c2 = w2.charAt(j) - 'a';

                if (c1 != c2) {
                    graph[c1].add(new Edge(c1, c2));
                    indegree[c2]++;
                    found = true;
                    break;
                }
            }

            if (!found && w1.length() > w2.length()) {
                return "";
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int totalChars = 0;

        for (int i = 0; i < V; i++) {
            if (present[i]) {
                totalChars++;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.remove();
            ans.append((char)(cur + 'a'));
            count++;

           for (int i = 0; i < graph[cur].size(); i++) {
        Edge e = graph[cur].get(i);
        indegree[e.dest]--;
         if (indegree[e.dest] == 0) {
           q.add(e.dest);
    }
}

        }

        if (count != totalChars) {
            return "";
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(words));
    }
}
