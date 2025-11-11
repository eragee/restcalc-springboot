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

    private String formatNumber(double n) {
        // If n is an integer (e.g., 12.0), return "12"; otherwise return the normal string form
        if (n == Math.rint(n)) {
            return String.valueOf((long) n);
        }
        return String.valueOf(n);
    }

    @GetMapping("/{arg1}/plus/{arg2}")
    public RestResponse add(@PathVariable String arg1, @PathVariable String arg2) {
        if ((!isANumber(arg1)) || (!isANumber(arg2))) {
            return new RestError("Invalid arguments.");
        }
        double answer = Double.parseDouble(arg1) + Double.parseDouble(arg2);
        return new RestResponse(formatNumber(answer));
    }

    @GetMapping("/{arg1}/minus/{arg2}")
    public RestResponse subtract(@PathVariable String arg1, @PathVariable String arg2) {
        if ((!isANumber(arg1)) || (!isANumber(arg2))) {
            return new RestError("Invalid arguments.");
        }
        double answer = Double.parseDouble(arg1) - Double.parseDouble(arg2);
        return new RestResponse(formatNumber(answer));
    }

    @GetMapping("/{arg1}/times/{arg2}")
    public RestResponse multiply(@PathVariable String arg1, @PathVariable String arg2) {
        if ((!isANumber(arg1)) || (!isANumber(arg2))) {
            return new RestError("Invalid arguments.");
        }
        double answer = Double.parseDouble(arg1) * Double.parseDouble(arg2);
        return new RestResponse(formatNumber(answer));
    }

    @GetMapping("/{arg1}/dividedby/{arg2}")
    public RestResponse divide(@PathVariable String arg1, @PathVariable String arg2) {
        if ((!isANumber(arg1)) || (!isANumber(arg2))) {
            return new RestError("Invalid arguments.");
        }
        double divisor = Double.parseDouble(arg2);
        double dividend = Double.parseDouble(arg1);

        if (divisor == 0.0) {
            return new RestError("Division by zero.");
        }

        double answer = dividend / divisor;
        return new RestResponse(formatNumber(answer));
    }
}
