// JavaFX Farmer Master Page (based on provided image UI)
// Includes all fields shown: Farmer ID, Code, Name, etc.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

public class FarmerMasterPage extends Application {
    TableView<Farmer> table = new TableView<>();
    ObservableList<Farmer> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KAM - FARMER MASTER");

        // Top Fields
        TextField tfId = new TextField(); tfId.setPromptText("Farmer ID");
        TextField tfCode = new TextField(); tfCode.setPromptText("Code");
        TextField tfName = new TextField(); tfName.setPromptText("Name");
        TextField tfPrintName = new TextField(); tfPrintName.setPromptText("Print Name");
        TextField tfOpeningBalance = new TextField(); tfOpeningBalance.setPromptText("Opening Balance");
        ComboBox<String> cbDrCr = new ComboBox<>(FXCollections.observableArrayList("Dr.", "Cr."));

        TextField tfAddress1 = new TextField(); tfAddress1.setPromptText("Address 1");
        TextField tfAddress2 = new TextField(); tfAddress2.setPromptText("Address 2");
        TextField tfVillage = new TextField("Local");
        TextField tfMobile = new TextField(); tfMobile.setPromptText("Mobile Number");
        ComboBox<String> cbType = new ComboBox<>(FXCollections.observableArrayList("Monthly Payment", "Weekly Payment"));
        cbType.setValue("Monthly Payment");

        // Toggle Buttons
        CheckBox cbDeactivate = new CheckBox("Deactivate");
        CheckBox cbMarket = new CheckBox("Market");
        CheckBox cbCycle = new CheckBox("Cycle");

        // Buttons
        Button btnNew = new Button("New");
        Button btnSave = new Button("Save");
        Button btnClose = new Button("Close");

        // Layout for top form
        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(8);
        
        form.add(new Label("Farmer ID:"), 0, 0); form.add(tfId, 1, 0);
        form.add(new Label("Code:"), 2, 0); form.add(tfCode, 3, 0);
        form.add(new Label("Name:"), 0, 1); form.add(tfName, 1, 1);
        form.add(new Label("Print Name:"), 2, 1); form.add(tfPrintName, 3, 1);
        form.add(new Label("Opening Balance:"), 0, 2); form.add(tfOpeningBalance, 1, 2);
        form.add(cbDrCr, 2, 2);
        form.add(cbDeactivate, 3, 2);
        form.add(cbMarket, 3, 3);
        form.add(cbCycle, 3, 4);

        form.add(new Label("Address 1:"), 0, 3); form.add(tfAddress1, 1, 3);
        form.add(new Label("Address 2:"), 0, 4); form.add(tfAddress2, 1, 4);
        form.add(new Label("Village:"), 2, 3); form.add(tfVillage, 3, 3);
        form.add(new Label("Mobile Number:"), 2, 4); form.add(tfMobile, 3, 4);
        form.add(new Label("Type:"), 0, 5); form.add(cbType, 1, 5);

        // Table Columns
        TableColumn<Farmer, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Farmer, String> colCode = new TableColumn<>("Code");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Farmer, String> colName = new TableColumn<>("Farmer");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Farmer, String> colPrintName = new TableColumn<>("Print Name");
        colPrintName.setCellValueFactory(new PropertyValueFactory<>("printName"));

        TableColumn<Farmer, String> colArea = new TableColumn<>("Area");
        colArea.setCellValueFactory(new PropertyValueFactory<>("village"));

        TableColumn<Farmer, String> colBalance = new TableColumn<>("OB");
        colBalance.setCellValueFactory(new PropertyValueFactory<>("openingBalance"));

        table.getColumns().addAll(colId, colCode, colName, colPrintName, colArea, colBalance);
        table.setItems(data);
        table.setPrefHeight(200);

        // Add to VBox
        VBox layout = new VBox(10, form, table, new HBox(10, btnNew, btnSave, btnClose));
        layout.setPadding(new Insets(10));

        // Scene Setup
        Scene scene = new Scene(layout, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Sample Save Action
        btnSave.setOnAction(e -> {
            Farmer f = new Farmer(tfId.getText(), tfCode.getText(), tfName.getText(), tfPrintName.getText(),
                tfVillage.getText(), tfOpeningBalance.getText());
            data.add(f);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Farmer Model Class
    public static class Farmer {
        private String id, code, name, printName, village, openingBalance;

        public Farmer(String id, String code, String name, String printName, String village, String openingBalance) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.printName = printName;
            this.village = village;
            this.openingBalance = openingBalance;
        }

        public String getId() { return id; }
        public String getCode() { return code; }
        public String getName() { return name; }
        public String getPrintName() { return printName; }
        public String getVillage() { return village; }
        public String getOpeningBalance() { return openingBalance; }
    }
}
