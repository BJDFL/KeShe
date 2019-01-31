package main.java.model;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import main.java.controller.MainUIController;

import java.net.MalformedURLException;

public class PictureInstance extends javafx.scene.control.Label {
    private Label label;
    private MainUIController mainUIController;
    private PictureFile pictureFile;
    private Image image;
    private ImageView imageView;
    private Text pictureName;
    public PictureInstance(PictureFile pictureFile,MainUIController mainUIController)throws MalformedURLException{
        this.pictureFile=pictureFile;
        this.mainUIController=mainUIController;
        init();

    }
    private void init()throws MalformedURLException {
        this.setGraphicTextGap(10);
        this.setPadding(new Insets(1,1,1,1));
        this.setContentDisplay(ContentDisplay.TOP);
        this.setPrefSize(110,110);
        this.image = new Image(pictureFile.getImageFile().toURI().toURL().toString(),100,100,true,true);
        this.imageView = new ImageView(image);
        this.pictureName = new Text(pictureFile.getImageName());
        this.setText(pictureName.getText());
        this.setGraphic(imageView);
    }
}
