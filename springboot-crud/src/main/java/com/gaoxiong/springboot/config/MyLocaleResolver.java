package com.gaoxiong.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author gaoxiong
 * @ClassName MyLocaleResolver
 * @Description TODO
 * @date 2018/9/24 1:19
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale ( HttpServletRequest request ) {
        //通过请求头中的参数来设置区域信息
        String language = request.getParameter("language");
        System.out.println(language);
        String[] split = language.split("_");
        Locale locale = Locale.getDefault();
        if (StringUtils.isEmpty(language)) {
            locale=new Locale(split[0],split[1] );
        }

        return locale;
    }

    @Override
    public void setLocale ( HttpServletRequest request, HttpServletResponse response, Locale locale ) {

    }

}
