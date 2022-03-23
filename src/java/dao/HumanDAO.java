
package dao;

import DBContext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

/**
 *
 * @author Chuong
 */
public class HumanDAO {

    public static ArrayList<Human> getHumans() throws SQLException {
        ArrayList<Human> humans = new ArrayList<>();

        PreparedStatement statement = null;
        ResultSet rs = null;
        Connection con = null;
        ConnectDB db = ConnectDB.getInstance();

        try {
            con = db.openConnection();
            String sql = "Select * from [dbo].[Human], [dbo].[HumanType]"
                    + "  where  Human.typeid=HumanType.typeid";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Human h = new Human();
                h.setId(rs.getInt("humanid"));
                h.setName(rs.getString("humanname"));
                h.setDob(rs.getDate("humandob"));
                h.setGender(rs.getBoolean("humangender"));
                HumanType ht = new HumanType();
                ht.setTypeId(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                h.setType(ht);
                humans.add(h);

            }

        } catch (Exception ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return humans;
    }

    public void deleteHuman(String idd) throws SQLException {
        String sql = "delete from[dbo].[Human] where humanid=?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            statement.execute();

        } catch (Exception ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            statement.close();
            con.close();

        }
    }

    
    public void updateHuman(Human human) throws SQLException {
        String sql = "update [dbo].[Human] set [humanname]=?,[humangender]=? where humanid=?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, human.getName());
            statement.setBoolean(2, human.isGender());
            statement.setInt(3, human.getId());
            statement.execute();

        } catch (Exception ex) {
            Logger.getLogger(HumanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            statement.close();
            con.close();

        }
    }
}
