package com.itakademija.hotel.controller.event;

import com.itakademija.hotel.business.user.User;
import com.itakademija.hotel.business.user.UserDao;
import com.itakademija.hotel.controller.Controller;
import com.itakademija.hotel.gui.admin.AdminView;
import com.itakademija.hotel.gui.employee.EmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class LoginEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Controller controller = Controller.instance();
        String username = controller.getUsernameInput();
        if (username == null || username.isBlank()) {
            controller.setMessageToMessageLabel("Empty username");
        }
        String password = controller.getPasswordInput();
        if (password == null || password.isBlank()) {
            controller.setMessageToMessageLabel("Empty password");
        }
        UserDao userDao = new UserDao();
        User loggedUser = userDao.login(username, password);
        if (loggedUser == null) {
            controller.setMessageToMessageLabel("Neispravna kombinacija korisničkog naloga i šifre");
            return;
        }
        controller.setLoggedUser(loggedUser);
        if (loggedUser.getPrivilege().getName().equals("administrator")) {
            AdminView view = new AdminView();
            controller.setAdminView(view);
            setNewSceneOnStage(view);
        } else {
            EmployeeView view = new EmployeeView();
            controller.setEmployeeView(view);
            setNewSceneOnStage(view);
        }
    }

    private void setNewSceneOnStage(BorderPane view){
        Controller controller = Controller.instance();
        Scene scene = new Scene(view, 650, 300);
        controller.getStage().setScene(scene);
    }
}
