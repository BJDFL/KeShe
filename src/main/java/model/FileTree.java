package main.java.model;
import java.io.File;
import java.net.MalformedURLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import main.java.controller.MainUIController;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class FileTree {

     private MainUIController mainUI;
     private TreeView<PictureFile> treeView;
     private TreeItem<PictureFile> root;
     private static File file = new File("C:");
     private final File[] rootPath = file.listFiles();

     public FileTree(MainUIController mianUI, TreeView<PictureFile> treeView) {

          this.mainUI = mianUI;
          // System.out.println(mianUI);
          this.treeView = treeView;
          root = new TreeItem<PictureFile>(new PictureFile("root"));
          root.setExpanded(true);
          treeView.setRoot(root);
          treeView.setShowRoot(false);
          buildFileTree();

     }

     private void buildFileTree() {
          for (int i = 0; i < rootPath.length; i++) {
               FileTreeItem item = new FileTreeItem(new PictureFile(rootPath[i]));
               root.getChildren().add(item);
          }
     }

     public TreeView<PictureFile> gettreeView() {
          return treeView;
     }

}