package net.a6te.lazycoder.jsondataparsingretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mobile App Develop on 4/17/2017.
 */

public interface RetrofitInterface {
    @GET("data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1")
    Call<ArrayList<WeatherModelClass>> getWeather();
}
