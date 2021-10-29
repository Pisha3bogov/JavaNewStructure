import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.modelDaoImpl;
import ru.sapteh.model.ModelCar;
import ru.sapteh.utils.Connector;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = Connector.getInstance();
        Dao<ModelCar,Integer> element = new modelDaoImpl(connection);

//        System.out.println(element.findByID(1));

        element.findAll().forEach(System.out::println);

//        ModelCar model = new ModelCar("Lada","Sedan","Benzolin");
//        element.save(model);

//        ModelCar model = new ModelCar(1,"Chery","Sedan","Benzolin");
//        element.update(model);

//        element.deleteByKey(4);


    }
}
