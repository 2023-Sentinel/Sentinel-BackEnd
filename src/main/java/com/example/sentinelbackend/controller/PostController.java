package com.example.sentinelbackend.controller;
import com.example.sentinelbackend.entity.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController // controller임을 알려주는 표시
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api주소로 받겠다(localhost:8080/api)
public class PostController {

    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

}
