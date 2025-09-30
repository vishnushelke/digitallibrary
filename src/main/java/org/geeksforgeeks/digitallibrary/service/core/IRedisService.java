package org.geeksforgeeks.digitallibrary.service.core;

import org.geeksforgeeks.digitallibrary.dto.SaveInRedisCacheDto;

public interface IRedisService {

    String save(SaveInRedisCacheDto dto);

    String get(String key);
}
