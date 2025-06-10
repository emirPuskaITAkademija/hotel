package com.itakademija.hotel.gui.admin.user;

import com.itakademija.hotel.business.user.User;
import com.itakademija.hotel.business.user.UserDao;
import com.itakademija.hotel.business.user.privilege.Privilege;
import com.itakademija.hotel.business.user.privilege.PrivilegeDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class UserAdminPanel extends VBox {

    private final Label titleLable = new Label("Administracija korisnika");
    private final TableView<User> userTableView = new TableView<>();
    private List<User> users;

    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final TextField nameTextField = new TextField();
    private final TextField surnameTextField = new TextField();
    private final ChoiceBox<Privilege> privilegeChoiceBox = new ChoiceBox<>();

    private final Button addUserButton = new Button("Add User");
    private final Button editUserButton = new Button("Edit User");
    private final Button deleteUserButton = new Button("Delete User");

    public UserAdminPanel() {
        titleLable.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        this.users = new UserDao().findAll();
        initTableView();
        getChildren().addAll(titleLable, userTableView, getForm());
    }

    private void initTableView() {
        TableColumn<User, String> usernameColumn = new TableColumn<>("Korisničko Ime");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Ime");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Prezime");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<User, Privilege> privilegeColumn = new TableColumn<>("Role");
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<>("privilege"));

        userTableView.setItems(FXCollections.observableList(users));
        userTableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, privilegeColumn);
    }

    private HBox getForm() {
        HBox form = new HBox();
        form.setSpacing(3);
        usernameTextField.setPromptText("Username..");
        passwordField.setPromptText("Password..");
        nameTextField.setPromptText("Name..");
        surnameTextField.setPromptText("Surname..");
        List<Privilege> privileges = new PrivilegeDao().findAll();
        privilegeChoiceBox.setItems(FXCollections.observableList(privileges));
        privilegeChoiceBox.getSelectionModel().select(0);
        addUserButton.setOnAction(this::onAddUserClick);
        deleteUserButton.setOnAction(this::onDeleteButtonClick);
        form
                .getChildren()
                .addAll(usernameTextField, passwordField, nameTextField, surnameTextField, privilegeChoiceBox, addUserButton, deleteUserButton);
        return form;
    }

    private void onAddUserClick(ActionEvent event) {
        User user = new User();
        user.setUsername(usernameTextField.getText());
        user.setPassword(passwordField.getText());
        user.setName(nameTextField.getText());
        user.setSurname(surnameTextField.getText());
        user.setPrivilege(privilegeChoiceBox.getSelectionModel().getSelectedItem());
        UserDao userDao = new UserDao();
        userDao.save(user);
        clearInputFields();
        reload();
    }

    private void onDeleteButtonClick(ActionEvent actionEvent) {
        User user = userTableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            UserDao userDao = new UserDao();
            userDao.delete(user);
            clearInputFields();
            reload();
        }
    }

    private void clearInputFields() {
        usernameTextField.clear();
        passwordField.clear();
        nameTextField.clear();
        surnameTextField.clear();
        privilegeChoiceBox.getSelectionModel().select(0);
    }

    private void reload() {
        this.users = new UserDao().findAll();
        userTableView.setItems(FXCollections.observableList(users));
    }

}
