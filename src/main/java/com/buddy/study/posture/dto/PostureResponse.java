package com.buddy.study.posture.dto;

import com.buddy.study.posture.domain.Posture;
import lombok.Getter;

@Getter
public class PostureResponse {
    private Long id;
    private Boolean isAppropriate;

    public PostureResponse(Posture posture) {
        this.id = posture.getId();
        this.isAppropriate = posture.getIsAppropriate();
    }
}
