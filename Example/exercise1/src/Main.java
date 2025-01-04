import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Quản lí Hóa Đơn");
            System.out.println("------------------------------------");
            System.out.println("1. Thêm sách");
            System.out.println("2. Sửa sách");
            System.out.println("3. Xếp sách theo năm");
            System.out.println("4. Tìm sách");
            System.out.println("5. Chuẩn hóa tên sách");
            System.out.println("6. Thoát!");
            System.out.println("Nhập lựa chọn của bạn: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    manager.addBook();
                    break;
                case 2:
                    manager.editBook();
                    break;
                case 3:
                    manager.SortBookListByYear();
                    break;
                case 4:
                    manager.SearchBook();
                    break;
                case 5:
                    manager.StandardizeBook();
                    break;
                case 6:
                    System.out.println("Thoát Chương trình.....");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    }