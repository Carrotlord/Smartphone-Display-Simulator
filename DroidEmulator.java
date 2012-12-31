package droidemulator;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * An emulator that simulates a simplified version of a typical
 * Droid Phone running some type of Google Android OS.
 * @author Oliver Chu, UC Berkeley EECS Major.
 */
public class DroidEmulator extends JFrame {
    
    /** Constructs a new emulator. */
    private DroidEmulator() {
        setSize(CONSTANTS.DROID_WINDOW_WIDTH, CONSTANTS.DROID_WINDOW_HEIGHT);
        Dimension widthByHeight = new Dimension(CONSTANTS.DROID_WINDOW_WIDTH,
                                                CONSTANTS.DROID_WINDOW_HEIGHT);
        setPreferredSize(widthByHeight);
        setTitle("Droid Emulator - Android OS X.Y");
        setDefaultCloseOperation(DroidEmulator.EXIT_ON_CLOSE);
        setVisible(false);
        pack();
    }
    
    public static DroidEmulator purchaseAndroidPhone() {
        return new DroidEmulator();
    }
    
    // Turns the phone off. Does not work yet.
    public void turnPhoneOff() {
        /* TODO */
    }
    
    @Override
    public void paint(Graphics paintbrush) {
        customDrawUsingBrush(paintbrush);
        repaint();
    }
    
    /** Draws the android OS loading screen,
     *  complete with a very flashy techno-flicker animation.
     */
    public void customDrawUsingBrush(Graphics paintbrush) {
        /* THERE SHOULD BE MORE CODE HERE!! */
        int w = getWidth();
        int h = getHeight();
        BufferedImage blueBg = new BufferedImage(w, h,
                                   BufferedImage.TYPE_INT_ARGB);
        Graphics2D pencil = (Graphics2D) blueBg.getGraphics();
        pencil.setColor(new Color(65, 105, 225));
        pencil.fillRect(0, 0, w, h);
        pencil.setComposite(AlphaComposite.DstIn);
        paintbrush.drawImage(blueBg, 0, 0, rootPane);
        paintbrush.setColor(Color.WHITE);
        paintbrush.setFont(new Font("Courier New", 0, 48));
        paintbrush.drawString("ANDROID", w / 2 - 102, h / 2);
        paintbrush.setFont(new Font("Courier New", 0, 16));
        paintbrush.drawString("EMULATOR by Oliver Chu", w / 2 - 112,
                              h / 2 + 20);
        repaint();
    }
    
    /** Removes the phone from your pocket so that you can
     *  see it clearly.
     */
    public void takeAndroidPhoneOutOfPocket() {
        if (isVisible()) {
            System.err.println("Your pocket is empty, you dolt!");
        } else {
            setVisible(true);
        }
    }
    
    /** TODO Turns the screen sideways.
     *  Might have unintended side effects.
     */
    public void turnAndroidPhoneSideways() {
        int selfW = getWidth();
        int selfH = getHeight();
        setSize(selfH, selfW);
        setPreferredSize(new Dimension(selfH, selfW));
    }

    /**
     * The main function, which takes in an array of Strings args.
     */
    public static void main(String[] args) {
        DroidEmulator myAndroidPhone = purchaseAndroidPhone();
        myAndroidPhone.takeAndroidPhoneOutOfPocket();
    }
}
