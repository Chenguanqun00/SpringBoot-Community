package com.animo.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ValueOperationsServiceImpl implements ValueOperations {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  会替换之前所存在的值
     * @param key
     * @param value
     */
    @Override
    public void set(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 存储设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    @Override
    public void set(Object key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 有则无需插入 如果没有则插入
     * @param key
     * @param value
     * @return
     */
    @Override
    public Boolean setIfAbsent(Object key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 插入多个key和对应的多个value  会替换新的值
     * @param map
     */
    @Override
    public void multiSet(Map map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 有则无需插入 如果没有则插入
     * @param map
     * @return
     */
    @Override
    public Boolean multiSetIfAbsent(Map map) {
        return redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    /**
     * 通过Key查询返回单个对象
     * @param key
     * @return
     */
    @Override
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 先获取旧值在重新设置新值
     * @param key
     * @param value
     * @return
     */
    @Override
    public Object getAndSet(Object key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    /**
     * 传入多个Key 返回List  获取顺序为Key传入的顺序
     * @param keys
     * @return
     */
    @Override
    public List multiGet(Collection keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 将该key下面的整数值递增 delta大小
     * 将存储的数字增加key一。如果密钥不存在，
     * 则0在执行操作之前将其设置为。
     * 如果密钥包含错误类型的值或包含不能表示为整数的字符串，
     * 则会返回错误。此操作仅限于64位有符号整数。
     * @param key
     * @param delta
     * @return
     */
    @Override
    public Long increment(Object key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public Double increment(Object key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     *  在原有的基础上往末尾添加Value（不存在则创建） 然后在返回总值的长度
     * @param key
     * @param value
     * @return
     */
    @Override
    public Integer append(Object key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    /**
     * 获取值 可以设置起点和终点 终点可设置－1 表示尽头 －2倒数第二个 以此类推
     * @param key
     * @param start
     * @param end
     * @return
     */
    @Override
    public String get(Object key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    /**
     * 在指定偏移处开始的键处覆盖字符串的一部分
     * @param key
     * @param value
     * @param offset
     */
    @Override
    public void set(Object key, Object value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * 返回该key的长度
     * @param key
     * @return
     */
    @Override
    public Long size(Object key) {
        return redisTemplate.opsForValue().size(key);
    }

    /**
     * 设置或清除键处存储的字符串值中的偏移位。
     * @param key
     * @param offset
     * @param value
     * @return
     */
    @Override
    public Boolean setBit(Object key, long offset, boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    @Override
    public Boolean getBit(Object key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    @Override
    public RedisOperations getOperations() {
        return null;
    }
}
