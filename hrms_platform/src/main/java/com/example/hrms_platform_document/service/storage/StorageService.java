package com.example.hrms_platform_document.service.storage;


import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String uploadToStaging(MultipartFile file, String key);

    void moveToVerified(String stagingKey, String verifiedKey);

    void delete(String key);

    String generatePresignedUrl(String key);
<<<<<<< HEAD
=======

    boolean exists(String key);

    String findLatestKey(String prefix);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
