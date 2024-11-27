package edu.upc.eetac.dsa.db.orm.dao;

import edu.upc.eetac.dsa.db.orm.model.users;

public interface IUserDAO {
    public int addUser(String name, String Password, String correu, double money, double Cobre);
    public users getUser(int employeeID);

}
