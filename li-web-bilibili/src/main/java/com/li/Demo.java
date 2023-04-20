package com.li;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo {
    public static void main(String[] args) throws IOException {


    }

    public static String[] extracted(int mid) throws IOException, InterruptedException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://space.bilibili.com/" + mid);
        httpGet.setHeader("User-Agent", "PostmanRuntime-ApipostRuntime/1.1.0\n");
        // 发送请求并获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();
//        URL url2 = new URL("https://space.bilibili.com/280793434");//这里请求name
//        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
//        BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(content));

        String inputLine2 = null;
        StringBuffer response2 = new StringBuffer();

        while ((inputLine2 = in2.readLine()) != null) {
            response2.append(inputLine2);
        }
        in2.close();

        String string = response2.toString().replaceAll("\\s", "");
        System.out.println(string);
        int i = string.indexOf("的个人空间-");
        int i2 = string.indexOf("个人主页-哔哩哔哩视频");
        int i3 = string.indexOf("，第一时间了解UP注动态。");
        int i4 = string.indexOf("\"/><metaname=\"referrer\"content=\"no-referrer-when-downgrade\"><linkrel=\"apple-touch-icon\"href=");
//        if (i4==-1||i3==-1||i==-1||i2==-1){
//
//            extracted(mid).wait(5*60*1000);
//
//        }
        String sign = string.substring(i3 + 13, i4);
        String name = string.substring(i + 6, i2);
        return new String[] {
                name, sign
        } ;
//        System.out.println(sign);
//        System.out.println(substring);
    }
}

//        System.out.println(sign);
//        System.out.println(substring);

