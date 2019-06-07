package filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.*;

@WebFilter(filterName = "Header", urlPatterns = {".jsp"}, initParams = {
        @WebInitParam(name = "Header", value = "headerForm.html")},
        servletNames = {"Controller"})
public class HeaderFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String formFile = filterConfig.getInitParameter("headerForm");
        ServletContext context = servletRequest.getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-INF/" + formFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        PrintWriter out = servletResponse.getWriter();
        while ((line = br.readLine()) != null) out.println(line);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
