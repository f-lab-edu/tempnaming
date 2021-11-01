package study.sorting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.sorting.entity.Member;
import study.sorting.repository.MemberRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberTestController {

    private final MemberRepository memberRepository;

    @GetMapping("/save")
    public void saveMember() {
        Member newMember = new Member("king");
        memberRepository.save(newMember);
    }

    @GetMapping("/get")
    public List<Member> getMember() {
        return memberRepository.findAll();
    }
}
