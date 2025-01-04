public class Book {
    private String Id;
    private String BookName;
    private String Author;
    private int NumberOfBook;
    private int NumberOfBookBorrowed;

    public Book() {}
    public Book(String Id, String BookName, String Author, int NumberOfBook) {
        this.Id = Id;
        this.BookName = BookName;
        this.Author = Author;
        this.NumberOfBook = NumberOfBook;
        this.NumberOfBookBorrowed = 0;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getNumberOfBook() {
        return NumberOfBook;
    }
    public boolean BorrowedBook() {
        if (NumberOfBookBorrowed < NumberOfBook) {
            NumberOfBookBorrowed++;
            return true;
        }
        return false;
    }
    public boolean ReturnBook() {
        if (NumberOfBookBorrowed > 0) {
            NumberOfBookBorrowed--;
            return true;
        }
        return false;
    }

    public void setNumberOfBook(int numberOfBook) {
        NumberOfBook = numberOfBook;
    }

    public int getNumberOfBookBorrowed() {
        return NumberOfBookBorrowed;
    }

    public void setNumberOfBookBorrowed(int numberOfBookBorrowed) {
        NumberOfBookBorrowed = numberOfBookBorrowed;
    }

    @Override
    public String toString() {
        return "Number of books remaining/Number of books: "+ (NumberOfBook- NumberOfBookBorrowed) + "/" + NumberOfBook ;
    }
}
