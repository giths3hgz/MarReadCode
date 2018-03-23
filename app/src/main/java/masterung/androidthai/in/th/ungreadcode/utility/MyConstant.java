package masterung.androidthai.in.th.ungreadcode.utility;

/**
 * Created by masterung on 22/3/2018 AD.
 */

public class MyConstant {

    //    About URL
    private String urlGetChildWhereIdUser = "http://androidthai.in.th/mar/getChildWhereIdUser.php";
    private String urlAddChildString = "http://androidthai.in.th/mar/AddChild.php";
    private String urlGetAllUserString = "http://androidthai.in.th/mar/getAllUser.php";
    private String urlPostUserString = "http://androidthai.in.th/mar/postUser.php";
    private String urlEditStatusWhereIDUser = "http://androidthai.in.th/mar/EditStatusByUser.php";  //แก้ไข Status จาก 1 เป็น 0

    //    About Array
    private String[] columnMessageStrings = new String[]{"id", "idUser", "Code",
            "NameChild", "ImageChild", "Status", "DateMessage", "Message"};
    private String[] loginStrings = new String[]{"id", "Name", "User", "Password"};

    public String getUrlEditStatusWhereIDUser() { return urlEditStatusWhereIDUser; }

    public String[] getColumnMessageStrings() {
        return columnMessageStrings;
    }

    public String getUrlGetChildWhereIdUser() {
        return urlGetChildWhereIdUser;
    }

    public String getUrlAddChildString() {
        return urlAddChildString;
    }

    public String[] getLoginStrings() {
        return loginStrings;
    }

    public String getUrlGetAllUserString() {
        return urlGetAllUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
}   // Main Class
