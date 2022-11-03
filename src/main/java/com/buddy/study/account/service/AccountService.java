package com.buddy.study.account.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.common.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    final private AccountRepository accountRepository;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse saveUser(JoinRequest joinRequest){
        Account account= new Account();
        account.setEmail(joinRequest.getEmail());
        account.setName(joinRequest.getName());
        account.setPassword(joinRequest.getPassword());
        accountRepository.save(account);
        return commonResponse.success("회원가입에 성공했습니다", null);
    }
    public CommonResponse outUser(Long id){
        Account account= accountRepository.findById(id).orElse(null);
        account.setIsDelete(true);
        accountRepository.save(account);
        return commonResponse.success("성공적으로 회원 탈퇴되었습니다.", null);
    }
    public CommonResponse checkUser(String email){
        if(accountRepository.findByEmail(email)!=null){
            throw new ConflictException(ErrorCode.DUPLICATE_EMAIL);
        }
        return commonResponse.success("사용가능한 이메일입니다.", null);
    }
    public CommonResponse loginUser(LoginRequest loginRequest){
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
        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setUid(account.getId());
        return commonResponse.success("로그인에 성공했습니다.", loginResponse);
    }
}
