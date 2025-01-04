import Views.MainController;
import Views.MainViews;

public class Main {
    public static void main(String[] args) {
        MainViews views = new MainViews();
        MainController controller = new MainController(views);
    }
}