package com.courier.packaging.service.order.config;

import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Value("${service-order-api.http4.maxTotalConnections}")
	private String maxTotalConnections;

	@Value("${service-order-api.http4.connectionsPerRoute}")
	private String connectionsPerRoute;
	
	@Value("${service-order-api.http4.connectionTimeToLive}")
	private String connectionTTL;

	@Value("${service-order-api.request.soTimeout}")
	private String socketTimeOut;

	@Value("${service-order-api.request.connectTimeout}")
	private String connectTimeout;

	@Bean
	public CloseableHttpClient createHttpClient() {
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager(
				Long.parseLong(connectionTTL), TimeUnit.MILLISECONDS);
		poolingConnManager.setMaxTotal(Integer.parseInt(maxTotalConnections));
		poolingConnManager.setDefaultMaxPerRoute(Integer.parseInt(connectionsPerRoute));

		RequestConfig config = RequestConfig.custom().setConnectTimeout(Integer.parseInt(connectTimeout))
				.setSocketTimeout(Integer.parseInt(socketTimeOut)).build();

		CloseableHttpClient client = HttpClients.custom().setConnectionManager(poolingConnManager)
				.setDefaultRequestConfig(config).build();
		return client;
	}

	@Bean
	public ClientHttpRequestFactory httpRequestFactory(CloseableHttpClient httpClient) {
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	@Bean
	public RestTemplate getRestTemplate(ClientHttpRequestFactory requestFactory) {
		return new RestTemplate(requestFactory);
	}
}
