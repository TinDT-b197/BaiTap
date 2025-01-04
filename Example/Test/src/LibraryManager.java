
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    Library library = new Library();
    public void AddLibrary() {
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        String Name = sc.nextLine();
        library.setId(ID);
        library.setName(Name);
        System.out.println("Thư viện đã được tạo!");
    }
    public void showInfoLibrary() {
        System.out.println("Thông tin thư viện");
        System.out.printf("| %-4s | %-10s | %-4s | %-4s |\n", "ID", "Tên thư viện", "Số lượng sách", "Người dùng đang có");
        System.out.println("-------------------------------------------------------------------");

        System.out.printf("| %-4s | %-10s | %-10d | %-10d |\n",
                library.getId(),library.getName(),library.getBookList().size(),library.getUserList().size());
    }
    public void AddUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id người dùng: ");
        String IdUser = sc.nextLine();
        System.out.println("Nhập tên người dùng: ");
        String UserName = sc.nextLine();
        System.out.println("NHập giới tính: ");
        String UserSex = sc.nextLine();
        System.out.println("NHập ngày sinh: ");
        String UserBirth = sc.nextLine();
        System.out.println("Nhập lớp: ");
        String UserGrade = sc.nextLine();
        System.out.println("Nhập ID Sinh viên: ");
        String StudentID = sc.nextLine();
        User newUser = new User(IdUser,UserName,UserSex,UserBirth,UserGrade,StudentID);
        library.AddUser(newUser);
    }
    public void AddBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("NHập ID Sách: ");
        String IdBook = sc.nextLine();
        System.out.println("Nhập tên sách: ");
        String BookName = sc.nextLine();
        System.out.println("Nhập tên tác giả: ");
        String Author = sc.nextLine();
        System.out.println("Nhập số lượng sách: ");
        int NumberOfBooks = sc.nextInt();
        Book newBook = new Book(IdBook, BookName, Author, NumberOfBooks);
        library.AddBook(newBook);
    }
    public void ShowUsersList(){
        if(library.getUserList().isEmpty()){
            System.out.println("Không có người dùng nào ! ");
            return;
        }
        System.out.println("Danh sách người dùng: ");
        System.out.printf("| %-10s | %-4s | %-10s | %-4s | %-10s |\n", "Name", "ID", "Sex", "StudentID" , "Book Borrowed");
        System.out.println("-------------------------------------------------------------------");
        for(User user : library.getUserList()){
            System.out.printf("| %-10s | %-10s | %-10s | %-10s | \n",
                    user.getName(),user.getId(),user.getSex(),user.getStudent_ID(),user.ListBookBorrowed().size());
        }
    }
    public void ShowBookList(){
        if(library.getBookList().isEmpty()){
            System.out.println("Không có cuốn sách nào !");
            return;
        }
        System.out.println("Danh sách sách đang có:");
        System.out.printf("| %-10s | %-10s | %-10s |\n", "Số lượng sách", "Số lượng sách đã bị mượn", "Số lượng sách còn lại");
        System.out.println("-------------------------------------------------------------------");
        for(Book book : library.getBookList()){
            System.out.printf("| %-10s | %-10s | %-10s |\n",
                    book.getNumberOfBook(),book.getNumberOfBookBorrowed(),(book.getNumberOfBookBorrowed()- book.getNumberOfBook()));
        }
    }
    public void BorrowBook(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sách cần mượn: ");
        String BookName = scanner.nextLine();
        Book BorrowBook = library.SearchBook(BookName);

        if (BorrowBook != null && BorrowBook.BorrowedBook()) {
            user.BorrowBook(BorrowBook);
            System.out.println("Mượn sách thành công!");
        } else {
            System.out.println("Sách không tồn tại hoặc đã hết.");
        }
    }
    public void ReturnBook(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sách cần trả: ");
        String BookName = scanner.nextLine();
        Book ReturnBook = library.SearchBook(BookName);
        if (ReturnBook != null && ReturnBook.ReturnBook()) {
            user.ReturnBook(ReturnBook);
            System.out.println("Trả sách thành công!");
        }else{
            System.out.println("Sách chưa được mượn hoặc không tồn tại!");
        }
    }

    public void showUserSortbyName() {
        List<User> sortedUser = library.getUserList().stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();

        if (sortedUser.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\nList of Patients sorted by Year of Birth:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-20s | %-4s | %-10s | %-10s | %-10s |\n", "Name", "UserID", "Birth", "Sex", "StudentID");
            System.out.println("-------------------------------------------------------------------");
            for (User user : sortedUser) {
                System.out.printf("| %-20s | %-4s | %-10s | %-10s | %-10s |\n",
                        user.getName(),user.getId(),user.getBirth(),user.getSex(),user.getStudent_ID());
            }
            System.out.println("-------------------------------------------------------------------");
        }
    }
    public void showBookSortbyName() {
        List<Book> sortedBooks  = library.getBookList().stream()
                .sorted(Comparator.comparing(Book::getBookName))
                .toList();

        if (sortedBooks.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\nList of Patients sorted by Year of Birth:");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("| %-10s | %-4s | %-10s |\n", "Name", "BookID", "Author");
            System.out.println("-------------------------------------------------------------------");
            for (Book book : sortedBooks) {
                System.out.printf("| %-10s | %-4s | %-10s |\n",
                        book.getBookName(),book.getId(),book.getAuthor());
            }
            System.out.println("-------------------------------------------------------------------");
        }
    }
}
