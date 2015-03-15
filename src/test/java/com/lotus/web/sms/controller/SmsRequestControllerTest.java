package com.lotus.web.sms.controller;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;

public class SmsRequestControllerTest {

    @Test
    public void sendSms() {

        while (true) {
            HttpURLConnection conn = null;
            try {
                // Construct data
                conn = (HttpURLConnection) new URL("http://localhost:8080/sendMessage").openConnection();
                conn.setConnectTimeout(30 * 1000);
                conn.setReadTimeout(30 * 1000);
                String appKey = "&appKey=" + "APIHash";
                String message = "hello test\n" +
                        " I plan to have a & in my message, should be correct\n" +
                        ". If not received* (//, then something is wrong \\";
                String sender = "&remoteUser=" + "remoteUser";
                URLCodec encoder = new URLCodec("UTF-8");
                // Send data
                String data = appKey + "&message=" + encoder.encode(message) + sender;
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();
                System.out.println(stringBuffer.toString());
                outputStream.close();
            } catch (IOException e) {
                System.out.println("Error SMS " + e);
            } catch (EncoderException e) {
                e.printStackTrace();
            }
        }

    }

}