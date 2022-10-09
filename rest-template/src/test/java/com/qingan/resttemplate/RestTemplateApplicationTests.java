package com.qingan.resttemplate;

import com.qingan.resttemplate.domin.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateApplicationTests {

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String url="https://www.baidu.com";
        String result =restTemplate.getForObject(url,String.class);
        System.out.println(result);
    }

    @Test
    void testGet01(){
        RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8080/get?name=xx";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }

    @Test
    void testGet02(){
        RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8080/get?name=xx";
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        System.out.println(result);
    }

    @Test
    void testPost01(){
        RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8080/postA";
        User user = new User("xx", 18);
        //发送post 而且是json参数 因为web里面默认使用jackson 他会把你的对象转成json字符串
        String result = restTemplate.postForObject(url,user, String.class);
        System.out.println(result);
    }

    @Test
    void testPost02(){
        RestTemplate restTemplate = new RestTemplate();
        String url="http://localhost:8080/postB";
        //构建表单参数
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name","xx");
        map.add("age",18);
        String result = restTemplate.postForObject(url,map, String.class);
        System.out.println(result);
    }

}
