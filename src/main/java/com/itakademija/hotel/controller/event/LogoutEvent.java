package com.itakademija.hotel.controller.event;

import com.itakademija.hotel.controller.Controller;
import com.itakademija.hotel.gui.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogoutEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Controller controller = Controller.instance();
        Stage stage = controller.getStage();

        LoginView loginView = new LoginView();
        controller.setLoginView(loginView);

        Scene scene = new Scene(loginView, 650, 180);
        stage.setTitle("Hotel Management");
        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.setScene(scene);


        controller.clearOnLogout();
    }
}
