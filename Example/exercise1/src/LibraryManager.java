import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibraryManager {
    private List<Book> bookList;

    public LibraryManager() {
        this.bookList = new ArrayList<>();
    }

    public void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the book: ");
        String id = sc.nextLine();
        System.out.println("Enter the name of the book: ");
        String name = sc.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = sc.nextLine();
        System.out.println("Enter the year of publication of the book: ");
        String year = sc.nextLine();
        Book newBook = new Book(id,name, author, year);
        bookList.add(newBook);
    }
    public void editBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the book to be edited: ");
        String id = sc.nextLine();
    }


    public void SortBookListByYear() {
        List<Book> sortedBooks = bookList.stream()
                .sorted(Comparator.comparing(Book::getYearOfPublication))
                .toList();

        if (sortedBooks.isEmpty()) {
            System.out.println("No patients found.");
        }
    }
    public void SearchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập từ khóa: ");
        String keyword = sc.nextLine();
        List<Book> foundBooks = Book.searchBooks(bookList, keyword);
        if (foundBooks.isEmpty()) {
            System.out.println("Không tìm thấy sách nào với từ khóa: " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            foundBooks.forEach(System.out::println);
        }
    }
    public void StandardizeBook(){
        for (Book book : bookList) {
            book.setBookName(book.standardizeName(book.getBookName()));
        }
        System.out.println("Đã chuẩn hóa tên sách.");
    }
}