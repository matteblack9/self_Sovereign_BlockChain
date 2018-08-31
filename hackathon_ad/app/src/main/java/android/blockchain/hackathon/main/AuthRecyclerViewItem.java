package android.blockchain.hackathon.main;

import java.io.Serializable;

/**
 * Created by rlarh on 2018-08-31.
 */

public class AuthRecyclerViewItem implements Serializable {
    String image_path;
    String auth_name;
    String auth_detail;

    public AuthRecyclerViewItem() {
    }

    public AuthRecyclerViewItem(String image_path, String auth_name, String auth_detail) {
        this.image_path = image_path;
        this.auth_name = auth_name;
        this.auth_detail = auth_detail;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getAuth_detail() {
        return auth_detail;
    }

    public void setAuth_detail(String auth_detail) {
        this.auth_detail = auth_detail;
    }
}
