package level3;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
        double num1, num2, result = 0;
        char op;
        System.out.println("계산기 프로그램 시작");

        while(true) {
            System.out.println("=======================================");
            System.out.print("첫번째 숫자를 입력하세요: ");
            num1 = scanner.nextDouble();
            if (num1 < 0) {
                System.out.println("Error: 0 이상의 숫자를 입력받아야 합니다.");
                continue;
            }

            System.out.print("두번째 숫자를 입력하세요: ");
            num2 = scanner.nextDouble();
            if (num2 < 0) {
                System.out.println("Error: 0 이상의 숫자를 입력받아야 합니다.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            op = scanner.next().charAt(0);

            try {
                result = calculator.calculate(num1, num2, op);
                System.out.println("실행 결과: " + result);

                while (true) {
                    System.out.print("\n해당 연산 결과를 저장하겠습니까? (y/n): ");
                    String ch = scanner.next();
                    if (ch.equals("y")) {
                        calculator.setResult(result);
                        break;
                    } else if (ch.equals("n")) {
                        break;
                    } else {
                        System.out.print("잘못된 입력입니다.");
                    }
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: 나눗셈의 경우 0으로 나눌 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: 잘못된 사칙연산 기호입니다.");
            }

            while (true) {
                System.out.print("\n결과값을 조회(1) / 맨 처음의 결과값 삭제(2) / 다음으로 이동(3): ");
                String ch = scanner.next();

                if (ch.equals("1")) {
                    if (calculator.isResultListEmpty()) {
                        System.out.println("결과값이 저장되어 있지 않습니다.");
                    }

                    System.out.print("모든 결과값(1) / 최근 결과값(2) / 특정 수보다 큰 결과값(3): ");
                    ch = scanner.next();

                    if (ch.equals("1")) {
                        List<Double> resultList = calculator.getAllResults();
                        System.out.println("resultList: " + resultList);
                    } else if (ch.equals("2")) {
                        System.out.println("recent result: " + calculator.getResult());
                    } else if (ch.equals("3")) {
                        System.out.print("기준 값을 입력하세요: ");
                        double standardNum = scanner.nextDouble();

                        List<Double> filteredResultList = calculator.searchGreater(standardNum);

                        if (filteredResultList.isEmpty()) {
                            System.out.println(standardNum + "보다 큰 수를 찾을 수 없습니다.");
                        } else {
                            System.out.println("filteredResultList: " + filteredResultList);
                        }
                    }else {
                        System.out.print("잘못된 입력입니다.");
                    }
                } else if (ch.equals("2")) {
                    calculator.removeResult();
                } else if (ch.equals("3")) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

            System.out.print("\n더 계산하시겠습니까? (exit 입력 시 종료): ");
            scanner.nextLine();
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }
        }

        System.out.println("계산기 프로그램을 종료합니다.");
    }
}
