package com.yuan.commons.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @author by yuanlai
 * @Date 2020/2/12 8:52 下午
 * @Description: JwtUtils
 * @Version 1.0
 */

/**
 * jwt加密和解密的工具类
 */
public class JwtUtils {

    private static String secretKey="itech4u";

    /**
     * 1h
     */
    private static long validityInMilliseconds = 3600000L;

    private final static String ISSUER = "itech4u";

    /**
     * 比如用户输入用户名和密码 若登录合法就生成jwt的一个token 发送给前端 前端存储到localStorage
     * 然后用户每次发起请求都从本地获取 携带着一个token送至后台 去验证  从而完成身份的验证
     * 签发JWT
     *
     * @param subject   用户信息 默认放JSON数据
     * @param ttlMillis 有效期 这里是1小时
     * @return
     */

    public static String createJWT( String subject, long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                //jwt id 唯一性
                .setId(UUID.randomUUID().toString())
                // 主题
                .setSubject(subject)
                // 签发者
                .setIssuer(ISSUER)
                // 签发时间
                .setIssuedAt(now)
                // 签名算法以及密匙
                .signWith(SignatureAlgorithm.HS256, generalKey());
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            // 过期时间
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 验证JWT  需要把jwt的token传过来
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 生成加密Key
     * 解密时也要用到 因为在刷新token时要通过原来生成的token解密获取用户id 和用户名(subject) 重新生成token
     *
     * @return
     */
    public static String generalKey() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


    /**
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt)  {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(jwt)
                .getBody();
    }


    /**
     * 解析JWT字符串并提取字段
     * @param jwt
     * @return
     */
    public static Object getJWTSubjectValue(String jwt,String key){
        Claims claims=parseJWT(jwt);
        String subject = claims.getSubject();
        JSONObject jsonObject= JSON.parseObject(subject);
        return jsonObject.get(key);
    }

    public static void main(String[] args) throws InterruptedException {
        String token = createJWT("laiyuan",validityInMilliseconds);
        System.out.println("jwt:"+token);



        System.out.println("验证token:"+validateToken(token));

        Claims claims=parseJWT(token);
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());


        String newtoken = createJWT(claims.getSubject(),validityInMilliseconds);
        System.out.println("newjwt:"+newtoken);

        System.out.println("验证旧token:"+validateToken(token));

    }
}