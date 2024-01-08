public class RPN {
  
  
  
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StackRealize<Character> stack = new StackRealize<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numBuffer = new StringBuilder();
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    numBuffer.append(infix.charAt(i));
                    i++;
                }
                postfix.append(numBuffer.toString()).append(" ");
                i--;
            } else if (c == ' ') {
                continue;
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public double evaluatePostfix(String postfix) {
        StackRealize<Double> stack = new StackRealize<>();
        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(token.charAt(0), operand1, operand2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("ZeroError");
                }
            default:
                throw new IllegalArgumentException("Invalid operator:" + operator);
        }
    }
}


