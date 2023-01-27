package com.openai.api;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class OpenAIResponse implements Serializable {
    private String       id;
    private String       object;
    private Long         created;
    private String       model;
    private List<Choice> choices;
    private Usage        usage;

    public OpenAIResponse() {
    }

    public OpenAIResponse(String id, String object, Long created, String model, List<Choice> choices, Usage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OpenAIResponse.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("object='" + object + "'")
                .add("created=" + created)
                .add("model='" + model + "'")
                .add("choices=" + choices)
                .add("usage=" + usage)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
