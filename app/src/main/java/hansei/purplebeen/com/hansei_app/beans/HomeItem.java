package hansei.purplebeen.com.hansei_app.beans;

/**
 * Created by baehyeonbin on 2017. 9. 19..
 */

public class HomeItem {
    private int image;
    private String title;

    public HomeItem(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
