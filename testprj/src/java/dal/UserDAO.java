/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import java.util.ArrayList;
import java.util.List;
//import org.mindrot.jbcrypt.BCrypt;
//import org.mindrot.jbcrypt.BCrypt;
import processer.AES;

/**
 *
 * @author ngotu
 */
public class UserDAO extends DBContext {

    public User getAccount(String usernameoremail, String pass) {
        String sql = "SELECT [id]\n"
                + "      ,[role]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[avatar]\n"
                + "  FROM [Users]\n"
                + "  WHERE username=? or email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usernameoremail);
            st.setString(2, usernameoremail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String avatar = rs.getString("avatar");
                if (checkPass(pass, AES.decrypt(password))) {
                    return new User(id, role, name, email, username, password, avatar);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT *"
                + "  FROM [Users]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String avatar = rs.getString("avatar");
                User u = new User(id, role, name, email, username, password, avatar);
                users.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }

    public boolean checkPass(String pass, String dpass) {
        boolean valuate = pass.equals(dpass);
        return valuate;
    }

    public int checkExit(String usernameoremail) {
        String sql = "SELECT [id]\n"
                + "      ,[role]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "  FROM [Users]\n"
                + "  WHERE username=? or email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usernameoremail);
            st.setString(2, usernameoremail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int insertUsser(String name, String username, String email, String pass) {
        errorMessage = "";
        if (checkExit(username) == 0 && checkExit(email) == 0) {
            String sql = "INSERT INTO [dbo].[Users]\n"
                    + "           ([role]\n"
                    + "           ,[name]\n"
                    + "           ,[email]\n"
                    + "           ,[username]\n"
                    + "           ,[password]\n"
                    + "           ,[avatar])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)\n";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "user");
                st.setString(2, name);
                st.setString(3, email);
                st.setString(4, username);
                st.setString(5, AES.encrypt(pass));
                st.setString(6, "https://i.imgur.com/zXbhmFD.png");
                st.execute();
                return 1;
            } catch (Exception e) {
                setErrorMessage(e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Acc da ton tai");
            return -1;
        }
    }

    public int updateUser(int id, String name, String username, String email) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [name] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[username] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, username);
            st.setInt(4, id);
            st.execute();
            return 1;
        } catch (Exception e) {
            setErrorMessage(e.getMessage());
            return 0;
        }
    }

    public int updatePass(String pass, int id) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [password] = ?\n"
                + " WHERE [id] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(2, id);
            st.setString(1, AES.encrypt(pass));
            st.execute();
            return 1;
        } catch (Exception e) {
            setErrorMessage(e.getMessage());
            return 0;
        }
    }

    public User getUser(int id) {
        String sql = "SELECT TOP (1000) [id]\n"
                + "      ,[role]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[avatar]\n"
                + "  FROM [Users]"
                + "  WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String avatar = rs.getString("avatar");
                User u = new User(id, role, name, email, username, password, avatar);
                return u;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUser(String userormail) {
        String sql = "SELECT TOP (1000) [id]\n"
                + "      ,[role]\n"
                + "      ,[name]\n"
                + "      ,[email]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[avatar]\n"
                + "  FROM [Users]"
                + "  WHERE username=? or email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userormail);
            st.setString(2, userormail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String role = rs.getString("role");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String avatar = rs.getString("avatar");
                User u = new User(id, role, name, email, username, password, avatar);
                return u;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {

//        String originalString = "123";
//        String encryptedString = AES.encrypt(originalString);
//        String decryptedString = AES.decrypt("123");
//
//        System.out.println(originalString);
//        System.out.println(encryptedString);
//        System.out.println(decryptedString);
//        System.out.println((new UserDAO()).checkPass("123", AES.decrypt(AES.encrypt("123"))));
//        System.out.println((new UserDAO()).getAccount("nguyenthanhlong16102002@gmail.com", "123"));
        UserDAO ud = new UserDAO();
        //        ud.updatePass("1234", 8);
        //        System.out.println((new UserDAO()).getAccount("nguyenthanhlong16102002@gmail.com", "123"));
        //        System.out.println((new UserDAO()).getAccount("nguyenthanhlong16102002@gmail.com", "1234"));
        //        System.out.println(AES.decrypt("123"));

        System.out.println(ud.getUser("nong2km@gmail.com"));;

    }

    public void deleteUser(String email) {
        String sql = "DELETE FROM [dbo].[Users]\n"
                + "      WHERE email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
