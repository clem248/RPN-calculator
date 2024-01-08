public class Model {
    private Viewer view;
    private String temp;
    private String actionValue;
    private String result;
    private String operatorForEqual;
    private boolean clearAfterEquals;
    private boolean equalsButtonClicked;
   
   
   
   
    RPN rpn = new RPN();

    public Model(Viewer view) {
        this.view = view;
        temp = "";
        actionValue = "1";
        result = "";
        operatorForEqual = "";
        clearAfterEquals = false;
        equalsButtonClicked = false;
    }

    public String getLastNumberAndOperator(String expression) {
        int len = expression.length();
        int index = len - 1;
        char lastOperator = ' ';
        for (int i = index; i >= 0; i--) {
            lastOperator = expression.charAt(index);
            index--;
            if (lastOperator == '+' || lastOperator == '-' || lastOperator == '*' || lastOperator == '/') break;
        }
        char lastChar = expression.charAt(index);
        index = len - 1;
        StringBuilder number = new StringBuilder();
        while (index >= 0 && (lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/')) {
            number.insert(0, lastChar);
            index--;
            if (index >= 0) {
                lastChar = expression.charAt(index);
            }
        }
        if (number.length() > 0) {
            return lastOperator + expression.substring(index + 1);
        } else {
            return "";
        }
    }

    public void doAction(String command) {
        if (clearAfterEquals) {
            view.cCommand("");
            if (!command.equals("Equals_Command")) {
                temp = "";
                actionValue = "";
                result = "";
                equalsButtonClicked = false;
            }

            clearAfterEquals = false;
        }

        if (command.equals("One")) {
            temp = temp + 1;
            result = result + 1;
        } else if (command.equals("Two")) {
            temp = temp + 2;
            result = result + 2;
        } else if (command.equals("Three")) {
            temp = temp + 3;
            result = result + 3;
        } else if (command.equals("Four")) {
            temp = temp + 4;
            result = result + 4;
        } else if (command.equals("Five")) {
            temp = temp + 5;
            result = result + 5;
        } else if (command.equals("Six")) {
            temp = temp + 6;
            result = result + 6;
        } else if (command.equals("Seven")) {
            temp = temp + 7;
            result = result + 7;
        } else if (command.equals("Eight")) {
            temp = temp + 8;
            result = result + 8;
        } else if (command.equals("Nine")) {
            temp = temp + 9;
            result = result + 9;
        } else if (command.equals("Zero")) {
            temp = temp + 0;
            result = result + 0;
        } else if (command.equals("Plus_Command")) {
            actionValue = "+";
            result = result + actionValue;
            view.updatelittleTextField(result);
            operatorForEqual = "";
            temp = "";
        } else if (command.equals("Minus_Command")) {
            actionValue = "-";
            result = result + actionValue;
            view.updatelittleTextField(result);
            operatorForEqual = "";
            temp = "";
        } else if (command.equals("Mult_Command")) {
            actionValue = "*";
            result = result + actionValue;
            view.updatelittleTextField(result);
            operatorForEqual = "";
            temp = "";
        } else if (command.equals("Dot_Command")) {

            if (temp.isEmpty()) {
                temp = "0.";
            } else if (!temp.contains(".")) {
                temp = temp + ".";
            }
            if (result.isEmpty()) result = "0";
            actionValue = ".";
            result = result + actionValue;
            view.updatelittleTextField(result);

        } else if (command.equals("Div_Command")) {
            actionValue = "/";
            result = result + actionValue;
            view.updatelittleTextField(result);
            operatorForEqual = "";
            temp = "";
        } else if (command.equals("C_Command")) {
            result = "";
            operatorForEqual = "";
            temp = "";
            view.cCommand("");
        } else if (command.equals("Del_Command")) {
            String stringWithoutLastCharacter = result.substring(0, result.length() - 1);
            result = stringWithoutLastCharacter;
            temp = result;
        } else if (command.equals("Equals_Command")) {
            actionValue = "0";
            if (result.equals("")) {
                result = temp + operatorForEqual;
            }
            if (operatorForEqual.equals("")) {
                operatorForEqual = getLastNumberAndOperator(result);
            }
            Double answer = rpn.evaluatePostfix(rpn.infixToPostfix(result));
            temp = String.valueOf(answer).replaceAll("\\.0*$", "");
            result = "";
            equalsButtonClicked = true;
            clearAfterEquals = true;
        }
        result = result.replaceAll("(^|[^0-9.])[-+*/%]", "");
        view.updateText(temp);
        view.updatelittleTextField(result);
    }
}
