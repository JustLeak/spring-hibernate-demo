package by.intexsoft.demo.model;

public class Response {
    private boolean success;
    private Object data;
    private Object error;

    private Response(boolean success, Object data, Object error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static Response errorResponse(Object error) {
        return new Response(false, null, error);
    }

    public static Response successResponse(Object data) {
        return new Response(true, data, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
