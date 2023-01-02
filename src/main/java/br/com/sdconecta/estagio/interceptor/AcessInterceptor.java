package br.com.sdconecta.estagio.interceptor;

import br.com.sdconecta.estagio.model.Acesso;
import br.com.sdconecta.estagio.repository.AcessoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.time.LocalDateTime;

public class AcessInterceptor implements HandlerInterceptor {

    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Acesso acesso = new Acesso();
        acesso.setPath(request.getRequestURI());
        acesso.setDate(LocalDateTime.now());
        request.setAttribute("acesso", acesso);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.setDuration(Duration.between( acesso.getDate() ,LocalDateTime.now()));
        acessoRepository.save(acesso);
    }

}
