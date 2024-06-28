package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("request-param-v2")
    public String requestParamV2 (
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("request-param-v3")
    public String requestParamV3 (
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 다 없애서 사용할 수 있지만, 그게 요청 파라미터의 이름과 맞아야한다.
    @ResponseBody
    @RequestMapping("request-param-v4")
    public String requestParamV4 (String username, int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // required=true가 기본값이다. 이렇게 되어있으면 username=hello 이런식으로 무조건 들어와야한다.
    @ResponseBody
    @RequestMapping("request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 빈문자까지는 자동으로 처리해준다.
    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefalut(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(
           @RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age= {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age= {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }


}
