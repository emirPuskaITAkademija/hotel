package com.itakademija.hotel;

import javafx.application.Application;
import javafx.stage.Stage;

public class HotelManagementApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hotel Management");
        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
