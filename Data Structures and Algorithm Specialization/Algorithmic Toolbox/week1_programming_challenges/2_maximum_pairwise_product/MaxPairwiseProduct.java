import java.util.*;
import java.io.*;
public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(int[] numbers) {
 //       int max_suspect = 0;
        int n = numbers.length;
	int temp = 0;
	int j=0;
	while(j<=1) {
	for( int i=1; i<n-j;i++){
/*		if(numbers[i]==numbers[i-1]) {
			max_suspect = numbers[i];
		}*/
		if(numbers[i]<numbers[i-1]){
			temp = numbers[i-1];
			numbers[i-1] = numbers[i];
			numbers[i] = temp;
		}
	}
	j++;
	}
/*	if(max_suspect == numbers[n-1]) {
		return ((long)max_suspect*(long)max_suspect);
	}*/
//	else {
	return ((long)numbers[n-1]*numbers[n-2]);
//	}
//        return max_product;
    }

    public static void main(String[] args) {
    	
        FastScanner scanner = new FastScanner(System.in);
        
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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
    }

}