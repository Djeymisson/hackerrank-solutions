package strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class UsernameValidator {
    public static final String regularExpression = "(^\\p{Alpha}\\w{7,29})(?![^a-zA-Z0-9_])";
}

public class ValidUsernameRegex {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/_input_files/usernames-tests"));
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
        scan.close();
    }
}
