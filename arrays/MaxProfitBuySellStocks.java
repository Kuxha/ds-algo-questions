public class MaxProfitBuySellStocks {
    public static int  GetMaxProfit(int prices[]){

      
        int buyingPrice =Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if(buyingPrice <= prices[i]){
                // means selling price is higher. so obvis=ously profit to hoboe
                int todaysProfit = prices[i] -  buyingPrice ;
                maxProfit = Math.max(maxProfit,todaysProfit);
            }else{

                buyingPrice = prices[i];
                // because this means buying price se bhi kam he selling price. so this will be our new minimum buying price
            }
        }

        return maxProfit;
    }
}
