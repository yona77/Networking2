package com.example.yona.retrofityona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.yona.retrofityona.Model.GetPembelian;
import com.example.yona.retrofityona.Model.Pembelian;
import com.example.yona.retrofityona.Model.PostPutDelPembelian;
import com.example.yona.retrofityona.Rest.ApiClient;
import com.example.yona.retrofityona.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btGet, btUpdate, btInsert, btDelete;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGet = (Button) findViewById(R.id.btGet);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btInsert = (Button) findViewById(R.id.btInsert);
        btDelete = (Button) findViewById(R.id.btDelete);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofit2.Call<GetPembelian> pembelianCall = mApiInterface.getPembelian();
                pembelianCall.enqueue(new Callback<GetPembelian>() {
                    @Override
                    public void onResponse(retrofit2.Call<GetPembelian> call, Response<GetPembelian> response) {
                        List<Pembelian> pembelianList = response.body().getListDataPembelian();
                        Log.d("Retrofit Get", "Jumlah data Pembelian : " + String.valueOf(pembelianList.size()));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<GetPembelian> call, Throwable t) {
                        //Log eror
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofit2.Call<PostPutDelPembelian> updatePembelianCall = mApiInterface.putPembelian("17", "7", "2018-11-15", "500000", "11");
                updatePembelianCall.enqueue(new Callback<PostPutDelPembelian>() {
                    @Override
                    public void onResponse(retrofit2.Call<PostPutDelPembelian> call, Response<PostPutDelPembelian> response) {
                        Log.d("Retrofit Update", "Status Update : " + String.valueOf(response.body().getStatus()));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<PostPutDelPembelian> call, Throwable t) {
                        Log.d("Retrofit Update", t.getMessage());
                    }
                });
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofit2.Call<PostPutDelPembelian> postPutDelPembelianCall = mApiInterface.postPembelian("17", "7", "2018-11-15", "500000", "11");
                postPutDelPembelianCall.enqueue(new Callback<PostPutDelPembelian>() {
                    @Override
                    public void onResponse(retrofit2.Call<PostPutDelPembelian> call, Response<PostPutDelPembelian> response) {
                        Log.d("Retrofit Insert", "Status Insert : " + String.valueOf(response.body().getStatus()));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<PostPutDelPembelian> call, Throwable t) {
                        Log.d("Retrofit Insert", t.getMessage());
                    }
                });
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrofit2.Call<PostPutDelPembelian> deletePembelian = mApiInterface.deletePembelian("17");
                deletePembelian.enqueue(new Callback<PostPutDelPembelian>() {
                    @Override
                    public void onResponse(retrofit2.Call<PostPutDelPembelian> call, Response<PostPutDelPembelian> response) {
                        Log.i("Retrofit Delete", "Status Delete : " + String.valueOf(response.body().getStatus()));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<PostPutDelPembelian> call, Throwable t) {
                        Log.i("Retrofit Delete", t.getMessage());
                    }
                });
            }
        });
    }
}