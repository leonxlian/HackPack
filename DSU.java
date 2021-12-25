import java.util.*;
import java.io.*;
public class DSU {
	int[] parents;
	int[] rank;
	public DSU(int size) { //constructor
		rank = new int[size];
		parents = new int[size];
		Arrays.fill(rank, 0);
		for(int i=0;i<parents.length;i++) {
			parents[i]=i;
		}
	}
	public int find(int x) {
		if(parents[x]==x) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	public void union(int x, int y) {
		int rootX=find(x);
		int rootY=find(y);
		if(rootX==rootY) {
			return;
		}
		if(rank[rootX]>rank[rootY]) {
			parents[rootY]=rootX;
		}else {
			parents[rootX]=rootY;
			if(rank[rootX]==rank[rootY]) {
				rank[rootY]++;
			}
		}
	}
}
