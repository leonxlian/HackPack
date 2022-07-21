import java.io.*;
import java.util.*;
public class Dijkstra {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		long[] dijk=new long[n+1];
		ArrayList<ArrayList<Integer>> connections=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			connections.add(new ArrayList<>());
			dijk[i]=Long.MAX_VALUE;
		}
		HashMap<String,Integer> weight=new HashMap<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
		    int b=Integer.parseInt(st.nextToken());
		    int c=Integer.parseInt(st.nextToken());
		    connections.get(a).add(b);
		    connections.get(b).add(a);
		    weight.put(a+" "+b,c);
		    weight.put(b+" "+a,c);
		}
		PriorityQueue<Integer> q=new PriorityQueue<>((Integer p1,Integer p2)->Long.compare(dijk[p1],dijk[p2]));
		int[] from=new int[n+1];
		dijk[1]=0;
		from[1]=-1;
		q.add(1);
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int next:connections.get(cur)) {
				long cost=weight.get(cur+" "+next);
				if(dijk[next]>dijk[cur]+cost) {
					dijk[next]=dijk[cur]+cost;
					from[next]=cur;
					q.add(next);
				}
			}
		}
		if(from[n]==0) {
			System.out.println(-1);
		}
        else {
            ArrayDeque<Integer> qq=new ArrayDeque<>();
            int cur=n;
            qq.addFirst(n);
            while(from[cur]!=-1) {
                qq.addFirst(from[cur]);
                cur=from[cur];
            }

            while(!qq.isEmpty()) {
            	System.out.print(qq.pop()+" ");
            }
            System.out.println();
        }
	}
}
