package com.song.simplebb.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnvHelperTest {
    @Test
    public void testEnv() {
        HashMap<String, String> env = EnvHelper.getEnv();
        assertEquals("1234", env.get("TEST"));
    }
}