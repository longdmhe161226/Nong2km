///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package dal;
//
//import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
//import model.Admin;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
///**
// *
// * @author FPT SHOP PCC Hai Hau
// */
//public class DAO extends DBContext{
//    //check tk
////    public Admin check(String username,String password){
////        String sql="select * from Admin where Username = ? and Password=?";
////        
////        try {
////            PreparedStatement st = connection.prepareStatement(sql);
////            st.setString(1, username);
////            st.setString(2, password);
////            ResultSet rs = st.executeQuery();
////            
////            if (rs.next()) {
////                return new Admin(rs.getString("username"), rs.getString("password"), rs.getInt("role"));
////            }
////            
////        } catch (Exception e) {
////        }
////        return null;
////    }
////    
////    public static void main(String[] args) {
////        System.out.println((new DAO()).check("sa", "12"));
////    }
////    
//}
