package info.xyzxyz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restcalc")
public class RestCalcController {

	private boolean isANumber(String s) {
		return s.matches("\\d+(\\.\\d+)?");
	}

	@GetMapping("/{arg1}/plus/{arg2}")
	public RestResponse add(@PathVariable String arg1, @PathVariable String arg2) {

		if ((!isANumber(arg1)) || (!isANumber(arg2))) {
			return new RestError("Invalid arguments.");
		}

		double arg1d = Double.valueOf(arg1);
		double arg2d = Double.valueOf(arg2);

		double answer = arg1d + arg2d;

		return new RestResponse(String.valueOf(answer));
	}

	@GetMapping("/{arg1}/minus/{arg2}")
	public RestResponse subtract(@PathVariable String arg1, @PathVariable String arg2) {

		if ((!isANumber(arg1)) || (!isANumber(arg2))) {
			return new RestError("Invalid arguments.");
		}

		double arg1d = Double.valueOf(arg1);
		double arg2d = Double.valueOf(arg2);

		double answer = arg1d - arg2d;

		return new RestResponse(String.valueOf(answer));
	}

	@GetMapping("/{arg1}/times/{arg2}")
	public RestResponse multiply(@PathVariable String arg1, @PathVariable String arg2) {

		if ((!isANumber(arg1)) || (!isANumber(arg2))) {
			return new RestError("Invalid arguments.");
		}

		double arg1d = Double.valueOf(arg1);
		double arg2d = Double.valueOf(arg2);

		double answer = arg1d * arg2d;

		return new RestResponse(String.valueOf(answer));
	}

	@GetMapping("/{arg1}/dividedby/{arg2}")
	public RestResponse divide(@PathVariable String arg1, @PathVariable String arg2) {

		if ((!isANumber(arg1)) || (!isANumber(arg2))) {
			return new RestError("Invalid arguments.");
		}

		double arg1d = Double.valueOf(arg1);
		double arg2d = Double.valueOf(arg2);

		double answer = arg1d / arg2d;

		return new RestResponse(String.valueOf(answer));
	}

}
