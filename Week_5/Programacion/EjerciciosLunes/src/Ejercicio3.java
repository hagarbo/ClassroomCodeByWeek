public class Ejercicio3 {

    static boolean compruebaFecha(int day, int month, int year) {
        if (day < 1 || day > 31)
            return false;
        if (month < 1 || month > 12)
            return false;
        if (year < 1900 || year > 2100)
            return false;
        if ((day == 31) && (month == 4 || month == 6 || month == 9 || month == 11))
            return false;
        if ((month == 2) && (day > 28 && day < 31))
            return false;
        return true;
    }

    public static void main(String[] args) {
        int day = Utilities.readIntegerFromTerminal();
        int month = Utilities.readIntegerFromTerminal();
        int year = Utilities.readIntegerFromTerminal();

        if (compruebaFecha(day, month, year))
            System.out.printf("La fecha es valida: %d/%d/%d\n", day, month, year);
        else
            System.out.println("La fecha es invalida");
    }

}
