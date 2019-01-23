package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField pass_text;
    @FXML private CheckBox pass_toggle;
    @FXML private PasswordField pass_hidden;
    @FXML
    public void togglevisiblePassword(ActionEvent event){
        if(pass_toggle.isSelected()){
            pass_text.setText(pass_hidden.getText());
            pass_text.setVisible(true);
            pass_hidden.setVisible(false);
            return;
        }
        pass_hidden.setText(pass_text.getText());
        pass_hidden.setVisible(false);
        pass_text.setVisible(false);
    }
    private String getPassword(){
        return pass_toggle.isSelected()?
                pass_text.getText():pass_hidden.getText();
    }
    //private
}
