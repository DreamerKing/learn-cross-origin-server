package CO.CrossOrigin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
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

}
