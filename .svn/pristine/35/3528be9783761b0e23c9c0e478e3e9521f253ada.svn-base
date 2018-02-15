package cn.rojao.redis.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import cn.rojao.annotation.ServiceExporter;
import cn.rojao.redis.EhcacheUtil;

@Service("redisService")
@ServiceExporter(targetInterface = RedisService.class)
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    
    private static final Logger LOG = LoggerFactory.getLogger(RedisService.class);
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }    
    
    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }

    /**
     * 哈希 获取哈希的key集合
     * @param key
     * @param hashKey
     * @param value
     */
    public Set<Object> hmKeys(String key){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.keys(key);        
    }    

    /**
     * 哈希 删除哈希的key
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmDelete(String key,String hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        hash.delete(key, hashKey);       
    }    
    
    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }
    
    /**
     * 根据hashKeys返回数据
     * @param key
     * @param hashKeys
     * @return
     */
    public List<Object> hmultiGet(String key, Set<Object> hashKeys){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.multiGet(key, hashKeys);
    }
    
    /**
     * 根据key查询Map
     * @param key
     * @return
     */
    public Map<String,String> hmentries(String key){
    	HashOperations<String, String, String>  hash = redisTemplate.opsForHash();
    	return hash.entries(key);
    }
    
    /**
     * 获取所有key值
     * @param key
     * @return
     */
    public Set<Object>  hmKeySet(String key){
    	HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	return hash.keys(key);	
    }
    
    /**
     * 获取所有key值
     * @param key
     * @return
     */
    public void  hmRemove(String key, Object hashKey){
    	HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	hash.delete(key, hashKey); 	
    }
    
    
    

    /**
     * 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }
    
    /**
     * 集合获取
     * @param key
     * @param count
     * @return
     */
    public Set<Object> setMembers(String key, int count){
    	 SetOperations<String, Object> set = redisTemplate.opsForSet();
    	 return set.distinctRandomMembers(key, count);
    }
    
    /**
     * 删除集合数据
     * @param key
     * @param value
     */
    public void remove(String key, Object value){
    	 SetOperations<String, Object> set = redisTemplate.opsForSet();
    	 set.remove(key, value);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();       
        return zset.rangeByScore(key, scoure, scoure1);
    }
    
    /**
     * 消息队列实现
     * @param channel
     * @param message
     */
    public void convertAndSend(String channel, Object message){
    	redisTemplate.convertAndSend(channel, message);
    }
    
    /**
     * 数列添加
     * @param key
     * @param value
     */
    public void addList(String key,Object value){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(key, value);
    }

    /**
     * 数列获取
     * @param key
     * @return
     */
    public List<Object> getList(String key){
        ListOperations<String, Object> list = redisTemplate.opsForList();   
        return list.range(key, 0, list.size(key));
    }
    
    /**
     * 左弹出数列
     * @param key
     * @return
     */
    public Object popList(String key) {
        ListOperations<String, Object> list = redisTemplate.opsForList();        
        return list.leftPop(key);
    }
    
    
    /**
     * 取到锁加锁 取不到锁一直等待直到获得锁
     */
    private static final long LOCK_TIMEOUT = 60 * 1000; //加锁超时时间 单位毫秒  意味着加锁期间内执行完操作 如果未完成会有并发现象
    public Long lock(String lockKey, String threadname) {
        LOG.info(threadname + "开始执行加锁");
        while (true) { //循环获取锁
            Long lock_timeout = System.currentTimeMillis() + LOCK_TIMEOUT + 1; //锁时间
            if ((Boolean)redisTemplate.execute(new RedisCallback<Boolean>() {
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
                    byte[] value = jdkSerializer.serialize(lock_timeout);
                    return connection.setNX(lockKey.getBytes(), value);
                }
            })) { //如果加锁成功
                LOG.info(threadname + "加锁成功++++++++111111111");
                redisTemplate.expire(lockKey, LOCK_TIMEOUT, TimeUnit.MILLISECONDS); //设置超时时间，释放内存
                return lock_timeout;
            }else {
                Long currt_lock_timeout_Str = (Long) redisTemplate.opsForValue().get(lockKey); // redis里的时间
                if (currt_lock_timeout_Str != null && currt_lock_timeout_Str < System.currentTimeMillis()) { //锁已经失效
                    // 判断是否为空，不为空的情况下，说明已经失效，如果被其他线程设置了值，则第二个条件判断是无法执行

                    Long old_lock_timeout_Str = (Long) redisTemplate.opsForValue().getAndSet(lockKey, lock_timeout);
                    // 获取上一个锁到期时间，并设置现在的锁到期时间
                    if (old_lock_timeout_Str != null && old_lock_timeout_Str.equals(currt_lock_timeout_Str)) {
                        // 如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                        LOG.info(threadname + "加锁成功+++++++2222222222");
                        redisTemplate.expire(lockKey, LOCK_TIMEOUT, TimeUnit.MILLISECONDS); //设置超时时间，释放内存
                        return lock_timeout;//返回加锁时间
                    }
                }
            }

            try {
                LOG.info(threadname +  "等待加锁，睡眠100毫秒"); 
                TimeUnit.MILLISECONDS.sleep(100);//睡眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }

    
    public void unlock(String lockKey, long lockvalue, String threadname) {
        LOG.info(threadname + "执行解锁==========");//正常直接删除 如果异常关闭判断加锁会判断过期时间
        Long currt_lock_timeout_Str = (Long) redisTemplate.opsForValue().get(lockKey); // redis里的时间

        if (currt_lock_timeout_Str != null && currt_lock_timeout_Str == lockvalue) {//如果是加锁者 则删除锁 如果不是则等待自动过期 重新竞争加锁
            redisTemplate.delete(lockKey); //删除键
            LOG.info(threadname + "解锁成功-----------------");
        }
    }
    
}