package datastructures;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JavaStack {

    static Map<Character, Character> mapChar = new TreeMap<>();

    static {
        mapChar.put(']', '[');
        mapChar.put('}', '{');
        mapChar.put(')', '(');
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            LinkedList<Character> stack = new LinkedList<>();
            for (char c : input.toCharArray()) {
                if (!stack.isEmpty() &&
                        (mapChar.containsKey(c) && stack.getFirst().equals(mapChar.get(c))))
                    stack.removeFirst();
                else
                    stack.addFirst(c);
            }

            System.out.println(stack.isEmpty());
        }

        sc.close();

    }
}
