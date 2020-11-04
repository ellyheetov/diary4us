package org.diary4us.web.user.controller;

import org.diary4us.web.user.dto.Member;
import org.diary4us.web.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }

    @GetMapping("joinform")
    public String joinform(){
        return "memebers/joinform";
    }

    @PostMapping("join")
    public String join(@ModelAttribute Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member,false);
        return "redirect:/members/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "members/welcome";
    }

    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap model){
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        model.addAttribute("user", member);

        return "members/memberinfo";
    }
}
