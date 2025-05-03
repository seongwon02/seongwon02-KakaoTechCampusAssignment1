package level1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num1, num2, result = 0;
        char op;
        String input;

        System.out.println("계산기 프로그램 시작");
        while (true)
        {
            System.out.println("=======================================");
            System.out.print("첫번째 숫자를 입력하세요: ");

            num1 = scanner.nextInt();

            if (num1 < 0) {
                System.out.println("Error: 0 이상의 숫자를 입력받아야 합니다.");
                continue;
            }

            System.out.print("두번째 숫자를 입력하세요: ");

            num2 = scanner.nextInt();

            if (num2 < 0) {
                System.out.println("Error: 0 이상의 숫자를 입력받아야 합니다.");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            op = scanner.next().charAt(0);

            switch (op) {
                case '+':
                    result = num1 + num2;
                    System.out.println("실행 결과: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("실행 결과: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("실행 결과: " + result);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: 나눗셈의 경우 0으로 나눌 수 없습니다.");
                        break;
                    }

                    result = num1 / num2;
                    System.out.println("실행 결과: " + result);
                    break;
                default:
                    System.out.println("Error: 잘못된 사칙연산 기호입니다.");
            }

            System.out.print("\n더 계산하시겠습니까? (exit 입력 시 종료): ");
            scanner.nextLine();
            input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }


        }

        System.out.println("계산기 프로그램을 종료합니다.");
    }
}
