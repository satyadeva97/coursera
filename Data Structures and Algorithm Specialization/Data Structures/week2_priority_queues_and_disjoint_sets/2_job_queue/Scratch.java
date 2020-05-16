import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
 
public class Scratch {
 
    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static List<Pair> getThreadListOutput(int a[], int m, int n) {
 
        List<Pair> answerList = new ArrayList<>();
        Queue<Pair> q = new PriorityQueue<>((a1, a2) -> {
            if (a1.x != a2.x) {
                return (a1.x - a2.x);
            } else {
                return a1.y - a2.y;
            }
        });
 
        int min = Math.min(m, n);
        for(int i = 0; i < min; i++) {
            q.offer(new Pair(a[i], i));
            answerList.add(new Pair(i, 0));
        }
 
        int j = min;
 
        while (j < m) {
            Pair p = q.poll();
            answerList.add(new Pair(p.y, p.x));
            q.offer(new Pair(p.x + a[j], p.y));
            j += 1;
        }
 
        return answerList;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        List<Pair> answerList = getThreadListOutput(a, m, n);
        for (Pair p : answerList) {
            System.out.println(p.x + " " + p.y);
        }
    }
}