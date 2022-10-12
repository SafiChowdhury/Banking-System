package application;

import java.io.IOException;

import banking.BankAccount;
import banking.InvalidAccountException;
import banking.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SpecificAccountTransactionController {

	
	Parent root;
	Stage stage;
	Scene scene;
	
	@FXML
	TextField accNumTF;
	
	@FXML
	public ListView<String> listV;
	
	public void confirm(ActionEvent event) {
		listV.getItems().clear();
		String accNum = accNumTF.getText();
		
		try {
			ObservableList<Transaction> list = FXCollections.observableArrayList(Main.bank.getAccTransactions(accNum));
			for(int i=0; i<list.size();i++) {
				listV.getItems().addAll(list.get(i).toString());
			}
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			listV.getItems().addAll("Sorry account "+ accNum + " not found");
		}
		accNumTF.clear();
	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
