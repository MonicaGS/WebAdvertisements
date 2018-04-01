import java.util.Arrays;
import java.util.Scanner;

public class matching {
	static int global=-1;
	
	/* greedyMatch function uses the ford-fulkerson algorithm to find an 
	 * assignment to each slot. This algorithm is based on greedy technique.
	 * When it is unable to match, it identifies the constricted set formed.
	 */
	public static boolean greedyMatch(int adSlot_Graph[][], int a, int visited[], int assignment[],Ads ad,Slots slot)
	{
		// Try every slot one by one
		for (int b = 0; b < slot.slot_size; b++)
		{
			// If ad a has high valuation for slot b and b is
			// not visited
			if (adSlot_Graph[a][b]==1 && visited[b]==0)
			{
				visited[b] = 1; // Mark slot as visited

				if (assignment[b] < 0 || greedyMatch(adSlot_Graph, assignment[b], visited, assignment,ad,slot))
				{
					//Try to assign to a different slot when another ad is 
					//contending for the same slot
					assignment[b] = a;	//If a slot is available, assign it to ad
					return true;
				}
			}
			if (visited[b] == 1)	//identifies the constricted set, here we are 
				global = b;			//identifying a slot which has too many contenders
		}
		return false;
	}

	/*
	 * Check for each slot if an ad can fit in.
	 */
	public static int perfectMatching(int adSlot_Graph[][],Slots slot,Ads ad,int slot_price[])
	{
		int assignment[]=new int[slot.slot_size];

		// Initially all slots are available
		for(int i=0;i<slot.slot_size;i++)
		{
			assignment[i]=-1;
		}

		int match = 0; // Count of ads assigned to slots
		for (int a = 0; a < ad.ad_size; a++)
		{
			// Mark all slots as not seen for next ad.
			int visited[]=new int[slot.slot_size];
			for(int i=0;i<slot.slot_size;i++)
			{
				visited[i]=0;
			}

			// Find if the ad a can get a slot
			if (greedyMatch(adSlot_Graph, a, visited, assignment,ad,slot))
				match++;
		}
		for (int i = 0; i<slot.slot_size; i++)
			System.out.println("ad "+ assignment[i]+" matched to slot "+i);
		
		int total_revenue=0;
		
		if(match == ad.ad_size){
		for (int i = 0; i < ad.ad_size; i++){
			//incase of matching, print the total revenue obtained
			total_revenue = total_revenue + (ad.ads_valuation[assignment[i]][i] - slot_price[i]);
		}
			System.out.println("total revenue is "+total_revenue); 
		}
		return match;			//number of matchings formed
	}
	
	/* Construct initial graph using hungarian algorithm.
	 * To maximize revenue, reconstruct the graph. This reduces
	   lot of iterations.	*/
	public static void construct_Graph(Slots Slot,Ads Ad, int adSlot_Graph[][])
	{
		int revenue[][]=new int[Ad.ad_size][Slot.slot_size];
		int maxValue=0;
		
		for (int i = 0; i < Ad.ad_size; i++){		//subtract max value from graph
			for (int j = 0; j < Slot.slot_size; j++)
			{
				revenue[i][j] = Ad.ads_valuation[i][j] - Slot.slot_price[j];
				if (revenue[i][j]>maxValue)
					maxValue = revenue[i][j];
			}
		}
		
		for (int i = 0; i < Ad.ad_size; i++){		//In each row, subtract minimum element 
			for (int j = 0; j < Slot.slot_size; j++)
			{
				revenue[i][j] = maxValue - revenue[i][j];
			}
		}
		
		for (int i = 0; i<Ad.ad_size; i++)			//In each column, subtract minimum element 
		{
			int min_payOff = 9999, payOff = 0;
			for (int j = 0; j<Slot.slot_size; j++)
			{
				if (revenue[i][j] < min_payOff)
					min_payOff = revenue[i][j];
			}

			for (int j = 0; j<Slot.slot_size; j++)
			{
				revenue[i][j] = revenue[i][j] - min_payOff;
			}
		}
		
		for (int i = 0; i<Ad.ad_size; i++)			//set 1 for elements correspnding to 0
		{											//0 otherwise
			int min_payOff = 9999, payOff = 0;
			for (int j = 0; j<Slot.slot_size; j++)
			{
				if (revenue[j][i] < min_payOff)
					min_payOff = revenue[j][i];
			}

			for (int j = 0; j<Slot.slot_size; j++)
			{
				revenue[j][i] = revenue[j][i] - min_payOff;
			}
		}

		for (int i = 0; i<Ad.ad_size; i++){
			for (int j = 0; j<Slot.slot_size; j++){
				if (revenue[i][j] == 0)
					adSlot_Graph[i][j] = 1;
				else
					adSlot_Graph[i][j] = 0;
			}
		}	
	}
	
	/*
	 * main method to initialize all inputs: slot prices, ad valuations
	 */
	public static void main(String args[])
	{
		int count=10;
		int slot_prices[]={60, 45, 40, 75, 85, 35, 20, 55, 90, 15};
		int slot_prices_copy[]={60, 45, 40, 75, 85, 35, 20, 55, 90, 15};
	
        Slots slot=new Slots(count,slot_prices);
        slot.recalculate_Price();
               
        int ad_prices[][]={{65, 70, 50, 90, 100, 40, 25, 75, 110, 50},
        		{70, 55, 65, 95, 105, 65, 50, 75, 110, 45},
        		{80, 45, 45, 80, 95, 45, 100, 75, 110, 55},
        		{90, 75, 60, 90, 100, 65, 37, 58, 99, 19},
        		{60, 45, 40, 75, 85, 35, 20, 55, 90, 15},
        		{82, 76, 56, 94, 88, 54, 32, 64, 99, 43},
        		{72, 56, 76, 87, 95, 46, 44, 76, 106, 34},
        		{98, 87, 54, 88, 94, 46, 53, 83, 99, 66},
        		{84, 67, 55, 85, 88, 37, 45, 67, 105, 45},
        		{78, 45, 67, 88, 95, 66, 33, 69, 93, 69}};
        Ads ad=new Ads(count,ad_prices);
        int adSlot_graph[][]=new int[ad.ad_size][slot.slot_size];
		
		
        construct_Graph(slot,ad,adSlot_graph);
        
        int maxMatch = 0;
    	maxMatch = perfectMatching(adSlot_graph,slot,ad,slot_prices);
    	
    	while (true){
    		//maxBPM function checks for perfect matching
    		System.out.println("Maximum number of ads that can get slots is "+maxMatch);

    		if (maxMatch == ad.ad_size){			//If perfect matching exisits, terminate
    			System.out.println("Perfect matching exists");
    			break;
    		}
    		else{									//increase valuation for the constricted set
    			System.out.println("constricted set formed for "+global);			//repeat the process
    			System.out.println("Initial is "+slot_prices_copy[global]);			//unless a matching exists
    			++slot_prices_copy[global];
    			System.out.println(slot_prices_copy[global]);
    			
    			//recalculate the slot prices
    			slot.setSlotprice(ad.ad_size,slot_prices_copy);

    			//construct the graph again
    			construct_Graph(slot,ad,adSlot_graph);
    			
    			maxMatch = perfectMatching(adSlot_graph,slot,ad,slot_prices);
    		}
    	}
	}
}