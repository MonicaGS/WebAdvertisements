public class Ads {
	int ads_valuation[][];
	int ad_size;
	
	/*Set initial ad valuation
	 *for each slot.
	 */
	Ads(int ad_count,int ads[][])
	{
		ad_size=ad_count;
		ads_valuation=new int[ad_count][ad_count];
		for(int i=0;i<ad_count;i++){
        	for(int j=0;j<ad_count;j++)
        	{
        	   	ads_valuation[i][j]=ads[i][j];
        	}
        }
	}
}
