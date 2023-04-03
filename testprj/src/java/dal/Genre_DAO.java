/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Genre;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Genre_DAO extends DBContext {

    static int c = 0;

    public List<Genre> getAll() {
        List<Genre> list = new ArrayList<>();
        String sql = "select * from Category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Genre g = new Genre(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(g);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void addCategory(String name, String des) {
        String max = "select MAX(id) from Category";

        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[description])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement stmax = connection.prepareStatement(max);
            ResultSet rs = stmax.executeQuery();
            int i = 0;
            while (rs.next()) {
                i = rs.getInt(1) + 1;
            }
            st.setInt(1, i);
            st.setString(2, name);
            st.setString(3, des);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private List<Integer> getListCid(String[] cid) {
        List<Integer> list = new ArrayList<>();
        String sql = "select [id] from Category where [name] like ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (String s : cid) {
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

    public void addMovieGenre(int mid, String[] cid) {
        List<Integer> gid = (new Genre_DAO()).getListCid(cid);
        String max = "select MAX(id) from movie_genre";
        String sql = "INSERT INTO [dbo].[movie_genre]\n"
                + "           ([id]\n"
                + "           ,[movie_id]\n"
                + "           ,[genre_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement stmax = connection.prepareStatement(max);
            ResultSet rs = stmax.executeQuery();
            int i = 0;
            while (rs.next()) {
                i = rs.getInt(1) + 1;
            }

            st.setInt(2, mid);
            for (Integer genreid : gid) {
                st.setInt(1, i++);

                st.setInt(3, genreid);
                st.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
//        String[] str = {"Horror", "Adventure"};
//        (new Genre_DAO()).addMovieGenre(2, str);
        (new Genre_DAO()).deleteCategory(19);

    }

    public void importCategory(int id, String name, String des) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[description])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, des);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCategory(int id) {
        String sql = "DELETE FROM [dbo].[Category]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMovieGenre(int id) {
        String sql = "DELETE FROM [dbo].[movie_genre]\n"
                + "      WHERE movie_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCategory(int id, String name, String des) {
        String sql = "UPDATE [Category]\n"
                + "   SET [name] = ?\n"
                + "      ,[description] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, des);
            st.setInt(3, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMovieGenreByGid(int id) {
        String sql = "DELETE FROM [dbo].[movie_genre]\n"
                + "      WHERE genre_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Genre getCateByID(int id) {

        Genre g = new Genre();
        String sql = "select * from Category where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                g = new Genre(rs.getInt(1), rs.getString(2), rs.getString(3));
                
            }

        } catch (Exception e) {
        }
        return g;

    }

}
