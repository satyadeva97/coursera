import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      int x=a[l],j=l,k=l;
      for(int i=l+1;i<a.length;i++) {
    	  if(a[i]<x) {
    		  j++;
    		  k++;   		  
    		  int t=a[j];
    		  a[j]=a[i];
    		  a[i]=t;
    		  if(j!=k) {
    		  a[i]=a[k];
    		  a[k]=t;
    		  }
    		continue;  
    	  }
    	  if(a[i]==x) {
    		  k++;
    		  int t=a[i];
    		  a[i]=a[k];
    		  a[k]=t;
    		  
    	  }
      }
      int t=a[l];
	  a[l]=a[j];
	  a[j]=t;
      int m1 = j;
      int m2 = k;
      int[] m = {m1, m2};
      return m;
    }

 /*   private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }*/

    private static void randomizedQuickSort(int[] a, int l, int r) {
    	int m[] = new int[2];
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
      a[k] = t;
        //use partition3
        m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

/*    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }*/
}

