package com.songj.http;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Map.Entry;

/**
 * @ClassName: HttpClient
 * @Description: httpCliect  工具类
 * @Author: Scott S
 * @Date: 2019/6/27 9:54
 * @Version: 1.0
 **/
@Slf4j
public class HttpClient {


    private HttpClient(){}

    // 编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 3000;

    // 请求获取数据的超时时间(即响应时间)，单位毫秒。
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * 发送get请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static HttpClientResult doGet(String url) throws Exception {
        return doGet(url, null, null);
    }

    /**
     * 发送get请求；带请求参数
     *
     * @param url    请求地址
     * @param params 请求参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doGet(String url, Map<String, String> params) throws Exception {
        return doGet(url, null, params);
    }

    /**
     * 发送get请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        // 创建httpClient对象
        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
        ) {
            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);
            setUriParam(params, uriBuilder);

            HttpGet httpGet = createGetRequest(headers, CONNECT_TIMEOUT, SOCKET_TIMEOUT, uriBuilder);
            // 执行请求并获得响应结果
            return getHttpClientResult(httpClient, httpGet);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw e;
        }
    }

    private static void setUriParam(Map<String, String> params, URIBuilder uriBuilder) {
        if (params != null) {
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 发送get请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @param timeOut 超时时间
     * @return
     * @throws Exception
     */
    public static HttpClientResult doGetWithTimeOut(String url, Map<String, String> headers, Map<String, String> params, Integer timeOut) throws Exception {
        // 创建httpClient对象
        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
                // 创建httpResponse对象
                CloseableHttpResponse httpResponse = null;

        ) {
            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);
            setUriParam(params, uriBuilder);

            if (timeOut == null) {
                timeOut = CONNECT_TIMEOUT;
            }

            // 创建http对象
            HttpGet httpGet = createGetRequest(headers, timeOut, timeOut, uriBuilder);
            // 执行请求并获得响应结果
            return getHttpClientResult(httpClient, httpGet);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw e;
        }
    }

    private static HttpGet createGetRequest(Map<String, String> headers, Integer connecttimeOut, Integer sockettimeOut, URIBuilder uriBuilder) throws URISyntaxException {
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connecttimeOut).setSocketTimeout(sockettimeOut).build();
        httpGet.setConfig(requestConfig);

        // 设置请求头
        packageHeader(headers, httpGet);
        return httpGet;
    }

    /**
     * 发送post请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String url) throws Exception {
        return doPost(url, null, null);
    }

    /**
     * 发送post请求；带请求参数
     *
     * @param url    请求地址
     * @param params 参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String url, Map<String, String> params) throws Exception {
        return doPost(url, null, params);
    }

    /**
     * 发送post请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        try (
                // 创建httpClient对象
                CloseableHttpClient httpClient = HttpClients.createDefault();
                // 创建httpResponse对象
                CloseableHttpResponse httpResponse = null;

        ) {
            HttpPost httpPost = createPost(url, headers);

            // 封装请求参数
            packageParam(params, httpPost);
            // 执行请求并获得响应结果
            return getHttpClientResult(httpClient, httpPost);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw e;
        }
    }

    private static HttpPost createPost(String url, Map<String, String> headers) {
        // 创建http对象
        HttpPost httpPost = new HttpPost(url);
        /**
         * setConnectTimeout：设置连接超时时间，单位毫秒。
         * setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
         * 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
         * setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
         */
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        packageHeader(headers, httpPost);
        return httpPost;
    }


    /**
     * 发送post请求；带请求头和请求参数
     *
     * @param contentType 自定义contentType
     * @param url         请求地址
     * @param headers     请求头集合
     * @param params      请求参数集合
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPost(String contentType, String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        // 创建httpClient对象
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            // 创建http对象
            HttpPost httpPost = createPost(url, headers);

            StringEntity s = new StringEntity(JSON.toJSONString(params));
            s.setContentType(contentType);//发送json数据需要设置contentType
            httpPost.setEntity(s);

            try {
                // 执行请求并获得响应结果
                return getHttpClientResult(httpClient, httpPost);
            } catch (Exception e) {
                log.debug(e.getMessage());
                throw e;
            }
        }
    }


    /**
     * Description: 封装请求头
     *
     * @param params
     * @param httpMethod
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException
     */
    public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // 封装请求参数
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<>();
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * Description: 获得响应结果
     *
     * @param httpClient
     * @param httpMethod
     * @return
     * @throws Exception
     */
    public static HttpClientResult getHttpClientResult(CloseableHttpClient httpClient, HttpRequestBase httpMethod) throws Exception {
        // 执行请求
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpMethod)) {
            // 获取返回结果
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                String content = "";
                if (httpResponse.getEntity() != null) {
                    content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
                return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
            }
            return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }

    }

}
