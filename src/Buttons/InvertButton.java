package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvertButton extends JButton implements ActionListener {
    public InvertButton(String name) {
        super(name);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    }
}