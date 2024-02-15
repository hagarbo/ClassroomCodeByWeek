import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {

        Stack<Character> pila = new Stack<>();
        Deque<Character> otraPila = new ArrayDeque<>();

        char c = ' ';
        while (c != '\n') {
            c = (char) System.in.read();
            pila.push(c);
            otraPila.push(c);
        }

        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
        System.out.println();

        while (!otraPila.isEmpty()) {
            System.out.print(otraPila.pop());
        }
        System.out.println();
    }
}
