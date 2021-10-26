public class Calculator {
    public static void main(String[] args) {
        try {
            double[] inputs = normalizeInputs(args);

            double input = inputs[0];
            for (int i = 1; i < inputs.length; i += 2) {
                double op1 = inputs[i+1];
                switch (args[i]) {
                    case "+":
                        input = input + op1;
                        break;
                    case "-":
                        input = input - op1;
                        break;
                    case "*":
                        input = input * op1;
                        break;
                    case "/":
                        input = input / op1;
                        break;
                }
                System.out.println(input);
            }
        } catch (Exception e) {
            System.out.println("Insert correct number");
        }
    }

    private static double[] normalizeInputs(String[] inputs) throws Exception {
        double[] normalized_inputs = new double[inputs.length];
        for (int i = 0; i < inputs.length; i+=2) {
            try {
                normalized_inputs[i] = Double.parseDouble(inputs[i]);
            } catch (NumberFormatException ex) {
                if (inputs[i].contains(",")) {
                    inputs[i] = inputs[i].replace(',', '.');
                }
                normalized_inputs[i] = Float.valueOf(inputs[i]).doubleValue();
            }
        }

        return normalized_inputs;
    }
}