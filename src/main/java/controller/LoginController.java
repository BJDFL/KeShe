package main.java.controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.objects.annotations.Getter;
import main.java.service.ChangeService;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField pass_text;
    @FXML
    private CheckBox pass_toggle;
    @FXML
    private PasswordField pass_hidden;
    @FXML
    private TextField username;
    @FXML
    private JFXCheckBox remember;
    private static int rememberUser = 1;

    @FXML
    public void togglevisiblePassword(ActionEvent event) {
        if (pass_toggle.isSelected()) {
            pass_text.setText(pass_hidden.getText());
            pass_text.setVisible(true);
            pass_hidden.setVisible(false);
            return;
        }
        pass_hidden.setText(pass_text.getText());
        pass_hidden.setVisible(true);
        pass_text.setVisible(false);
    }

    private String getPassword() {
        return pass_toggle.isSelected() ?
                pass_text.getText() : pass_hidden.getText();
    }

    private void setPassword(String password) {
         if(pass_toggle.isSelected())  pass_text.setText(password);
         else pass_hidden.setText(password);
    }
    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
        String loginName = username.getText();
        String password = getPassword();
        rememberUser = remember.isScaleShape() ? 1 : 0;
        if (rememberUser == 1) {
            if (!loginName.isEmpty() && !password.isEmpty()) {
                Properties prop = new Properties();
                try {
                    FileOutputStream oFile = new FileOutputStream("user.properties", false);
                    prop.setProperty(loginName, password);
                    prop.store(oFile, null);
                    oFile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @FXML
    public void login(){
        String loginName = username.getText();
        String password = getPassword();
        if(loginName.equals("admin") && password.equals("123456")){
           try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/fxml/MainUI.fxml"));
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            ChangeService.stage.setScene(scene);
            ChangeService.stage.setTitle("picture-system1.0");
            ChangeService.stage.show();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Properties prop = new Properties();
        try {
            if (new File("user.properties").exists()) {
                remember.setSelected(true);
                InputStream in = new BufferedInputStream(new FileInputStream("user.properties"));
                prop.load(in);
                Iterator<String> it = prop.stringPropertyNames().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    username.setText(key);
                    setPassword(prop.getProperty(key));
                }
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        //private
    }
}