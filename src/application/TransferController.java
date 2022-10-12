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

public class TransferController {

	Parent root;
	Stage stage;
	Scene scene;
	
	@FXML
	TextField fanTF;
	
	@FXML
	TextField tanTF;
	
	@FXML
	TextField amtTF;
	@FXML
	Label lbl;
	
	public void next(ActionEvent event) {
		String fAccNum = fanTF.getText();
		String tAccNum = tanTF.getText();
		double amount = Double.parseDouble(amtTF.getText());
		
		try {
			Main.bank.transfer(fAccNum, tAccNum, amount);
			lbl.setText("Transfer successful!");
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			lbl.setText("Sorry account not found");
		} catch (InSufficientBalanceException e) {
			// TODO Auto-generated catch block
			lbl.setText("Sorry you don't have enough balance to transfer");
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
