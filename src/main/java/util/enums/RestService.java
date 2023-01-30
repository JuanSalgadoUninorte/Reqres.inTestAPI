package util.enums;

public enum RestService {
    BASE_URL("https://reqres.in/api/");

    String url;

    RestService(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return url;
    }
}
