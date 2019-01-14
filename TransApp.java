import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;

public class TransApp extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        Rectangle rect1 = new Rectangle(100, 100, 80, 80);
        rect1.setFill(Color.BLUE);
        rect1.setArcWidth(20);
        rect1.setArcHeight(20);
        rect1.setEffect(new Lighting());

        Rectangle rect2 = new Rectangle(100, 300, 80, 80);
        rect2.setFill(Color.BLUE);
        rect2.setArcWidth(20);
        rect2.setArcHeight(20);
        rect2.setEffect(new Lighting());

        Rectangle rect3 = new Rectangle(300, 100, 80, 80);
        rect3.setFill(Color.BLUE);
        rect3.setArcWidth(20);
        rect3.setArcHeight(20);
        rect3.setEffect(new Lighting());

        Rectangle rect4 = new Rectangle(300, 300, 80, 80);
        rect4.setFill(Color.BLUE);
        rect4.setArcWidth(20);
        rect4.setArcHeight(20);
        rect4.setEffect(new Lighting());

        Group root = new Group();
        root.getChildren().addAll(rect1, rect2, rect3, rect4);

        //------  Die verschiedenen Transitionen ------
        RotateTransition transition1 = new RotateTransition();
        transition1.setNode(rect1);
        transition1.setDuration(Duration.seconds(1));
        transition1.setByAngle(235);
        rect1.setOnMouseClicked(e -> transition1.play());

        TranslateTransition transition2 = new TranslateTransition();
        transition2.setNode(rect2);
        transition2.setDuration(Duration.seconds(1));
        transition2.setAutoReverse(true);
        transition2.setCycleCount(2);
        transition2.setByX(100);
        rect2.setOnMouseClicked(e -> transition2.play());

        FadeTransition transition3 = new FadeTransition();
        transition3.setNode(rect3);
        transition3.setDuration(Duration.seconds(1));
        transition3.setAutoReverse(true);
        transition3.setCycleCount(2);
        transition3.setFromValue(1.0);
        transition3.setToValue(0.3);
        rect3.setOnMouseClicked(e -> transition3.play());
        
        FillTransition transition4 = new FillTransition();
        transition4.setShape(rect4);
        transition4.setDuration(Duration.seconds(1));
        //transition4.setAutoReverse(true);
        transition4.setCycleCount(2);
        transition4.setToValue(Color.RED);
        rect4.setOnMouseClicked(e -> transition4.play());
        
        
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transition");
        primaryStage.show();
    }

}
