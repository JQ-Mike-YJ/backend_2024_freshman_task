package com.mike.backJava2024FreshmanTask.utils;

import com.alibaba.fastjson.JSONObject;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * http 客户端工具
 */
@Slf4j
public class HttpClientUtil {

    /**
     * 工具类构造方法私有化
     */
    private HttpClientUtil() {
    }

    /**
     * httpClient的get请求方式
     * 使用GetMethod来访问一个URL对应的网页实现步骤：
     * 1.生成一个HttpClient对象并设置相应的参数；
     * 2.生成一个GetMethod对象并设置响应的参数；
     * 3.用HttpClient生成的对象来执行GetMethod生成的Get方法；
     * 4.处理响应状态码；
     * 5.若响应正常，处理HTTP响应内容；
     * 6.释放连接。
     *
     * @param url     请求连接
     * @param charset 字符集
     * @return String
     */
    public static String doGet(String url, String charset) throws BusinessException {
        //1.生成HttpClient对象并设置参数
        HttpClient httpClient = new HttpClient();
        //设置Http连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        //2.生成GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        //设置get请求超时为5秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        //设置请求重试处理，用的是默认的重试处理：请求三次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String response = "";
        //3.执行HTTP GET 请求
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            //4.判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                log.error("doGet request error -> {}", JSONObject.toJSONString(getMethod.getStatusLine()));
                throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "请求异常");
            }
            //5.处理HTTP响应内容
            //HTTP响应头部信息，这里简单打印
            Header[] headers = getMethod.getResponseHeaders();
            for (Header h : headers) {
                log.info("doGet headInfo -> {}", h.getName() + "---------------" + h.getValue());
            }
            //读取HTTP响应内容（字节数组），这里简单打印网页内容
            byte[] responseBody = getMethod.getResponseBody();
            response = new String(responseBody, charset);
        } catch (HttpException e) {
            //发生致命的异常，可能是协议不对或者返回的内容有问题
            log.error("doGet httpException -> {}", e.getMessage());
            throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "请检查输入的URL");
        } catch (IOException e) {
            //发生网络异常
            throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "网络异常");
        } finally {
            //6.释放连接
            getMethod.releaseConnection();
        }
        return response;
    }

}
