package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import main.java.model.FileTree;
import main.java.model.PictureFile;
import main.java.model.PictureInstance;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {
    @FXML
    private TreeView<PictureFile> tv;
    private ArrayList<PictureInstance>pictures;
    private ArrayList<File>files;
    private MainUIController mainUI;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDate();
    }
    private void initDate(){
        pictures = new ArrayList<>();
        tv =new FileTree(mainUI,tv).gettreeView();

    }
}
