package com.carfriend.Util;

import com.carfriend.Domain.Token;
import com.carfriend.Domain.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class TokenCreator {
    private static Date Expiration=new Date(System.currentTimeMillis()+1000*60*60*24);
    private static String signature="CarFriend";

    //生成token
    private static String createToken(String userID,String permission){
        JwtBuilder builder = Jwts.builder();
        String token=builder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("userID",userID)
                .claim("permission",permission)
                .setId(UUID.randomUUID().toString())
                .setSubject("UserLogin-access")
                .setExpiration(Expiration)
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return token;
    }

    //验证token
    private static Boolean checkToken(String token){
        JwtParser parser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = parser.setSigningKey(signature).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //获取token内的信息
    private static String getTokenInfo(String token){
        JwtParser parser = Jwts.parser();
        //首先先验证token是否失效
        if (checkToken(token)){
            Jws<Claims> claimsJws = parser.setSigningKey(signature).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String userID = body.get("userID", String.class);
            return userID;
        }
        return null;
    }

    /***
     * 根据用户信息生成token
     * @param user 用户信息，用户id和用户权限身份
     * @return token字符串
     */
    public static Token SetNewToken(User user) {
        //登录成功后返回token和用户信息（除密码和id外）
        String tokenId = String.valueOf(user.getId());
        String permission=String.valueOf(user.getPermission());
        String tokenStr = createToken(tokenId,permission);
        return new Token(tokenStr);
    }
}
