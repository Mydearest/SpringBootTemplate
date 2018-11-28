package cn.shinoha.boot.controller;

import cn.shinoha.boot.bean.Shinbun;
import cn.shinoha.boot.dao.ShinbunDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private ShinbunDao shinbunDao;

    @RequestMapping("/{echo}")
    public String index(@PathVariable String echo){
        Shinbun shinbun = new Shinbun();
        shinbun.setContent("1");
        shinbun.setData("2");
        shinbun.setImgUrl("3");
        shinbun.setTimestamps(123);
        shinbun.setTitle("4");
        shinbunDao.save(shinbun);
        for(Shinbun shinbun1 : shinbunDao.testAll()){
            echo = echo+shinbun1.getContent()+shinbun1.getData();
        }
        return "Echo : "+echo;
    }

    @Autowired
    public void setShinbunDao(ShinbunDao shinbunDao) {
        this.shinbunDao = shinbunDao;
    }
}