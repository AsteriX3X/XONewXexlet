package ua.com.asterix.xo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

public class MyPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JCheckBox chk = new JCheckBox("flag", false);
    private JButton bt = new JButton("Ok");
    // логическая группа кнопок
    private ButtonGroup group = new ButtonGroup();

    public MyPanel() {
        setLayout(new BorderLayout());

        // -------------------------------------
        // создание радиокнопок
        JPanel jp = new JPanel(new GridLayout(0, 1)); // панель для кнопок
        JRadioButton rb = null; // временная переменная для радиокнопок

        rb = new JRadioButton("radio1");
        group.add(rb); // добавляем ее в группу
        jp.add(rb); // добавляем ее в панель

        rb = new JRadioButton("radio2", true); // выбранная по умолчанию
        group.add(rb);
        jp.add(rb);

        rb = new JRadioButton("radio3");
        group.add(rb);
        jp.add(rb);

        // ------------------------------------
        // добавление кнопок на панель
        add(chk, BorderLayout.NORTH);
        add(jp);
        add(bt, BorderLayout.SOUTH);

        // -------------------------------------
        // добавление обработчиков действия
        bt.addActionListener(this);
        chk.addActionListener(this);
        for (Enumeration<AbstractButton> e = group.getElements(); e
                .hasMoreElements(); ) {
            e.nextElement().addActionListener(this);
        }

        // ------------------------------
        // добавляем быструю клавишу
        chk.setMnemonic(KeyEvent.VK_F); // ALT+F
        bt.setMnemonic(KeyEvent.VK_ENTER); // ALT+Enter
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton a;
        System.out.println(e.getActionCommand());

        // если Ок то выводим доп. инфу по другим кнопкам
        if (e.getSource().equals(bt)) {
            System.out.println("flag state: " + chk.isSelected());
            for (Enumeration<AbstractButton> rb = group.getElements(); rb
                    .hasMoreElements(); ) {
                a = rb.nextElement();
                System.out.println("radio " + a.getActionCommand() + "state: "
                        + a.isSelected());
            }
        }
    }
}
