package com.agroknow.nlpapi.repository.ontology;



import org.apache.http.HttpHost;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "elastic")
public class ElasticProperties {

    private Integer port;

    private List<String> hosts;

    private List<String> keywordFields;

    private String clusterName;

    private String indexName;

    private String scheme;

    private Map<String, String> indexMapper;

    public ElasticProperties() {
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public List<HttpHost> getHttpHosts() {
        return hosts.stream().map( h -> new HttpHost(h, port, scheme)).collect(Collectors.toList());
    }

    public Map<String, String> getIndexMapper() {
        return indexMapper;
    }

    public void setIndexMapper(Map<String, String> indexMapper) {
        this.indexMapper = indexMapper;
    }

    public List<String> getKeywordFields() {
        return keywordFields;
    }

    public void setKeywordFields(List<String> keywordFields) {
        this.keywordFields = keywordFields;
    }
}
