import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean condition = true;
        int no;
        BinarySearchTree tree = new BinarySearchTree();
        while (condition){
            Scanner scan = new Scanner(System.in);
            System.out.print("\n");
            System.out.println("""
                    1-Numara Ekleme
                    2-Numara Silme
                    3-Numara Listeleme
                    4-Programdan Çık""");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int secim = scan.nextInt();
            System.out.print("\n");
            switch (secim) {
                case 1 -> {
                    //Numara Ekleme
                    System.out.print("Eklemek İstediğiniz Öğrencinin Numarası: ");
                    no = scan.nextInt();
                    tree.addDataInTree(no);
                }
                case 2 -> {
                    //Numara Silme
                    System.out.print("\nSilmek İstediğiniz Öğrencinin Numarası: ");
                    no = scan.nextInt();
                    tree.deleteDataInTree(no);
                }
                case 3 ->{
                    // Numara Listeleme (inOrder)
                    tree.printTree();
                    System.out.print("\n");
                }
                case 4 -> condition = false;

                default -> System.out.println("Yanlış Seçim Yaptınız.");
            }
        }
    }

}