/*import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	static int M=0,N=0;
	// A DFS based recursive function that returns true if a
	// matching for vertex u is possible
		
	public static boolean bpm(int bpGraph[][], int u, int seen[], int matchR[])
	{
		for (int v = 0; v < N; v++)
		{
			if (bpGraph[u][v]==1 && seen[v]==0)
			{
				seen[v] = 1; // Mark v as visited

				if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR))
				{
					matchR[v] = u;
					return true;
				}
			}
		}
		return false;
	}

	public static int maxBPM(int bpGraph[][])
	{
		int matchR[]=new int[N];

		// Initially all jobs are available
		for(int i=0;i<N;i++)
		{
			matchR[i]=-1;
		}

		int result = 0; // Count of jobs assigned to applicants
		for (int u = 0; u < M; u++)
		{
			// Mark all jobs as not seen for next applicant.
			int seen[]=new int[M];
			for(int i=0;i<M;i++)
			{
				seen[i]=0;
			}

			// Find if the applicant 'u' can get a job
			if (bpm(bpGraph, u, seen, matchR))
				result++;
		}
		for (int i = 0; i<N; i++)
			System.out.println("ad "+i+" matched to slot "+matchR[i]);
		return result;
	}
	
	public static void main(String args[])throws IOException
	{ 
		String file = "C:\\Users\\monica g\\Desktop\\set1-cl.txt";
		//String file = "C:\\Users\\monica g\\Desktop\\set2-actor.txt";
		
		BufferedReader br = null;
		FileReader fr = null;
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
	    String line;
	    int firstCol,secondCol,max=0,i=0,count=0;
	    int slot_prices[];
	    
		while ((line = br.readLine()) != null) {
			String arrayLine[]= line.split("\\s+"); // here you are splitting with whitespace 
			if(i==-1)
				while(i++ != count)
				{
					firstCol=Integer.parseInt(arrayLine[0]);
					slot_prices[i]=Integer.parseInt(arrayLine[0]);
				}
			else	
		    	firstCol = Integer.parseInt(arrayLine[0]);
		    if(i==0){
		    	count=firstCol;i--;
		    	slot_prices=new int[count];
		    }
		    //System.out.println(count);
		    //secondCol=Integer.parseInt(arrayLine[1]);
		}
		System.out.println(max);
		M=N=max;
		int bpGraph[][]=new int[M][N];
		int a=0,b=0;
		
		for(int k=0;k<M;k++){
			for(int j=0;j<N;j++){
				bpGraph[k][j]=-1;
			//	System.out.print(bpGraph[i][j]+" ");
			}
			//System.out.println();
		}
		
		BufferedReader br1 = null;
		FileReader fr1 = null;
		fr1 = new FileReader(file);
		br1 = new BufferedReader(fr1);
		
		
		while ((line = br1.readLine()) != null) {
			System.out.println("inside code");
			String arrayLine1[]= line.split("\\s+"); // here you are splitting with whitespace 
		    a=Integer.parseInt(arrayLine1[0]);
		    b=Integer.parseInt(arrayLine1[1]);
		    System.out.println("a value is "+a+" b value is "+b);
			bpGraph[a-1][b-1]=1;
		}

		System.out.println("Maximum number of applicants that can get job is "+maxBPM(bpGraph));
	}

}*/