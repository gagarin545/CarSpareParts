package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.GroupPartsEntity;
import ru.entity.ModelCarEntity;
import ru.entity.PartsEntity;
import ru.entity.SparePartsEntity;
import ru.service.GroupService;
import ru.service.ModelService;
import ru.service.PartServise;
import ru.service.SpareService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartsTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    PartServise partServise;

    @Resource
    SpareService spareService;

    @Resource
    ModelService modelService;


    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        SparePartsEntity spare = spareService.spare(  1L );
        ModelCarEntity model = modelService.model(1L);
        List<PartsEntity> parts = partServise.part(model, spare);
        System.out.println(spare.getSpare_name());
        parts.forEach(x-> System.out.println( x.getCost() + x.getPhoto()));

    }
}
