package es.ieslosmoncecillos.componenetes_plazaraul;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CampoTextoBoton extends HBox implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private Button btnControl;

    // Constructor
    public CampoTextoBoton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoBoton.fxml"));
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

    private ObjectProperty<EventHandler<ActionEvent>> OnAction = new ObjectPropertyBase<EventHandler<ActionEvent>>(){
        @Override protected void invalidated(){
            setEventHandler(ActionEvent.ACTION, get());
        }


        @Override
        public Object getBean() {
            return CampoTextoBoton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return OnAction;
    }
    public final void setOnAction(EventHandler<ActionEvent> handler) {
        onActionProperty().set(handler);
    }
    public final EventHandler<ActionEvent> getOnAction() {
        return onActionProperty().get();
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
