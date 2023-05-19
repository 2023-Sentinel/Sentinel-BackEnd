package com.example.sentinelbackend.controller;
import com.example.sentinelbackend.entity.Member;
import com.example.sentinelbackend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AccountController {        //계정 컨트롤러
    @Autowired
    MemberRepository memberRepository;
    @PostMapping("/api/account/login")
    public int login(@RequestBody Map<String, String> params) {
        Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
        if(member != null){
            return member.getId();
        }
        return 0;
    }
}
