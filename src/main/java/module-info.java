module es.ieslosmoncecillos.componenetes_plazaraul {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmoncecillos.componenetes_plazaraul to javafx.fxml;
    exports es.ieslosmoncecillos.componenetes_plazaraul;
}