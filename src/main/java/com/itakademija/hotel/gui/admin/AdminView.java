package com.itakademija.hotel.gui.admin;

import com.itakademija.hotel.controller.Controller;
import com.itakademija.hotel.controller.event.LogoutEvent;
import com.itakademija.hotel.gui.admin.room.RoomAdminPanel;
import com.itakademija.hotel.gui.admin.user.UserAdminPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AdminView extends BorderPane {

    private final ToggleButton userToggleButton = new ToggleButton("Korisnici");
    private final ToggleButton roomToggleButton = new ToggleButton("Room");
    private final Button logoutButton = new Button("Odjava");

    private  UserAdminPanel userAdminPanel = new UserAdminPanel();
    private  RoomAdminPanel roomAdminPanel = new RoomAdminPanel();

    public AdminView() {
        userToggleButton.setOnAction(this::onUserToggleButtonClick);
        roomToggleButton.setOnAction(this::onRoomToggleButtonClick);

        ToggleGroup toggleGroup = new ToggleGroup();
        userToggleButton.setToggleGroup(toggleGroup);
        roomToggleButton.setToggleGroup(toggleGroup);
        userToggleButton.setSelected(true);

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));
        mainMenu.getChildren().addAll(userToggleButton, roomToggleButton);

        logoutButton.setText("Odjava (" + Controller.instance().getLoggedUser().getName()+")");
        Controller controller = Controller.instance();
        LogoutEvent logoutEvent = controller.getEventBus().getLogoutEvent();
        logoutButton.setOnAction(logoutEvent);
        HBox logoutBox = new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER_RIGHT);
        logoutBox.setPadding(new Insets(10, 10 , 10 , 10));


        GridPane topPane = new GridPane();
        topPane.add(mainMenu, 0, 0);
        topPane.add(logoutBox, 1, 0);

        setTop(topPane);
        setCenter(userAdminPanel);
    }

    private void onUserToggleButtonClick(ActionEvent event){
        userAdminPanel = new UserAdminPanel();
        setCenter(userAdminPanel);
    }

    private void onRoomToggleButtonClick(ActionEvent event){
        roomAdminPanel = new RoomAdminPanel();
        setCenter(roomAdminPanel);
    }
}
