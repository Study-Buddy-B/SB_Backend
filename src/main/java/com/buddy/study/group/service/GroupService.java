package com.buddy.study.group.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.dto.FailResponse;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.common.service.CommonService;
import com.buddy.study.group.domain.Mapping;
import com.buddy.study.group.domain.StudyGroup;
import com.buddy.study.group.dto.CreateResponse;
import com.buddy.study.group.dto.GroupRequest;
import com.buddy.study.group.dto.GroupResponse;
import com.buddy.study.group.dto.GroupType;
import com.buddy.study.group.repository.GroupRepository;
import com.buddy.study.group.repository.MappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final MappingRepository mappingRepository;
    private final AccountService accountService;
    private MessageResponse messageResponse=new MessageResponse();
    public StudyGroup findGroup(Long gid){
        return groupRepository.findById(gid).orElse(null);
    }
    public CreateResponse createGroup(UUID uid, GroupRequest groupRequest){
        Account account= accountService.findUser(uid);

        // 그룹 생성
        StudyGroup group=new StudyGroup();
        group.setName(groupRequest.getName());
        group.setTime(groupRequest.getTime());
        group.setMaxPerson(groupRequest.getMaxPerson());
        group.setCurPerson(1);
        group.setGroupType(GroupType.valueOfType(groupRequest.getType()));
        groupRepository.save(group);

        // 최초 생성자 매핑 테이블에 추가
        Mapping mapping=new Mapping();
        mapping.setGroup(group);
        mapping.setAccount(account);
        mappingRepository.save(mapping);
        return new CreateResponse(group.getId());
    }
    public MessageResponse joinGroup(UUID uid, Long gid){
        StudyGroup group=findGroup(gid);
        Account account= accountService.findUser(uid);
        List<StudyGroup> studyGroups=mappingRepository.findAllByAccount(account);
        //이미 가입되어 있는 그룹인 경우 에러코드
        if(studyGroups.contains(group))
            throw new ConflictException(ErrorCode.DUPLICATE_GROUP);
        //최대 인원이라 가입을 하지 못하는 경우 에러코드
        if(group.getCurPerson()>=group.getMaxPerson())
            throw new ConflictException(ErrorCode.MAXIMUM_GROUP);
        Mapping mapping=new Mapping();
        mapping.setGroup(group);
        mapping.setAccount(account);
        mappingRepository.save(mapping);
        //인원 수 추가
        group.setCurPerson(group.getCurPerson()+1);
        groupRepository.save(group);
        messageResponse.setMessage("그룹 가입에 성공했습니다.");
        return messageResponse;
    }
    public List<GroupResponse> loadGroup(){
        List<GroupResponse> groupsResponse=new ArrayList<>();
        List<StudyGroup> groups=groupRepository.findAllByOrderByIdDesc();
        for(StudyGroup group:groups){
            GroupResponse groupResponse=new GroupResponse();
            groupResponse.setCurPerson(group.getCurPerson());
            groupResponse.setMaxPerson(group.getMaxPerson());
            groupResponse.setName(group.getName());
            groupResponse.setType(group.getGroupType().getMessage());
            groupsResponse.add(groupResponse);
        }
        return groupsResponse;
    }

}
