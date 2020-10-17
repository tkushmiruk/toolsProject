package ua.taras.kushmyruk.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.service.CalculatorService;
import ua.taras.kushmyruk.validators.CalculatorValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    CalculatorValidator calculatorValidator;

    public CalculatorServiceImpl(CalculatorValidator calculatorValidator) {
        this.calculatorValidator = calculatorValidator;
    }

    @Override
    public Integer calculate(String formula) {
        String[] numbers = spliter(formula);
        if (!calculatorValidator.inputFormulaValidate(formula)) {
            return null;
        }
        if (!calculatorValidator.correctArrayLength(numbers.length)) {
            return null;
        }
        List<Integer> numbersList = new ArrayList<>();
        List<String> symbolsList = new ArrayList<>();
        List<Integer> resultsList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                numbersList.add(Integer.parseInt(numbers[i]));
            } else if (i % 2 == 0) {
                numbersList.add(Integer.parseInt(numbers[i]));
            } else {
                symbolsList.add(numbers[i]);
            }
        }

        for (int i = 0; i < symbolsList.size(); i++) {
            if (symbolsList.get(i).equals("*") || symbolsList.get(i).equals("/")) {
                System.out.println("for cycle");
                System.out.println(numbersList.get(i));
                System.out.println(numbersList.get(i + 1));
                numbersList.add(i, mathMethodFirstPriority
                        (numbersList.get(i), numbersList.get(i + 1), symbolsList.get(i)));
                numbersList.remove(i+ 1);
                numbersList.remove(i + 1);
                symbolsList.remove(i);
                i--;
            }
        }
        System.out.println(numbersList.size());
        System.out.println(symbolsList.size());
        int result = numbersList.get(0);
        System.out.println(result);
        symbolsList = deleteFirstPrioritySymbols(symbolsList);
        for (int i = 0; i < symbolsList.size(); i++) {
            System.out.println( "for " + result);
            result = mathMethodSecondPriority(result, numbersList.get(i+1), symbolsList.get(i));
        }

        return result;

    }

    public int plusing(int one, int two) {
        return one + two;
    }

    public int minus(int one, int two) {
        return one - two;
    }

    public int multiplying(int one, int two) {
        return one * two;
    }

    public int diviation(int one, int two) {
        return one / two;
    }

    public String[] spliter(String formula) {
        String modifiedString = "";
        for (int i = 0; i < formula.length(); i++) {
            char symbol = formula.charAt(i);
            if (symbol == ' ' && formula.charAt(i + 1) == ' ') {
                continue;
            }
            modifiedString += symbol;
        }
        return modifiedString.split(" ");
    }

    public Integer mathMethodFirstPriority(int one, int two, String symbol) {
        if (symbol.equals("*")) {
            return multiplying(one, two);
        }
        if (symbol.equals("/")) {
            return diviation(one, two);
        }
        return null;
    }

    public Integer mathMethodSecondPriority(int one, int two, String symbol) {
        if (symbol.equals("+")) {
            return plusing(one, two);
        }
        if (symbol.equals("-")) {
            return minus(one, two);
        }
        return null;
    }
    public List<String> deleteFirstPrioritySymbols(List<String> symbolsList){
        for(int i = 0; i< symbolsList.size(); i++){
            if(symbolsList.get(i).equals("*") && symbolsList.get(i).equals("/")){
                symbolsList.remove(i);
                i--;
            }
        }
        return symbolsList;

    }


}
