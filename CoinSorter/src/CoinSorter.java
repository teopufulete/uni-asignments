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
		// append the following message to output string
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
		output.append(" ");
		
		// check if coinType is part of the coinList
		if (coinList.contains(coinType) == false) {
			System.out.println("Error! You may only enter available coins types! " + printCoinList());
			output.append("Error! You may only enter available coins types! " + printCoinList());
			return output.toString();
		}
		
		// check if value is between minCoinIn and maxCoinIn
		else if (value < minCoinIn || value > maxCoinIn) {
			System.out.println("Error! Program only supports values between 0 and 10000.");
			output.append("Error! Program only supports values between 0 and 10000.");
		}
		
		else {
			output.append("A total of " + value / coinType + " x " + coinType + "p coins can be exchanged, with a remainder of " + value % coinType + "p.");
			System.out.println(output);
			return output.toString();
		}
		return output.toString();			
	}
	
	
	public String multiCoinCalculator(int value, int excludedCoinType) {
		StringBuilder output = new StringBuilder();
		output.append("The coins exchanged are: ");
		
		// perform the same input checks as coinCalculator. Could add checker method
		if (coinList.contains(excludedCoinType) == false) {
			System.out.println("Error! You may only enter available coins types: 10p, 20p, 50p, 100p, 200p");
		}
		else if (value < minCoinIn || value > maxCoinIn) {
			System.out.println("Error! Program only supports values between 0 and 10000.");
		}
		
		// loop over the coins in coinList
		else for (int coin : coinList) {
			// for excluded coin don't perform any calculations 
			if (excludedCoinType == coin) {
				output.append(0 + " x " + coin + "p, ");
			}
			else {
				// divide value by coin type and append result to string
				output.append(value / coin + " x " + coin + "p, ");
				// value is now the remainder of the division
				value = value % coin;
			}			
		}
		output.append("with a remainder of " + value + "p. ");
		System.out.println(output);
		return output.toString();
	}
	
	
    // print program details
	public void displayProgramConfigs() {
		System.out.println("Currency: " + currency);
		System.out.println("Minimum value accepted: " + minCoinIn);
		System.out.println("Maximum value accepted: " + maxCoinIn);
	}
}
