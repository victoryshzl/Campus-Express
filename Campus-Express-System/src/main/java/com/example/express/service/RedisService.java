package com.example.express.service;

import java.util.concurrent.TimeUnit;


public interface RedisService {
    boolean checkRequestRateLimit(final String key, final int expireTime, final int max, TimeUnit timeUnit, String userAgent);
}
