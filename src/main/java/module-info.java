module hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires jakarta.persistence;
    requires java.sql;
    requires java.sql.rowset;
    requires org.controlsfx.controls;
    requires static org.hibernate.orm.core;
    requires java.desktop;


    opens com.itakademija.hotel to javafx.base, javafx.fxml;
    opens com.itakademija.hotel.business;
    opens com.itakademija.hotel.business.user;
    opens com.itakademija.hotel.business.user.privilege;
    opens com.itakademija.hotel.business.reservation;
    opens com.itakademija.hotel.business.reservation.guest;
    opens com.itakademija.hotel.business.room;
    opens com.itakademija.hotel.business.country;
    opens com.itakademija.hotel.business.country.town;
    opens com.itakademija.hotel.business.country.town.address;


    exports com.itakademija.hotel;
}