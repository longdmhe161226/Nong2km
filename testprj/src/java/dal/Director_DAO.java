/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Director;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Director_DAO extends DBContext {

    public Director getDirectorByID(int mvid) {
        Director mv = new Director();
        String sql = "SELECT *"
                + "  FROM [dbo].[Directors]"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mvid);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Director(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (Exception e) {
            System.out.println(e);
            return mv;
        }
        return mv;
    }

    public Director getDirectorByName(String name) {
        Director mv = new Director();
        String sql = "SELECT *"
                + "  FROM [dbo].[Directors]"
                + "  WHERE [fullname] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Director(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
        } catch (Exception e) {
            System.out.println(e);
            return mv;
        }
        return mv;
    }

    public List<Director> getAll() {
        List<Director> list = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [dbo].[Directors]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                list.add(new Director(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
        } catch (Exception e) {
            System.out.println(e);

        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println((new Director_DAO()).getAll());
    }

    public void addDirector(String name, String des, boolean male, String dob, String na) {

        String sql = "INSERT INTO [dbo].[Directors]\n"
                + "           ([FullName]\n"
                + "           ,[Male]\n"
                + "           ,[Dob]\n"
                + "           ,[Nationality]\n"
                + "           ,[Description])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setBoolean(2, male);
            st.setString(3, dob);
            st.setString(4, na);
            st.setString(5, des);
            st.execute();
        } catch (Exception e) {
        }

    }

    public void deleteDirectorInMovies(int did) {

        String sql = "UPDATE [dbo].[Movies]\n"
                + "   SET\n"
                + "      [DirectorId] = NULL\n"
                + " WHERE [DirectorId]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, did);
            st.execute();
        } catch (Exception e) {
        }

    }

    public void deleteDirector(int did) {
        String sql = "DELETE FROM [dbo].[Directors]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, did);
            st.execute();
        } catch (Exception e) {
        }
    }

    public void updateDir(int id, String name, String des, boolean male, String dob, String na) {

        String sql = "UPDATE [dbo].[Directors]\n"
                + "   SET [FullName] = ?\n"
                + "      ,[Male] =?\n"
                + "      ,[Dob] = ?\n"
                + "      ,[Nationality] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setBoolean(2, male);
            st.setString(3, dob);
            st.setString(4, na);
            st.setString(5, des);
            st.setInt(6, id);
            st.execute();
        } catch (Exception e) {
        }

    }

}
