/*******************************************************************************
* Name: Feras
* Description: A program to calculate the future value of an investment at a given
* interest rate for a specified number of years.
 ******************************************************************************/

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvestmentValueCalculator extends Application{
    
    //create private nodes
    private TextField tfInvstAmt = new TextField();
    private TextField tfNumOfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfFutureVal = new TextField();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClearAll = new Button("Clear All");
    
    
    @Override//Override the start method
    public void start(Stage primaryStage){
        
        //create grid pane ,add nodes to it, edit alignments
       GridPane pane = new GridPane();
       pane.setVgap(5);
       pane.setHgap(5);
       pane.setHgap(5);
       pane.add(new Label("Investment Amount:"),0 ,0);
       pane.add(tfInvstAmt,1,0);
       pane.add(new Label("Number of Years:"),0,1);
       pane.add(tfNumOfYears,1 ,1);
       pane.add(new Label("Annual Interest Rate:"),0,2);
       pane.add(tfAnnualInterestRate,1,2);
       pane.add(new Label("Future Value"),0,3);
       pane.add(tfFutureVal,1,3);
       pane.add(btnCalculate,1,4);
       pane.add(btnClearAll,0,4);
       pane.setAlignment(Pos.CENTER);
       pane.setHalignment(btnCalculate, HPos.RIGHT);
       pane.setPadding(new Insets(10, 10, 10, 10));
       
       //make tfFutureVal uneditible by the user
       tfFutureVal.setEditable(false);
       
       //align text inside text field
       tfInvstAmt.setAlignment(Pos.BASELINE_RIGHT);
       tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
       tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
       tfFutureVal.setAlignment(Pos.BASELINE_RIGHT);
       
       //Event handler to handle the btnCalculate
       btnCalculate.setOnAction(e -> calcFutureValue());
       
      //Event handler to handle the btnClearAll
       btnClearAll.setOnAction(e -> clearAll());
        
       //display scene 
       Scene scene = new Scene(pane);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Investment Value Calculator");
       primaryStage.show();
    }//end start method
    
    //calcFutureValue method to compute the equation and get user input
    private void calcFutureValue(){
        //get user input from text fields and parse the value
        double invstAmt = Double.parseDouble(tfInvstAmt.getText());
        double numOfYears = Integer.parseInt(tfNumOfYears.getText());
        double monthlyInterestRate = 
                Double.parseDouble(tfAnnualInterestRate.getText()) / 1200;
        
        //calculate the futureVal using the equation
        double futureVal = invstAmt * 
                Math.pow(1 + monthlyInterestRate, numOfYears * 12);
        
        //display the futureVal value to the textField 
        tfFutureVal.setText(String.format("$%.2f",futureVal));
    }//end calcFutureValue method
    
    //method to clear all text fields and set focus
    private void clearAll(){
        tfInvstAmt.clear();
        tfNumOfYears.clear();
        tfNumOfYears.clear();
        tfAnnualInterestRate.clear();
        tfFutureVal.clear();
        tfInvstAmt.requestFocus();
    }//end clear method 
    
    //main method to launch the application
    public static void main(String[] args) {
        Application.launch(args);

    }//end main
}//end class
