package com.agroknow.nlpapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonSerialize
public class Annotation {

    private String value;

    private Double confidence;

    private String ontology;

    private String uri;

    @JsonProperty("annotated_by")
    private String annotatedBy;

    private String id;

    private List<String> children = new ArrayList<>();

    private List<String> parents = new ArrayList<>();

    public Annotation() {
    }

    public Annotation(String value, Double confidence, String ontology, String uri, String annotatedBy) {
        this.value = value;
        this.confidence = confidence;
        this.ontology = ontology;
        this.uri = uri;
        this.annotatedBy = annotatedBy;
    }

    public Annotation(String value, Double confidence, String ontology, String uri, String annotatedBy, List<String> children, List<String> parents) {
        this.value = value;
        this.confidence = confidence;
        this.ontology = ontology;
        this.uri = uri;
        this.annotatedBy = annotatedBy;
        this.children = children;
        this.parents = parents;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getOntology() {
        return ontology;
    }

    public void setOntology(String ontology) {
        this.ontology = ontology;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAnnotatedBy() {
        return annotatedBy;
    }

    public void setAnnotatedBy(String annotatedBy) {
        this.annotatedBy = annotatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annotation that = (Annotation) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(uri, that.uri) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, uri, id);
    }
}
