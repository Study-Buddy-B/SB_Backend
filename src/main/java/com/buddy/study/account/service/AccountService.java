package com.buddy.study.account.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.common.exception.UnauthorizedException;
import com.buddy.study.posture.domain.Posture;
import com.buddy.study.posture.repository.PostureRepository;
import com.buddy.study.temperature.domain.Temperature;
import com.buddy.study.temperature.repository.TemperatureRepository;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.repository.TimeRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final TemperatureRepository temperatureRepository;
    private final TimeRepository timeRepository;
    private final PostureRepository postureRepository;
    private MessageResponse messageResponse=new MessageResponse();
    public Account findUser(UUID uid){
        return accountRepository.findById(uid).orElse(null);
    }
    public void checkName(String name){
        if(accountRepository.findByName(name)!=null){
            throw new ConflictException(ErrorCode.DUPLICATE_NAME);
        }
    }
    public void checkUser(String email){
        if(accountRepository.findByEmail(email)!=null){
            throw new ConflictException(ErrorCode.DUPLICATE_EMAIL);
        }
    }
    public MessageResponse saveUser(JoinRequest joinRequest){
        checkUser(joinRequest.getEmail());
        checkName(joinRequest.getName());

        Account account= new Account();
        account.setEmail(joinRequest.getEmail());
        account.setName(joinRequest.getName());
        account.setPassword(joinRequest.getPassword());
        accountRepository.save(account);

        Time time=new Time();
        time.setAccount(account);
        time.setDate(LocalDate.now().toString());
        time.setTime(0f);
        timeRepository.save(time);

        Temperature temperature=new Temperature(20.5f,account);
        temperatureRepository.save(temperature);

        Posture posture=new Posture(true,account);
        postureRepository.save(posture);

        messageResponse.setMessage("회원가입에 성공했습니다.");
        return messageResponse;
    }
    public MessageResponse outUser(UUID uuid){
        Account account= accountRepository.findById(uuid).orElse(null);
        if(account==null){
            throw new UnauthorizedException(ErrorCode.INVALID_EMAIL);
        }
        account.setIsDelete(true);
        System.out.println(account.getEmail());
        accountRepository.save(account);
        messageResponse.setMessage("회원탈퇴에 성공했습니다.");
        return messageResponse;
    }
    public LoginResponse loginUser(LoginRequest loginRequest){
        Account account=accountRepository.findByEmail(loginRequest.getEmail());
        if(account==null){
            throw new UnauthorizedException(ErrorCode.INVALID_EMAIL);
        }
        if(!account.getPassword().equals(loginRequest.getPassword())){
            throw new UnauthorizedException(ErrorCode.INVALID_PASSWORD);
        }
        if(account.getIsDelete()){
            throw new UnauthorizedException(ErrorCode.WITHDRAW_EMAIL);
        }
        LoginResponse loginResponse=new LoginResponse(account.getId());
        return loginResponse;
    }
}
