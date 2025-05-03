package level3;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return this.operator;
    }

    public static OperatorType findOperator(char operator) {
        for(OperatorType op : values()) {
            if (op.getOperator() == operator) {
                return op;
            }
        }

        throw new IllegalArgumentException();
    }
}
