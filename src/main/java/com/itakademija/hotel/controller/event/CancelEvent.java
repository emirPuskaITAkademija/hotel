package com.itakademija.hotel.controller.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CancelEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
