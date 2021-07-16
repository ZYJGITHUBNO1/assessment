package com.itcast.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;

public class RequestUtil {

    //常量字段
    private static final String IMG_URL = "imgUrl";
    private static final String TOKEN = "token";
    private static final String FILE = "file";
    private static final String IMG_BASE_64 = "imgBase64";
    private static final String ACCESS_KEY = "accessKey";
    private static final String ACCESS_SECRET = "accessSecret";
    //http连接超时时间
    private static final int SO_TIMEOUT = 30 * 1000;
    //数据传输超时时间
    private static final int SO_TIMEOUT_DATA = 30 * 1000;

    /**
     * <p>
     * 发送http post请求
     * </p>
     *
     * @param url   请求地址
     * @param param 请求参数
     * @param file  文件参数
     */
    public static String yuebaoPost(String url, Map<String, String> param, File file) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT_DATA)
                .setConnectTimeout(SO_TIMEOUT).setConnectionRequestTimeout(SO_TIMEOUT).build();// 设置请求和传输超时时间
        HttpPost httpPost = new HttpPost(url);
        httpPost.setProtocolVersion(HttpVersion.HTTP_1_0);
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //文件参数
            if (file != null) {
                FileBody fileBody = new FileBody(file);
                builder.addPart(FILE, fileBody);
            }
            //其他参数
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addPart(key,
                            new StringBody(param.get(key), ContentType.create("text/plain", Consts.UTF_8)));
                }
            }
            HttpEntity reqEntity = builder.build();
            httpPost.setEntity(reqEntity);

            httpPost.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("POST请求返回值：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * <p>
     * 发送http get请求
     * </p>
     *
     * @param url   请求地址
     * @param param 请求参数
     */
    public static String yuebaoGet(String url, Map<String, String> param) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT_DATA)
                .setConnectTimeout(SO_TIMEOUT).setConnectionRequestTimeout(SO_TIMEOUT).build();// 设置请求和传输超时时间
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (param != null) {
                stringBuffer.append("?");
                for (String key : param.keySet()) {
                    stringBuffer.append(key);
                    stringBuffer.append("=");
                    stringBuffer.append(param.get(key));
                    stringBuffer.append("&");
                }
            }
            String str = stringBuffer.toString();
            String params = str.substring(0, str.length() - 1);
            HttpGet httpGet = new HttpGet(url + params);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("GET请求返回值：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
