package com.itakademija.hotel.gui.login;

import com.itakademija.hotel.controller.Controller;
import com.itakademija.hotel.controller.event.CancelEvent;
import com.itakademija.hotel.controller.event.EventBus;
import com.itakademija.hotel.controller.event.LoginEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane {

    private final Label usernameLabel = new Label("Korisničko ime:");
    private final Label passwordLabel = new Label("Lozinka:");
    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Prijava");
    private final Button cancelButton = new Button("Odustani");
    //ovdje nikakvog teksta nema..nju ćemo puniti dinamički na klik prijava
    private final Label messageLabel = new Label("");

    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        setAlignment(Pos.CENTER);

        add(usernameLabel, 0, 0);
        add(usernameTextField, 1, 0);

        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.getChildren().addAll(loginButton, cancelButton);
        add(flowPane, 1, 2);

        add(messageLabel, 1, 3);

        EventBus eventBus = Controller.instance().getEventBus();
        LoginEvent loginEvent = eventBus.getLoginEvent();
        loginButton.setOnAction(loginEvent);
        CancelEvent cancelEvent = eventBus.getCancelEvent();
        cancelButton.setOnAction(cancelEvent);
    }

    public String getUsernameFromInput(){
        return usernameTextField.getText();
    }

    public String getPasswordFromInput(){
        return passwordField.getText();
    }

    public void setMessageToMessageLabel(String message){
        this.messageLabel.setText(message);
    }
}
