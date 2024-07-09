package com.example.calculatorfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private TextField display ;
    Calculator calculator = null;

    public static void main(String[] args) {
        HelloApplication helloApplication = new HelloApplication();
        launch(args);
    }

//    private void performOperation(String operator) {
//         firstNumb = Double.parseDouble(display.getText());
//         operator = op ;
//        display.clear();
//
//    }

    @Override
    public void start(Stage stage) throws IOException {
        calculator = new Calculator();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));

        display = new TextField("0");
        display.setStyle("-fx-font-size: 18pt;");
        GridPane.setConstraints(display, 0, 0, 4, 1);

        Button button1 = createNumberButton("1");
        Button button2 = createNumberButton("2");
        Button button3 = createNumberButton("3");
        Button button4 = createNumberButton("4");
        Button button5 = createNumberButton("5");
        Button button6 = createNumberButton("6");
        Button button7 = createNumberButton("7");
        Button button8 = createNumberButton("8");
        Button button9 = createNumberButton("9");
        Button button0 = createNumberButton("0");

        Button buttonAdd = createButton("+" );
        Button buttonSubtract = createButton("-");
        Button buttonMultiply = createButton("*");
        Button buttonDivide = createButton("/");
        Button buttonEquals = new Button("=");
        buttonEquals.setStyle("-fx-background-color: #77b2b0; -fx-text-fill: white; -fx-font-size: 30;");
        buttonEquals.setOnAction(e -> calculateResult());

        Button buttonClear = new Button("C");
        buttonClear.setStyle("-fx-background-color: #77b2b0; -fx-text-fill: white; -fx-font-size: 30;");
        buttonClear.setOnAction(e -> clearDisplay());

        HBox row1 = new HBox(5, button7, button8, button9, buttonDivide);
        HBox row2 = new HBox(5, button4, button5, button6, buttonMultiply);
        HBox row3 = new HBox(5, button1, button2, button3, buttonSubtract);
        HBox row4 = new HBox(5, button0, buttonClear, buttonEquals, buttonAdd);

        GridPane.setConstraints(row1, 0, 1);
        GridPane.setConstraints(row2, 0, 2);
        GridPane.setConstraints(row3, 0, 3);
        GridPane.setConstraints(row4, 0, 4);

        root.getChildren().addAll(display, row1, row2, row3, row4);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setOnAction(actionEvent -> {
            if (text == "=") {
                calculateResult();
            }
            if (calculator.getFirstNumb() != null) {
                display.setText(display.getText() + text);
                calculator.setOperation(text);
            }
        });
        button.setStyle("-fx-background-color: #77b2b0; -fx-text-fill: white; -fx-font-size: 30;");
        return button;
    }

    private Button createNumberButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #77b2b0; -fx-text-fill: white; -fx-font-size: 30;");

        button.setOnAction(e -> {
            if (display.getText().equals("0")) {
                display.setText(text);
            } else {
                display.setText(display.getText() + text);
            }
            if (calculator.getOperation() != null) {
                String allText = display.getText();
                String[] parts = allText.split("\\D", 2);

                String secondPart = parts[1];

                calculator.setSecondNumb(Double.parseDouble(secondPart));
                calculator.getSecondNumb();
            } else {
                calculator.setFirstNumb(Double.parseDouble(display.getText()));
                calculator.getFirstNumb();
            }
        });
        return button;
    }


    private void calculateResult() {
        if (!display.getText().isEmpty()) {
            double result = calculator.calculate();
            display.setText(String.valueOf(result));
        }
        calculator.setFirstNumb(null);
        calculator.setOperation(null);
        calculator.setSecondNumb(null);
       // clearDisplay();
    }

    private void clearDisplay() {
        display.setText("0");
        Calculator calculator = new Calculator(); // Reset calculator
    }

    public void test(Calculator calculator) {
        System.out.println("sdvdsvdsv");
    }
}



