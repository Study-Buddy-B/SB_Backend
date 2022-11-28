package com.buddy.study.posture.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.posture.domain.Posture;
import com.buddy.study.posture.dto.CreateRequest;
import com.buddy.study.posture.dto.PostureResponse;
import com.buddy.study.posture.repository.PostureRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostureService {
    private final PostureRepository postureRepository;

    private final AccountService accountService;

    public PostureResponse createPosture(UUID userId, CreateRequest request) {
        Account account = accountService.findUser(userId);

        Posture posture = new Posture(request.getIsAppropriate(), account);
        return new PostureResponse(postureRepository.save(posture));
    }

    public PostureResponse getPosture(UUID userId) {
        Account account = accountService.findUser(userId);

        Posture posture = postureRepository.findTopByAccountOrderByIdDesc(account)
            .orElseGet(()-> postureRepository.save(new Posture(true, account)));
        return new PostureResponse(posture);
    }
}
