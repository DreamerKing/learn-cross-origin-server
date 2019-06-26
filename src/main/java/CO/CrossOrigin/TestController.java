package CO.CrossOrigin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//@CrossOrigin
public class TestController {
    @GetMapping("/get1")
    private ResultBean get1(){
        System.out.println("TestController.get1()");
        return new ResultBean("get1 ok");
    }

    @PostMapping("/postjson")
    public ResultBean postJson(@RequestBody User user){
        System.out.println("TestController.postJson()"+  user.getName());
        return new ResultBean("postJson" + user.getName());

    }

    @GetMapping("/getCookies")
//    @CrossOrigin(allowCredentials = "true")
    public ResultBean getCookies(@CookieValue(value="cookies1") String cookies1) {
        System.out.println("TestController.getCookies()"+ cookies1);
        return new ResultBean("getCookie" + cookies1);
    }

    @GetMapping("/getHeaders")
    public ResultBean getHeaders(@RequestHeader("x-header-1") String header1,
                                 @RequestHeader("x-header-2") String header2) {
        System.out.println("TestControll.getHeaders()");
        return new ResultBean(String.format("getHeaders %s %s", header1, header2));
    }


}
