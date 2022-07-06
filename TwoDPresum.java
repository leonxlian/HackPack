import java.io.*;
import java.util.*;
public class TwoDPresum{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int[][] a=new int[n][m];
	    for(int i=0;i<n;i++) for(int j=0;j<m;j++) a[i][j]=scan.nextInt();
	    int[][] presum=new int[n+1][m+1];
	    for(int i=1;i<=n;i++) 
	    	for(int j=1;j<=m;j++)
	    		presum[i][j]=//to get the answer at this spot......
	    			a[i-1][j-1]//add the current value at i j in original matrix
	    					+presum[i-1][j]//add the answer for box "above"
	    					+presum[i][j-1]//add the answer for box " to the left"
	    							-presum[i-1][j-1]; //subtract the box where the "above" and "left" overlap since we added it twice
	
	            //print out sht
	   for(int i=0;i<=n;i++) {
	        for(int j=0;j<=m;j++) System.out.print(presum[i][j]+" ");
	            System.out.println();
	   }
	
	   //query
	   int q=scan.nextInt();
	   while(q-->0) {
		   int x1=scan.nextInt()-1,y1=scan.nextInt()-1,x2=scan.nextInt(),y2=scan.nextInt();
		   System.out.println(presum[x2][y2]//big rectangle
				   			-presum[x1][y2]//subtract box "above"
	                        -presum[x2][y1]//subtract box "left"
	                        +presum[x1][y1]);//add back part where they overlap, since it was subtracted twice
	   }
	}
}