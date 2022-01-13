public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node rootNode;
    BinarySearchTree(){
        rootNode = null;
    }

    void deleteDataInTree(int no) {
        if(rootNode != null){
            rootNode = deleteDataInTree(rootNode, no);
        }else{
            System.out.println("Ağaç Boş");
        }
    }
    Node deleteDataInTree(Node node, int no)  {
        if (node == null){
            System.out.println("Silmek Istediğniz Eleman Ağaçta Yok");
            return node;
        }
        if (no < node.data)
            node.left = deleteDataInTree(node.left, no);
        else if (no > node.data)
            node.right = deleteDataInTree(node.right, no);
        else  {
            if (node.left == null){
                System.out.println("Silme İşlemi Başarılı");
                return node.right;
            }
            else if (node.right == null){
                System.out.println("Silme İşlemi Başarılı");
                return node.left;
            }
            node.data = successor(node.right);
            node.right = deleteDataInTree(node.right, node.data);
        }
        return node;
    }
    int successor(Node node)  {
        int succ = node.data;
        while (node.left != null)  {
            succ = node.left.data;
            node = node.left;
        }
        return succ;
    }

    boolean isElementInTree(Node node, int no){
        boolean condition = false;

        if (node != null){
            if(no == node.data){
                condition = true;
            }
            isElementInTree(node.left,no);
            isElementInTree(node.right,no);
        }
        return condition;
    }

    void addDataInTree(int no) {
        rootNode = addDataInTree(rootNode, no);
    }
    Node addDataInTree(Node node, int no) {
        if (isElementInTree(node,no)){
            System.out.println("Numara Zaten Kayıtlı.");
        }else{
            if (node == null) {
                node = new Node(no);
                System.out.println("Ekleme Işlemi Başarılı");
                return node;
            }
            if (no < node.data){
                node.left = addDataInTree(node.left, no);
            }
            else if (no > node.data){
                node.right = addDataInTree(node.right, no);
            }
        }
        return node;
    }

    void printTree(){
        if (rootNode == null){
            System.out.print("Ağaç Boş");
        }else{
            printTree(rootNode);
        }
    }
    void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

}
