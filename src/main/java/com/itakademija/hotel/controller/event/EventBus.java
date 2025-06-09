package com.itakademija.hotel.controller.event;

public class EventBus {
    private final LoginEvent loginEvent = new LoginEvent();
    private final LogoutEvent logoutEvent = new LogoutEvent();
    private final CancelEvent cancelEvent = new CancelEvent();

    public EventBus() {
    }

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }


    public LogoutEvent getLogoutEvent() {
        return logoutEvent;
    }

    public CancelEvent getCancelEvent() {
        return cancelEvent;
    }
}
