package com.animo.redis.service.impl;

import com.animo.redis.service.ListOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ListOperationsServiceImpl implements ListOperationsService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 从指定的start 到 end 返回key 0 －1 可以返回全部
     * @param key key
     * @param start 起始位置
     * @param end 结束位置
     * @return List集合
     */
    @Override
    public List range(Object key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 修剪list 修剪样子 start 到 end之间
     * LTRIM foobar 0 2将修改存储的列表，foobar以便只保留列表的前三个元素
     * 如果start 大于 end会导致key被删除
     * @param key key
     * @param start 起始位置
     * @param end   结束位置
     */
    @Override
    public void trim(Object key, long start, long end) {
        redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * 返回该key的大小 个数
     * @param key key
     * @return
     */
    @Override
    public Long size(Object key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     *如果key不存在则创建
     * 如现列表有（1，2，3） 如需插入4 则（4，1，2，3）
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long leftPush(Object key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     *  添加多个值
     *  LPUSH mylist a b c将导致包含c第一个元素，b第二个元素和a第三个元素的列表。
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long leftPushAll(Object key, Object[] values) {
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     *  Collection 是集合的接口 所以可以传入集合
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long leftPushAll(Object key, Collection values) {
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * value存储在列表头部的插入key，仅在key已存在且包含列表的情况下。
     * 与LPUSH相反，当key尚不存在时将不执行任何操作。
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long leftPushIfPresent(Object key, Object value) {
        return redisTemplate.opsForList().leftPushIfPresent(key, value);
    }

    /**
     * 插入从pivot的位置往上插入一个value
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    @Override
    public Long leftPush(Object key, Object pivot, Object value) {
        return redisTemplate.opsForList().leftPush(key, pivot, value);
    }

    /**
     *  同理 leftPush
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long rightPush(Object key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 同理 leftPushAll
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long rightPushAll(Object key, Object[] values) {
        return redisTemplate.opsForList().rightPush(key,values);
    }

    /**
     * 同理leftPushAll
     * @param key
     * @param values
     * @return
     */
    @Override
    public Long rightPushAll(Object key, Collection values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     *  同理leftPushIfPresent
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long rightPushIfPresent(Object key, Object value) {
        return redisTemplate.opsForList().rightPushIfPresent(key, value);
    }

    /**
     * 同理rightPush
     * @param key
     * @param pivot
     * @param value
     * @return
     */
    @Override
    public Long rightPush(Object key, Object pivot, Object value) {
        return redisTemplate.opsForList().rightPush(key, pivot, value);
    }

    /**
     * 在指定位置替换值
     * @param key
     * @param index
     * @param value
     */
    @Override
    public void set(Object key, long index, Object value) {
        //因为索引从0开始
        Long keySize = redisTemplate.opsForList().size(key)-1;
        if(index<=keySize){
            redisTemplate.opsForList().set(key, index, value);
        }
    }

    /**
     * 从存储的列表中删除第一次count出现的元素。该论点以下列方式影响操作：valuekeycount
     * count > 0：删除等于value从头到尾移动的元素。
     * count < 0：删除等于value从尾部移动到头部的元素。
     * count = 0：删除所有等于的元素value。
     * @param key
     * @param count
     * @param value
     * @return
     */
    @Override
    public Long remove(Object key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }


    /**
     * 根据索引返回该key的值
     * @param key
     * @param index
     * @return
     */
    @Override
    public Object index(Object key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 删除并返回存储在列表中的第一个元素key。
     * @param key
     * @return
     */
    @Override
    public Object leftPop(Object key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 阻塞式队列 如果key中没有值弹出 则会进入阻塞时间 timeout
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    @Override
    public Object leftPop(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     *  同理leftPop
     * @param key
     * @return
     */
    @Override
    public Object rightPop(Object key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     *  同理leftPop
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    @Override
    public Object rightPop(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPop(key, timeout, unit);
    }

    /**
     * 先弹出sourceKey的尾部 在插入destinationKey的头部
     * @param sourceKey
     * @param destinationKey
     * @return
     */
    @Override
    public Object rightPopAndLeftPush(Object sourceKey, Object destinationKey) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey, destinationKey);
    }

    /**
     * 若sourceKey的值为空了将一直阻塞 反之
     * 先弹出sourceKey的尾部 在插入destinationKey的头部
     * @param sourceKey
     * @param destinationKey
     * @param timeout
     * @param unit
     * @return
     */
    @Override
    public Object rightPopAndLeftPush(Object sourceKey, Object destinationKey, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey, destinationKey, timeout, unit);
    }

    @Override
    public RedisOperations getOperations() {
        return null;
    }
}
