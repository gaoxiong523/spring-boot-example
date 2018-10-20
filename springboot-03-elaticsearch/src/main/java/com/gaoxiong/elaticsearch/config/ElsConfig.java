package com.gaoxiong.elaticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @author gaoxiong
 * @ClassName ElsConfig
 * @Description TODO
 * @date 2018/10/18 23:10
 */
@Configuration
public class ElsConfig {
  /*  @Bean
    public TransportClient transportClient() throws Exception {
        TransportClientFactoryBean factoryBean = new TransportClientFactoryBean();
        factoryBean.setClusterNodes("192.168.1.104:9300");
        return factoryBean.getObject();
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
       return new ElasticsearchTemplate(transportClient());
    }*/
}
