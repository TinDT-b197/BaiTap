import java.util.List;

public interface UserInterface {
    public void BorrowBook(Book book);
    public void ReturnBook(Book book);
    public Book SearchBook(Book book);
    public List<Book> ListBookBorrowed();
}
