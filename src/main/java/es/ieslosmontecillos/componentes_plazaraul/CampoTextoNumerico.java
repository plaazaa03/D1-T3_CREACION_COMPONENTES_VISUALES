package es.ieslosmontecillos.componentes_plazaraul;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import java.io.IOException;


public class CampoTextoNumerico extends TextField {
    @FXML
    private TextField textField;

    public CampoTextoNumerico() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoNumerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
            }
        });
    }
    @Override
    public void replaceText(int start, int end, String text) {
        if (!text.matches("[a-zA-Z]")) {
            super.replaceText(start, end, text);
        }
    }
    @Override
    public void replaceSelection(String text) {
        if (!text.matches("[a-zA-Z]")) {
            super.replaceSelection(text);
        }
    }
}