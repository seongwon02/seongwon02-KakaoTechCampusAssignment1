package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator <T extends Number> {

    private final List<Double> resultList = new ArrayList<>();

    public double calculate(T num1, T num2, char op) {
        double result = 0;

        switch (op) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return result;
    }

    private double add(T num1, T num2) {
        return (Double)num1 + (Double)num2;
    }

    private double subtract(T num1, T num2) {
        return (Double)num1 - (Double)num2;
    }

    private double multiply(T num1, T num2) {
        return (Double)num1 * (Double)num2;
    }

    private double divide(T num1, T num2) {
        if ((Double)num2 == 0)
            throw new ArithmeticException();
        return (Double)num1 / (Double)num2;
    }

    public double getResult() {
        int idx = this.resultList.size();
        return (Double)this.resultList.get(idx - 1);
    }

    public List<Double> getAllResults() {
        return this.resultList;
    }

    public void setResult(T result) {
        this.resultList.add((Double)result);
        System.out.println("계산 값을 저장하였습니다.");
    }

    public boolean isResultListEmpty() {
        return this.resultList.isEmpty();
    }

    public void removeResult() {
        if (!this.resultList.isEmpty()) {
            double num = resultList.remove(0);
            System.out.println(num + "을 결과값 리스트에서 삭제합니다.");
        } else {
            System.out.println("삭제할 연산 결과가 존재하지 않습니다.");
        }
    }

    public List<Double> searchGreater(T num) {
        return resultList.stream().filter((x) -> x > (Double)num).collect(Collectors.toList());
    }
}
