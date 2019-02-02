package main.java.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import main.java.model.FileTree;
import main.java.model.PictureFile;
import main.java.model.PictureInstance;
import main.java.service.ChangeService;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {
    @FXML
    private TreeView<PictureFile> tv;
    @FXML
    private FlowPane picture_show;
    private ArrayList<PictureInstance>pictures;
    private ArrayList<File>files;
    public static String theFilePath;
    private MainUIController mainUI;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDate();
    }
    private void initDate(){
        pictures = new ArrayList<>();
        tv =new FileTree(this,tv).gettreeView();
    }
    public void clearPictures(){
        pictures.clear();
    }
    public  void addPictures(PictureInstance pictureInstance){
        pictures.add(pictureInstance);
    }
    public ArrayList<File> getFiles() {
        return files;
    }

    public FlowPane getFlowPane() {
        return picture_show;
    }
    public ObservableList<Node> getFlowPaneChildren() {
        return picture_show.getChildren();
    }
    public void show_picture(){
          System.out.println("233");
          picture_show.getChildren().remove(0,picture_show.getChildren().size());
          files = new ArrayList<File>();
          for(PictureInstance tmp :pictures){
              picture_show.getChildren().add(tmp);
          }
          for(int i=0 ; i<pictures.size() ; i++){
              files.add(pictures.get(i).getImageFile());
          }
        ChangeService.files = files;
    }

}
