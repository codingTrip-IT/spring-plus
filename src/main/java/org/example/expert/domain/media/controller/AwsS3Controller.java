package org.example.expert.domain.media.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.media.service.AwsS3Service;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AwsS3Controller {

    private final AwsS3Service awsS3Service;

    @PostMapping("/users/upload")
    public String createProfile(@AuthenticationPrincipal AuthUser authUser,
                              @RequestPart(value = "file", required = false) MultipartFile multipartFile
    ) throws IOException {
        return awsS3Service.upload(authUser, multipartFile);
    }
}
