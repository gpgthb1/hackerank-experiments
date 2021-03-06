package com.hackerrank.test.patterns.elemaninTeki.observer_pattern;

import java.text.DecimalFormat;

/**
 * Created by txcakaloglu on 2/9/17.
 */
/* ***********************/
/* OBSERVER PATTERNS    */
/* ***********************/
// allow to use threads with Runnable
public class GetTheStock implements Runnable {

    // Could be used to set how many seconds to wait
    // in Thread.sleep() below
    private String stock;
    private double price;

    // Will hold reference to the StockGrabber object
    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice) {

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods
        this.stockGrabber = stockGrabber;
        this.stock = newStock;
        this.price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                // Sleep for 2 seconds
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            finally {
                // Generates a random number between -.03 and .03
                double randNum = (Math.random() * (.06)) - .03;

                // Formats decimals to 2 places
                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                // Change the price and then convert it back into a double
                price = Double.valueOf(decimalFormat.format(price + randNum));
                if (stock == "IBM")
                    ((StockGrabber)stockGrabber).setIbmPrice(price);
                if (stock == "APPLE")
                    ((StockGrabber)stockGrabber).setApplePrice(price);
                if (stock == "GOOGLE")
                    ((StockGrabber)stockGrabber).setGooglePrice(price);
                System.out.println(stock + ": " + decimalFormat.format(price + randNum) + " " + decimalFormat.format(randNum));
                System.out.println();
            }

        }
    }
}
