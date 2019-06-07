package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebFilter(filterName = "FooterFilter", urlPatterns = {"*.jsp"},
        initParams = {
                @WebInitParam(name = "footerForm", value = "footerForm.html")},
        servletNames = {"Controller"})
class FootFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        StringResponseWrapper newResp = new StringResponseWrapper(
                (HttpServletResponse) resp
        );
        chain.doFilter(req, newResp);
        StringWriter sw = newResp.getStringWriter();
        String cont = sw.toString();
        PrintWriter out = resp.getWriter();
        String formFile = filterConfig.getInitParameter("footerForm");
        ServletContext context = req.getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-INF/" + formFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        out.println(cont);
        while ((line = br.readLine()) != null) out.println(line);
        out.close();


    }

    @Override
    public void destroy() {

    }

    public void init(FilterConfig filterConfig){
        this.filterConfig = filterConfig;
    }
}

