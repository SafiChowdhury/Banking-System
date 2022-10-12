package application;

import java.io.IOException;

import banking.InvalidAccountException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepositController {
	
	@FXML
	TextField accNumTF;
	@FXML
	TextField amntTF;
	@FXML
	Label msgLabel;
	
	Parent root;
	Stage stage;
	Scene scene;
	
	public void next(ActionEvent event) {
		String accNum = accNumTF.getText();
		String amountS = amntTF.getText();
		double amount = Double.parseDouble(amountS);
		
		try {
			Main.bank.deposit(accNum, amount);
			Main.bank.saveData();
			msgLabel.setText("Deposit Successful!");
		} catch (InvalidAccountException e) {
			msgLabel.setText("Sorry account " + accNum + " not found");
//			e.printStackTrace();
		}
	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
