import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class UI extends JFrame {

    private Image background;
    private Image hello;

    private Image regionImage;

    private Image themeImage;

    private Image locationTypeImage;

    private Image typingBlock;
    private JButton startButton;

    private JButton exitButton;
    private JPanel imagePanel;
    private ImageIcon loadingImage;

    private JButton themeButton1;
    private JButton themeButton2;
    private JButton themeButton3;
    private JButton themeButton4;
    private JButton themeButton5;
    private JButton themeButton6;

    private JButton locationTypeButton1;
    private JButton locationTypeButton2;
    private JButton locationTypeButton3;

    private JButton locationRecommendationButton;


    private JButton ThemeChoiceButton;

    private URL loadingurl;

    private boolean theme1Choice = false;
    private boolean theme2Choice = false;
    private boolean theme3Choice = false;
    private boolean theme4Choice = false;
    private boolean theme5Choice = false;
    private boolean theme6Choice = false;


    private JButton themeChoiceButton;


    private JFormattedTextField regionField;

    public TourCourseRecommender tourCourseRecommender;

    public RegionCriteria regionCriteria;
    public ThemeCriteria themeCriteria;
    public LocationTypeCriteria locationTypeCriteria;

    boolean regionFlag = false;

    boolean themeFlag = false;

    boolean locationTypeFlag = false;

    boolean bufferingFlag = false;

    private JLabel loadingLabel;

    private Icon loadingIcon;

    private Timer repaintTimer;


    public UI() {
        try {
            this.themeCriteria = new ThemeCriteria();
            this.locationTypeCriteria = new LocationTypeCriteria();
            background = ImageIO.read(getClass().getResourceAsStream("/background.jpg"));
            hello = ImageIO.read(getClass().getResourceAsStream("/hello.png"));
            regionImage = ImageIO.read(getClass().getResourceAsStream("/region.png"));
            themeImage = ImageIO.read(getClass().getResourceAsStream("/theme.png"));
            locationTypeImage = ImageIO.read(getClass().getResourceAsStream("/locationType.png"));
            regionField = new JFormattedTextField();
            tourCourseRecommender = TourCourseRecommender.getInstance();
            typingBlock = ImageIO.read(getClass().getResourceAsStream("/typingBlock.png"));
            loadingImage = new ImageIcon(getClass().getResource("/loading.gif"));
            loadingurl = getClass().getResource("/loading.gif");
            loadingIcon = new ImageIcon(loadingurl);
            loadingLabel = new JLabel(loadingIcon);
            repaintTimer = new Timer(100, e -> repaint());

        } catch (IOException e) {
            e.printStackTrace();
        }


        regionField = new JFormattedTextField();
        regionField.setBounds(35, 170, 200, 30);
        regionField.setOpaque(false);
        regionField.setBackground(new Color(0, 0, 0, 0));
        regionField.setBorder(null);
        regionField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        regionField.setVisible(false);

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

                if(bufferingFlag){

                }
                else {

                    g.drawImage(background, 0, 0, TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT, null);

                    if (hello != null) {
                        g.drawImage(hello, 20, 20, hello.getWidth(null), hello.getHeight(null), null);
                    }

                    if (regionFlag) {
                        g.drawImage(regionImage, 20, 20, regionImage.getWidth(null), regionImage.getHeight(null), null);
                        g.drawImage(typingBlock, 20, 150, typingBlock.getWidth(null), typingBlock.getHeight(null), null);
                        regionField.setVisible(true);
                    }

                    if (themeFlag) {
                        g.drawImage(themeImage, 20, 20, themeImage.getWidth(null), themeImage.getHeight(null), null);
                        themeButton1.setVisible(true);
                        themeButton2.setVisible(true);
                        themeButton3.setVisible(true);
                        themeButton4.setVisible(true);
                        themeButton5.setVisible(true);
                        themeButton6.setVisible(true);
                        ThemeChoiceButton.setVisible(true);
                    } else {
                        themeButton1.setVisible(false);
                        themeButton2.setVisible(false);
                        themeButton3.setVisible(false);
                        themeButton4.setVisible(false);
                        themeButton5.setVisible(false);
                        themeButton6.setVisible(false);
                        ThemeChoiceButton.setVisible(false);
                    }


                    if (locationTypeFlag) {
                        g.drawImage(locationTypeImage, 20, 20, locationTypeImage.getWidth(null), locationTypeImage.getHeight(null), null);
                        locationTypeButton1.setVisible(true);
                        locationTypeButton2.setVisible(true);
                        locationTypeButton3.setVisible(true);
                        locationRecommendationButton.setVisible(true);

                    } else {
                        locationTypeButton1.setVisible(false);
                        locationTypeButton2.setVisible(false);
                        locationTypeButton3.setVisible(false);
                        locationRecommendationButton.setVisible(false);
                    }
                }
            }
        };


        imagePanel.setBounds(0, 0, TouristMain.UI_WIDTH, TouristMain.UI_HEIGHT);
        imagePanel.setOpaque(false);


        startButton = new JButton(new ImageIcon(getClass().getResource("/start.png")));
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);
        startButton.setBounds(50, 100, startButton.getIcon().getIconWidth(), startButton.getIcon().getIconHeight());


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                startButton.setVisible(false);
                hello = null;

                regionFlag = true;

                imagePanel.repaint();
                imagePanel.revalidate();
            }
        });

        exitButton = new JButton(new ImageIcon(getClass().getResource("/exit.png")));

        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);
        exitButton.setBounds(TouristMain.UI_WIDTH - exitButton.getIcon().getIconWidth() - 20, 20, exitButton.getIcon().getIconWidth(), exitButton.getIcon().getIconHeight());

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });


        imagePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evt.consume();
            }
        });


        regionField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regionCriteria = new RegionCriteria(regionField.getText());
                regionFlag = false;
                themeFlag = true;
                imagePanel.repaint();
                imagePanel.revalidate();
                regionField.setVisible(false);
            }
        });

        //set themeButtons, and when themeButton clicked, themeCriteria will be saved by tourCourseRecommender
        //when themeChoiceButton clicked, all the themes choiced before clicked themeButtons will setted to tourCourseRecommender
        themeButton1 = new JButton(new ImageIcon(getClass().getResource("/theme1.png")));
        themeButton1.setBorderPainted(false);
        themeButton1.setContentAreaFilled(false);
        themeButton1.setFocusPainted(false);
        themeButton1.setOpaque(false);
        themeButton1.setBounds(20, 100, themeButton1.getIcon().getIconWidth(), themeButton1.getIcon().getIconHeight());

        themeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme1Choice) {
                    theme1Choice = true;
                    themeButton1.setIcon(new ImageIcon(getClass().getResource("/theme1dark.png")));
                } else {
                    theme1Choice = false;
                    themeButton1.setIcon(new ImageIcon(getClass().getResource("/theme1.png")));
                }
                repaint();
                revalidate();
            }
        });


        themeButton2 = new JButton(new ImageIcon(getClass().getResource("/theme2.png")));
        themeButton2.setBorderPainted(false);
        themeButton2.setContentAreaFilled(false);
        themeButton2.setFocusPainted(false);
        themeButton2.setOpaque(false);
        themeButton2.setBounds(20, 160, themeButton2.getIcon().getIconWidth(), themeButton2.getIcon().getIconHeight());

        themeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme2Choice) {
                    theme2Choice = true;
                    themeButton2.setIcon(new ImageIcon(getClass().getResource("/theme2dark.png")));
                } else {
                    theme2Choice = false;
                    themeButton2.setIcon(new ImageIcon(getClass().getResource("/theme2.png")));
                }
                repaint();
                revalidate();
            }
        });



        themeButton3 = new JButton(new ImageIcon(getClass().getResource("/theme3.png")));
        themeButton3.setBorderPainted(false);
        themeButton3.setContentAreaFilled(false);
        themeButton3.setFocusPainted(false);
        themeButton3.setOpaque(false);
        themeButton3.setBounds(20, 220, themeButton3.getIcon().getIconWidth(), themeButton3.getIcon().getIconHeight());

        themeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme3Choice) {
                    theme3Choice = true;
                    themeButton3.setIcon(new ImageIcon(getClass().getResource("/theme3dark.png")));
                } else {
                    theme3Choice = false;
                    themeButton3.setIcon(new ImageIcon(getClass().getResource("/theme3.png")));
                }
                repaint();
                revalidate();
            }
        });

        themeButton4 = new JButton(new ImageIcon(getClass().getResource("/theme4.png")));
        themeButton4.setBorderPainted(false);
        themeButton4.setContentAreaFilled(false);
        themeButton4.setFocusPainted(false);
        themeButton4.setOpaque(false);
        themeButton4.setBounds(20, 280, themeButton4.getIcon().getIconWidth(), themeButton4.getIcon().getIconHeight());

        themeButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme4Choice) {
                    theme4Choice = true;
                    themeButton4.setIcon(new ImageIcon(getClass().getResource("/theme4dark.png")));
                } else {
                    theme4Choice = false;
                    themeButton4.setIcon(new ImageIcon(getClass().getResource("/theme4.png")));
                }
                repaint();
                revalidate();
            }
        });

        themeButton5 = new JButton(new ImageIcon(getClass().getResource("/theme5.png")));
        themeButton5.setBorderPainted(false);
        themeButton5.setContentAreaFilled(false);
        themeButton5.setFocusPainted(false);
        themeButton5.setOpaque(false);
        themeButton5.setBounds(20, 340, themeButton5.getIcon().getIconWidth(), themeButton5.getIcon().getIconHeight());

        themeButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme5Choice) {
                    theme5Choice = true;
                    themeButton5.setIcon(new ImageIcon(getClass().getResource("/theme5dark.png")));
                } else {
                    theme5Choice = false;
                    themeButton5.setIcon(new ImageIcon(getClass().getResource("/theme5.png")));
                }
                repaint();
                revalidate();
            }
        });

        themeButton6 = new JButton(new ImageIcon(getClass().getResource("/theme6.png")));
        themeButton6.setBorderPainted(false);
        themeButton6.setContentAreaFilled(false);
        themeButton6.setFocusPainted(false);
        themeButton6.setOpaque(false);
        themeButton6.setBounds(20, 400, themeButton6.getIcon().getIconWidth(), themeButton6.getIcon().getIconHeight());

        themeButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!theme6Choice) {
                    theme6Choice = true;
                    themeButton6.setIcon(new ImageIcon(getClass().getResource("/theme6dark.png")));
                } else {
                    theme6Choice = false;
                    themeButton6.setIcon(new ImageIcon(getClass().getResource("/theme6.png")));
                }
                repaint();
                revalidate();
            }
        });

        ThemeChoiceButton = new JButton(new ImageIcon(getClass().getResource("/themechoice.png")));
        ThemeChoiceButton.setBorderPainted(false);
        ThemeChoiceButton.setContentAreaFilled(false);
        ThemeChoiceButton.setFocusPainted(false);
        ThemeChoiceButton.setOpaque(false);
        ThemeChoiceButton.setBounds(20, 470, ThemeChoiceButton.getIcon().getIconWidth(), ThemeChoiceButton.getIcon().getIconHeight());

        ThemeChoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(theme1Choice){
                    themeCriteria.pushTheme("종교/역사/전통");
                }
                if(theme2Choice){
                    themeCriteria.pushTheme("쇼핑/놀이");
                }
                if(theme3Choice){
                    themeCriteria.pushTheme("캠핑/스포츠");
                }
                if(theme4Choice){
                    themeCriteria.pushTheme("자연/힐링");
                }
                if(theme5Choice){
                    themeCriteria.pushTheme("문화/예술");
                }
                if(theme6Choice){
                    themeCriteria.pushTheme("체험/학습/산업");
                }

                themeFlag = false;
                locationTypeFlag = true;
                imagePanel.repaint();
                imagePanel.revalidate();
            }
        });

        locationTypeButton1 = new JButton(new ImageIcon(getClass().getResource("/locationType1.png")));
        locationTypeButton1.setBorderPainted(false);
        locationTypeButton1.setContentAreaFilled(false);
        locationTypeButton1.setFocusPainted(false);
        locationTypeButton1.setOpaque(false);
        locationTypeButton1.setBounds(20, 200, 248, 84);

        locationTypeButton2 = new JButton(new ImageIcon(getClass().getResource("/locationType2.png")));
        locationTypeButton2.setBorderPainted(false);
        locationTypeButton2.setContentAreaFilled(false);
        locationTypeButton2.setFocusPainted(false);
        locationTypeButton2.setOpaque(false);
        locationTypeButton2.setBounds(20, 300, 248, 84);

        locationTypeButton3 = new JButton(new ImageIcon(getClass().getResource("/locationType3.png")));
        locationTypeButton3.setBorderPainted(false);
        locationTypeButton3.setContentAreaFilled(false);
        locationTypeButton3.setFocusPainted(false);
        locationTypeButton3.setOpaque(false);
        locationTypeButton3.setBounds(20, 400, 248, 84);

        locationTypeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locationTypeCriteria.setSilnaesilwae("실내");
                locationTypeButton1.setIcon(new ImageIcon(getClass().getResource("/selectLocationType1.png")));
                locationTypeButton2.setIcon(new ImageIcon(getClass().getResource("/locationType2.png")));
                locationTypeButton3.setIcon(new ImageIcon(getClass().getResource("/locationType3.png")));


                repaint();
                revalidate();
            }
        });

        locationTypeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locationTypeCriteria.setSilnaesilwae("실외");
                locationTypeButton1.setIcon(new ImageIcon(getClass().getResource("/locationType1.png")));
                locationTypeButton2.setIcon(new ImageIcon(getClass().getResource("/selectLocationType2.png")));
                locationTypeButton3.setIcon(new ImageIcon(getClass().getResource("/locationType3.png")));
                repaint();
                revalidate();
            }
        });

        locationTypeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locationTypeCriteria.setSilnaesilwae("상관 없음");
                locationTypeButton1.setIcon(new ImageIcon(getClass().getResource("/locationType1.png")));
                locationTypeButton2.setIcon(new ImageIcon(getClass().getResource("/locationType2.png")));
                locationTypeButton3.setIcon(new ImageIcon(getClass().getResource("/selectLocationType3.png")));
                repaint();
                revalidate();
            }
        });


        locationRecommendationButton = new JButton(new ImageIcon(getClass().getResource("/locationRecommendation.png")));
        locationRecommendationButton.setBorderPainted(false);
        locationRecommendationButton.setContentAreaFilled(false);
        locationRecommendationButton.setFocusPainted(false);
        locationRecommendationButton.setOpaque(false);
        locationRecommendationButton.setBounds(20, 510, locationRecommendationButton.getIcon().getIconWidth(), locationRecommendationButton.getIcon().getIconHeight());

        locationRecommendationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bufferingFlag = true;
                loadingLabel.setVisible(true);
                loadingLabel.repaint();
                loadingLabel.revalidate();
                repaint();
                revalidate();
                tourCourseRecommender.addCriteria(regionCriteria);
                tourCourseRecommender.addCriteria(themeCriteria);
                tourCourseRecommender.addCriteria(locationTypeCriteria);
                tourCourseRecommender.recommendCourse();
                tourCourseRecommender.showAllAttractions();
                locationTypeButton1.setVisible(false);
                locationTypeButton2.setVisible(false);
                locationTypeButton3.setVisible(false);
                locationRecommendationButton.setVisible(false);
                loadingLabel.setVisible(false);
                loadingLabel.repaint();
                loadingLabel.revalidate();
                repaint();
                revalidate();

            }
        });




        loadingLabel.setBounds(TouristMain.UI_WIDTH/2 - 193, TouristMain.UI_HEIGHT/2 - 193, 386, 386);
        loadingLabel.setVisible(false);


        add(imagePanel);
        add(startButton);
        add(exitButton);
        add(regionField);
        add(themeButton1);
        add(themeButton2);
        add(themeButton3);
        add(themeButton4);
        add(themeButton5);
        add(themeButton6);
        add(ThemeChoiceButton);
        add(locationTypeButton1);
        add(locationTypeButton2);
        add(locationTypeButton3);
        add(locationRecommendationButton);
        add(loadingLabel);

        setComponentZOrder(loadingLabel, 1);
        setComponentZOrder(themeButton1, 2);
        setComponentZOrder(themeButton2, 3);
        setComponentZOrder(themeButton3, 4);
        setComponentZOrder(themeButton4, 5);
        setComponentZOrder(themeButton5, 6);
        setComponentZOrder(themeButton6, 7);
        setComponentZOrder(ThemeChoiceButton, 8);
        setComponentZOrder(startButton, 9);
        setComponentZOrder(exitButton, 10);
        setComponentZOrder(regionField, 11);
        setComponentZOrder(locationTypeButton1, 12);
        setComponentZOrder(locationTypeButton2, 13);
        setComponentZOrder(locationTypeButton3, 14);
        setComponentZOrder(locationRecommendationButton, 15);
        setComponentZOrder(imagePanel, 16);



        setVisible(true);
    }
}








