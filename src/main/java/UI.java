import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UI extends JFrame {
    TourCourseRecommender tourCourseRecommender = TourCourseRecommender.getInstance();

    private Image background;
    private Image hello;
    private JButton startButton;
    private JPanel imagePanel;

    public UI() {
        try {
            background = ImageIO.read(getClass().getResourceAsStream("/background.jpg"));
            hello = ImageIO.read(getClass().getResourceAsStream("/hello.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setUndecorated(true);
        setSize(TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (background != null) {
                    g.drawImage(background, 0, 0, this);
                }
                if (hello != null) {
                    g.drawImage(hello, 20, 30, this);
                }
            }
        };
        imagePanel.setBounds(0, 0, TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT);
        imagePanel.setOpaque(false);

        // JButton
        startButton = new JButton(new ImageIcon(getClass().getResource("/start.png")));
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);
        startButton.setBounds(50, 100, startButton.getIcon().getIconWidth(), startButton.getIcon().getIconHeight());
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });


        add(imagePanel);
        add(startButton);


        setComponentZOrder(startButton, 0);
        setComponentZOrder(imagePanel, 1);

        setVisible(true);
    }

}
