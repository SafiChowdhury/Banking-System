package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import banking.*;

public class TempController {
	public ListView<String> lv;
	
	public void display() {
		ObservableList<BankAccount> bList = FXCollections.observableArrayList(Main.bank.getAccounts());
		for(int i=0; i < bList.size();i++) {
			lv.getItems().addAll(bList.get(i).toString());
		}
	}
	
	public void refresh(ActionEvent event) {
		lv.getItems().clear();
		display();
	}
}
