package com.buddy.study.account.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.FailResponse;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.common.exception.UnauthorizedException;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    final private AccountRepository accountRepository;
    final private CommonService commonService;
    private MessageResponse messageResponse=new MessageResponse();
    public MessageResponse checkUser(String email){
        if(accountRepository.findByEmail(email)!=null){
            throw new ConflictException(ErrorCode.DUPLICATE_EMAIL);
        }
        messageResponse.setMessage("사용가능한 이메일입니다.");
        return messageResponse;
    }
    public MessageResponse saveUser(JoinRequest joinRequest){
        checkUser(joinRequest.getEmail());
        commonService.checkUser(joinRequest.getName());

        Account account= new Account();
        account.setEmail(joinRequest.getEmail());
        account.setName(joinRequest.getName());
        account.setPassword(joinRequest.getPassword());
        accountRepository.save(account);
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
