package lk.ijse.dep10.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    private static Stage stgProgressBar;
    private static Stage stgImageViewer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.setTitle("Java FX Controls Continue");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void mainScene(Stage stage){
        Label lblTitle = new Label("Java FX Controls Cont.");
        Button btnProgressBar = new Button("Progress Bar");
        Button btnImageViewer = new Button("Image Viewer");
        VBox root = new VBox(lblTitle, btnProgressBar, btnImageViewer);

        root.setSpacing(10);
        root.setPadding(new Insets(10));

        lblTitle.setFont(new Font(20));
        lblTitle.setMaxWidth(Double.MAX_VALUE);
        lblTitle.setAlignment(Pos.CENTER);

        Font font = new Font(16);
        btnProgressBar.setFont(font);
        btnImageViewer.setFont(font);
        btnProgressBar.setMaxWidth(Double.MAX_VALUE);
        btnImageViewer.setMaxWidth(Double.MAX_VALUE);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(400);
        
        /* Setting Event Listeners */
        
        btnProgressBar.setOnAction(event -> showProgressBarStage());
        btnImageViewer.setOnAction(event -> showImageViewerStage());
    }

    private void showProgressBarStage() {
        if (stgProgressBar != null) return;

        stgProgressBar = new Stage();
        stgProgressBar.setTitle("Progress Bar Demo");
        progressBarScene();
        stgProgressBar.show();
        stgProgressBar.centerOnScreen();

        /* Setting Event Listeners */

        stgProgressBar.setOnCloseRequest(event -> stgProgressBar = null);
    }

    private void progressBarScene(){
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        HBox hBox = new HBox(btnStart, btnStop);

        ProgressBar prg = new ProgressBar(0);
        Label lblPercentage = new Label("0%");
        VBox root = new VBox(hBox, prg, lblPercentage);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Font font = new Font(16);
        btnStart.setFont(font);
        btnStop.setFont(font);

        lblPercentage.setFont(font);

        prg.setMaxWidth(Double.MAX_VALUE);

        stgProgressBar.setScene(new Scene(root));
        stgProgressBar.setMinWidth(300);
        stgProgressBar.setWidth(600);
    }

    private void showImageViewerStage() {
        if (stgImageViewer !=null) return;

        stgImageViewer = new Stage();
        stgImageViewer.setTitle("Image Viewer Demo");
        stgImageViewer.show();
        stgImageViewer.centerOnScreen();

        /* Setting Event Listeners */

        stgImageViewer.setOnCloseRequest(event -> stgImageViewer = null);
    }
}
