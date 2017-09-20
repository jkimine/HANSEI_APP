package hansei.purplebeen.com.hansei_app.services;

import hansei.purplebeen.com.hansei_app.beans.Meal;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by baehy on 2017. 9. 20..
 */

public interface MealService {
    @GET("/")
    Call<Meal> getMeal();
}
