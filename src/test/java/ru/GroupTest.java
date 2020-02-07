package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.GroupPartsEntity;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.service.CarService;
import ru.service.GroupService;
import ru.service.ModelService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    GroupService groupService;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        GroupPartsEntity group = groupService.group( 1L );
        System.out.println(group.getGroup_name());

       // modelList.forEach(x->System.out.println(x.getModel_name() + "|" + x.getId_model()) );
    }
}
