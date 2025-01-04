import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private String Id;
    private String Name;
    private List<Book> BookList;
    private List<User> userList;
    public Library() {
        this.userList = new ArrayList<>();
        this.BookList = new ArrayList<>();
    }
    public Library(String id, String name) {
        Id = id;
        Name = name;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public List<Book> getBookList() {
        return BookList;
    }
    public List<User> getUserList() {
        return userList;
    }

    public void AddBook(Book book) {
        BookList.add(book);
    }
    public void RemoveBook(Book book) {
        BookList.remove(book);
    }
    public void AddUser(User user) {
        userList.add(user);
    }
    public void RemoveUser(User user) {
        userList.remove(user);
    }
    public Book SearchBook(String name) {
        for (Book book : BookList) {
            if(book.getBookName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }
    public void showBookList() {
        for (Book book : BookList) {
            System.out.println(book);
        }
    }
    public void showUserList() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
