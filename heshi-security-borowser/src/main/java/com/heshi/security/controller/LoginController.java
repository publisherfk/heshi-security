package com.heshi.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    RequestCache requestCache = new HttpSessionRequestCache();

    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/loginRedirect")
    public String loginRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (null != savedRequest) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发登录的url:{}", targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, "/login");
            }
        }
        return null;
    }
}
