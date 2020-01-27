package com.agroknow.nlpapi.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;
import java.util.stream.Collectors;

@JsonSerialize
public class NlpResponse {

    private String input;

    private List<String> output;

    private String serialized;

    public NlpResponse() {
    }

    public NlpResponse(String input, List<String> output) {
        this.input = input;
        this.output = output;
        serialized = output.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public String getSerialized() {
        return serialized;
    }

    public void setSerialized(String serialized) {
        this.serialized = serialized;
    }
}
