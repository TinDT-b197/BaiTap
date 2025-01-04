import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibraryManager libraryManager = new LibraryManager();

        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            // Display main menu
            System.out.println("<<==== Library Manager ====>>");
            System.out.println("1. Tạo thư viện");
            System.out.println("2. Xem thông tin thư viện");
            System.out.println("3. Thêm người dùng");
            System.out.println("4. Thêm sách");
            System.out.println("5. Tìm người dùng theo tên");
            System.out.println("6. Tìm sách theo tên");
            System.out.println("7. Mượn sách");
            System.out.println("8. Trả sách");
            System.out.println("9. Xem danh sách sách");
            System.out.println("10. Xem danh sách người dùng");
            System.out.println("11. Thoát");

            System.out.print("Select an option: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    libraryManager.AddLibrary();
                    break;
                case 2:
                    libraryManager.showInfoLibrary();
                    break;
                case 3:
                    libraryManager.AddUser();
                    break;
                case 4:
                    libraryManager.AddBook();
                    break;
                case 5:
                    libraryManager.showUserSortbyName();
                    break;
                case 6:
                    libraryManager.showBookSortbyName();
                    break;
                case 7:
                    libraryManager.BorrowBook();
                    break;
                case 8:
                    libraryManager.ReturnBook();
                    break;
                case 9:
                    libraryManager.ShowBookList();
                    break;
                case 10:
                    libraryManager.ShowUsersList();
                    break;
                case 11:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}


