package com.openai.api;

import java.io.Serializable;
import java.util.StringJoiner;

public class Choice implements Serializable {
    private String text;
    private Long   index;
    private Object logprobs;
    private String finish_reason;

    public Choice() {
    }

    public Choice(String text, Long index, Object logprobs, String finish_reason) {
        this.text = text;
        this.index = index;
        this.logprobs = logprobs;
        this.finish_reason = finish_reason;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Choice.class.getSimpleName() + "[", "]")
                .add("text='" + text + "'")
                .add("index=" + index)
                .add("logprobs=" + logprobs)
                .add("finish_reason='" + finish_reason + "'")
                .toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}
