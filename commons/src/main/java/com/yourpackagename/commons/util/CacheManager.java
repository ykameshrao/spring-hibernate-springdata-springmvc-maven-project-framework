package com.yourpackagename.commons.util;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides common methods to manage a JCS based cache region.
 *
 * @author Y Kamesh Rao
 */
public class CacheManager {

    private static Logger log = LoggerFactory.getLogger(CacheManager.class);

    /**
     * Fetches a cache region specified in the config file. Returns null if the region is not found or if the config
     * file is bad.
     *
     * @param configFilePath The file path for .ccf file
     * @param regionName     Name of cache region
     * @return JCS    A cache region.
     */

    public static JCS initCacheRegion(String configFilePath, String regionName) throws CacheException {
        JCS cache = null;
        // Set the config file
        try {
            if (configFilePath != null)
                JCS.setConfigFilename(configFilePath);
        } catch (Exception e) {
            // Trace the exception
            log.error(e.getMessage());
            // Throw a new sophisticated exception
            throw new CacheException("Could not set cache config file.\n");
        }

        log.info("Successfully set config file to::" + configFilePath);

        // Fetch the region
        try {
            cache = JCS.getInstance(regionName);
        } catch (Exception e) {
            // Trace the exception
            log.error(e.getMessage());
            // Throw a new sophisticated exception
            throw new CacheException("Could not fetch the cache region::" + regionName + ".\n");
        }

        log.info("Successfully fetched the cache region::" + regionName);
        return cache;
    }


    /**
     * Adds an object to cache with its key.
     *
     * @param cache  The JCS cache object
     * @param key    Key to be used for identification
     * @param object object to be cached
     * @throws CacheException: thrown if the cache instance is found to be null
     */
    public static void addToCache(JCS cache, String key, Object object) throws CacheException {
        if (cache == null)
            throw new CacheException("Null cache");
        cache.put(key, object);
    }


    /**
     * Fetches an object from cache.
     *
     * @param cache The JCS cache object
     * @param key   Key to be used for identification
     * @return object Corresponding cached object. Null if not found.
     * @throws CacheException: thrown if the cache instance is found to be null
     */
    public static Object getFromCache(JCS cache, String key) throws CacheException {
        if (cache == null)
            throw new CacheException("Null cache");
        return cache.get(key);
    }


    /**
     * Flushes the specified cache
     *
     * @param cache Cache instance to be cleared
     * @throws CacheException
     */
    public static void clearCache(JCS cache) throws CacheException {
        if (cache == null)
            throw new CacheException("Null cache");
        cache.clear();
    }

}
