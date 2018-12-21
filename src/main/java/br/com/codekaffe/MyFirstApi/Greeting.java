package br.com.codekaffe.MyFirstApi;

public class Greeting {
    private String message;

    public Greeting() {
        this("Hello Man,I see later");
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
