
import java.util.Scanner;

public class BinaryTree {

    // Inner Node class
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // 🔹 Method to insert elements interactively
    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of left of " + node.value + ": ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of right of " + node.value + ": ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // 🔹 Simple Preorder display
    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "   ");
        display(node.right, indent + "   ");
    }

    // 🔹 Pretty Display (sideways tree view)
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    // ✅ FIXED: added `void` return type
    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        // Print right subtree first (appears on top)
        prettyDisplay(node.right, level + 1);

        // Print current node with indentation
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t\t");
            }
            System.out.println("|-------> " + node.value);
        } else {
            System.out.println(node.value);
        }

        // Print left subtree (appears below)
        prettyDisplay(node.left, level + 1);
    }
}
