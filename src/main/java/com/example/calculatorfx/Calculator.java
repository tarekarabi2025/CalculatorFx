package com.example.calculatorfx;

import javafx.scene.Parent;

public class Calculator extends Parent {
    protected double firstNumb=0;
    private double secondNumb;
    String operation ="";



    public double getFirstNumb() {
        return firstNumb;
    }

    public void setFirstNumb(double firstNumb) {
        this.firstNumb = firstNumb;
    }

    public double getSecondNumb() {
        return secondNumb;
    }

    public void setSecondNumb(double secondNumb) {
        this.secondNumb = secondNumb;
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
