package com.itakademija.hotel;

import com.itakademija.hotel.business.user.User;
import com.itakademija.hotel.business.user.UserDao;
import com.itakademija.hotel.controller.Controller;
import com.itakademija.hotel.gui.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX GUI
 * <li>1. zero fxml only code base</li>
 * <li>2. fxml </li>
 * <p>
 * <p>
 * JavaFX i Android APP dev su jako slični.
 * <p>
 *
 *     Napraviti ekrane.
 *     Ekrani koje prepoznajemo:
 *     <li>1. LoginScreen </li>
 *     <li>2. AdminScreen </li>
 *     <li>3. EmployeeScreen </li>
 * </p>
 * </p>
 */
public class HotelManagementApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = Controller.instance();
        controller.setStage(stage);

        LoginView loginView = new LoginView();
        controller.setLoginView(loginView);

        Scene scene = new Scene(loginView, 650, 180);
        stage.setTitle("Hotel Management");
        stage.setMinWidth(300);
        stage.setMinHeight(300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
