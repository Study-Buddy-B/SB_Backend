package com.buddy.study.user.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.posture.dto.PostureResponse;
import com.buddy.study.posture.service.PostureService;
import com.buddy.study.temperature.dto.TemperatureResponse;
import com.buddy.study.temperature.service.TemperatureService;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.service.TimeService;
import com.buddy.study.user.dto.TimeRequest;
import com.buddy.study.user.dto.UserResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final TimeService timeService;
    private final TemperatureService temperatureService;
    private final PostureService postureService;
    private MessageResponse messageResponse=new MessageResponse();

    public UserResponse loadUser(UUID uid){
        Account account=accountService.findUser(uid);
        UserResponse userResponse=new UserResponse();
        userResponse.setTarTime(account.getHours());

        TimeResponse time=timeService.getTodayTime(uid);
        userResponse.setCurTime(time.getTime());

        TemperatureResponse temperature=temperatureService.getTemperature(uid);
        userResponse.setTemperature(temperature.getCurrent());

        PostureResponse postureResponse=postureService.getPosture(uid);
        userResponse.setIsAppropriate(postureResponse.getIsAppropriate());

        return userResponse;
    }
    public MessageResponse setTime(UUID uid, TimeRequest timeRequest){
        Account account=accountService.findUser(uid);
        if(timeRequest.getTime()<1 || timeRequest.getTime()>24){
            throw new ConflictException(ErrorCode.INVALIDATE_TIME);
        }
        account.setHours(timeRequest.getTime());
        accountRepository.save(account);
        messageResponse.setMessage("?????? ????????? ??????????????????.");
        return messageResponse;
    }

}
