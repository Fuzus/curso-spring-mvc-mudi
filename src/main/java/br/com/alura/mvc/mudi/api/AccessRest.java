package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.interceptior.AccessInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessRest {

    @GetMapping
    public List<AccessInterceptor.Access> getAccess() {
        return AccessInterceptor.list;
    }
}
