package com.xiaoming.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * 去连wiremock服务器，先启动wiremock服务器
 */
public class MockServer {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8062);
        WireMock.removeAllMappings();//移除之前的配置
        mock("/order/1", "res1");
        mock("/order/2", "res2");
    }

    /**
     * 收到指定url，从指定文件读取内容
     * @param url
     * @param file
     * @throws IOException
     */
    private static void mock(String url, String file) throws IOException {
        //读取配置文件
        ClassPathResource resource = new ClassPathResource("mock/response/" + file + ".txt");
        //读取配置文件的内容
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        //模拟请求
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url)).willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}