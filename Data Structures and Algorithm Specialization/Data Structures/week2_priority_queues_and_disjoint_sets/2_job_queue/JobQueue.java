import java.io.*;
import java.util.*;

class element{
	int index;
	long value;
	public element(int index, long value) {
		this.index = index;
		this.value = value;
	}
}

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    
    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }
    
	public static element[] siftDown(element [] a, int i) {
		if(right(i) <= a.length) {
		int min = i;
		if(a[left(i)].value < a[min].value) {
			min = left(i);	
		}
		else if(a[left(i)].value == a[min].value) {
			if(a[left(i)].index < a[min].index) {
				min = left(i);
			}
//			min = Math.min(a[min].index, a[left(i)].index);
		}
		if(right(i) < a.length) {
		if(a[right(i)].value < a[min].value) {
			min = right(i);		
		}
		else if(a[right(i)].value == a[min].value) {
			if(a[right(i)].index < a[min].index) {
				min = right(i);
			}
//			min =Math.min(a[min].index, a[right(i)].index);
		}
		}
		if(min != i) {
			swap(a, min , i);
			siftDown(a , min);
		}
		}
		return a;
	}
	
//	public static element[] siftup(element[] a, int i) {
//		while(i >= 1) {
//			if(a[parent(i)].value < a[i].value) {
//				swap(a, parent(i), i);
//			}
//			else if(a[parent(i)].value == a[i].value) {
//				if(a[parent(i)].index == a[i].index) {
//					swap(a, parent(i), i);//
//				}
//			}
//		}
//		return a;
//	}
	
	public static element[] changeValue(element[] a, int p) {
		a[0].value += p;
		return siftDown(a,0);	
	}
	public static int left(int i) {
		return 2*i+1;
	}
	public static int right(int i) {
		return 2*i+2;
	}
	public static int parent(int i) {
		return Math.abs((i-1)/2);
	}
	public static element[] swap(element [] a, int x, int y) {
		element temp = a[y];
		a[y] = a[x];
		a[x] = temp;
		return a;
	}

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        element[] a = new element[numWorkers];
        for(int i = 0; i < numWorkers; i++) {       		
    		a[i] = new element(i,0);
    	}
        
        	for(int i = 0; i < jobs.length; i++ ) {
        		int duration = jobs[i];
//        		element temp = pq.poll();
        		assignedWorker[i] = a[0].index;
        		startTime[i] = a[0].value;
        		
        		a = changeValue(a , duration)	;
        	}
//        long[] nextFreeTime = new long[numWorkers];
//        for (int i = 0; i < jobs.length; i++) {
//            int duration = jobs[i];
//            int bestWorker = 0;
//            for (int j = 0; j < numWorkers; ++j) {
//                if (nextFreeTime[j] < nextFreeTime[bestWorker])
//                    bestWorker = j;
//            }
//            assignedWorker[i] = bestWorker;
//            startTime[i] = nextFreeTime[bestWorker];
//            nextFreeTime[bestWorker] += duration;
//        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
