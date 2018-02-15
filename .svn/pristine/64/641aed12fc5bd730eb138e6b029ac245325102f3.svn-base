package cn.rojao.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * i4接口请求插播广告请求返回实体类
 * @author Administrator
 *
 */
public class InterCutResp {
    
    private InterCutSmil smil;
    
    private String retcode;
    
    private String message;

    public InterCutSmil getSmil() {
        return smil;
    }

    public void setSmil(InterCutSmil smil) {
        this.smil = smil;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        
        return JSON.toJSONString(this,filter);
    }
    
    private ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };    
}
