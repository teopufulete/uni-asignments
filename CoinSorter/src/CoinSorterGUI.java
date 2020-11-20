import java.awt.Insets;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 

public class CoinSorterGUI extends Application {
	CoinSorter sorter = new CoinSorter();
	
	public void start (Stage stage) {
		 Text title = new Text(68, 240, "Coin Sorter");         
		 title.setFill(Color.BLACK);         
		 title.setFont(Font.font ("Courier", 50));
		 
		 Text subTitle = new Text(68, 240, "Main Menu");         
		 subTitle.setFill(Color.BLACK);         
		 subTitle.setFont(Font.font ("Courier", 20));
		 
		 VBox titleBox = new VBox();
		 titleBox.getChildren().addAll(title, subTitle);
		 titleBox.setAlignment(Pos.CENTER); 
		 
		 
		 Button button1 = new Button("Coin calculator"); 
		 Button button2 = new Button("Multiple coin calculator");      
		 Button button3 = new Button("Print coin list"); 
		 Button button4 = new Button("Set details"); 
		 Button button5 = new Button("Display program configurations"); 
		 Button button6 = new Button("Quit the program"); 
	 
		 VBox buttonBox = new VBox(10);         
		 buttonBox.setAlignment(Pos.CENTER); 
		 buttonBox.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		 
		 
//		 Label label = new Label("Enter value:");
//		 TextField textField = new TextField ();
//		 TextField textField2 = new TextField ();
//		 HBox textBox = new HBox();
//		 textBox.setAlignment(Pos.CENTER);
//		 textBox.getChildren().addAll(label, textField, textField2);
//		 textBox.setSpacing(10);
		 
		 Label label = new Label(); 
		 
		 EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
			 public void handle(ActionEvent e) {
				 TextInputDialog dialog1 = new TextInputDialog();
				 dialog1.setTitle("Enter values");
				 dialog1.setHeaderText("Enter amount to be exhange");
				 dialog1.setContentText("Amount:");
				 
				 TextInputDialog dialog2 = new TextInputDialog(); 
				 dialog2.setTitle("Enter values");
				 dialog2.setHeaderText("Enter coin type");
				 dialog2.setContentText("Coin Type:");
			     
				 Optional<String> result1 = dialog1.showAndWait(); 
				 result1.ifPresent(name -> {
					 label.setText("Amount Entered: " + name);
				 });
				 
				 Optional<String> result2 = dialog2.showAndWait();
				 result2.ifPresent(name -> {
					 label.setText("Coin type entered: " + name);
				 });
				 
				 String input1 = result1.get();
				 int amountIn = Integer.parseInt(input1);
				
				 String input2 = result2.get();
				 int coinIn = Integer.parseInt(input2);
				 label.setText(sorter.coinCalculator(amountIn, coinIn));
			 }
		 };
		 
		 EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
			 public void handle(ActionEvent e) {
				 TextInputDialog dialog1 = new TextInputDialog();
				 dialog1.setTitle("Enter values");
				 dialog1.setHeaderText("Enter amount to be exhange");
				 dialog1.setContentText("Amount:");
				 
				 TextInputDialog dialog2 = new TextInputDialog(); 
				 dialog2.setTitle("Enter values");
				 dialog2.setHeaderText("Enter coin you wish to exclude");
				 dialog2.setContentText("Excluded Coin:");
			     
				 Optional<String> result1 = dialog1.showAndWait(); 
				 result1.ifPresent(name -> {
					 label.setText("Amount Entered: " + name);
				 });
				 
				 Optional<String> result2 = dialog2.showAndWait();
				 result2.ifPresent(name -> {
					 label.setText("Coin to be excluded: " + name);
				 });
				 
				 String input1 = result1.get();
				 int amountIn = Integer.parseInt(input1);
				
				 String input2 = result2.get();
				 int coinIn = Integer.parseInt(input2);
				 label.setText(sorter.multiCoinCalculator(amountIn, coinIn));
			 }
		 };
		 
		 EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() { 
		     public void handle(ActionEvent e) { 
		    	 label.setText(sorter.printCoinList());
		     } 
	      }; 
		
	      EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() { 
				 public void handle(ActionEvent e) {
					 TextInputDialog dialog1 = new TextInputDialog();
					 dialog1.setTitle("Pick currency");
					 dialog1.setHeaderText("Enter currency symbol: ");
					 dialog1.setContentText("Symbol");
					 
					 TextInputDialog dialog2 = new TextInputDialog(); 
					 dialog2.setTitle("Enter values");
					 dialog2.setHeaderText("Set minimum value to be exchanged");
					 dialog2.setContentText("Minimum value:");
				     
					 TextInputDialog dialog3 = new TextInputDialog(); 
					 dialog3.setTitle("Enter values");
					 dialog3.setHeaderText("Set maximum value to be exchanged");
					 dialog3.setContentText("Maximum value:");
					 
					 Optional<String> result1 = dialog1.showAndWait(); 
					 result1.ifPresent(name -> {
						 label.setText("Currency set to: " + name);
					 });
					 
					 Optional<String> result2 = dialog2.showAndWait();
					 result2.ifPresent(name -> {
						 label.setText("New minimum value set to: " + name);
					 });
					 
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
					 label.setText("Currency set to: " + sorter.getCurrency() + "\n" + "New minimum value set to: " + sorter.getMinCoinIn() + "\n" + "New maximum value set to: " + sorter.getMaxCoinIn());
				 }
			 };
	      
	      EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() { 
			  public void handle(ActionEvent e) {
				  label.setText("");
				  label.setText("Currency: " +  sorter.getCurrency() + "\n" + "Minimum value accepted: " + sorter.getMinCoinIn() + "\n" + "Maximum value accepted: " + sorter.getMaxCoinIn());
		  } 
		 };

		 button1.setOnAction(event1);
		 button2.setOnAction(event2);
		 button3.setOnAction(event3);
		 button4.setOnAction(event4);
		 button5.setOnAction(event5); 
		 button6.setOnAction(e -> Platform.exit());    
		 
		 VBox root = new VBox(10); 
		 root.setBackground(Background.EMPTY);         
		 root.setAlignment(Pos.CENTER);
		 root.getChildren().addAll(titleBox, buttonBox, label);
		 
		 Scene scene = new Scene(root, 450, 400, Color.PINK);
		 stage.setScene(scene);         
		 stage.setTitle("Coin Sorter");  
		 
		 // show the stage         
		 stage.show();    
	}
	
	
	public static void main(String[] args) {         
		 launch(args);     
	 }

}
