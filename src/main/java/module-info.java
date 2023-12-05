module es.ieslosmontecillos.componentes_plazaraul {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_plazaraul to javafx.fxml;
    exports es.ieslosmontecillos.componentes_plazaraul;
}