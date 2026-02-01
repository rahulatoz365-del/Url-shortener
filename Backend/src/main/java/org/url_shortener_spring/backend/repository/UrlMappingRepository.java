package org.url_shortener_spring.backend.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.url_shortener_spring.backend.models.UrlMapping;
import org.url_shortener_spring.backend.models.User;

import java.util.List;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    boolean existsByShortUrl(String shortUrl);

    // 1. CACHING ENABLED HERE
    // When this is called, Spring checks Caffeine memory first.
    // If it exists, it returns the result INSTANTLY (Microseconds) avoiding the Database.
    @Cacheable(value = "short_urls", key = "#shortUrl")
    UrlMapping findByShortUrl(String shortUrl);

    List<UrlMapping> findByUser(User user);

    // 2. CACHE EVICTION
    // When a URL is deleted, we MUST remove it from the cache immediately.
    @Override
    @CacheEvict(value = "short_urls", key = "#entity.shortUrl")
    void delete(UrlMapping entity);

    // 3. OPTIMIZED COUNTER INCREMENT
    // Since 'findByShortUrl' returns a cached object, its clickCount might be old.
    // We use this custom query to tell the DB: "Whatever the count is, add 1 to it".
    // This is thread-safe and works perfectly with caching.
    @Modifying
    @Transactional
    @Query("UPDATE UrlMapping u SET u.clickCount = u.clickCount + 1 WHERE u.id = :id")
    void incrementClickCount(Long id);
}
