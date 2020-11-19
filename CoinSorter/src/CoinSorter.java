import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinSorter {
	private String currency;
	private int minCoinIn;
	private int maxCoinIn;
	private List<Integer> coinList;

	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, List<Integer> coinList) {
		this.currency = currency;	
		this.minCoinIn = minCoinIn;
		this.maxCoinIn = maxCoinIn;
		this.coinList = coinList;
	}
	
	
	public CoinSorter() {
		// initialize attributes
		currency = "pounds"; 	
		minCoinIn = 0;
		maxCoinIn = 10000;
		
		// allocates memory for coinList
		coinList = new ArrayList<Integer>(); 
		// add coin types to coinList
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
	}
	
	
	// setter method for currency
	public void setCurrency(String currencyIn) {
		currency = currencyIn;
	}
	
	
	// currency getter method
	public String getCurrency() {
		return currency;
	}
	
	
	// setter method for minCoinIn
	public void setMinCoinIn(int minCoinInput) {
		minCoinIn = minCoinInput;
	}
	
	
	// minCoinIn getter method
	public int getMinCoinIn() {
		return minCoinIn;
	}
	
	
	// setter method for maxCoinIn
	public void setMaxCoinIn(int maxCoinInput) {
		maxCoinIn = maxCoinInput;
	}
	
	
	// maxCoinIn getter method
	public int getMaxCoinIn() {
		return maxCoinIn;
	}
	
	
	// method that loops over coinList element and prints them
	public String printCoinList() {
		
		// use StringBuilder to create a string that will hold the output
		StringBuilder output = new StringBuilder();
		
		output.append("The current coin denominations are in circulation: ");
		// loop over elements in list and append them to output string
		for (int element : coinList) {
			output.append(element + ", ");
		}
		
		System.out.println(output);
		return output.toString();
	}
	
	
	public String coinCalculator(int value, int coinType) {
		
		// use StringBuilder to create a string that will hold the output
		StringBuilder output = new StringBuilder();
		output.append("A total of ");
		
		// check if coinType is part of the coinList
		if (coinList.contains(coinType) == false) {
			System.out.println("Error! You may only enter available coins types: " + printCoinList());
		}
		
		// check if value to be exchanged is between minCoinIn and maxCoinIn
		else if (value < minCoinIn || value > maxCoinIn) {
			System.out.println("Error! Program only supports values between 0 and 10000.");
		}
		
		else {
			output.append(value / coinType + " x " + coinType + "p coins can be exchanged, with a remainder of " + value % coinType + "p.");
			System.out.println(output);
		}
		return output.toString();			
	}
	
	
	
	public String multiCoinCalculator(int value, int excludedCoinType) {

	}
	
//	public boolean checkCoinType() {
//		if (coinList.contains(coinn) == false) {
//			System.out.println("Error! You may only enter available coins types: 10p, 20p, 50p, 100p, 200p");
//			return false;
//		}
//		return true;
//	}
	
    // print program details
	public void displayProgramConfigs() {
		System.out.println("Currency " + currency);
		System.out.println("Minimum value accepted " + minCoinIn);
		System.out.println("Maximum value accepted " + maxCoinIn);
	}
}
