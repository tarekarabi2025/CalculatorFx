package com.example.calculatorfx;

import javafx.scene.Parent;

public class Calculator extends Parent {
    protected Double firstNumb = Double.valueOf(0);
    String operation = null;
    private Double secondNumb;

    public Double getFirstNumb() {
        System.out.println("firstNumb: " + firstNumb);
        return firstNumb;
    }

    public Calculator setFirstNumb(Double firstNumb) {
        this.firstNumb = firstNumb;
        return this;
    }

    public Double getSecondNumb() {
        System.out.println("secondNumb: " + secondNumb);
        return secondNumb;
    }

    public Calculator setSecondNumb(Double secondNumb) {
        this.secondNumb = secondNumb;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    public double calculate() {
        switch (operation) {
            case "+":
                return firstNumb + secondNumb;

            case "-":
                return firstNumb - secondNumb;
            case "*":
                return firstNumb * secondNumb;
            case "/":
                if (secondNumb != 0) {
                    return firstNumb / secondNumb;
                } else {
                    return Double.NaN; // Handle division by zero
                }
            default:
                return 0;
        }
    }

}
