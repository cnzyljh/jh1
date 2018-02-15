/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   ohun@live.cn (夜色)
 */

package cn.rojao.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ohun on 2015/12/25.
 *
 * @author ohun@live.cn
 */
public final class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    private static String LOCAL_IP;

    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("127(\\.\\d{1,3}){3}$");

    private static String EXTRANET_IP;

    public static boolean isLocalHost(String host) {
        return host == null
                || host.length() == 0
                || host.equalsIgnoreCase("localhost")
                || host.equals("0.0.0.0")
                || (LOCAL_IP_PATTERN.matcher(host).matches());
    }

    public static String getLocalIp() {
        if (LOCAL_IP == null) {
            LOCAL_IP = getInetAddress(true);
        }
        return LOCAL_IP;
    }

    /**
     * 只获取第一块网卡绑定的ip地址
     *
     * @param getLocal 局域网IP
     * @return ip
     */
    public static String getInetAddress(boolean getLocal) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                Enumeration<InetAddress> addresses = interfaces.nextElement().getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (address.isLoopbackAddress()) continue;
                    if (address.getHostAddress().contains(":")) continue;
                    if (getLocal) {
                        if (address.isSiteLocalAddress()) {
                            return address.getHostAddress();
                        }
                    } else {
                        if (!address.isSiteLocalAddress() && !address.isLoopbackAddress()) {
                            return address.getHostAddress();
                        }
                    }
                }
            }
            LOGGER.warn("getInetAddress is null");
            return getLocal ? "127.0.0.1" : null;
        } catch (Throwable e) {
            LOGGER.error("getInetAddress exception", e);
            return getLocal ? "127.0.0.1" : null;
        }
    }

    public static String getExtranetIp() {
        if (EXTRANET_IP == null) {
            EXTRANET_IP = getInetAddress(false);
        }
        return EXTRANET_IP;
    }


    public static String headerToString(Map<String, String> headers) {
        if (headers != null && headers.size() > 0) {
            StringBuilder sb = new StringBuilder(headers.size() * 64);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                sb.append(entry.getKey())
                        .append(':')
                        .append(entry.getValue()).append('\n');
            }
            return sb.toString();
        }
        return null;
    }


    public static Map<String, String> headerFromString(String headersString) {
        if (headersString == null) return null;
        Map<String, String> headers = new HashMap<>();
        int L = headersString.length();
        String name, value = null;
        for (int i = 0, start = 0; i < L; i++) {
            char c = headersString.charAt(i);
            if (c != '\n') continue;
            if (start >= L - 1) break;
            String header = headersString.substring(start, i);
            start = i + 1;
            int index = header.indexOf(':');
            if (index <= 0) continue;
            name = header.substring(0, index);
            if (index < header.length() - 1) {
                value = header.substring(index + 1);
            }
            headers.put(name, value);
        }
        return headers;
    }

    public static boolean checkHealth(String ip, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 1000);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
    * 去掉url中的路径，留下请求参数部分
    * @param strURL url地址
    * @return url请求参数部分
    * @author lzf
    */
    private static String TruncateUrlPage(String strURL){
    	String strAllParam=null;
    	String[] arrSplit=null;
    	strURL=strURL.trim();
    	arrSplit=strURL.split("[?]");
    	if(strURL.length()>1){
    		if(arrSplit.length>1){
    			for (int i=1;i<arrSplit.length;i++){
    				strAllParam = arrSplit[i];
    			}
    		}
    	}
    	return strAllParam; 
    }
    
    /**
    * 解析出url参数中的键值对
    * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
    * @param URL url地址
    * @return url请求参数部分
    * @author lzf
    */
    public static Map<String, String> urlSplit(String URL){
    	Map<String, String> mapRequest = new HashMap<String, String>();
    	String[] arrSplit=null;
    	String strUrlParam=TruncateUrlPage(URL);
    	if(strUrlParam==null){
    		return mapRequest;
    	}
    	arrSplit=strUrlParam.split("[&]");
    	for(String strSplit:arrSplit){
    		String[] arrSplitEqual=null; 
    		arrSplitEqual= strSplit.split("[=]");
    		//解析出键值
    		if(arrSplitEqual.length>1){
    			//正确解析
    			mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
    		}else{
    			if(arrSplitEqual[0]!=""){
    				//只有参数没有值，不加入
    				mapRequest.put(arrSplitEqual[0], ""); 
    			}
    		}
    	} 
    	return mapRequest; 
   
    }
    
    /**
     * 通过url下载文件
     * @param urlStr
     * @return
     * @throws Exception
     */
    public static InputStream downLoadFromUrl(String urlStr/*,String fileName,String savePath*/) throws Exception{
    	URL url = new URL(urlStr);  
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                //设置超时间为3秒
		conn.setConnectTimeout(3*1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		//得到输入流
		InputStream inputStream = conn.getInputStream();  
		/*//获取自己数组
		byte[] getData = readInputStream(inputStream);    

		//文件保存位置
		File saveDir = new File(savePath);
		if(!saveDir.exists()){
			saveDir.mkdir();
		}
		File file = new File(saveDir+File.separator+fileName);    
		FileOutputStream fos = new FileOutputStream(file);     
		fos.write(getData); 
		if(fos!=null){
			fos.close();  
		}
		if(inputStream!=null){
			inputStream.close();
		}
		System.out.println("info:"+url+" download success");*/
		return inputStream;
    }
    
    /**
	 * 从输入流中获取字节数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
		byte[] buffer = new byte[1024];  
		int len = 0;  
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
		while((len = inputStream.read(buffer)) != -1) {  
			bos.write(buffer, 0, len);  
		}  
		bos.close();  
		return bos.toByteArray();  
	}  
    
    public static void main(String[] args) throws Exception{
    //	http://127.0.0.1:9000/zm.txt
    	InputStream in = downLoadFromUrl("http://127.0.0.1:9000/zm.txt");
    	InputStreamReader isr =  new InputStreamReader(in,"GB2312");
    	BufferedReader buff = new BufferedReader(isr);
    	String str = "";
    	while ((str = buff.readLine()) != null) {
    		   System.out.println(str);
    	 }
    	/*urlSplit("/a?a=b&b=c");
    	System.out.println(getInetAddress(true));*/
    }
}
