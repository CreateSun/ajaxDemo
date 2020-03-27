package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//@CrossOrigin
@RestController
public class Hello {
    @GetMapping("/{num}")
    public String HelloController(@PathVariable String num) {
        return new String("感应到了你的访问哦，你访问的地址是:" + num);
    }
//
//    @GetMapping("/get")
//    public String GetController( @PathVariable String string){
//        return new String("恭喜你get成功了！");
//    }

    @PostMapping(value = "/ajax/post")
    public void PostController(@RequestBody Map<String, String> body, HttpServletResponse res) throws JSONException, IOException {

        JSONObject json = new JSONObject();
        if (body.containsKey("username")){
            json.put("username", body.get("username"));
        }
        if (body.containsKey("password")){
            json.put("password", body.get("password"));
        }
        res.getWriter().print(json);
    }
}
