import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        tree.populate(scanner);

        System.out.println("\nNormal Display:\n");
        tree.display();

        System.out.println("\nPretty Tree Display:\n");
        tree.prettyDisplay();
    }
}
