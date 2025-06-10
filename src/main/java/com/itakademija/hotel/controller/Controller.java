package com.itakademija.hotel.controller;

import com.itakademija.hotel.business.user.User;
import com.itakademija.hotel.controller.event.EventBus;
import com.itakademija.hotel.gui.admin.AdminView;
import com.itakademija.hotel.gui.employee.EmployeeView;
import com.itakademija.hotel.gui.login.LoginView;
import javafx.stage.Stage;

/**
 * SINGLETON
 */
public class Controller {

    private Stage stage;
    private LoginView loginView;
    private AdminView adminView;
    private EmployeeView employeeView;
    private User loggedUser;
    private final EventBus eventBus = new EventBus();

    private Controller() {
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public String getUsernameInput() {
        if (loginView == null) return "";
        return loginView.getUsernameFromInput();
    }

    public String getPasswordInput() {
        if (loginView == null) return "";
        return loginView.getPasswordFromInput();
    }

    public void clearOnLogout(){
        adminView = null;
        employeeView = null;
        loggedUser = null;
    }


    public void setMessageToMessageLabel(String message) {
        if (loginView == null) return;
        loginView.setMessageToMessageLabel(message);
    }

    private static Controller INSTANCE = null;

    public static Controller instance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
}
