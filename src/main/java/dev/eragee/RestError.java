package dev.eragee;

public class RestError extends RestResponse {

	public RestError(String error) {
		super("error", error);
	}

}
