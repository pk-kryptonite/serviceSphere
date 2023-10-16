package za.co.mhi.service.sphere.service;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import za.co.mhi.service.sphere.screens.DashboardActivity;
import za.co.mhi.service.sphere.service.exception.InvalidEmailOrPasswordException;

public class UserServices {
    private final String baseUrl = "https://pkkryptonite.pythonanywhere.com";

    public void Login(Context context, String emailAddress, String encodedPassword) {
        try {
            OkHttpClient client = new OkHttpClient();
            String url = baseUrl.concat("/authenticate_user");
            JSONObject object = new JSONObject();
            object.put("user_name", "Martin");
            object.put("password", "secure_password");
            RequestBody body = RequestBody.create(object.toString(), MediaType.get("application/json; charset=utf-8"));
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    //Squash exception
                    // TODO: 2023/10/11 When theres no internet connection
                    Log.e("onFailure: ", e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(context, DashboardActivity.class);
                        startActivity(context, intent, null);
                    } else if (response.code() == 404) {
                        throw new InvalidEmailOrPasswordException();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
