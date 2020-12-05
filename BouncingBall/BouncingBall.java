package BouncingBall;


import java.awt.*;
import java.awt.image.BufferStrategy;

public class BouncingBall {
    int x = 200;
    int y = 200;
    int radius = 50;
    int tempX, tempY;
    int maxX, maxY;

    private static final DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[]{
            new DisplayMode(1920, 1080, 32, 30),
            new DisplayMode(1920, 1080, 16, 30),
            new DisplayMode(1920, 1080, 8, 30)
    };

    Frame mainFrame;

    public void move() {
        tempY = (int) (tempY + 1) % (int) (2 * (maxY - radius));
        y += (int) Math.pow(-1, Math.floor(tempY / (maxY - radius)));

        tempX = (int) (tempX + 1) % (int) (2 * (maxX - radius));
        x += (int) Math.pow(-1, Math.floor(tempX / (maxX - radius)));
    }


    BouncingBall(int numBuffers, GraphicsDevice device) {
        try {
            GraphicsConfiguration gc = device.getDefaultConfiguration();
            mainFrame = new Frame(gc);
            mainFrame.setUndecorated(true);
            mainFrame.setIgnoreRepaint(true);
            device.setFullScreenWindow(mainFrame);
            if (device.isDisplayChangeSupported()) {
                chooseBestDisplayMode(device);
            }
            Rectangle bounds = mainFrame.getBounds();
            bounds.setSize(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight());
            maxX = device.getDisplayMode().getWidth();
            maxY = device.getDisplayMode().getHeight();
            tempX = x;
            tempY = y;
            mainFrame.createBufferStrategy(numBuffers);
            BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();

            while (true) {
                Graphics g = bufferStrategy.getDrawGraphics();
                if (!bufferStrategy.contentsLost()) {
                    move();
                    g.setColor(Color.white);
                    g.fillRect(0, 0, bounds.width, bounds.height);
                    g.setColor(Color.red);
                    g.fillOval(x, y, radius, radius);
                    bufferStrategy.show();
                    g.dispose();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            device.setFullScreenWindow(null);
        }
    }

    private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
        for (DisplayMode bestDisplayMode : BEST_DISPLAY_MODES) {
            DisplayMode[] modes = device.getDisplayModes();
            for (DisplayMode mode : modes) {
                if (mode.getWidth() == bestDisplayMode.getWidth()
                        && mode.getHeight() == bestDisplayMode.getHeight()
                        && mode.getBitDepth() == bestDisplayMode.getBitDepth()
                ) {
                    return bestDisplayMode;
                }
            }
        }
        return null;
    }

    public static void chooseBestDisplayMode(GraphicsDevice device) {
        DisplayMode best = getBestDisplayMode(device);
        if (best != null) {
            device.setDisplayMode(best);
        }
    }

    public static void main(String[] args) {
        try {
            int numBuffers = 2;

            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = env.getDefaultScreenDevice();
            BouncingBall ball = new BouncingBall(numBuffers, device);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
