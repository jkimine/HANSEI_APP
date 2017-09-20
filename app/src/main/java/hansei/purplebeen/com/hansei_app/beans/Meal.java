package hansei.purplebeen.com.hansei_app.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by baehy on 2017. 9. 20..
 */

public class Meal {
    @SerializedName("date")
    private String date;
    @SerializedName("menu")
    private String menu;
    @SerializedName("message")
    private String success;

    public Meal(String date, String menu, String success) {
        this.date = date;
        this.menu = menu;
        this.success = success;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
