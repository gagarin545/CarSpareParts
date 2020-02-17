package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.MakeCarEntity;
import ru.entity.SparePartsEntity;
import ru.service.CarService;
import ru.service.SpareService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpareTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    SpareService spareService;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        List<SparePartsEntity> spareList = spareService.spareList();
        System.out.println( spareList.size());
        spareList.forEach(x->System.out.println(x.getSpare_name()));
        SparePartsEntity spare = spareService.spare(  2L );
        System.out.println(spare.getSpare_name());

    }
}
