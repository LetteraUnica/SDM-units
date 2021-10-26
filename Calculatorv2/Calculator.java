import enums.Operations;
import exceptions.InputException;
import exceptions.OperationException;
import manager.OutputManager;

public class Calculator {
    double result;
    String display_string;
    Operations ops;
    final OutputManager outputManager;

    public Calculator(OutputManager display) {
        this.outputManager = display;
        reset_display();
        ops = Operations.SUM;
    }

    private void digit_pressed(char digit) {
        display_string += digit;
        outputManager.display(display_string);
    }

    private void reset_display() {
        display_string = "";
    }

    private void update_result() throws OperationException {
        switch (ops) {
            case SUM -> result = result + Double.parseDouble(display_string);
            case SUBTRACTION -> result = result - Double.parseDouble(display_string);
            case MULTIPLICATION -> result = result * Double.parseDouble(display_string);
            case DIVISION -> result = result / Double.parseDouble(display_string);
            default -> throw new OperationException("Operation not supported");
        }
    }

    private void plus_pressed(char button) throws OperationException {
        update_result();
        ops = Operations.SUM;
        outputManager.display(button);
        reset_display();
    }

    private void minus_pressed(char button) throws OperationException {
        update_result();
        ops = Operations.SUBTRACTION;
        outputManager.display(button);
        reset_display();
    }

    private void multiply_pressed(char button) throws OperationException {
        update_result();
        ops = Operations.MULTIPLICATION;
        outputManager.display(button);
        reset_display();
    }

    private void divide_pressed(char button) throws OperationException {
        update_result();
        ops = Operations.DIVISION;
        outputManager.display(button);
        reset_display();
    }

    private void equal_pressed(char button) throws OperationException {
        outputManager.display(button);
        update_result();
        outputManager.display(result);
    }

    public void button_pressed(char button) throws InputException {
        if (Character.isDigit(button)) {
            digit_pressed(button);
        }
        else {
            switch (button) {
                case '+' -> {
                    try {
                        plus_pressed(button);
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
                case '-' -> {
                    try {
                        minus_pressed(button);
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
                case '*' -> {
                    try {
                        multiply_pressed(button);
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
                case '/' -> {
                    try {
                        divide_pressed(button);
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
                case '=' -> {
                    try {
                        equal_pressed(button);
                    } catch (OperationException e) {
                        e.printStackTrace();
                    }
                }
                default -> throw new InputException("Unexpected value: " + button);
            }
        }
    }
}