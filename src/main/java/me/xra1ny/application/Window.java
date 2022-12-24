package me.xra1ny.application;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import me.xra1ny.application.annotations.WindowInfo;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;


@Slf4j
public abstract class Window extends JFrame implements MouseListener, KeyListener {
    private String initialTitle = "";
    private Dimension initialSize = new Dimension(640, 480); // Instantiate new Dimension for Size of this Window (480p)

    @Getter(onMethod = @__(@NotNull))
    private Screen currentScreen = new DefaultScreen();
    @Getter(onMethod = @__(@NotNull))
    private Screen lastScreen = new DefaultScreen();

    public Window() {
        final WindowInfo info = getClass().getDeclaredAnnotation(WindowInfo.class);

        if(info == null) {
            log.warn("No WindowInfo Annotation provided! Using default Settings...");
        }else {
            log.info("WindowInfo Annotation detected! Using Settings in Annotation...");
            initialTitle = info.title();
            initialSize = new Dimension(info.width(), info.height());
        }

        initialise();
    }

    /** Initialises this Windows default Mainframe Settings and applies those specified in the Window Annotation if provided */
    private void initialise() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(initialSize);
        setResizable(false);
        setLocationRelativeTo(null); // Center this Window

        setTitle(initialTitle);

        setVisible(true);

        addMouseListener(this);
        addKeyListener(this);
    }

    /** Enabled and show the specified Screen on this Window */
    public void show(@NotNull Screen screen) {
        if(screen == currentScreen) {
            log.info("Attempted to switch to the same Screen!");
        }else {
            log.info("Switching to new Screen " + screen);

            lastScreen = currentScreen;
            currentScreen = screen;

            remove(lastScreen);
            lastScreen.setEnabled(false); // Disable last Screen
            lastScreen.updateUI();
            lastScreen.revalidate();

            currentScreen.setEnabled(true); // Enable current Screen
            add(currentScreen);
            currentScreen.updateUI();
            currentScreen.revalidate();
        }
    }
}
