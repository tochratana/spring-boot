package com.tochratana.learnSpring.feature.fileUpload;

import com.tochratana.learnSpring.feature.fileUpload.dto.FileResponse;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUpload{
    @Value("${file-upload.server-path}")
    private String serverPath;
    @Override
    public FileResponse upload(MultipartFile file) {

        String fileName = UUID.randomUUID().toString();
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        Path path = Paths.get(String.format("%s%s.%s",serverPath,fileName, fileExt));
        try {
            Files.copy(file.getInputStream(),path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        
        return FileResponse.builder()
                .name(String.format("%s%s.%s", serverPath,fileName, fileExt))
                .mediaType(file.getContentType())
                .size(file.getSize())
                .uri("")
                .build();
    }
}
