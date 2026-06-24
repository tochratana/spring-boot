package com.tochratana.learnSpring.feature.fileUpload;


import com.tochratana.learnSpring.feature.fileUpload.dto.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/fileupload")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUpload fileUpload;

    @PostMapping
    public FileResponse upload(
            @RequestPart MultipartFile file
    ){
        return fileUpload.upload(file);
    }
}
