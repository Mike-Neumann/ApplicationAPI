package me.xra1ny.application;

import javax.swing.*;
import java.awt.event.KeyListener;

public abstract class Screen extends JPanel implements MouseListener, KeyListener {
    public Screen() {
        initialise();
    }

    private void initialise() {
        addMouseListener(this);
        addKeyListener(this);
    }

    public abstract void onEnable();
    public abstract void onDisable();
}
