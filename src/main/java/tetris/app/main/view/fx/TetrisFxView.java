package tetris.app.main.view.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tetris.app.main.basis.entity.Color;
import tetris.app.main.basis.service.TetrisService;
import tetris.app.main.basis.service.TetrisServiceImpl;
import tetris.app.main.command.handler.CommandHandler;

import java.util.Arrays;

/**
 * @author pollra
 * @description TetrisFxView
 * @since 2020.04.04
 **********************************************************************************************************************/
public class TetrisFxView extends Application {

    private static boolean gameRunning = true;
    private static int[][] gameBoard = new int[24][12];
    private static TetrisService tetrisService = new TetrisServiceImpl();
    private static CommandHandler commandHandler = new CommandHandler(tetrisService);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/tetris.fxml"));
        BorderPane pane = new BorderPane();
        pane.setCenter(parent);

        primaryStage.setWidth(550);
        primaryStage.setHeight(720);

        Scene scene = new Scene(pane);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (gameRunning) {
                Platform.runLater(()->{
                    scene.setRoot(updateMap(commandHandler.command(e).clone()));
                });
            }
        });

        Thread thread = new Thread(() -> {
            while (gameRunning) {
                Platform.runLater(()->{
                    int[][] downResult = tetrisService.downMove();
                    print(downResult);
                    scene.setRoot(updateMap(downResult));
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
            }
        });
        thread.setDaemon(true);
        thread.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void print(int[][] downResult) {
        for (int i = 0; i < downResult.length; i++) {
            System.out.println(Arrays.toString(downResult[i]));
        }
    }

    public GridPane updateMap(int[][] arr){
        GridPane gridPane = new GridPane();

        Button button;
        StringBuffer colorString = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                button = new Button();
                button.setPrefSize(30, 30);
                button.setDisable(true);
                colorString.append(getColor(arr[i][j]));
                button.setStyle(colorString.toString());
                gridPane.add(button, j, i, 1, 1);
                colorString.delete(0, colorString.length());
            }
        }

        return gridPane;
    }

    public String getColor(int colorNumber){
        final String BACKGROUND_COLOR = "-fx-background-color: #";
//        System.out.print("colorNumber: "+ colorNumber);
        switch (colorNumber){
            case -2:
            case -1:
                return BACKGROUND_COLOR+ Color.BLOCK.getCode()+";";
            case 1:
                return BACKGROUND_COLOR+ Color.RED.getCode()+";";
            case 2:
                return BACKGROUND_COLOR+ Color.ORANGE.getCode()+";";
            case 3:
                return BACKGROUND_COLOR+ Color.YELLOW.getCode()+";";
            case 4:
                return BACKGROUND_COLOR+ Color.GREEN.getCode()+";";
            case 5:
                return BACKGROUND_COLOR+ Color.BLUE.getCode()+";";
            case 6:
                return BACKGROUND_COLOR+ Color.PURPLE.getCode()+";";
            case 7:
                return BACKGROUND_COLOR+ Color.SKY.getCode()+";";
            default:
                return BACKGROUND_COLOR+ Color.WHITE.getCode()+";";
        }
    }
}
