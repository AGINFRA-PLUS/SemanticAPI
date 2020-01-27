package com.agroknow.nlpapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonSerialize
public class NERAnnotation {

    private String text;

    private String label;

    private String ontology;

    private Double confidence;

    private List<String> children = new ArrayList<>();

    private List<String> parents = new ArrayList<>();

    public NERAnnotation() {
    }

    public NERAnnotation(String text, String label, String ontology, Double confidence) {
        this.text = text;
        this.label = label;
        this.ontology = ontology;
        this.confidence = confidence;
    }

    public NERAnnotation(Annotation annotation, String text) {
        this.text = text;
        this.label = annotation.getValue();
        this.ontology = annotation.getOntology();
        this.confidence = annotation.getConfidence();

        this.children = annotation.getChildren();
        this.parents = annotation.getParents();
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOntology() {
        return ontology;
    }

    public void setOntology(String ontology) {
        this.ontology = ontology;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NERAnnotation that = (NERAnnotation) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(label, that.label) &&
                Objects.equals(ontology, that.ontology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, label, ontology);
    }
}
