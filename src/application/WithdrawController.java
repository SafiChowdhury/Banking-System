package application;

import java.io.IOException;

import banking.InSufficientBalanceException;
import banking.InvalidAccountException;
import banking.MaxWithdawException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WithdrawController {

	@FXML
	TextField accNumTF;
	
	@FXML
	TextField amtTF;
	
	@FXML
	Label lbl;
	
	Parent root;
	Stage stage;
	Scene scene;
	
	public void next(ActionEvent event) {
		String accNum = accNumTF.getText();
		String amt = amtTF.getText();
		double amount = Double.parseDouble(amt);
		
		try {
			Main.bank.withdraw(accNum, amount);
			lbl.setText("Withdraw successful!");
			Main.bank.saveData();
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			lbl.setText("Sorry account not fount");
		} catch (InSufficientBalanceException e) {
			// TODO Auto-generated catch block
			lbl.setText("Sorry you don't have enough balance to withdraw");
		} catch (MaxWithdawException e) {
			// TODO Auto-generated catch block
			lbl.setText("Sorry this amount is more than your maximum withdraw limit");
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
