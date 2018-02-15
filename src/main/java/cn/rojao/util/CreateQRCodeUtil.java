package cn.rojao.util;  

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
  
  
/**   
 * @Description: (��ͨ��ά������)      
 * @author��Relieved   
 * @date��2014-11-7 ����04:42:35      
 */  
public class CreateQRCodeUtil {  
    
    private static Logger log = LoggerFactory.getLogger(CreateQRCodeUtil.class);
    
    public static void  main(String [] args) throws IOException, WriterException{  
        /*CreateQRCodeUtil cpCode = new CreateQRCodeUtil();  
        String code = CreateQRCodeUtil.createCode("！！！！！"); 
        System.out.println(code);
        cpCode.parseCode(new File("D:/TDC-test.png"));*/  
          
    }  
    /** 
     * ��ά������� 
     * 
     */  
    public static String createCode(String url){  
        String text = url;
        int width = 800;  
        int height = 800;  
        // ��ά���ͼƬ��ʽ  
        String format = "png";  
        /**  ���ö�ά��Ĳ��� */  
        HashMap hints = new HashMap();  
        // ������ʹ�ñ���  
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        try {  
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,height,hints);  
            // ���ɶ�ά��  
            File outputFile = new File("D:" + File.separator + "TDC-test2.png");  
            MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
            
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix); 
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
            ImageIO.write(image, format, out);  
            byte[] b = out.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();  
            return encoder.encode(b);
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return "";
          
    }  
    /** 
     * ��ά��Ľ��� 
     * 
     * @param file 
     */  
    public void parseCode(File file)  
    {  
        try  
        {  
            MultiFormatReader formatReader = new MultiFormatReader();  
   
            if (!file.exists())  
            {  
                return;  
            }  
   
            BufferedImage image = ImageIO.read(file);  
   
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
   
            Map hints = new HashMap();  
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
   
            Result result = formatReader.decode(binaryBitmap, hints);  
   
            System.out.println("������� = " + result.toString());  
            System.out.println("��ά���ʽ���� = " + result.getBarcodeFormat());  
            System.out.println("��ά���ı����� = " + result.getText());  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  
