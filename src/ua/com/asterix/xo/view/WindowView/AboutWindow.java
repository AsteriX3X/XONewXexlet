package ua.com.asterix.xo.view.WindowView;

import javax.swing.*;

public class AboutWindow extends JFrame {
    public AboutWindow() {
        showWindow();
    }

    private void showWindow() {
        setTitle("О программе");
        setSize(300, 200);

        setVisible(true);
    }
}
