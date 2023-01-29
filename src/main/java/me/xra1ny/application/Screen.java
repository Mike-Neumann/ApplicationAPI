package me.xra1ny.application;

import javax.swing.*;
import java.awt.event.KeyListener;

public abstract class Screen extends JPanel implements MouseListener, KeyListener {
    public abstract void onEnable();
    public abstract void onDisable();
}
