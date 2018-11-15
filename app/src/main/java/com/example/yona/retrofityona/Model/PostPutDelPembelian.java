package com.example.yona.retrofityona.Model;
import com.google.gson.annotations.SerializedName;

public class PostPutDelPembelian {
    @SerializedName("status")
    String status;

    @SerializedName("result")
    Pembelian mPembelian;

    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Pembelian getmPembelian() {
        return mPembelian;
    }

    public void setmPembelian(Pembelian mPembelian) {
        this.mPembelian = mPembelian;
    }
}
