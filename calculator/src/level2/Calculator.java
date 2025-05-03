package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> resultList;

    public Calculator() {
        this.resultList = new ArrayList<>();
    }

    public int calculate(int num1, int num2, char op) {

        int result = 0;

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
        int idx = resultList.size();
        return resultList.get(idx - 1);
    }

    public List<Integer> getAllResults() {
        return resultList;
    }

    public void setResult(int result) {
        resultList.add(result);
        System.out.println("계산 값을 저장하였습니다.");
    }

    public boolean isResultListEmpty(){
        return resultList.isEmpty();
    }

    public void removeResult(){
        if (!resultList.isEmpty()){
            int num = resultList.remove(0);
            System.out.println(num + "을 결과값 리스트에서 삭제합니다.");
        } else {
            System.out.println("삭제할 연산 결과가 존재하지 않습니다.");
        }
    }
}


