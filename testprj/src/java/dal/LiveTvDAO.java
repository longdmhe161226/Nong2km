/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.LiveTV;
import model.Movie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngotu
 */
public class LiveTvDAO extends DBContext {

    public List<LiveTV> getAllChannel() {
        List<LiveTV> listmo = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[image]\n"
                + "      ,[link]\n"
                + "  FROM [dbo].[LiveTV]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String des = rs.getString("description");
                String image = rs.getString("image");
                String link = rs.getString("link");
                LiveTV tv = new LiveTV(id, title, image, des, link);
                listmo.add(tv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listmo;
    }

    public LiveTV getChannel(int cid) {
        String sql = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[description]\n"
                + "      ,[image]\n"
                + "      ,[link]\n"
                + "  FROM [dbo].[LiveTV]"
                + "  WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String des = rs.getString("description");
                String image = rs.getString("image");
                String link = rs.getString("link");
                LiveTV tv = new LiveTV(id, title, image, des, link);
                return tv;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addChannel(LiveTV tv) {
        String sql = "INSERT INTO [dbo].[LiveTV]\n"
                + "           ([title]\n"
                + "           ,[description]\n"
                + "           ,[image]\n"
                + "           ,[link])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tv.getTitle());
            st.setString(2, tv.getDes());
            st.setString(3, tv.getImage());
            st.setString(4, tv.getLink());
            st.execute();     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        LiveTvDAO ld = new LiveTvDAO();
        System.out.println(ld.getChannel(0).getTitle());
    }
}
