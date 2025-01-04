package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViews {
    JButton OKbutton;
    JButton clearbutton;
    JFrame mainFrame;
    TextArea textArea;
    FlowLayout flowLayout;
    JPanel buttonPanel;
    BorderLayout borderLayout;
    JButton exitButton;

    public MainViews() {
        mainFrame = new JFrame();
        mainFrame.setSize(1280, 720);
        mainFrame.setVisible(true);
        textArea = new TextArea();
        mainFrame.add(textArea, BorderLayout.CENTER);
        mainFrame.setTitle("Tài Xỉu MD5");

        OKbutton = new JButton("OK");
        clearbutton = new JButton("Clear");
        exitButton = new JButton("Exit");
        buttonPanel = new JPanel();
        borderLayout = new BorderLayout();
        flowLayout = new FlowLayout();
        buttonPanel.setLayout(flowLayout);
        buttonPanel.add(OKbutton);
        buttonPanel.add(clearbutton);
        buttonPanel.add(exitButton);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);


    }
    public void setOKbutton(JButton okbutton) {
        this.OKbutton = okbutton;
    }
    public void setCancelbutton(JButton clearbutton) {
        this.clearbutton = clearbutton;
    }
    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }
    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }
    public JButton getOKbutton() {
        return OKbutton;
    }
    public JButton getClearbutton() {
        return clearbutton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
    public TextArea getTextArea() {
        return textArea;
    }

}