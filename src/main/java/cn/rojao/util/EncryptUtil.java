package cn.rojao.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * 加密
 * @author lenovo
 *
 */
public class EncryptUtil {
	
	public static void main(String[] args){
		try {
			String encryptStr = encrypt("111", "A1B845F45BC6EF59" , "1234567890123456");
			System.out.println(encryptStr);
			String decrypt = decrypt(encryptStr, "A1B845F45BC6EF59" , "1234567890123456");
			System.out.println(decrypt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密
	 * @param content 待加密内容
	 * @param key     密钥,16位16进制
	 * @param iv      偏移量 ,16位16进制
	 * @return string
	 * @throws Exception
	 */
	public static String encrypt(String content, String key, String iv) throws Exception {
        try {
        	SecretKeySpec  keySpec = new SecretKeySpec(key.getBytes(), "AES");    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivSpec);
            byte[] byteResult = cipher.doFinal(content.getBytes());
            return parseByte2HexStr(byteResult); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 解密
	 * @param content 待加密内容
	 * @param key     密钥,16位16进制
	 * @param iv      偏移量 ,16位16进制
	 * @return string
	 * @throws Exception
	 */
	public static String decrypt(String encryptStr, String key , String iv) throws Exception {
        try {
        	SecretKeySpec  keySpec = new SecretKeySpec(key.getBytes(), "AES");    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec,ivSpec);
            byte[] result = cipher.doFinal(parseHexStr2Byte(encryptStr));  
            return new String(result).trim(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	/**
	 * 将二进制转成16进制 
	 * @param buf
	 * @return String
	 */
    public static String parseByte2HexStr(byte buf[]) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < buf.length; i++) {  
            String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {  
                hex = '0' + hex;  
            }  
            sb.append(hex.toUpperCase());  
        }  
        return sb.toString();  
    } 
	
    /**
     * 将16进制转成2进制 
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {  
        if (hexStr.length() < 1)  
            return null;  
        byte[] result = new byte[hexStr.length()/2];  
        for (int i = 0;i< hexStr.length()/2; i++) {  
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
            result[i] = (byte) (high * 16 + low);  
        }  
        return result;  
    } 
}
