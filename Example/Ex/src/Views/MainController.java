package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    MainViews mainViews;
    public MainController(MainViews mainViews) {
        this.mainViews = mainViews;

        //events
        mainViews.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainViews.getClearbutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainViews.getTextArea().setText(" ");
            }
        });
    }
}
