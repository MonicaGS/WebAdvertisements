public class Slots {
	int slot_price[],slot_size=0;
	
	/* Initialize with prices for each slot.
	 These prices will be used to calculate maximum payoff after assignment. */
	Slots(int m,int prices[])
	{
		slot_size=m;
		slot_price=new int[slot_size];
		for(int i=0;i<m;i++){
			slot_price[i]=prices[i];
		}
	}
	
	/* Set minimum slot price to 0.
	 Reduces number of iterations. 
	 */
	public void recalculate_Price()
	{
		int min=0;
		for (int i = 0; i<slot_size; i++)
		{
			min = slot_price[i];
			if (slot_price[i] < min)
				min = slot_price[i];
		}
		for (int i = 0; i<slot_size; i++)
		{
			slot_price[i] = slot_price[i] - min;
		}
	}
	
	/* When a constricted set is formed, slot price for the
	 corresponding set is increased, so as to break ties.
	 */
	public void setSlotprice(int ad_size, int[] slot_prices_copy) {
		slot_size=ad_size;
		slot_price=new int[slot_size];
		for(int i=0;i<ad_size;i++){
			slot_price[i]=slot_prices_copy[i];
		}
		recalculate_Price();
	}
}
