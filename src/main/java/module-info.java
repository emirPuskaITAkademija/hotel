module hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires jakarta.persistence;
    requires java.sql;
    requires java.sql.rowset;
    requires org.controlsfx.controls;

    opens com.itakademija.hotel to javafx.base;


    exports com.itakademija.hotel;
}