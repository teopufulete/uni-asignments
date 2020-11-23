import java.util.Scanner;

public class testCoinSorter {
	
	public static void main(String[] args) {
		// create instance of CoinSorter
		CoinSorter sorter = new CoinSorter();
		// use Scanner class to get user input
		Scanner scanner = new Scanner(System.in);
		int choice1 = 0;
		
	    
		// prompts for user input until user exits
	    do {// menu main body
	    	System.out.println("~~~~~ Coin Sorter - Main Menu ~~~~~");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter number:");
			
			// user input
			choice1 = scanner.nextInt();
	
			//user input determines menu behaviour
		    switch (choice1) {
		    
		        case 1:
		        	System.out.println("Enter amount you wish to exchange");
	        		int amountIn = scanner.nextInt();
	        		System.out.println("Enter desired coin type");
	        		int coinIn = scanner.nextInt();
		            sorter.coinCalculator(amountIn, coinIn);
		            break;
		            
		        case 2:
		        	System.out.println("Enter amount you wish to exchange");
	        		int valueIn = scanner.nextInt();
	        		System.out.println("Enter coin type you want to exclude");
	        		int excludedCoinIn = scanner.nextInt();
		            sorter.multiCoinCalculator(valueIn, excludedCoinIn);
		            break;
		            
		        case 3:
		            sorter.printCoinList();
		            break;
		            
		        case 4:
		        	// sub-menu body
		        	System.out.println("~~~~~ Set Details Sub-Menu ~~~~~");
		        	System.out.println("1 - Set currency");
		        	System.out.println("2 - Set minimum coin input value");
		        	System.out.println("3 - Set maximum coin input value");
		        	System.out.println("4 - Return to main menu");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Enter number:");
					// new user input variable
		        	int choice2 = scanner.nextInt();
		        	switch (choice2) {
		        	case 1:
		        		System.out.println("Enter currency");
		        		String currencyIn = scanner.nextLine();
			            sorter.setCurrency(currencyIn);
			            break;
			        case 2:
			        	System.out.println("Enter minimum coin input value ");
			        	int minCoinInput = scanner.nextInt();
			            sorter.setMinCoinIn(minCoinInput);;
			            break;
			        case 3:
			        	System.out.println("Enter maximum coin input value");
			        	int maxCoinInput = scanner.nextInt();
			            sorter.setMaxCoinIn(maxCoinInput);
			            break;
			        case 4: // returns to main menu
			        	break;
		        	}
		            break;
		            
		        case 5:
		            sorter.displayProgramConfigs();
		            break;
		        default:
		        	System.out.println("Invalid selection.");
		        	
		     } 
	    } 
	    while (choice1 != 6);
	    // exits loop if user enters 6
        System.exit(1);
	}
}
