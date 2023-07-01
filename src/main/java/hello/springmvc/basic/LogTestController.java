package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
//@RestController
public class LogTestController {

    // 롬복을 사용하면 이걸 사용할 필요없이 자동으로 다 출력해준다
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 무슨 일이든 실행만 시키면 무조건 나오는거라 시스템아웃은 쓰지마라
        System.out.println("name = " + name);
        // 이렇게 쓰면 안된다
        // 쓸모없는 리소스를 사용하게 된다
        log.trace(" trace my log = {}" + name);
        // 아래 방식을 추천
        // 이렇게 사용하면 출력할 필요 없을 때 출력을 안한다.
        // 그리고 현재 로그는 설정을 해서 튜닝해서 로그를 남길 수 있다
        log.trace(" trace log = {}", name);
        log.debug(" debug log = {}", name); // 현재 로그 디버그
        log.info(" info log = {}", name); // 비즈니스 정보
        log.warn(" warn log = {}", name); // 경고
        log.error(" error log = {}", name); // 에러

        return "ok";
    }
}
