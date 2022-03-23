
import dao.HumanDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Human;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chuong
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        HumanDAO humanDAO= new HumanDAO();
        Human newHuman = new Human();
        ArrayList<Human> humans = HumanDAO.getHumans();
        for (Human human : humans) {
            System.out.println(""+ human);
            
        }
        /*System.out.println("---------DELETE----------");
        humanDAO.deleteHuman("333");
        for (Human human : humans) {
            System.out.println(""+ human);
        }*/
        System.out.println("");
        
        System.out.println("------Update------");
        newHuman = new Human(111, "Tran Chuong");
        humanDAO.updateHuman(newHuman);
        for (Human human : humans) {
            System.out.println(""+human);
        }
        
        
    }
    
}
