/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport_exam;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    private int[][] salesData;
    private String[] productNames;

    public Product(int[][] salesData, String[] productNames) {
        this.salesData = salesData;
        this.productNames = productNames;
    }

    // Calculating the total amount of products sold in three months//
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }
    
// Calculating the average number of products sold per product //
    @Override
    public double GetAverageProductSold() {
        int totalProducts = productNames.length;
        int totalSales = GetTotalProductsSold();
        return (double) totalSales / totalProducts;
    }
    
// Calculating the most popular product based on the highest total sales //
    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int maxIndex = 0;

        for (int i = 0; i < salesData.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal += salesData[i][j];
            }
            if (productTotal > maxSales) {
                maxSales = productTotal;
                maxIndex = i;
            }
        }
        // Stores names and matches sales to products//
        return productNames[maxIndex] + " (" + maxSales + ")";
    }
}