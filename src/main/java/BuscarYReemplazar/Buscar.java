package dad.BuscarYReemplazar;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Buscar extends Application {

    //modelo de datos

    private StringProperty buscar = new SimpleStringProperty();
    private StringProperty remplazar = new SimpleStringProperty();


    @Override
    public void start(Stage stage) throws Exception {

        TextField buscarText = new TextField();
        buscarText.setPromptText("Buscar");

        TextField remplazarText = new TextField();
        remplazarText.setPromptText("remplazar");


        RadioButton mayuscula = new RadioButton("Mayúscula y minúsculas");
        RadioButton expresion = new RadioButton("Expresión regular");
        RadioButton buscar = new RadioButton("Buscar hacia atrás");
        RadioButton resaltar = new RadioButton("Resaltar resultados");

        ToggleGroup opcionGroup = new ToggleGroup();
        opcionGroup.getToggles().setAll(mayuscula, expresion, buscar, resaltar);

        Button buscarButton = new Button("Buscar");
        buscarButton.setDefaultButton(true);
        buscarButton.setOnAction(this::onBuscarAction);

        Button reemplazarButton = new Button("Reemplazar");
        reemplazarButton.setOnAction(this::onReemplazarAction);

        Button reemplazartodoButton = new Button("Reemplazar todo ");
        reemplazartodoButton.setOnAction(this::onReemplazartodoAction);

        Button cerrarButton = new Button("Cerrar");
        cerrarButton.setOnAction(this::onCerrarAction);

        Button ayudaButton = new Button("Ayuda");
        ayudaButton.setOnAction(this::onAyudaAction);

        VBox rightPanel = new VBox(5, buscarButton, reemplazarButton, reemplazartodoButton, cerrarButton, ayudaButton);
        rightPanel.setPadding(new Insets(5));

        GridPane checkboxPanel = new GridPane();
        checkboxPanel.setVgap(5);
        checkboxPanel.setHgap(5);
        checkboxPanel.addRow(0, mayuscula, expresion);
        checkboxPanel.addRow(1, buscar, resaltar);


        GridPane root = new GridPane();

        //root.setGridLinesVisible(true);
        root.setVgap(5);
        root.setHgap(5);
        root.setPadding(new Insets(5));
        root.addRow(0, new Label("Buscar: "), buscarText, rightPanel);
        root.addRow(1, new Label("Remplazar con: "), remplazarText);
        root.add(checkboxPanel, 1, 2);
        GridPane.setRowSpan(rightPanel, 3);


        ColumnConstraints[] cols = {
                new ColumnConstraints(),
                new ColumnConstraints(),
                new ColumnConstraints(),
        };
        root.getColumnConstraints().setAll(cols);

        //restricciones c1
        cols[1].setHgrow(Priority.ALWAYS);
        cols[1].setFillWidth(true);


        stage.setTitle("Buscar y reemplazar ");
        stage.setScene(new Scene(root, 600, 200));
        stage.show();

    }

    private void onAyudaAction(ActionEvent actionEvent) {
    }

    private void onCerrarAction(ActionEvent actionEvent) {
    }

    private void onReemplazartodoAction(ActionEvent actionEvent) {
    }


    private void onReemplazarAction(ActionEvent actionEvent) {
    }

    private void onBuscarAction(ActionEvent actionEvent) {
    }
}
