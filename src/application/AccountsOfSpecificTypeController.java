package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import banking.BankAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AccountsOfSpecificTypeController implements Initializable {

	Parent root;
	Stage stage;
	Scene scene;

	@FXML
	ComboBox<String> combo;

	@FXML
	Label textLabel;

	@FXML
	public ListView <String> listV;

	ObservableList<String> list = FXCollections.observableArrayList("Savings Account", "Current Account", "Student Account");

	public void confirm(ActionEvent e) {
				listV.getItems().clear();
		String comboValue = combo.getValue();
		switch(comboValue) {
		case "Savings Account":
			String type = "saving";
			textLabel.setText("Showing " + type + " accounts:");
			ObservableList<BankAccount> list = FXCollections.observableArrayList(Main.bank.getAccounts(type));
			for(int i=0; i<list.size(); i++) {
				listV.getItems().addAll(list.get(i).toString());
			}
			break;
			
		case "Current Account":
			String type2 = "current";
			textLabel.setText("Showing " + type2 + " accounts:");
			ObservableList<BankAccount> list2 = FXCollections.observableArrayList(Main.bank.getAccounts(type2));
			for(int i=0; i<list2.size(); i++) {
				listV.getItems().addAll(list2.get(i).toString());
			}
			break;
			
			case "Student Account":
			String type3 = "student";
			textLabel.setText("Showing " + type3 + " accounts:");
			ObservableList<BankAccount> list3 = FXCollections.observableArrayList(Main.bank.getAccounts(type3));
			for(int i=0; i<list3.size(); i++) {
				listV.getItems().addAll(list3.get(i).toString());
			}
			break;
		}

	}

	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		combo.setItems(list);

	}
}
