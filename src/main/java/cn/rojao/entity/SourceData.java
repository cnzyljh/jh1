package cn.rojao.entity;

import com.alibaba.fastjson.JSON;

public class SourceData {
    
    private String content;
    
    private String img;
    
    private String name;
    
    private String src;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        
        return JSON.toJSONString(this);
    }
    
    
    
}
