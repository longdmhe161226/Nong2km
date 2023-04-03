/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Producer;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Producer_DAO extends DBContext {

    public Producer Producer(int mvid) {
        Producer mv = new Producer();
        String sql = "SELECT *"
                + "  FROM [dbo].[Producers]"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mvid);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Producer(rs.getInt(1), rs.getString(2));

            }
        } catch (Exception e) {
            System.out.println(e);
            return mv;
        }
        return mv;
    }

    public Producer Producer(String name) {
        Producer mv = new Producer();
        String sql = "SELECT *"
                + "  FROM [dbo].[Producers]"
                + "  WHERE [name] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                mv = new Producer(rs.getInt(1), rs.getString(2));

            }
        } catch (Exception e) {
            System.out.println(e);
            return mv;
        }
        return mv;
    }

    public List<Producer> getAll() {
        List<Producer> list = new ArrayList<>();
        String sql = "select * from Producers";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                list.add(new Producer(rs.getInt(1), rs.getString(2)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public void add(String parameter) {
        String sql = "INSERT INTO [dbo].[Producers]\n"
                + "           ([Name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, parameter);
            st.execute();
        } catch (Exception e) {
        }
    }

    public void deleteProInMovies(int pid) {
        String sql = "UPDATE [dbo].[Movies]\n"
                + "   SET\n"
                + "      [ProducerId] = NULL\n"
                + " WHERE [ProducerId]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.execute();
        } catch (Exception e) {
        }
    }

    public void deletePro(int pid) {
        String sql = "DELETE FROM [dbo].[Producers]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.execute();
        } catch (Exception e) {
        }
    }

    public void update(int id, String name) {

        String sql = "UPDATE [dbo].[Producers]\n"
                + "   SET [Name] = ?\n"
                + " WHERE id=?";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(2, id);
            st.setString(1, name);
            st.execute();
        } catch (Exception e) {
        }

    }

}
