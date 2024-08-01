public class TestPascal {
    public static void main (String[] args) {
        ManagePascal.printTest();
        ManagePascal.calculate(3);
    }
}

class ManagePascal {
    public static void calculate (int length) {
        System.out.println(length);
    }

    public static void printTest () {
        System.out.println(":3");
    }
}
