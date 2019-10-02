package by.intexsoft.demo.model;

public class ServiceResponse<T> {
    private boolean success;
    private T responseData;

    public ServiceResponse(boolean success, T responseData) {
        this.success = success;
        this.responseData = responseData;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponseData() {
        return responseData;
    }
}
