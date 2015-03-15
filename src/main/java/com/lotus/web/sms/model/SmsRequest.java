package com.lotus.web.sms.model;

import java.io.Serializable;

/**
 * Created by johndoe on 3/15/2015.
 */
public class SmsRequest implements Serializable {
    private static final long serialVersionUID = 1l;

    private String message;
    private String appKey;
    private String remoteUser;

    @Override
    public String toString() {
        return "SmsRequest{" +
                "message='" + message + '\'' +
                ", appKey='" + appKey + '\'' +
                ", remoteUser='" + remoteUser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsRequest that = (SmsRequest) o;

        if (!appKey.equals(that.appKey)) return false;
        if (!message.equals(that.message)) return false;
        if (!remoteUser.equals(that.remoteUser)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + appKey.hashCode();
        result = 31 * result + remoteUser.hashCode();
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }
}
