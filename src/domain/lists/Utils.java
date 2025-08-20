package domain.lists;

import data.FilesTxt;
public class Utils {
    public static List UserList = new List();
    public static List DateList = new List();

    public static void loadUsersFromTxt(String filePath) {
        UserList = FilesTxt.loadUsersFromTxt(filePath);
    }
    

}
