package application;

import java.io.IOException;

import banking.BankAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DisplayAllController {

	Parent root;
	Stage stage;
	Scene scene;
	
	@FXML
	ListView <String> listV;
	
	public void display() {
		ObservableList<BankAccount> bList = FXCollections.observableArrayList(Main.bank.getAccounts());
		listV.getItems().clear();
		for(int i=0; i < bList.size();i++) {
			listV.getItems().addAll(bList.get(i).toString());
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
