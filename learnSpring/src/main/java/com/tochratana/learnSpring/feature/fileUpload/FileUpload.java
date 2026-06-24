package com.tochratana.learnSpring.feature.fileUpload;

import com.tochratana.learnSpring.feature.fileUpload.dto.FileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileUpload {
    FileResponse upload(MultipartFile file);
}
