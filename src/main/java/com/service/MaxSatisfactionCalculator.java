package com.service;

import java.util.Scanner;

public class MaxSatisfactionCalculator {

	static int maxTime;
	static int noOfItems;
	static int[] satisfactions;
	static int[] times;

	public static int calculatorMain(String args) {
		createArrayfromFile(args);
		return knapsack(satisfactions, times, maxTime, noOfItems);
	}

	private static void createArrayfromFile(String fileloc) {
		Scanner scanner = new Scanner(fileloc);
		String line = scanner.nextLine();
		String[] splitArray = getInputFromLine(line);
		maxTime = Integer.parseInt(splitArray[0].trim());
		noOfItems = Integer.parseInt(splitArray[1].trim());
		satisfactions = new int[noOfItems];
		times = new int[noOfItems];
		int count = 0;
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			splitArray = getInputFromLine(line);
			satisfactions[count] = Integer.parseInt(splitArray[0]);
			times[count] = Integer.parseInt(splitArray[1]);
			count++;
		}
		scanner.close();
		if (!(count == noOfItems)) {
			System.out.println("Invalid Input Size Discrepancy");
			System.exit(0);
		}
	}

	private static String[] getInputFromLine(String line) {
		String[] splitArray = line.split(" ");
		if (splitArray.length == 2) {
			return splitArray;
		}
		return null;
	}

	public static int knapsack(int satisfactions[], int times[], int maxTime, int noOfItems) {
		int[][] knapSackMatrix = new int[noOfItems + 1][maxTime + 1];
		// Initialize KnapsackMatrix column
		for (int col = 0; col <= maxTime; col++) {
			knapSackMatrix[0][col] = 0;
		}
		// Initialize KnapsackMatrix rows
		for (int row = 0; row <= noOfItems; row++) {
			knapSackMatrix[row][0] = 0;
		}
		for (int item = 1; item <= noOfItems; item++) {
			for (int time = 1; time <= maxTime; time++) {
				if (times[item - 1] <= time) {
					knapSackMatrix[item][time] = Math.max(satisfactions[item - 1] + knapSackMatrix[item - 1][time - times[item - 1]], knapSackMatrix[item - 1][time]);
				} else {
					knapSackMatrix[item][time] = knapSackMatrix[item - 1][time];
				}
			}
		}
		return knapSackMatrix[noOfItems][maxTime];
	}
}
