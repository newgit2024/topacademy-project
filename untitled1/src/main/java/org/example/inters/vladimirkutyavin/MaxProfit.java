package org.example.inters.vladimirkutyavin;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update the maximum profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit: " + maxProfit);
    }
    public static int maxProfit2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int n :prices) {
            if (n < minPrice){
                minPrice = n;
            } else if (n - minPrice > maxProfit){
                maxProfit = n - minPrice;
            }
        }
        return maxProfit;
    }
}

