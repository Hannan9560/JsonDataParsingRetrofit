package net.a6te.lazycoder.jsondataparsingretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String url = "http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1";
    private static final String BASE_URL = "http://samples.openweathermap.org/";

    private String TAG = "Retrofit";
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<ArrayList<WeatherModelClass>> weatherData = retrofitInterface.getWeather();

        weatherData.enqueue(new Callback<ArrayList<WeatherModelClass>>() {
            @Override
            public void onResponse(Call<ArrayList<WeatherModelClass>> call, Response<ArrayList<WeatherModelClass>> response) {

                    Log.d(TAG, "onResponse: ======= "+response.code());
            }

            @Override
            public void onFailure(Call<ArrayList<WeatherModelClass>> call, Throwable t) {
                Log.d(TAG, "onResponse: ======= "+t);

            }
        });

    }
}
