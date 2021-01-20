import java.util.Scanner;

public class FirstBank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter name: ");
        String name = scan.nextLine();
        System.out.println("Please enter ID-Number: ");
        String id = scan.nextLine();

        Account accountOfUser = new Account(name, id);
        accountOfUser.showMenu();

    }
}
