public class RecuentoNegativosTest {
    public static void main(String[] args) {
        // Caso de prueba 1: Número negativo
        testPrintNumberNegative();
        // Caso de prueba 2: Número positivo
        testPrintNumberPositive();
        // Caso de prueba 3: Número cero
        testPrintNumberZero();
        // Caso de prueba 4: Salida del programa principal
        testMainProgramExit();
    }

    private static void testPrintNumberNegative() {
        // Arrange
        int num = -5;
        int count = 3;
        // Act
        System.out.println("Resultado de la prueba:");
        RecuentoNegativos.printNumberInfo(num, count);
    }

    private static void testPrintNumberPositive() {
        // Arrange
        int num = 8;
        int count = 2;
        // Act
        System.out.println("Resultado de la prueba:");
        RecuentoNegativos.printNumberInfo(num, count);
    }

    private static void testPrintNumberZero() {
        // Arrange
        int num = 0;
        int count = 4;
        // Act
        System.out.println("Resultado de la prueba:");
        RecuentoNegativos.printNumberInfo(num, count);
    }

    private static void testMainProgramExit() {
        // Arrange
        // Establece un flujo de entrada simulado con -999 como primera entrada
        String simulatedInput = "-999\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));
        // Act
        System.out.println("Resultado de la prueba:");
        RecuentoNegativos.main(new String[] {});
    }
}
