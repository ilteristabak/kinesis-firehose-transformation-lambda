package indie.ilteristabak.enumeration;

public enum transformedState {
    OK("Ok"),
    DROPPED("Dropped"),
    PROCESSING_FAILED("ProcessingFailed");

    private String name;

    transformedState(String name) {
        this.name = name;
    }

    public String text(){
        return name;
    }
}
