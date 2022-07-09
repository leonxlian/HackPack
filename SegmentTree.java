import java.io.*;
import java.util.*;
public class SegmentTree {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		Scanner sc=new Scanner();
		out=new PrintWriter(System.out);
		int n=sc.nextInt();
		int q=sc.nextInt();
		SegTree st=new SegTree(n);
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		st.build(a);
		for(int i=0;i<q;i++) {
			int low=sc.nextInt()-1;
			int high=sc.nextInt()-1;
			out.println(st.sum(1, 0, st.size-1, low, high));
		}
		out.close();
	}
	static class SegTree{
		int size;
		long tree[];
		public SegTree(int n) {
			size=1;
			while(size<n) {
				size*=2;
			}
			tree=new long[2*size];
		}
		public void build(int a[]) {
			for(int i=0;i<a.length;i++) {
				tree[size+i]=a[i];
			}
			for(int i=size-1;i>=1;i--) {
				tree[i]=tree[2*i]+tree[2*i+1];
			}
		}
		public long sum(int node, int node_low, int node_high, int query_low, int query_high) {
			if(query_low<=node_low&&node_high<=query_high) {
				return tree[node];
			}
			if(query_high<node_low||query_low>node_high) {
				return 0;
			}
			int last_in_left=(node_low+node_high)/2;
			return sum(2*node, node_low, last_in_left, query_low, query_high)
					+sum(2*node+1, last_in_left+1, node_high, query_low, query_high);
		}
		//change
		public void setRecur(int node, int node_low, int node_high, int query_low, int query_high, int v) {
			if(query_low<=node_low&&node_high<=query_high) {
				tree[node]=v;
				return;
			}
			if(query_high<node_low||query_low>node_high) {
				return;
			}
			int last_in_left=(node_low+node_high)/2;
			setRecur(2*node, node_low, last_in_left, query_low, query_high, v);
			setRecur(2*node+1, last_in_left+1, node_high, query_low, query_high, v);
			tree[node]=tree[2*node]+tree[2*node+1];
			
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

