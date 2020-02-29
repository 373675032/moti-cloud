package com.moti.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

/**
 * @Description 二维码生成工具类
 * @Author xw
 * @Date 12:14 2020/2/12
 * @Param  * @param null
 * @return
 **/
public class QRCodeUtil {

    //编码
    private static final String CHARSET = "utf-8";
    //文件格式
    private static final String FORMAT = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int LOGO_WIDTH = 60;
    // LOGO高度
    private static final int LOGO_HEIGHT = 60;

    /**
     * @Description 生成二维码
     * @Author xw
     * @Date 12:14 2020/2/12
     * @Param [content, logoPath, needCompress] 内容,logo路径,是否压缩
     * @return java.awt.image.BufferedImage
     **/
    public static BufferedImage createImage(String content, String logoPath, boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if (logoPath == null || "".equals(logoPath)) {
            return image;
        }
        // 插入图片
        QRCodeUtil.insertImage(image, logoPath, needCompress);
        return image;
    }

    /**
     * @Description 插入logo
     * @Author xw
     * @Date 12:15 2020/2/12
     * @Param [source, logoPath, needCompress] 二维码图片,logo路径,是否压缩
     * @return void
     **/
    private static void insertImage(BufferedImage source, String logoPath, boolean needCompress) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = QRCodeUtil.getResourceAsStream(logoPath);
            Image src = ImageIO.read(inputStream);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            if (needCompress) {
                // 压缩LOGO
                width = width>LOGO_WIDTH?LOGO_WIDTH:width;
                height = height>LOGO_HEIGHT?LOGO_HEIGHT:height;
                Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(image, 0, 0, null);
                // 绘制缩小后的图
                g.dispose();
                src = image;
            }
            // 插入LOGO
            Graphics2D graph = source.createGraphics();
            int x = (QRCODE_SIZE - width) / 2;
            int y = (QRCODE_SIZE - height) / 2;
            graph.drawImage(src, x, y, width, height, null);
            Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
            graph.setStroke(new BasicStroke(3f));
            graph.draw(shape);
            graph.dispose();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * @Description 生成二维码,获得到输出流 ,logo内嵌
     * @Author xw
     * @Date 12:16 2020/2/12
     * @Param [content, logoPath, output, needCompress] 内容,logo路径,输出流,是否压缩
     * @return void
     **/
    public static void encode(String content, String logoPath, OutputStream output, boolean needCompress)
            throws Exception {
        BufferedImage image = QRCodeUtil.createImage(content, logoPath, needCompress);
        ImageIO.write(image, FORMAT, output);
    }

    /**
     * @Description 获取指定文件的输入流，获取logo
     * @Author xw
     * @Date 12:17 2020/2/12
     * @Param [logoPath] logo路径
     * @return java.io.InputStream
     **/
    public static InputStream getResourceAsStream(String logoPath) {
        return QRCodeUtil.class.getResourceAsStream(logoPath);
    }
}