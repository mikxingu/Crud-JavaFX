package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable{
	
	@FXML
	private ComboBox<Person> personComboBox;
	
	private ObservableList<Person> obsList;

	//BUTONS
	@FXML
	private Button allPersonButton;
	
	@FXML
	private Button quitButton;
	
	//ACTIONS
	@FXML
	public void onAllPersonButtonAction() {
		for (Person person : personComboBox.getItems()) {
			System.out.println(person.getName());
		}
	}
	@FXML
	public void onPersonComboBoxAction() {
		Person selectedPerson = personComboBox.getSelectionModel().getSelectedItem();
		String personName = selectedPerson.getName();
		System.out.println(personName + " selected.");
		
	}
	
	@FXML
	public void onQuitAction() {
		System.exit(0);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Mike", "michelalvs@gmail.com"));
		list.add(new Person(2, "Vitoria", "vitorialuynne@gmail.com"));
		list.add(new Person(3, "Melito", "melito@gmail.com"));
		
		obsList = FXCollections.observableArrayList(list);
		personComboBox.setItems(obsList);
		
		//CALLBACK TO DEFINE HOW A PERSON IS VIEWED ON THE COMBOBOX
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem (Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());;
			}
		};
		
		personComboBox.setCellFactory(factory);
		personComboBox.setButtonCell(factory.call(null));
	}
}