package info.xyzxyz;

public class RestError extends RestResponse {

	public RestError(String error) {
		super("error", error);
	}

}
