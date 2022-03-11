package com.gourmetapi.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具包
 *
 * @author none
 * @since 2022/3/11 2:42 PM
 */
@Log4j2
public class JwtUtil {

    private static final String JWT_CLAIM_KEY ="tokenObj-key";
    private static final String JWT_SECRET_KEY ="jwtSecret-Key";

    /**
     * 生成jwt的token串
     * @param value
     * @return
     */
    public static String createJwtToken(String value)
    {
        Map<String,Object> claims=new HashMap<>();
        claims.put(JWT_CLAIM_KEY,value);
        Calendar calendar=Calendar.getInstance();
        //当前时间添加24是小时,即token在24小时后过期
        calendar.add(Calendar.HOUR_OF_DAY,24);
        return Jwts.builder()
                //设置载荷部分
                .setClaims(claims)
                //设置过期时间
                .setExpiration(calendar.getTime())
                //设置加密算法
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
    }

    /**
     * 从jwttoken串中获取载荷值
     * @param tokenStr
     * @return
     */
    public static String getJwtTokenClaimValue(String tokenStr)
    {
        String result=null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET_KEY)
                    .parseClaimsJws(tokenStr)
                    .getBody();

            if(claims.getExpiration().compareTo(Calendar.getInstance().getTime())>0)
            {
                //token未过期
                result=claims.get(JWT_CLAIM_KEY,String.class);
            }
        } catch (Exception ex) {
            log.error(ex);
        }
        return result;
    }
}
