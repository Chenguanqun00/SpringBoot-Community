package com.animo.redis.service.impl;

import com.animo.redis.service.SetOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
public class SetOperationsServiceImpl implements SetOperationsService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  添加到集合中的元素数量，不包括已存在于集合中的所有元素。
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long add(Object key, Object[] values) {
        return redisTemplate.opsForSet().add(key,values);
    }

    /**
     * 从存储的集合中删除指定的成员key。
     * 不包含此集合成员的指定成员将被忽略。
     * 如果key不存在，则将其视为空集并返回此命令 0。
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long remove(Object key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 删除并返回
     * @param key
     * @return
     */
    @Override
    public Object pop(Object key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 删除并返回
     * @param key
     * @param count 删除的个数
     * @return
     */
    @Override
    public List pop(Object key, long count) {
        return null;
    }

    /**
     *  如果value不存在或不包含于key指定的元素，则不执行任何操作并0返回。
     *  否则，将从key中删除该元素并将其添加到destKey。
     *  当指定的value已存在于destKey时，它仅从key中删除
     * @param key
     * @param value
     * @param destKey
     * @return
     */
    @Override
    public Boolean move(Object key, Object value, Object destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * 集合的基数（元素数），或者0如果key 不存在。
     * @param key
     * @return
     */
    @Override
    public Long size(Object key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 1 如果元素是集合的成员。
     * 0如果元素不是集合的成员，或者如果key不存在。
     * @param key
     * @param o
     * @return
     */
    @Override
    public Boolean isMember(Object key, Object o) {
        return redisTemplate.opsForSet().isMember(key, o);
    }

    /**
     *  返回key 和 otherKey 相同的值
     * @param key
     * @param otherKey
     * @return
     */
    @Override
    public Set intersect(Object key, Object otherKey) {
        return redisTemplate.opsForSet().intersect(key, otherKey);
    }

    /**
     * 可以传入多个值
     * @param key
     * @param otherKeys
     * @return
     */
    @Override
    public Set intersect(Object key, Collection otherKeys) {
        return redisTemplate.opsForSet().intersect(key, otherKeys);
    }

    /**
     * 此命令等于SINTER，但不是返回结果集，而是存储在destination。
     * 如果destination已经存在，则会被覆盖。
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    @Override
    public Long intersectAndStore(Object key, Object otherKey, Object destKey) {
        return redisTemplate.opsForSet().intersectAndStore(key, otherKey, destKey);
    }

    /**
     *
     * @param key
     * @param otherKeys 可以传入多个keys
     * @param destKey
     * @return
     */
    @Override
    public Long intersectAndStore(Object key, Collection otherKeys, Object destKey) {
        return redisTemplate.opsForSet().intersectAndStore(key, otherKeys, destKey);
    }

    /**
     * 返回所有集合 会去重复
     * @param key
     * @param otherKey
     * @return
     */
    @Override
    public Set union(Object key, Object otherKey) {
        return redisTemplate.opsForSet().union(key, otherKey);
    }

    /**
     * 返回所有集合  可传入N Key 会去重复
     * @param key
     * @param otherKeys
     * @return
     */
    @Override
    public Set union(Object key, Collection otherKeys) {
        return redisTemplate.opsForSet().union(key, otherKeys);
    }

    /**
     *  返回所有key的值到 destKey  如果存在则覆盖 并返回添加长度
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    @Override
    public Long unionAndStore(Object key, Object otherKey, Object destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     * 可以传入多个值
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    @Override
    public Long unionAndStore(Object key, Collection otherKeys, Object destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
    }

    /**
     *  otherKey中包含key的值之外的全部返回
     * @param key
     * @param otherKey
     * @return
     */
    @Override
    public Set difference(Object key, Object otherKey) {
        return redisTemplate.opsForSet().difference(key, otherKey);
    }

    /**
     * 可以传入集合对象
     * @param key
     * @param otherKeys
     * @return
     */
    @Override
    public Set difference(Object key, Collection otherKeys) {
        return redisTemplate.opsForSet().difference(key, otherKeys);
    }

    /**
     * otherKey中包含key的值之外的值 存入destKey 重复即覆盖
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    @Override
    public Long differenceAndStore(Object key, Object otherKey, Object destKey) {
        return redisTemplate.opsForSet().differenceAndStore(key, otherKey, destKey);
    }

    /**
     * 可以传入多个值
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    @Override
    public Long differenceAndStore(Object key, Collection otherKeys, Object destKey) {
        return redisTemplate.opsForSet().differenceAndStore(key, otherKeys, destKey);
    }

    /**
     *  返回所有集合
     * @param key
     * @return
     */
    @Override
    public Set members(Object key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 随机返回一个值
     * @param key
     * @return
     */
    @Override
    public Object randomMember(Object key) {
        return redisTemplate.opsForSet().randomMember(key);
    }


    /**
     * 目前不知道什么意思
     * @param key
     * @param count
     * @return
     */
    @Override
    public Set distinctRandomMembers(Object key, long count) {
        return redisTemplate.opsForSet().distinctRandomMembers(key, count);
    }

    /**
     * 随机返回值 并且可以设置返回的数量
     * @param key
     * @param count
     * @return
     */
    @Override
    public List randomMembers(Object key, long count) {
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     *
     * @param key
     * @param options
     * @return
     */
    @Override
    public Cursor scan(Object key, ScanOptions options) {
        return redisTemplate.opsForSet().scan(key, options);
    }

    @Override
    public RedisOperations getOperations() {
        return null;
    }
}
