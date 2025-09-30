package org.geeksforgeeks.digitallibrary.controller;

import org.geeksforgeeks.digitallibrary.dto.SaveInRedisCacheDto;
import org.geeksforgeeks.digitallibrary.models.DigitalLibraryResponse;
import org.geeksforgeeks.digitallibrary.service.core.IRedisService;
import org.geeksforgeeks.digitallibrary.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final IRedisService service;

    public RedisController(IRedisService service) {
        this.service = service;
    }

    @GetMapping("/{key}")
    public ResponseEntity<DigitalLibraryResponse<String>> getValue(@PathVariable String key) {
        return new ResponseEntity<>(new DigitalLibraryResponse<>(Constants.SUCCESS_STATUS, this.service.get(key), null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DigitalLibraryResponse<String>> setValue(@RequestBody SaveInRedisCacheDto dto){
        return new ResponseEntity<>(new DigitalLibraryResponse<>(Constants.SUCCESS_STATUS, this.service.save(dto), null), HttpStatus.OK);
    }
}
