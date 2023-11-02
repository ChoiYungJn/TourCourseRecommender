import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image background;

    public UI(){
        setTitle("제목");
        setSize(TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        background = new ImageIcon(TouristMain.class.getResource("../resources/test.jpg")).getImage();
    }

    public void paint(Graphics g){
        screenImage = createImage(TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(background, 0, 0, null);
        this.repaint();
    }
}
