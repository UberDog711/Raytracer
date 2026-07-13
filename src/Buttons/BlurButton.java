package Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlurButton extends JButton implements ActionListener {
    public BlurButton(String name) {
        super(name);             // calls the super class (JButton) constructor
        addActionListener(this);       // adds this object (itself) as its own action listener
    }

    public void actionPerformed(ActionEvent e) {
    }

}