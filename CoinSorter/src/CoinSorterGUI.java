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
		 
		 
		 
		 Label label = new Label("Enter value:");
		 TextField textField = new TextField ();
		 TextField textField2 = new TextField ();
		 HBox textBox = new HBox();
		 textBox.setAlignment(Pos.CENTER);
		 textBox.getChildren().addAll(label, textField, textField2);
		 textBox.setSpacing(10);
		 
		 Label l = new Label(); 
		 EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() { 
		     public void handle(ActionEvent e) { 
		    	 l.setText(sorter.printCoinList());
		     } 
	      }; 
	      button3.setOnAction(event3); 
		
	      EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() { 
			  public void handle(ActionEvent e) {
				 l.setText("");
			   	 l.setText("Currency: " +  sorter.getCurrency() + "\n" + "Minimum value accepted: " + sorter.getMinCoinIn() + "\n" + "Maximum value accepted: " + sorter.getMaxCoinIn());
		  } 
		 };
		 
		 
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
//				 DialogPane dialogPane = dialog.getDialogPane();
//			     dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
//			     TextField amount = new TextField("Amount to be exchanged: ");
//			     TextField coin = new TextField("Amount to be exchanged: ");
//				 
//			     dialogPane.setContent(new VBox(8, textField, amount, coin));
			     
				 Optional<String> result1 = dialog1.showAndWait(); 
				 result1.ifPresent(name -> {
				     l.setText(name);
				 });
				 
				 Optional<String> result2 = dialog2.showAndWait();
				 result2.ifPresent(name -> {
				     l.setText(name);
				 });
//				 String input1 = amount.getText();
//				 int amountIn = Integer.parseInt(input1);
//				
//				 String input2 = coin.getText();
//				 int coinIn = Integer.parseInt(input2);
//				 l.setText(sorter.coinCalculator(amountIn, coinIn));
			 }
		 };

 		 
		 button1.setOnAction(event1);
		 button3.setOnAction(event3);
		 button5.setOnAction(event5); 
		 button6.setOnAction(e -> Platform.exit()); 

		     
	    
		 
	 
		 
		 
		 VBox root = new VBox(10); 
		 root.setBackground(Background.EMPTY);         
		 root.setAlignment(Pos.CENTER);
		 root.getChildren().addAll(titleBox, buttonBox, textBox, l);
		 
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
