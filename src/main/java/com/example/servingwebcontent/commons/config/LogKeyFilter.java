package com.example.servingwebcontent.commons.config;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2020/02/18
 *
 * @author 최성헌
 * @since JDK1.8
 */
@Slf4j
@Component
public class LogKeyFilter extends OncePerRequestFilter {
    private static final String logKeyName = "logKey";
    private String lastIpNumber;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    public LogKeyFilter() {
        String ip;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ip = "000.000.000.000";
        }

        final Matcher matcher = Pattern.compile("\\d+$").matcher(ip);
        if (matcher.find()) {
            this.lastIpNumber = Strings.padStart(matcher.group(), 3, '0');
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String logKey = this.lastIpNumber + "_"
                + LocalDateTime.now().format(formatter) + "_"
                + UUID.randomUUID().toString().replace("-", "");
        MDC.put(logKeyName, logKey);
        filterChain.doFilter(request, response);
    }
}
