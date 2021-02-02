package lk.ijse.dep.exception;

/**
 * Created by Sesath De Costa on 2021-02-01
 * <p>
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 **/

public class HttpResponseException extends RuntimeException {
    private int statusCode;

    public HttpResponseException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.setStatusCode(statusCode);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
