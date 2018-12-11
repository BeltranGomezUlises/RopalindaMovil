package com.ropalinda.ropalindamovil.Entities;

public class WSRes<T> {

    private T data;
    private Meta meta;

    public WSRes() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public enum Status {
        OK, WARNING, ERROR, ACCESS_DENIED, INVALID_PARAM
    }

    public static class Meta {
        private Status status;
        private String devMessage;
        private String message;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getDevMessage() {
            return devMessage;
        }

        public void setDevMessage(String devMessage) {
            this.devMessage = devMessage;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
