import java.io.*;
import java.util.*;
public class Methods {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        Scanner sc=new Scanner();
        out=new PrintWriter(System.out);
        out.close();
	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
		public int compareTo(Pair o) {
			return x-o.x;
		}
	}
	static class Triple{
		int x, y, z;
		public Triple(int x, int y, int z) {
			this.x=x;this.y=y;this.z=z;
		}
	}
	public static long gcd(long a, long b) {
		while (b != 0) {
			a %= b;
			long temp = a;
			a = b;
			b = temp;
        }
        return a;
	}
	public static long lcm(long a, long b) {
		return a*b/gcd(a, b);
	}
	public static long power(long a, long b, int mod) {
		long res=1;
		while(b!=0) {
			if(b%2==1) {
				res=(res*a)%mod;
			}
			a=(a*a)%mod;
			b/=2;
		}
		return res;
	}
	public static long inverse(int a, int p) {
		return (long) Math.pow(a, p-2);
	}
	static class DSU {
        int[] parents;
        int[] rank;
        int[] setSize;
        int numSets;
        public DSU(int N) {
            parents=new int[numSets=N];
            rank=new int[N];
            setSize=new int[N];
            for(int i=0;i<N;i++) {
                parents[i]=i;
                setSize[i]=1;
            }
        }
        public int find(int i) { 
        	return parents[i] == i ? i : (parents[i] = find(parents[i])); 
        }
        public boolean isSameSet(int i, int j) { 
        	return find(i) == find(j); 
        }
        public void union(int i,int j) {
            if (isSameSet(i, j)) {
            	return;
            }
            numSets--;
            int x=find(i);
            int y=find(j);
            if(rank[x]>rank[y]) {
                parents[y] = x; setSize[x] += setSize[y];
            }else {
                parents[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }
        public int numDisjointSets() { 
        	return numSets; 
        }
        public int sizeOfSet(int i) { 
        	return setSize[find(i)]; 
        }
    }
	public static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;
	
	    public Scanner() {
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }

	    String next() {
	        while (st == null || !st.hasMoreElements()) {
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
	
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	
	    String nextLine(){
	        String str = "";
	        try {
	            str = br.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
}