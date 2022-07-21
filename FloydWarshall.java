import java.io.*;
import java.util.*;
public class FloydWarshall {
	public static void main(String[] args)throws IOException{
		int n=5;
		int d[][]=new int[n][n];
		for (int k = 0; k < n; ++k) {
		    for (int i = 0; i < n; ++i) {
		        for (int j = 0; j < n; ++j) {
		            d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]); 
		        }
		    }
		}
	}
}
