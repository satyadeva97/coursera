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

public class test {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;
    
    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new test().solve();
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
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        PriorityQueue<element> pq = new PriorityQueue<element>(numWorkers, (x,y)-> {
        	if(x.value != y.value) return (int)(x.value - y.value);
        	else {
        		return x.index-y.index;
        	}     	
        });
        	for(int i = 0; i < numWorkers; i++) {       		
        		pq.add(new element(i,0));
        	}
        	for(int i = 0; i < jobs.length; i++ ) {
        		int duration = jobs[i];
        		element temp = pq.poll();
        		assignedWorker[i] = temp.index;
        		startTime[i] = temp.value;
        		temp.value  += duration;
        		pq.offer(temp);
        		
        		
        	}
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
