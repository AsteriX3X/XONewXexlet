package ua.com.asterix.xo.view;

import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.trash.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class WindowView extends JFrame implements IView {
    private Field field = new Field();
    private JButton[][] buttons = new JButton[Field.FIELD_SIZE][Field.FIELD_SIZE];
    private JPanel settings = new JPanel();
    private JPanel gameField = new JPanel();
    private JPanel statusBar = new JPanel();
//    private String gameName = new Game().getGameName();

    public WindowView(){
        start();
    }

    public void start() {
//        setTitle(gameName);
        setTitle("Тест");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createMenuBar();

        settings.add(new JButton("Игрок против игрока"));
        settings.add(new JButton("Игрок против компьютера"));
        settings.add(new JButton("Компьютер против компьютера"));

        showField(field);

        add(settings, BorderLayout.NORTH);
        add(new MyPanel(), BorderLayout.SOUTH);
        add(gameField);
        setVisible(true);
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Меню");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.setToolTipText("Меню");

        JMenuItem about = new JMenuItem("О программе");
        menu.setMnemonic(KeyEvent.VK_O);
        about.setToolTipText("О программе");
        about.addActionListener((ActionEvent event) -> {
            AboutWindow aboutWindow = new AboutWindow();
        } );

        JMenuItem exit = new JMenuItem("Выход");
        menu.setMnemonic(KeyEvent.VK_E);
        exit.setToolTipText("Выход");
        exit.addActionListener((ActionEvent event) -> System.exit(0));

        JMenuItem reload = new JMenuItem("Рестарт");
        reload.setMnemonic(KeyEvent.VK_R);
        reload.setToolTipText("Рестарт игры");

        menuBar.add(menu);
        menu.add(reload);
        menu.add(about);
        menu.add(exit);

        setJMenuBar(menuBar);
    }

    @Override
    public void getGameType() {

    }

    @Override
    public void showRules() {

    }

    @Override
    public void showField(Field field) {
//        gameField.setLayout(new GridLayout(Field.FIELD_SIZE, Field.FIELD_SIZE_Y));
//
//        for (int x = 0; x < Field.FIELD_SIZE; x++)
//            for (int y = 0; y < Field.FIELD_SIZE_Y; y++) {
//                JButton jButton = new JButton(String.valueOf(field.getFigure(new Point(x, y))));
//                buttons[x][y] = jButton;
//                gameField.add(jButton);
//                int finalX = x;
//                int finalY = y;
//                jButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//                        System.out.printf("Нажата кнопка [%d-%C]\n", finalX + 1, finalY + 'А');
//
//                        MoveController.doShoot(new Point(finalX, finalY));
//
//                        jButton.setText("X");
//                    }
//                });
//            }
    }

    @Override
    public void getShoot() {

    }

    @Override
    public void showInvalidPoint() {

    }

    @Override
    public void showPointOccupied() {

    }

    @Override
    public void showWinner(String winnerName) {

    }

    @Override
    public void showGameOver() {

    }
}
