package edu.upc.eetac.dsa.db.orm.dao;

import edu.upc.eetac.dsa.db.orm.FactorySession;
import edu.upc.eetac.dsa.db.orm.Session;
import edu.upc.eetac.dsa.db.orm.model.users;

public class IUserDAOImpl implements IUserDAO{
    public int addUser(String name, String password, String correu, double money, double cobre) {
        Session session = null;
        int UserID = 2;
        try {
            session = FactorySession.openSession();
            users user = new users(name, password, correu, money, cobre);
            session.save(user);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return UserID;
    };
    public users getUser(int UserID){
        Session session = null;
        users user = null;
        try {
            session = FactorySession.openSession();
            user = (users)session.get(users.class, UserID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return user;
    };
}
