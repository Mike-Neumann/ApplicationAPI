package me.xra1ny.application;

import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

public interface MouseListener extends java.awt.event.MouseListener {
    @Override
    default void mouseClicked(MouseEvent e) {
        mouseClick(e);
    }
    void mouseClick(@NotNull MouseEvent e);

    @Override
    default void mousePressed(MouseEvent e) {
        mousePress(e);
    }
    void mousePress(@NotNull MouseEvent e);

    @Override
    default void mouseReleased(MouseEvent e) {
        mouseRelease(e);
    }
    void mouseRelease(@NotNull MouseEvent e);

    @Override
    default void mouseExited(MouseEvent e) {
        mouseEnter(e);
    }
    void mouseEnter(@NotNull MouseEvent e);

    @Override
    default void mouseEntered(MouseEvent e) {
        mouseExit(e);
    }
    void mouseExit(@NotNull MouseEvent e);
}
