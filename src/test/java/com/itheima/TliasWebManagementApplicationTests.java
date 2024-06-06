package com.itheima;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    //------------------------测试生成JWT令牌
    // 用jwts工具包中的方法builder
    // setClaims 方法自定义载荷
    // SignWith 签名算法
    // eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcxNzY4MTEzOX0.xRvVRbrszVvE86Dif45Q7Izfymue6eF0aojLuVJAeus
    // --前两位都是Base64编码的结果--可以反编码-- 第三部分是签名算法
    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");

        String jwt = Jwts.builder()
                .setClaims(claims) //自定义内容（载荷）
                .signWith(SignatureAlgorithm.HS256,"xinhuo")  //签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 12*3600*1000)) //设置有效期为12h
                .compact();
        System.out.println(jwt);
    }

    //-----------------------测试解析Jwt令牌
    // Jwt 校验时使用的是签名密钥 必须和生成Jwt令牌使用的密钥配套
    //
    @Test
    public void testParseJwt(){
         Claims claims = Jwts.parser()
                 .setSigningKey("xinhuo") // 签名密钥
                 .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcxNzY4MTEzOX0.xRvVRbrszVvE86Dif45Q7Izfymue6eF0aojLuVJAeus")
                 .getBody();
        System.out.println(claims);
    }

}
