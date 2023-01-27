package com.openai.api;

import java.io.Serializable;
import java.util.StringJoiner;

public class OpenAIRequest implements Serializable {
    private String model;
    private String prompt;
    private Long   temperature;
    private Long   max_tokens;
    private Long   top_p;
    private Double frequency_penalty;
    private Long   presence_penalty;

    public OpenAIRequest() {
    }

    public OpenAIRequest(String model, String prompt, Long temperature, Long max_tokens, Long top_p, Double frequency_penalty, Long presence_penalty) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
        this.top_p = top_p;
        this.frequency_penalty = frequency_penalty;
        this.presence_penalty = presence_penalty;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("model='" + model + "'")
                .add("prompt='" + prompt + "'")
                .add("temperature=" + temperature)
                .add("max_tokens=" + max_tokens)
                .add("top_p=" + top_p)
                .add("frequency_penalty=" + frequency_penalty)
                .add("presence_penalty=" + presence_penalty)
                .toString();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Long max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Long getTop_p() {
        return top_p;
    }

    public void setTop_p(Long top_p) {
        this.top_p = top_p;
    }

    public Double getFrequency_penalty() {
        return frequency_penalty;
    }

    public void setFrequency_penalty(Double frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public Long getPresence_penalty() {
        return presence_penalty;
    }

    public void setPresence_penalty(Long presence_penalty) {
        this.presence_penalty = presence_penalty;
    }
}
