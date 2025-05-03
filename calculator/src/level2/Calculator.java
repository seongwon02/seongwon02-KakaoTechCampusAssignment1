package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> resultList = new ArrayList<>();

    public int calculate(int num1, int num2, char op) {
        int result = 0;

        switch (op) {
            case '+':
                result = this.add(num1, num2);
                break;
            case '-':
                result = this.subtract(num1, num2);
                break;
            case '*':
                result = this.multiply(num1, num2);
                break;
            case '/':
                result = this.divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return result;
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int getResult() {
        int idx = this.resultList.size();
        return (Integer)this.resultList.get(idx - 1);
    }

    public List<Integer> getAllResults() {
        return this.resultList;
    }

    public void setResult(int result) {
        this.resultList.add(result);
        System.out.println("계산 값을 저장하였습니다.");
    }

    public boolean isResultListEmpty() {
        return this.resultList.isEmpty();
    }

    public void removeResult() {
        if (!this.resultList.isEmpty()) {
            int num = (Integer)this.resultList.remove(0);
            System.out.println(num + "을 결과값 리스트에서 삭제합니다.");
        } else {
            System.out.println("삭제할 연산 결과가 존재하지 않습니다.");
        }

    }
}
