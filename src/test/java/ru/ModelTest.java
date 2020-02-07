package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.repository.ModelCarEntityRepository;
import ru.service.CarService;
import ru.service.ModelService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    ModelService modelService;

    @Resource
    CarService carsService;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        MakeCarEntity car  = carsService.car( 1L);
        System.out.println( car.getCar_name());
        List<ModelCarEntity> modelList = modelService.modelList( car );
        modelList.forEach(x->System.out.println(x.getModel_name() + "|" + x.getId_model()) );
    }
}
