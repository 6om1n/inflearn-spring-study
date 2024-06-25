package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(getClass()); // 안에 클래스 정보만 있으면 된다.

    @RequestMapping ("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name); // 이건 무조건 출력이 되서 사용하면 안된다.

        log.trace("trace my log=" + name); // 이렇게 하면 쓸모없는 리소스가 사용이 되어서 이렇게 하면 안된다.
        log.trace("trace log={}", name); // 두개는 기록되지 않음
        log.debug("debug log={}", name); // 두개는 기록되지 않음
        log.info ("info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
