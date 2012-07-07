package com.yourpackagename.framework.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourpackagename.framework.common.Key;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * The purpose of this class is to contain the com.yourpackagename.framework.response that
 * needs to be sent to the calling users
 *
 * @author Y Kamesh Rao
 */
@XStreamAlias(Key.response)
@XmlRootElement(name = Key.response)
public class Response implements Serializable {
    private class Result {}
    private @XStreamAlias(value = Key.result, impl = Result.class) Object result;
    private Meta meta = new Meta();


    public void setError(int code, String msg) {
        meta.setCode(code);
        result = msg;
    }


    public void setError(int code, Object msg) {
        meta.setCode(code);
        result = msg;
    }


    @XmlElement(type = Object.class)
    public Object getResult() {
        return result;
    }


    public void setResult(Object result) {
        this.result = result;
    }


    @XmlElement
    public Meta getMeta() {
        return meta;
    }


    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    @Override public String toString() {
        return "Response{" +
                "result=" + result +
                ", meta=" + meta +
                '}';
    }
}
