import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Jpa_session {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.sessionFactory.openSession();
        //session.beginTransaction();


//      List<Object[]> x = session.createQuery("select t.dt, t.vl from W_dao t where t.profileID = 1851 and t.type = 20 and t.vl >= 40").list();
        List<W_dao> x = session.createQuery("from W_dao t where t.profileID = 1851 and t.type = 20 and t.vl >= 40").list();
        //session.getTransaction().commit();
        System.out.println("----\nQuerying using HQL:");
            for (W_dao u : x) {
            System.out.print(u + "\n");
        }

//        for (Object[] u : x) {
//            Timestamp a = (Timestamp) u[0];
//            System.out.print(a.toLocalDateTime().toLocalDate() + " | ");
//            System.out.print(u[1] + "\n");
//        }

//                for (Object[] o : x) {
//            System.out.println(Arrays.toString(o));
//        }

        //Запрос criteria

        Criteria criteria = session.createCriteria(W_dao.class);
        criteria.add(Restrictions.and(Restrictions.eq("vl", 41F), Restrictions.eq("profileID", 1851), Restrictions.eq("type", 20)));
        List<W_dao> ws = criteria.list();
        System.out.println("----\nQuerying using Hibernate Criteria:");
        for (W_dao w : ws)
            System.out.println(w);




        session.close();
        HibernateSessionFactory.sessionFactory.close();



//      String SQL = "SELECT [vl] FROM [flow3].[dbo].[Vls] WHERE [profileID] = 1851 AND [type] = 20 AND [channel] = 0 AND YEAR([dt])=" + i_year + " AND MONTH([dt])=" + i;




    }
}
