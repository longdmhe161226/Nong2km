/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngotu
 */
public class Count extends DBContext {

    public void add_view() throws Exception {
        int count = 1;
        String date = java.time.LocalDate.now().toString();
        String get = "SELECT [visitor] FROM [dbo].[visitor_count] WHERE [date] = '" + date + "'";
        String insert = "INSERT INTO [dbo].[visitor_count]\n"
                + "           ([date]\n"
                + "           ,[visitor])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        String update = "UPDATE [dbo].[visitor_count]\n"
                + "   SET [visitor] = ?\n"
                + " WHERE [date] = ?";
        PreparedStatement sget = connection.prepareStatement(get);
        ResultSet rs = sget.executeQuery();
        if (!rs.next()) {
            PreparedStatement sinsert = connection.prepareStatement(insert);
            sinsert.setString(1, date);
            sinsert.setInt(2, count);
            sinsert.execute();
        } else {
            int view = rs.getInt("visitor");
            PreparedStatement supdate = connection.prepareStatement(update);
            view = view + count;
            supdate.setInt(1, view);
            supdate.setString(2, date);
            supdate.execute();
        }
    }

    public int count_view() throws Exception {
        int count = 0;
        String sqlCount = "SELECT SUM([visitor])\n"
                + "FROM [visitor_count]";
        PreparedStatement sget = connection.prepareStatement(sqlCount);
        ResultSet rs = sget.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public int count_movie() throws Exception {
        int count = 0;
        String sqlCount = "SELECT COUNT([id])\n"
                + "FROM [Movies]";
        PreparedStatement sget = connection.prepareStatement(sqlCount);
        ResultSet rs = sget.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }


    public int count_user() throws Exception {
        int count = 0;
        String sqlCount = "SELECT COUNT([id])\n"
                + "FROM [Users]";
        PreparedStatement sget = connection.prepareStatement(sqlCount);
        ResultSet rs = sget.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

//    public static void main(String[] args) throws Exception {
//        Count c = new Count();
//        System.out.println(c.count_user());
//    }
}
