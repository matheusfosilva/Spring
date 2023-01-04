package br.com.sdconecta.estagio;

import br.com.sdconecta.estagio.interceptor.AcessInterceptor;
import br.com.sdconecta.estagio.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AcessInterceptor(acessoRepository)).addPathPatterns("/**");
    }
}
