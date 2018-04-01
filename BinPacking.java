import java.util.Arrays;
import java.util.Collections;

/*
 * Uses bin packing "best fit" approach
 * to "tightly" pack ads into available slots
 */
//public class BinPacking {
	/*
	 * Pack as many ads as possible into the given bins
	 * to maximize the profit
	 */
/*	public static void packAds(Integer adProfit[], int noSlots, int slotHeight)
	{
		int profit=0,binAssignment[]=new int[noSlots];
		int SlotNo = 0;

		// Store remaining space in slots
		int capacity_available[]=new int[noSlots];
		int ad_count=adProfit.length;
	    
		for (int i=0; i<ad_count; i++)				//consider ads one by one
		{
			int j;
			int min = slotHeight+1, Si = 0;			//Si indicates the slot to be filled

			for (j=0; j<SlotNo; j++)
			{
				if (capacity_available[j] >= adProfit[i] &&			//if space is available in the current slot
						capacity_available[j] - adProfit[i] < min)	//and next ad could be fit, then assign
				{													//ad to slot
					Si = j;
					min = capacity_available[j] - adProfit[i];		//remaining capacity in the slot
				}
			}

			if (min==slotHeight+1 && SlotNo<noSlots)				//if space isn't available in the existing
			{														//slots, pack the ad into a new slot
			    System.out.println("Ad "+i+" assigned to slot "+j);
			    profit+=adProfit[i];								//calculate profit obtained
			    capacity_available[SlotNo] = slotHeight - adProfit[i];
				SlotNo++;
			}
			else {													//assign ad to available slot
			    if(capacity_available[Si]>0){						//with adequate capacity
			    	capacity_available[Si] -= adProfit[i];
				    System.out.println("Ad "+i+" assigned to slot "+Si);
				    profit+=adProfit[i];
			    }
			}
		}
		System.out.println("Maximum profit that could be achieved is "+profit);
	}
*/
	/*
	 * main method to initialize inputs: 
	 * Number of available slots, slot capacity, profit of each ad
	 */
/*	public static void main(String[] args) {
		Integer adProfit[] = {99,
				94,
				92,
				54,
				34,
				45,
				78,
				88,
				98,
				23,
				34,
				78,
				12,
				6,
				1,
				2,
				5,
				66,
				3,
				67,
				4,
				88,
				12,
				45,
				54,
				98,
				99,
				100,
				34,
				42,
				19,
				82,
				35,
				67,
				54,
				43,
				64,
				78,
				54,
				37,
				97,
				54,
				65,
				42,
				43,
				79,
				64,
				50,
				46,
				43,
				37,
				32,
				19,
				18,
				 7,
				 6,
				 3};
		int slotHeight = 100;
		int noSlots = 30;
		
		Arrays.sort(adProfit, Collections.reverseOrder()); //sort  the array in decreasing order
		packAds(adProfit,noSlots,slotHeight);			   
	}
}*/