import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String id;
    private String bookName;
    private String author;
    private String yearOfPublication;

    public Book(String id, String bookName, String author, String yearOfPublication) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
    public Book(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                '}';
    }
    public static List<Book> searchBooks(List<Book> books, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return new ArrayList<>();
        }
        return books.stream()
                .filter(book -> book.getBookName().toLowerCase().contains(keyword.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    public String standardizeName(String Name) {
        String[] words = Name.trim().split("\\s+");
        StringBuilder standardize = new StringBuilder();
        for (String word : words) {
            standardize.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return standardize.toString().trim();
    }
}
