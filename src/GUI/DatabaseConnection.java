/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author yanukadeneth
 */
public class DatabaseConnection {

    private String dbURL = "jdbc:derby://localhost:1527/GameShopDB";
    private String dbUsername = "gameshopdbadmin";
    private String dbPassword = "gshopAdmin@123";

    public String GETDBURL() {
        return dbURL;
    }

    public String GETDBUSERNAME() {
        return dbUsername;
    }

    public String GETDBPASSWORD() {
        return dbPassword;
    }

}
