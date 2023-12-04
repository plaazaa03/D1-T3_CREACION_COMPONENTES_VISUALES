package es.ieslosmontecillos.componentes_plazaraul;



import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CampoTextoNumerico extends TextField {

    final static Label label = new Label();

    public CampoTextoNumerico() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoNumerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    final TextField sum = new TextField() {
        @Override
        public void replaceText(int start, int end, String text) {
            if (!text.matches("[a-z, A-Z]")) {
                super.replaceText(start, end, text);
            }
            label.setText("Enter a numeric value");
        }
        @Override
        public void replaceSelection(String text) {
            if (!text.matches("[a-z, A-Z]")) {
                super.replaceSelection(text);
            }
        }
    };

}

