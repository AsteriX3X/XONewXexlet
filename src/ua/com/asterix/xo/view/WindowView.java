package ua.com.asterix.xo.view;

import ua.com.asterix.xo.controller.MoveController;
import ua.com.asterix.xo.model.Field;
import ua.com.asterix.xo.model.Point;
import ua.com.asterix.xo.trash.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowView extends JFrame implements IView {
    private Field field = new Field();
    private JButton[][] buttons = new JButton[Field.FIELD_SIZE_X][Field.FIELD_SIZE_Y];
    private JPanel settings = new JPanel();
    private JPanel gameField = new JPanel();

    public void start() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        showGameName();

        settings.add(new JButton("Игрок против игрока"));
        settings.add(new JButton("Игрок против компьютера"));
        settings.add(new JButton("Компьютер против компьютера"));

        showField();

        add(settings, BorderLayout.NORTH);
        add(new MyPanel(), BorderLayout.SOUTH);
        add(gameField);
        setVisible(true);
    }

    @Override
    public void showGameName() {
        setTitle("XO Game v4 + GUI by -=AsteriX=-");
    }

    @Override
    public void showField() {
        gameField.setLayout(new GridLayout(Field.FIELD_SIZE_X, Field.FIELD_SIZE_Y));

        for (int i = 0; i < Field.FIELD_SIZE_X; i++)
            for (int j = 0; j < Field.FIELD_SIZE_Y; j++) {
                JButton jButton = new JButton(String.valueOf(field.getFigure(new Point(j, i))));
                buttons[i][j] = jButton;
                gameField.add(jButton);
                int finalI = i;
                int finalJ = j;
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.printf("Нажата кнопка [%d-%C]\n", finalI + 1, finalJ + 'А');

                        MoveController.doShoot(new Point(finalI, finalJ));

                        jButton.setText("X");
                    }
                });
            }
    }

    @Override
    public void showPointOccupied() {

    }

    @Override
    public void showWinner() {

    }

    @Override
    public void showGameOver() {

    }
}
