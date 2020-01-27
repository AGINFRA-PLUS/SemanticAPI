package com.agroknow.nlpapi.service.term;

import com.agroknow.nlpapi.model.Annotation;
import com.agroknow.nlpapi.repository.ontology.ElasticProperties;
import com.agroknow.nlpapi.service.term.AnnotationService;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TermService implements AnnotationService {

    @Value("${nlp.confidence.threshold}")
    private Double threshold;

    @Override
    public List<Annotation> annotate(String text, ElasticProperties properties) {
        /*
        * TODO:
        *   insert logic here
        * */
        return null;
    }

    @Override
    public List<Annotation> annotateWithVocabulary(String text, String vocabulary, ElasticProperties properties) {
        return null;
    }

    @Override
    public List<Annotation> extractEntityTypes(String text) {
        return null;
    }

}
