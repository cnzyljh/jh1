package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

public class InterCutBody {
    private InterCutSeq seq;

    public InterCutSeq getSeq() {
        return seq;
    }

    public void setSeq(InterCutSeq seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }
    
    
}
