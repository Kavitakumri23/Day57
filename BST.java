
    import java.util.Scanner;

    public class BST {

        // Node class
        private static class Node {
            int value;
            Node left;
            Node right;

            Node(int value) {
                this.value = value;
            }
        }

        private Node root;

        // 🔹 Insert a new node
        public void insert(int value) {
            root = insert(root, value);
        }

        private Node insert(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            }

            return node;
        }

        // 🔹 Search for a value
        public boolean search(int value) {
            return search(root, value);
        }

        private boolean search(Node node, int value) {
            if (node == null) return false;

            if (node.value == value) return true;
            if (value < node.value) return search(node.left, value);
            else return search(node.right, value);
        }

        // 🔹 Inorder traversal (sorted order)
        public void inorder() {
            System.out.print("Inorder Traversal: ");
            inorder(root);
            System.out.println();
        }

        private void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }

        // 🔹 Pretty Display (sideways)
        public void prettyDisplay() {
            prettyDisplay(root, 0);
        }

        private void prettyDisplay(Node node, int level) {
            if (node == null) {
                return;
            }
            prettyDisplay(node.right, level + 1);
            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("\t\t");
                }
                System.out.println("|-------> " + node.value);
            } else {
                System.out.println(node.value);
            }
            prettyDisplay(node.left, level + 1);
        }

        public static void main(String[] args) {
            BST bst = new BST();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number of nodes: ");
            int n = scanner.nextInt();

            System.out.println("Enter " + n + " values:");
            for (int i = 0; i < n; i++) {
                bst.insert(scanner.nextInt());
            }

            System.out.println("\nPretty Display of BST:");
            bst.prettyDisplay();

            bst.inorder();

            System.out.print("\nEnter a value to search: ");
            int key = scanner.nextInt();
            System.out.println(bst.search(key) ? "Found ✅" : "Not Found ❌");
        }
    }

