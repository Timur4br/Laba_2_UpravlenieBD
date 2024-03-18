package org.example.repozitory;
import org.example.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MastersRepozitory implements IRepo<Masters> {
    public EntityManager em =
            Persistence.createEntityManagerFactory("TST").createEntityManager();

    @Override
    public int insert(Masters masters) throws SQLException {
        String str = String.format("INSERT INTO masters (surname, name) VALUES ('%s', '%s')",
                masters.getSurname(),
                masters.getName());
        masters.setDelete(false);
        this.executeRequest(str);
        try (ResultSet ms = this.getStatement(this.connectToDB()).executeQuery("SELECT MAX(id) FROM Masters")) {
            while (ms.next()) {
                return ms.getInt(1);
            }
            return -1;
        }

    }

    private void executeRequest(String request) throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(request);
        stmt.close();
    }

    @Override
    public void delete(Masters stylists) throws SQLException {
        String str = String.format("UPDATE Masters SET isDelete = true WHERE id = %s" , stylists.getId());
        this.executeRequest(str);
    }
    @Override
    public void update(Masters masters, int id) throws SQLException {// не исправлен у мастеров и клиентов
        String str = String.format("UPDATE masters SET id = %s, surname = '%s', name = '%s' WHERE id = %s" ,
                masters.getId(),
                masters.getSurname(),
                masters.getName(),
                masters.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }

    @Override
    public List<Masters> getList() {
        TypedQuery<Masters> namedQuery = em.createNamedQuery("Masters.getAll", Masters.class);
        return namedQuery.getResultList();
    }
    @Override
    public Connection connectToDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:testbd", "root", "");
        if (conn==null) {
            System.out.println("Error with connection with DataBase!");
            System.exit(0);
        }
        return conn;
    }
    @Override
    public Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }
    public void closeConnection(Statement stmt) throws SQLException {
        stmt.close();
    }
}

