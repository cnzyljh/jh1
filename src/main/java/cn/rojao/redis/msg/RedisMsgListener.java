package cn.rojao.redis.msg;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisMsgListener  {
	@Autowired
	Receiver receiver;

	/**
	 * 外部广告位修改监听记录
	 * @param connectionFactory
	 * @param listenerAdapter
	 * @return
	 */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
    		MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("extendsPositionSchedule"));
        return container;
    }
    
    /**
     * 监听方法
     * @return
     */
    @Bean(name="listenerAdapter")
    MessageListenerAdapter listenerAdapter() {
    	//回调数据处理方法
        return new MessageListenerAdapter(receiver, "dealExtendsPositionCache");
    }
    
    /**
   	 * 用户修改监听记录
   	 * @param connectionFactory
   	 * @param listenerAdapter
   	 * @return
   	 */
       @Bean
       RedisMessageListenerContainer advTypeContainer(RedisConnectionFactory connectionFactory,
       		 MessageListenerAdapter advTypeAdapter) {
           RedisMessageListenerContainer container = new RedisMessageListenerContainer();
           container.setConnectionFactory(connectionFactory);
           container.addMessageListener(advTypeAdapter, new PatternTopic("dealAdvTypeCache"));
           return container;
       }
       
       /**
        * 监听方法
        * @return
        */
       @Bean(name="advTypeAdapter")
       MessageListenerAdapter advTypeAdapter() {
       	//回调数据处理方法
           return new MessageListenerAdapter(receiver, "dealAdvTypeCache");
       }
       
       /**
      	 * 广告位修改监听记录
      	 * @param connectionFactory
      	 * @param listenerAdapter
      	 * @return
      	 */
          @Bean
          RedisMessageListenerContainer positionTypeContainer(RedisConnectionFactory connectionFactory,
          		 MessageListenerAdapter positionTypeAdapter) {
              RedisMessageListenerContainer container = new RedisMessageListenerContainer();
              container.setConnectionFactory(connectionFactory);
              container.addMessageListener(positionTypeAdapter, new PatternTopic("dealPositionTypeCache"));
              return container;
          }
          
          /**
           * 监听方法
           * @return
           */
          @Bean(name="positionTypeAdapter")
          MessageListenerAdapter positionTypeAdapter() {
          	//回调数据处理方法
              return new MessageListenerAdapter(receiver, "dealPositionTypeCache");
          }
       
       
       /**
     	 * 用户修改监听记录
     	 * @param connectionFactory
     	 * @param listenerAdapter
     	 * @return
     	 */
         @Bean
         RedisMessageListenerContainer dealUserContainer(RedisConnectionFactory connectionFactory,
         		 MessageListenerAdapter dealUserCache) {
             RedisMessageListenerContainer container = new RedisMessageListenerContainer();
             container.setConnectionFactory(connectionFactory);
             container.addMessageListener(dealUserCache, new PatternTopic("dealUserCache"));
             return container;
         }
         
         /**
          * 监听方法
          * @return
          */
         @Bean(name="dealUserCache")
         MessageListenerAdapter dealUserCache() {
         	//回调数据处理方法
             return new MessageListenerAdapter(receiver, "dealUserCache");
         }    
       
   
         
         /**
      	 * 用户修改监听记录
      	 * @param connectionFactory
      	 * @param listenerAdapter
      	 * @return
      	 */
          @Bean
          RedisMessageListenerContainer dealMaterialContainer(RedisConnectionFactory connectionFactory,
          		 MessageListenerAdapter dealMaterialCache) {
              RedisMessageListenerContainer container = new RedisMessageListenerContainer();
              container.setConnectionFactory(connectionFactory);
              container.addMessageListener(dealMaterialCache, new PatternTopic("dealMaterialCache"));
              return container;
          }
          
          /**
           * 监听方法
           * @return
           */
          @Bean(name="dealMaterialCache")
          MessageListenerAdapter dealMaterialCache() {
          	//回调数据处理方法
              return new MessageListenerAdapter(receiver, "dealMaterialCache");
          } 
          
          
          	/**
          	 * 模板修改监听记录
          	 * @param connectionFactory
          	 * @param dealMaterialCache
          	 * @return
          	 */
            @Bean
            RedisMessageListenerContainer dealTempletContainer(RedisConnectionFactory connectionFactory,
            		 MessageListenerAdapter dealTempletCache) {
                RedisMessageListenerContainer container = new RedisMessageListenerContainer();
                container.setConnectionFactory(connectionFactory);
                container.addMessageListener(dealTempletCache, new PatternTopic("dealTempletCache"));
                return container;
            }
            
            /**
             * 监听方法
             * @return
             */
            @Bean(name="dealTempletCache")
            MessageListenerAdapter dealTempletCache() {
            	//回调数据处理方法
                return new MessageListenerAdapter(receiver, "dealTempletCache");
            } 
          
          
          /**
           * 网络ID修改监听记录
           * @param connectionFactory
           * @param listenerAdapter
           * @return
           */
        @Bean
        RedisMessageListenerContainer dealNetworkContainer(RedisConnectionFactory connectionFactory,
               MessageListenerAdapter dealNetworkCache) {
            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.addMessageListener(dealNetworkCache, new PatternTopic("dealNetworkCache"));
            return container;
        }
        
        /**
         * 监听方法
         * @return
         */
        @Bean(name="dealNetworkCache")
        MessageListenerAdapter dealNetworkCache() {
          //回调数据处理方法
            return new MessageListenerAdapter(receiver, "dealNetworkCache");
        }  
       
            /**
             * 区域修改监听记录
             * @param connectionFactory
             * @param listenerAdapter
             * @return
             */
          @Bean
          RedisMessageListenerContainer dealRegionContainer(RedisConnectionFactory connectionFactory,
                 MessageListenerAdapter dealRegionCache) {
              RedisMessageListenerContainer container = new RedisMessageListenerContainer();
              container.setConnectionFactory(connectionFactory);
              container.addMessageListener(dealRegionCache, new PatternTopic("dealRegionCache"));
              return container;
          }
          
          /**
           * 监听方法
           * @return
           */
          @Bean(name="dealRegionCache")
          MessageListenerAdapter dealRegionCache() {
            //回调数据处理方法
              return new MessageListenerAdapter(receiver, "dealRegionCache");
          }  

          /**
           * 上下级区域修改监听记录
           * @param connectionFactory
           * @param listenerAdapter
           * @return
           */
        @Bean
        RedisMessageListenerContainer dealSonRegionContainer(RedisConnectionFactory connectionFactory,
               MessageListenerAdapter dealSonRegionCache) {
            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.addMessageListener(dealSonRegionCache, new PatternTopic("dealSonRegionCache"));
            return container;
        }
        
        /**
         * 监听方法
         * @return
         */
        @Bean(name="dealSonRegionCache")
        MessageListenerAdapter dealSonRegionCache() {
          //回调数据处理方法
            return new MessageListenerAdapter(receiver, "dealSonRegionCache");
        }  

        /**
         * 用户数据修改监听记录
         * @param connectionFactory
         * @param listenerAdapter
         * @return
         */
      @Bean
      RedisMessageListenerContainer dealUserDataContainer(RedisConnectionFactory connectionFactory,
             MessageListenerAdapter dealUserDataCache) {
          RedisMessageListenerContainer container = new RedisMessageListenerContainer();
          container.setConnectionFactory(connectionFactory);
          container.addMessageListener(dealUserDataCache, new PatternTopic("dealUserDataCache"));
          return container;
      }
      
      /**
       * 监听方法
       * @return
       */
      @Bean(name="dealUserDataCache")
      MessageListenerAdapter dealUserDataCache() {
        //回调数据处理方法
          return new MessageListenerAdapter(receiver, "dealUserDataCache");
      }  

      /**
       * 用户数据修改监听记录
       * @param connectionFactory
       * @param listenerAdapter
       * @return
       */
    @Bean
    RedisMessageListenerContainer dealSysParameterContainer(RedisConnectionFactory connectionFactory,
           MessageListenerAdapter dealSysParameterCache) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(dealSysParameterCache, new PatternTopic("dealSysParameterCache"));
        return container;
    }
    
    /**
     * 监听方法
     * @return
     */
    @Bean(name="dealSysParameterCache")
    MessageListenerAdapter dealSysParameterCache() {
      //回调数据处理方法
        return new MessageListenerAdapter(receiver, "dealSysParameterCache");
    }  
      /**
       * epg节目修改监听记录
       * @param connectionFactory
       * @param listenerAdapter
       * @return
       */
    @Bean
    RedisMessageListenerContainer dealProgramListContainer(RedisConnectionFactory connectionFactory,
           MessageListenerAdapter dealProgramListCache) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(dealProgramListCache, new PatternTopic("dealProgramListCache"));
        return container;
    }
    
    /**
     * 监听方法
     * @return
     */
    @Bean(name="dealProgramListCache")
    MessageListenerAdapter dealProgramListCache() {
      //回调数据处理方法
        return new MessageListenerAdapter(receiver, "dealProgramListCache");
    }  

    /**
     * 内容修改监听记录
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
      @Bean
      RedisMessageListenerContainer dealProgramContainer(RedisConnectionFactory connectionFactory,
             MessageListenerAdapter dealProgramCache) {
          RedisMessageListenerContainer container = new RedisMessageListenerContainer();
          container.setConnectionFactory(connectionFactory);
          container.addMessageListener(dealProgramCache, new PatternTopic("dealProgramCache"));
          return container;
      }
      
      /**
       * 监听方法
       * @return
       */
      @Bean(name="dealProgramCache")
      MessageListenerAdapter dealProgramCache() {
        //回调数据处理方法
          return new MessageListenerAdapter(receiver, "dealProgramCache");
      }  
      
      /**
       * 内容栏目修改监听记录
       * @param connectionFactory
       * @param listenerAdapter
       * @return
       */
        @Bean
        RedisMessageListenerContainer dealProgramColumnContainer(RedisConnectionFactory connectionFactory,
               MessageListenerAdapter dealProgramColumnCache) {
            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.addMessageListener(dealProgramColumnCache, new PatternTopic("dealProgramColumnCache"));
            return container;
        }
        
        /**
         * 监听方法
         * @return
         */
        @Bean(name="dealProgramColumnCache")
        MessageListenerAdapter dealProgramColumnCache() {
          //回调数据处理方法
            return new MessageListenerAdapter(receiver, "dealProgramColumnCache");
        }  
      
       @Bean(name="latch")
       CountDownLatch latch() {
           return new CountDownLatch(1);
       }

     

}
