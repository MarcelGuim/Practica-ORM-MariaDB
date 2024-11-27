package edu.upc.eetac.dsa.db.orm;

import edu.upc.eetac.dsa.db.orm.model.users;
import org.junit.Test;

public class ORMTest {

    @Test
    public void registerUserTest(){
        Session session = FactorySession.openSession(); //url, user, password);
        users user1 = new users("Lluc", "123452","lluc" ,200.5, 21.2);
        session.save(user1);
    }

    @Test
    public void getUserTest(){
        Session session = FactorySession.openSession(); //url, user, password);
        users u = (users)session.get(users.class, 1);
        int j =2;
    }

}
