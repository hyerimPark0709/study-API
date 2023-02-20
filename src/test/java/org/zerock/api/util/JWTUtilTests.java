package org.zerock.api.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTests {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {
        Map<String, Object> claimMap = Map.of("mid", "ABCDE");
        String jwtStr = jwtUtil.generateToken(claimMap, 1);
        log.info(jwtStr);
    }

    @Disabled
    @Test
    public void testValidate() {
        // 유효 시간 지난 토큰
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzY0NDc2MjksIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNjc2NDQ3NTY5fQ.zZHTrhnL30kxy5SZMxDNcriP8EB2q47BjFb2rEs4kYY";

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);
    }

    @Test
    public void testAll() {
        String jwtStr = jwtUtil.generateToken(Map.of("mid", "AAAA", "email", "aaaa@bbb.com"), 1);
        log.info(jwtStr);

        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info("MID: " + claim.get("mid"));
        log.info("EMAIL: " + claim.get("email"));
    }

}
