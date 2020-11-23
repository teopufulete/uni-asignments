import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class CoinSorterGUI extends Application {
	// create an instance of CoinSorter class
	CoinSorter sorter = new CoinSorter();
	
	public void start (Stage stage) {
		// set title properties
		Text title = new Text(68, 240, "Coin Sorter");         
		title.setFill(Color.BLACK);         
		title.setFont(Font.font ("Courier", 50));
		
		// set subtitle properties 
		Text subTitle = new Text(68, 240, "Main Menu");         
		subTitle.setFill(Color.BLACK);         
		subTitle.setFont(Font.font ("Courier", 20));
		
		// create a vertical container for the title entries
		VBox titleBox = new VBox();
		titleBox.getChildren().addAll(title, subTitle); //add title entries to container
		titleBox.setAlignment(Pos.CENTER); 
		 
		// create and add text to buttons 
		Button button1 = new Button("Coin calculator"); 
		Button button2 = new Button("Multiple coin calculator");      
		Button button3 = new Button("Print coin list"); 
		Button button4 = new Button("Set details"); 
		Button button5 = new Button("Display program configurations"); 
		Button button6 = new Button("Quit the program"); 
		
		// create a vertical container for the buttons
		VBox buttonBox = new VBox(10);         
		buttonBox.getChildren().addAll(button1, button2, button3, button4, button5, button6); //add buttons to container
		buttonBox.setAlignment(Pos.CENTER);  	 
		
		// create empty label, will be used to hold outputs
		Label label = new Label(); 
		
		
		 // create event handler
		 EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
			 public void handle(ActionEvent e) {
				 // dialog box prompt so user can enter values
				 TextInputDialog dialog1 = new TextInputDialog();
				 dialog1.setTitle("Enter values");
				 dialog1.setHeaderText("Enter amount to be exhange");
				 dialog1.setContentText("Amount:");
				 
				 // dialog box prompt so user can enter values
				 TextInputDialog dialog2 = new TextInputDialog(); 
				 dialog2.setTitle("Enter values");
				 dialog2.setHeaderText("Enter coin type");
				 dialog2.setContentText("Coin Type:");
			     
				 // print the input value upon entering
				 Optional<String> result1 = dialog1.showAndWait(); 
				 result1.ifPresent(name -> {
					 label.setText("Amount Entered: " + name);
				 });
				 
				 // print the input value upon entering
				 Optional<String> result2 = dialog2.showAndWait();
				 result2.ifPresent(name -> {
					 label.setText("Coin type entered: " + name);
				 });
				 
				 // get entered input in string form
				 String input1 = result1.get();
				 // typecast string to int
				 int amountIn = Integer.parseInt(input1);
				
				 // get entered input in string form
				 String input2 = result2.get();
				 // typecast string to int
				 int coinIn = Integer.parseInt(input2);
				 
				 // use entered inputs as parameters for coinCalulator method and display result in label
				 label.setText(sorter.coinCalculator(amountIn, coinIn));
			 }
		 };
		
		 
		 // create event handler
		 EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
			 public void handle(ActionEvent e) {
				 // dialog box prompt so user can enter values
				 TextInputDialog dialog1 = new TextInputDialog();
				 dialog1.setTitle("Enter values");
				 dialog1.setHeaderText("Enter amount to be exhange");
				 dialog1.setContentText("Amount:");
				 
				 // dialog box prompt so user can enter values
				 TextInputDialog dialog2 = new TextInputDialog(); 
				 dialog2.setTitle("Enter values");
				 dialog2.setHeaderText("Enter coin you wish to exclude");
				 dialog2.setContentText("Excluded Coin:");
			     
				 // print the input value upon entering
				 Optional<String> result1 = dialog1.showAndWait(); 
				 result1.ifPresent(name -> {
					 label.setText("Amount Entered: " + name);
				 });
				 
				 // print the input value upon entering
				 Optional<String> result2 = dialog2.showAndWait();
				 result2.ifPresent(name -> {
					 label.setText("Coin to be excluded: " + name);
				 });
				 
				 // get entered input in string form
				 String input1 = result1.get();
				 // typecast string to int
				 int amountIn = Integer.parseInt(input1);
				
				 // get entered input in string form
				 String input2 = result2.get();
				 // typecast string to int
				 int coinIn = Integer.parseInt(input2);
				 
				 // use entered inputs as parameters for multiCoinCalculator method and display result in label
				 label.setText(sorter.multiCoinCalculator(amountIn, coinIn));
			 }
		 };
		 
		 // create event handler 
		 EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() { 
		     public void handle(ActionEvent e) { 
		    	 label.setText(sorter.printCoinList());
		     } 
	      }; 
		
	      // create event handler
	      EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() { 
				 public void handle(ActionEvent e) {
					 // dialog box prompt so user can enter values
					 TextInputDialog dialog1 = new TextInputDialog();
					 dialog1.setTitle("Pick currency");
					 dialog1.setHeaderText("Enter currency symbol: ");
					 dialog1.setContentText("Symbol");
					 
					 // dialog box prompt so user can enter values
					 TextInputDialog dialog2 = new TextInputDialog(); 
					 dialog2.setTitle("Enter values");
					 dialog2.setHeaderText("Set minimum value to be exchanged");
					 dialog2.setContentText("Minimum value:");
				     
					 // dialog box prompt so user can enter values
					 TextInputDialog dialog3 = new TextInputDialog(); 
					 dialog3.setTitle("Enter values");
					 dialog3.setHeaderText("Set maximum value to be exchanged");
					 dialog3.setContentText("Maximum value:");
					 
					 // print the input value upon entering
					 Optional<String> result1 = dialog1.showAndWait(); 
					 result1.ifPresent(name -> {
						 label.setText("Currency set to: " + name);
					 });
					 
					 // print the input value upon entering
					 Optional<String> result2 = dialog2.showAndWait();
					 result2.ifPresent(name -> {
						 label.setText("New minimum value set to: " + name);
					 });
					 
					 // print the input value upon entering
					 Optional<String> result3 = dialog3.showAndWait(); 
					 result1.ifPresent(name -> {
						 label.setText("New maximum value set to: " + name);
					 });
					 
					 String input1 = result1.get();
					 sorter.setCurrency(input1);
					 
					 String input2 = result2.get();
					 int minCoinInput = Integer.parseInt(input2);
					 sorter.setMinCoinIn(minCoinInput);
					 
					 String input3 = result3.get();
					 int maxCoinInput = Integer.parseInt(input3);
					 sorter.setMaxCoinIn(maxCoinInput);
					 
					 // display new set values in label
					 label.setText("Currency set to: " + sorter.getCurrency() + "\n" + "New minimum value set to: " + sorter.getMinCoinIn() + "\n" + "New maximum value set to: " + sorter.getMaxCoinIn());
				 }
			 };
	      
		  // create event handler	 
	      EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() { 
			  public void handle(ActionEvent e) {
				  // display details to label
				  label.setText("Currency: " +  sorter.getCurrency() + "\n" + "Minimum value accepted: " + sorter.getMinCoinIn() + "\n" + "Maximum value accepted: " + sorter.getMaxCoinIn());
		  } 
		 };

		 // set specific event handler for each button
		 button1.setOnAction(event1);
		 button2.setOnAction(event2);
		 button3.setOnAction(event3);
		 button4.setOnAction(event4);
		 button5.setOnAction(event5); 
		 button6.setOnAction(e -> Platform.exit());    
		 
		 // create a vertical container for the buttons
		 VBox root = new VBox(10); 
		 root.getChildren().addAll(titleBox, buttonBox, label); //add the title, button container and label to root
		 root.setBackground(Background.EMPTY);         
		 root.setAlignment(Pos.CENTER);
		 
		 // create scene
		 Scene scene = new Scene(root, 450, 400, Color.PINK);
		 // set scene
		 stage.setScene(scene);         
		 stage.setTitle("Coin Sorter");  
		 
		 // show the stage         
		 stage.show();    
	}
	
	
	public static void main(String[] args) {         
		 launch(args);     
	 }

}
