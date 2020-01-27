package com.agroknow.nlpapi.controllers;

import com.agroknow.nlpapi.model.Annotation;
import com.agroknow.nlpapi.model.NERAnnotation;
import com.agroknow.nlpapi.model.response.NlpResponse;
import com.agroknow.nlpapi.model.response.Response;
import com.agroknow.nlpapi.repository.ontology.ElasticProperties;
import com.agroknow.nlpapi.service.term.TermService;
import com.agroknow.nlpapi.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class SemanticController {

    @Autowired
    public ElasticProperties properties;

    @Autowired
    public TermService termService;

    @Value("${ngrams}")
    private Integer ngramCount;

    @Value("${search.orDelimiter}")
    private String orDelimiter;

    @RequestMapping(method = RequestMethod.POST, path = {"/semantic-api/terms/annotate"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> nerAnnonate(@RequestBody String input, @RequestParam(name = "vocabulary", required = false) List<String> vocabularies) throws Exception {

        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        input = input.replace("\"", "");
        input = input.substring(0, Math.min(input.length(), 200));

        Long start = System.currentTimeMillis();
        List<String> ngrams = Arrays.stream(input.split(orDelimiter))
                .map(v -> v.replace("\"", "")).collect(Collectors.toList());

        List<NERAnnotation> annotations = new ArrayList<>();

        List<String> finalNgrams = ngrams;
        vocabularies.stream().forEach(v -> {
            finalNgrams.forEach(ng -> {
                List<Annotation> annotationList = null;
                try {
                    annotationList = termService.annotateWithVocabulary(ng, v, properties);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                annotationList.forEach(a -> annotations.add(new NERAnnotation(a, ng)));
            });
        });
        ResponseGenerator.generateValidResponse(response, annotations.stream().distinct().collect(Collectors.toList()));
        return ResponseEntity.status(response.getStatus()).body(response.getBody());
    }

    @ApiIgnore
    @RequestMapping(method = RequestMethod.POST, path = {"/terms/annotate"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> nerAnnonateSecond(@RequestBody String input, @RequestParam(name = "vocabulary", required = false) List<String> vocabularies) throws Exception {
        return nerAnnonate(input, vocabularies);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/semantic-api/nlp/stopwords", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> removeStopwords(@RequestParam(value = "input") String input) throws Exception {

        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }

    @ApiIgnore
    @RequestMapping(method = RequestMethod.POST, path = "/nlp/stopwords", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> removeStopwordsSecond(@RequestParam(value = "input") String input) throws Exception {
        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/semantic-api/nlp/tag", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> keepTags(
            @RequestParam(value = "input") String input,
            @RequestParam(value = "tags") List<String> tags
    ) throws Exception {
        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/nlp/tag", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> keepTagsSecond(
            @RequestParam(value = "input") String input,
            @RequestParam(value = "tags") List<String> tags
    ) throws Exception {
        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/semantic-api/nlp/ngrams", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> generateNgrams(
            @RequestParam(value = "input") String input,
            @RequestParam(value = "ngramSize") int ngramSize
    ) throws Exception {
        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }

    @ApiIgnore
    @RequestMapping(method = RequestMethod.POST, path = "/nlp/ngrams", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> generateNgramsSecond(
            @RequestParam(value = "input") String input,
            @RequestParam(value = "ngramSize") int ngramSize
    ) throws Exception {
        /*
         * TODO:
         *   insert logic here
         * */
        return null;
    }


    private ResponseEntity<String> generateResponse(String input, List<String> result) throws Exception {
        NlpResponse nlpResponse = new NlpResponse(input, result);

        Response response = new Response();
        response.setStatus(HttpStatus.OK);
        ResponseGenerator.generateValidResponse(response, nlpResponse);
        return ResponseEntity.status(response.getStatus()).body(response.getBody());
    }
}
