package cn.rojao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * 生成hash桶工具类
 * @author Administrator
 *
 */
public class HashKey {
	
	/**
	 * 生成hash桶的key
	 * @param key  要转换的key值
	 * @param bit  表示要生成hash桶个数,2^bit
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getBucketId(String key, Integer bit) throws NoSuchAlgorithmException{
		char hexDigits[] = { '0', '1', '2', '3', '4',  
                 '5', '6', '7', '8', '9',  
                 'A', 'B', 'C', 'D', 'E', 'F' }; 
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(key.getBytes());
		byte [] md = mdInst.digest();
		byte [] r = new byte[bit/4+1];
		System.arraycopy(md, 0, r, 0, r.length);
		char str[] = new char[r.length]; 
		for(int i =0; i<r.length;i++){
			if(i==r.length-1){
				r[i] &= ((int) Math.pow(2, bit%4)-1);
			}
			byte byte0 = r[i];  
            str[i] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
	
	/**
	 * 按照key生成hash桶,桶数为2^14个
	 * @param key 要转换的key值
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getBucketId14(String key) throws NoSuchAlgorithmException{
		char hexDigits[] = { '0', '1', '2', '3', '4',  
                 '5', '6', '7', '8', '9',  
                 'A', 'B', 'C', 'D', 'E', 'F' }; 
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(key.getBytes());
		byte [] md = mdInst.digest();
		byte [] r = new byte[14/4+1];
		System.arraycopy(md, 0, r, 0, r.length);
		char str[] = new char[r.length]; 
		for(int i =0; i<r.length;i++){
			if(i==r.length-1){
				r[i] &= ((int) Math.pow(2, 14%4)-1);
			}
			byte byte0 = r[i];  
            str[i] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
	
	
	
	
	
	
	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		long time =System.currentTimeMillis();
		for(int g=0;g<1000000;g++){
			String test = "abcdddgadfadf";
			
			try {
				System.out.println(getBucketId14(String.valueOf(g)));
				set.add(getBucketId(String.valueOf(g),14));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(set.size());
		System.out.println(System.currentTimeMillis()-time);
	}
	
	

}
