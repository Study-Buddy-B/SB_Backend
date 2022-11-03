package com.buddy.study.common.service;

import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {
    final private AccountRepository accountRepository;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse checkUser(String name){
        if(accountRepository.findByName(name)!=null){
            throw new ConflictException(ErrorCode.DUPLICATE_NAME);
        }
        return commonResponse.success("사용 가능한 이름입니다.",null);
    }

}
