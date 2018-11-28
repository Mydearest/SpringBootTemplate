package cn.shinoha.boot.dao;

import cn.shinoha.boot.bean.Shinbun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ShinbunDao extends JpaRepository<Shinbun,String> {

    @Modifying
    @Query(value = "select en from Shinbun en")
    List<Shinbun> testAll();
}
