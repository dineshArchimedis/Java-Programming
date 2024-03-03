package com.dinesh.fb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class ImageController {

    @GetMapping("/facebook/images")
    public ResponseEntity<byte[]> getFacebookImages() {
    	String imageUrl = "https://scontent.fmaa6-1.fna.fbcdn.net/v/t39.30808-6/428675230_916442463816138_1479856618043134338_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=dd5e9f&_nc_ohc=Db4XAlYVkBAAX8Z6oo3&_nc_ht=scontent.fmaa6-1.fna&oh=00_AfA8Tvw2B1H2pEutLO8id4ofe6aS3BPvrcvF1WxBbHqEAw&oe=65E88D9A";
        
    
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);
        
        return ResponseEntity.ok()
                .contentType(response.getHeaders().getContentType())
                .body(response.getBody());
    }
}