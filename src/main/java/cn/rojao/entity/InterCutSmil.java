package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

/**
 * i4接口请求插播广告请求返回实体类
 * @author Administrator
 *
 */

public class InterCutSmil {

    private String head;
    
    private InterCutBody body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public InterCutBody getBody() {
        return body;
    }

    public void setBody(InterCutBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }
    
}
