/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Star;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Stars_DAO extends DBContext {

    public List<Star> getAll() {

        List<Star> list = new ArrayList<>();
        String sql = "select * from Stars";
        try {

            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Star(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(6), rs.getString(5)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public void deleteMovieStar(int id) {

        String sql = "DELETE FROM [dbo].[Movie_Star]\n"
                + "      WHERE MovieId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
        }

    }

    public void addMovieStar(int mid, String[] stars) {
        List<Integer> sid = (new Stars_DAO()).getListSid(stars);
        String sql = "INSERT INTO [dbo].[Movie_Star]\n"
                + "           ([MovieId]\n"
                + "           ,[StarId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, mid);
            for (Integer starid : sid) {

                st.setInt(2, starid);
                st.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private List<Integer> getListSid(String[] stars) {

        List<Integer> list = new ArrayList<>();
        String sql = "select [id] from Stars where [fullname] like ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (String s : stars) {
                st.setString(1, s);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    list.add(rs.getInt(1));
                }
            }

        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        String[] str = {"StarA", "StarC", "StarB"};
        System.out.println((new Stars_DAO()).getListSid(str));
    }

    public void addStar(String name, String des, boolean male, String dob, String na) {
        String sql = "INSERT INTO [dbo].[Stars]\n"
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

    public void deleteMovieStarBySid(int id) {
        String sql = "DELETE FROM [dbo].[movie_star]\n"
                + "      WHERE StarId =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Stars]\n"
                + "      WHERE id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Star getStarByID(int id) {
        Star s = new Star();
        String sql = "SELECT *"
                + "  FROM [dbo].[Stars]"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                s = new Star(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(6), rs.getString(5));

            }
        } catch (Exception e) {
            System.out.println(e);
            return s;
        }
        return s;
    }

    public void update(int id, String name, String des, boolean male, String dob, String na) {
        String sql = "UPDATE [dbo].[Stars]\n"
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
