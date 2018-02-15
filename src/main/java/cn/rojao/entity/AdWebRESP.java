package cn.rojao.entity;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 页面广告请求返回实体类
 * @author Administrator
 *
 */
public class AdWebRESP {
    //版本信息
    private AdWebHead head;
    //请求返回主体
    private List<AdWebBody> body;
    
    public AdWebHead getHead() {
        return head;
    }
    public void setHead(AdWebHead head) {
        this.head = head;
    }
    public List<AdWebBody> getBody() {
        return body;
    }
    public void setBody(List<AdWebBody> body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
}
