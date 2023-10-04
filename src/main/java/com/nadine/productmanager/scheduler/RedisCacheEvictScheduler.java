package com.nadine.productmanager.scheduler;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheEvictScheduler {

    @CacheEvict(cacheNames = "productId", allEntries = true)
    @Scheduled(fixedRateString = "${app.cache.products.evict-time}")
    public void productsCacheCleaner() {
        System.out.println("LIMPANDOOO");
    }

}
