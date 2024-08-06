package com.ohgiraffers.example.member.service;

import com.ohgiraffers.example.member.model.dto.SignupDTO;
import com.ohgiraffers.example.member.model.entity.Member;
import com.ohgiraffers.example.member.model.entity.RoleType;
import com.ohgiraffers.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void register(SignupDTO signupDTO) {

        // ID 중복체크

        Member member = Member.builder()
                .memberId(signupDTO.getMemberId())
                .password(passwordEncoder.encode(signupDTO.getPassword())) // 암호화
                .name(signupDTO.getName())
                .role(RoleType.valueOf(signupDTO.getRole())) // USER, ADMIN
                .build();

        Member saveMember = memberRepository.save(member);

        log.info("저장된 회원 번호 : {}", saveMember.getMemberNo());
    }

    // memberId Member를 찾아오는 기능
    public Member findMemberById(String memberId) {

        Member member = memberRepository.findMemberByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("회원을 찾을 수 없습니다."));

        return member;
    }
}
