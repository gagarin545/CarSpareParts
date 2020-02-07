package ru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.service.CarService;
import ru.service.ModelService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTest {
    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Resource
    CarService carsService;

    @Before
    public void setUp() throws Exception {        em = emf.createEntityManager();    }

    @Test
    public void  test() {
        List<MakeCarEntity> carList = carsService.carsList( );
        System.out.println( carList.size());
        carList.forEach(x->System.out.println(x.getCar_name()));
        MakeCarEntity car = carsService.car(  1L );
        System.out.println(car.getCar_name());

    }
}
