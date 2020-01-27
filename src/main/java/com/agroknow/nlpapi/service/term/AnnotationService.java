package com.agroknow.nlpapi.service.term;

import com.agroknow.nlpapi.model.Annotation;
import com.agroknow.nlpapi.repository.ontology.ElasticProperties;

import java.util.List;

public interface AnnotationService {

    List<Annotation> annotate(String text, ElasticProperties properties) throws Exception;

    List<Annotation> annotateWithVocabulary(String text, String vocabulary, ElasticProperties properties) throws Exception;

    List<Annotation> extractEntityTypes(String text);

}
