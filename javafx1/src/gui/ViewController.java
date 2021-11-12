package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{
	
	@FXML
	private TextField txtFirstNumber;
	
	@FXML
	private TextField txtSecondNumber;
	
	@FXML
	private Label resultLabel;
	
	
	@FXML
	private Button sumButton;
	
	@FXML
	private Button quitButton;
	
	@FXML
	public void onSumButtomAction() {
		
		try {
			Locale.setDefault(Locale.US);
			
			double value1 = Double.parseDouble(txtFirstNumber.getText());
			double value2 = Double.parseDouble(txtSecondNumber.getText());
			
			double sum = value1 + value2;
			
			resultLabel.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
	
	}
	
	@FXML
	public void onQuitAction() {
		System.exit(0);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtFirstNumber);
		Constraints.setTextFieldDouble(txtSecondNumber);
		Constraints.setTextFieldMaxLength(txtFirstNumber, 10);
		Constraints.setTextFieldMaxLength(txtSecondNumber, 10);
		
	}
}