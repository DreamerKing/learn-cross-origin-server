package CO.CrossOrigin;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.util.ObjectUtils.isEmpty;

public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String origin = req.getHeader("Origin");
        String headers = req.getHeader("Access-Control-Request-Headers");
        if(!isEmpty(origin)){
            res.addHeader("Access-Control-Allow-Origin", origin);
        }
        if(!isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers", headers);
        }
        res.addHeader("Access-Control-Allow-Methods", "*");
        //res.addHeader("Access-Control-Allow-Headers", "Content-Type, x-header-1, x-header-2");
        // enable cookies
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Max-Age", "3600");
        //res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
       // res.addHeader("Access-Control-Allow-Methods", "GET");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
