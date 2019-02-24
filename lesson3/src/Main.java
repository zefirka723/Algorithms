import stack.Stack;
import stack.StackImpl;

public class Main {

    public static void main(String[] args) {

        /* Создать программу, которая переворачивает
        вводимые строки (читает справа налево). */

        String str = "123456789";

        Stack<Character> stack = new StackImpl<>(str.length());
        // Накидываем строку в стэк
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Читаем
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }


    }

}
