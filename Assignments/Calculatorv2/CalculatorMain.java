import exceptions.InputException;
import manager.OutputManager;

public class CalculatorMain {

    public static void main(String[] args) {
        OutputManager display = new OutputManager();
        Calculator calculator = new Calculator(display);

        try {
            calculator.button_pressed('5');
            calculator.button_pressed('1');
            calculator.button_pressed('1');

            calculator.button_pressed('-');
            calculator.button_pressed('1');
            calculator.button_pressed('4');

            calculator.button_pressed('*');
            calculator.button_pressed('1');
            calculator.button_pressed('4');

            calculator.button_pressed('=');
        }

        catch (InputException ex) {
            ex.printStackTrace();
        }
    }
}