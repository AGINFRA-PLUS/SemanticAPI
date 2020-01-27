package com.agroknow.nlpapi.repository.ontology;


import com.agroknow.nlpapi.model.ontology.Term;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface TermRepository extends ElasticsearchRepository<Term, String> {

    default List<Term> findAllByLabelStrict(String label, ElasticProperties properties) throws Exception {
        return null;
    }

    default List<Term> findAllByLabelStrictAndVocabulary(String label, String vocabulary, ElasticProperties properties) throws Exception {
        return null;
    }

    Iterable<Term> findAllByMissingMultiLingualLabel();

    Iterable<Term> findAllByVocabulary(String vocabulary);


}
