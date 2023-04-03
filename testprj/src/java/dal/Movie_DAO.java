/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Movie;

/**
 *
 * @author FPT SHOP PCC Hai Hau
 */
public class Movie_DAO extends DBContext {

    public List<Movie> getTop10() {
        List<Movie> list = new ArrayList<>();
        String sql = "select top 10 * from Movies order by [views] desc ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                Movie m = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                list.add(m);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Movie> getTopView() {
        List<Movie> list = new ArrayList<>();
        String sql = "select top 30 * from Movies order by [views] desc ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                Movie m = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                list.add(m);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Movie> getTopVote() {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movies where [vote_average]>=7.5\n"
                + "order by [vote_average] desc ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                Movie m = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                list.add(m);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Movie> getNew() {
        List<Movie> list = new ArrayList<>();
        String sql = "select * from Movies where overview = 'COMING' ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;
                Movie m = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                list.add(m);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Movie getMovieByid(int mvid) {
        Movie mv = new Movie();
        String sql = "SELECT *"
                + "  FROM [dbo].[Movies]"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mvid);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15), rs.getInt(16));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mv;
    }

    public List<Movie> getAllMovie() {
        List<Movie> list = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [dbo].[Movies]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                Movie m = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                list.add(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void addMovie(Movie movie) {
        String sql = "INSERT INTO [dbo].[Movies]\n"
                + "           ([title]\n"
                + "           ,[overview]\n"
                + "           ,[poster]\n"
                + "           ,[backdrop]\n"
                + "           ,[vote_average]\n"
                + "           ,[vote_count]\n"
                + "           ,[views]\n"
                + "           ,[runtime]\n"
                + "           ,[release_date]\n"
                + "           ,[create_at]\n"
                + "           ,[video_link]\n"
                + "           ,[quality]\n"
                + "           ,[category])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,getDate()\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, movie.getTitle());
            st.setString(2, movie.getOverview());
            st.setString(3, "images/poster/" + movie.getPoster());
            st.setString(4, "images/backdrop/" + movie.getBackdrop());
            st.setFloat(5, movie.getVote_average());
            st.setInt(6, movie.getVote_count());
            st.setInt(7, movie.getView());
            st.setInt(8, movie.getRuntime());
            st.setString(9, movie.getRelease_date());
            st.setString(10, movie.getVideo_link());
            st.setString(11, movie.getQuality());
            st.setString(12, movie.getCategory());
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMovie(int id, String title, String overview, String poster, String backdrop, float vote_average, int runtime, String release_date, String link, String quality, String category, int pid, int did) {
        String sql = "UPDATE [dbo].[Movies]\n"
                + "   SET [title] = ?\n"
                + "      ,[overview] = ?\n"
                + "      ,[poster] = ?\n"
                + "      ,[backdrop] = ?\n"
                + "      ,[vote_average] = ?\n"
                + "      ,[vote_count] = ?\n"
                + "      ,[views] = ?\n"
                + "      ,[runtime] = ?\n"
                + "      ,[release_date] = ?\n"
                + "      ,[create_at] = ?\n"
                + "      ,[video_link] = ?\n"
                + "      ,[quality] = ?\n"
                + "      ,[category] = ?\n"
                + "      ,[ProducerId] = ?\n"
                + "      ,[DirectorId] = ?\n"
                + " WHERE [id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, overview);
            st.setString(3, "images/poster/" + poster);
            st.setString(4, "images/backdrop/" + backdrop);
            st.setFloat(5, vote_average);
            st.setInt(6, runtime);
            st.setString(7, release_date);
            st.setString(8, link);
            st.setString(9, quality);
            st.setString(10, category);
            st.setInt(11, pid);
            st.setInt(12, did);
            st.setInt(13, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMovie(int id, String title, String overview, String poster, String backdrop, int runtime, String release_date, String link, String category, int pid, int did) {
        String sql = "UPDATE [dbo].[Movies]\n"
                + "     SET [title] = ?\n"
                + "      ,[overview] = ?\n"
                + "      ,[poster] =  ?\n"
                + "      ,[backdrop] =  ?\n"
                + "      ,[runtime] = ?\n"
                + "      ,[release_date] = ?\n"
                + "      ,[video_link] = ?\n"
                + "      ,[category] = ?"
                + "      ,[ProducerId] = ?\n"
                + "      ,[DirectorId] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, overview);
            st.setString(3, "images/poster/" + poster);
            st.setString(4, "images/backdrop/" + backdrop);
            st.setInt(5, runtime);
            st.setString(6, release_date);
            st.setString(7, link);
            st.setString(8, category);
            st.setInt(9, pid);
            st.setInt(10, did);
            st.setInt(11, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMovie(int id, float vote_average) {
        String sql = "UPDATE [dbo].[Movies]\n"
                + "   SET\n"
                + "      \n"
                + "   \n"
                + "      [vote_average] =(?+vote_average*vote_count)/(vote_count+1)\n"
                + "      ,[vote_count] = vote_count+1\n"
                + "     \n"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setFloat(1, vote_average);

            st.setInt(2, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateMovie(int id) {
        String sql = "UPDATE [dbo].[Movies]\n"
                + "   SET \n"
                + "      [views] = views+1\n"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMovie(int id) {
        String sql = "DELETE FROM [dbo].[Movies]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

//        Movie_DAO md = new Movie_DAO();
//        md.deleteMovie(82);
//        md.deleteMovie(83);
//        md.deleteMovie(84);
//        md.deleteMovie(86);
//        md.deleteMovie(89);
//        md.updateMovie(1, "ok", "ok", "ok", "ok", 0, 0, "20021010", "ok", "ok", "ok");
////        md.addMovie(new Movie(0, "ok", "ok", "ok", "ok", 0, 0, 0, 123, "20021016", "", "ok", "ok", "ok"));
        for (Movie m : (new Movie_DAO()).getMovieByCategory("Comedy")) {
            System.out.println(m);
        }

    }

    public List<Movie> getMovieByCategory(String string) {
        Movie mv = new Movie();
        List<Movie> l = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [dbo].[Movies]"
                + "  WHERE [category] like ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + string + "%");
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                l.add(mv);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return l;

    }

    public List<Movie> getMovieByTitle(String string) {
        Movie mv = new Movie();
        List<Movie> l = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [dbo].[Movies]"
                + "  WHERE [title] like ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + string + "%");
            ResultSet rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;

                mv = new Movie(rs.getInt(1), i, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getInt(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
                l.add(mv);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return l;

    }

}
