package com.design.hice.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 自定义验证码类
 */
public class VerifyCode {
    private final String RAMDOM_STR = "0123456789";

    private int width = 100;    //生成验证码图片的宽度
    private int height = 40;    //生成验证码图片的高度
    private Color bgColor = new Color(255, 255, 255); //定义验证码图片的背景色
    private String text;

    public VerifyCode() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(RAMDOM_STR.charAt(random.nextInt(RAMDOM_STR.length())));
        }
        this.text = builder.toString();
    }

    public String getText() {
        return text;
    }

    /**
     * 创建一个空白的BufferedImage对象
     *
     * @return
     */
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(bgColor);
        g2.fillRect(0, 0, width, height);
        return image;
    }

    /**
     * 绘制验证码
     *
     * @return
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        char[] chars = text.toCharArray();
        int i = 4;
        for (char aChar : chars) {
            String s = String.valueOf(aChar);
            sb.append(s);
            g2.setColor(Color.BLACK);
            g2.setFont(new Font(null, 0, 36));
            g2.drawString(s,  i, height - 6);
            i += 23;
        }
        return image;
    }
}