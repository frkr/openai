package com.openai.api;

import java.io.Serializable;
import java.util.StringJoiner;

public class Usage implements Serializable {
    private Long prompt_tokens;
    private Long completion_tokens;
    private Long total_tokens;

    public Usage() {
    }

    public Usage(Long prompt_tokens, Long completion_tokens, Long total_tokens) {
        this.prompt_tokens = prompt_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Usage.class.getSimpleName() + "[", "]")
                .add("prompt_tokens=" + prompt_tokens)
                .add("completion_tokens=" + completion_tokens)
                .add("total_tokens=" + total_tokens)
                .toString();
    }

    public Long getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setPrompt_tokens(Long prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public Long getCompletion_tokens() {
        return completion_tokens;
    }

    public void setCompletion_tokens(Long completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public Long getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(Long total_tokens) {
        this.total_tokens = total_tokens;
    }
}
