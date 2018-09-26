package Entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class entityMain {

    private static final EntityManagerFactory ent = 
            Persistence.createEntityManagerFactory("AgroServPU");
    public entityMain()
    {}
    public static EntityManagerFactory getInstanceI()
    {
        return ent;
    }
}
