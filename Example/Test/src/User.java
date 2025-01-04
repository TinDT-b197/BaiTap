
import java.util.ArrayList;
import java.util.List;

public class User implements UserInterface {
    private String Id;
    private String Name;
    private String Sex;
    private String Birth;
    private String Grade;
    private String Student_ID;
    private ArrayList<Book> BookBorrowedList;

    public User() {}

    public User(String Id, String Name, String Sex, String Birth, String Grade, String Student_ID) {
        this.Id = Id;
        this.Name = Name;
        this.Sex = Sex;
        this.Birth = Birth;
        this.Grade = Grade;
        this.Student_ID = Student_ID;
        this.BookBorrowedList = new ArrayList<>();
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getStudent_ID() {
        return Student_ID;
    }
    public boolean coTheMuon() {
        return BookBorrowedList.size() < 5;
    }
    public void BorrowBook(Book book) {
        BookBorrowedList.add(book);
    }
    public void ReturnBook(Book book) {
        BookBorrowedList.remove(book);
    }
    public Book SearchBook(Book book){

        return book;
    }

    @Override
    public List<Book> ListBookBorrowed() {
        return BookBorrowedList;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }
    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birth='" + Birth + '\'' +
                ", Grade='" + Grade + '\'' +
                ", Student_ID='" + Student_ID + '\'' +
                '}';
    }

}
