package ua.taras.kushmyruk.validators;

import org.springframework.stereotype.Component;

@Component
public class CalculatorValidator {
    public boolean inputFormulaValidate(String formula) {
        char[] symbols = formula.toCharArray();
        int trueCount = 0;
        for (int i = 0; i < symbols.length; i++) {
            trueCount += numberValidate(symbols[i]);
            trueCount += symbolValidate(symbols[i]);
        }
        if (trueCount == symbols.length) {
            return true;
        }

        return false;
    }

    public int numberValidate(char symbol) {
        char[] correctSymbol = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
        boolean isCorrect = false;
        for (int i = 0; i < correctSymbol.length; i++) {
            if (correctSymbol[i] == symbol) {
                isCorrect = true;
                break;
            }
        }
        if (isCorrect) {
            return 1;
        }
        return 0;
    }

    public int symbolValidate(char symbol) {
        char[] correctSymbol = {'+', '-', '*', '/'};
        boolean isCorrect = false;
        for (int i = 0; i < correctSymbol.length; i++) {
            if (correctSymbol[i] == symbol) {
                isCorrect = true;
                break;
            }
        }
        if (isCorrect) {
            return 1;
        }
        return 0;
    }

    public boolean correctArrayLength(int arrayLength) {
        arrayLength -= 1;
        arrayLength %= 2;
        if (arrayLength == 0) {
            return true;
        }
        return false;

    }


}
