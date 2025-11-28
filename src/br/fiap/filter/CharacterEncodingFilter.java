package br.fiap.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização do filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        // Verifica se é uma requisição HTTP
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String requestURI = httpRequest.getRequestURI();
            
            // Não aplica content-type text/html para arquivos estáticos
            if (!isStaticResource(requestURI)) {
                response.setContentType("text/html; charset=UTF-8");
            }
        } else {
            response.setContentType("text/html; charset=UTF-8");
        }
        
        chain.doFilter(request, response);
    }
    
    private boolean isStaticResource(String uri) {
        return uri.endsWith(".css") || 
               uri.endsWith(".js") || 
               uri.endsWith(".png") || 
               uri.endsWith(".jpg") || 
               uri.endsWith(".jpeg") || 
               uri.endsWith(".gif") || 
               uri.endsWith(".svg") || 
               uri.endsWith(".ico") || 
               uri.endsWith(".woff") || 
               uri.endsWith(".woff2") || 
               uri.endsWith(".ttf") || 
               uri.endsWith(".eot");
    }

    @Override
    public void destroy() {
        // Limpeza do filtro
    }
}



