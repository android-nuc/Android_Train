package com.example.android_train.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_train.R;
import com.example.android_train.adapter.MovieListAdapter;
import com.example.android_train.bean.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author 65667
 */
public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView textView;
    private List<Movie> movieList = new ArrayList<>();

    private String path1 = "http://106.55.173.177:8081/index.php/top250?page=0";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie,container,false);
        recyclerView = view.findViewById(R.id.movie_fragment_recycler);
        progressBar = view.findViewById(R.id.fragment_progress);
        textView = view.findViewById(R.id.fragment_message);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        requestData();
        return view;
    }

    private void requestData() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request =new Request.Builder().url(path1).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJson(responseData);
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * {"coderYJ":"\u7b80\u4e66\u5173\u6ce8coderYJ \u6b22\u8fce\u52a0QQ\u7fa4\u8ba8\u8bba277030213","code":200,"msg":"\u8bf7\u6c42\u6210\u529f","data":{"total":250,"limit":25,"page":0,"subject":[{"id":1,"img":"https:\/\/img2.doubanio.com\/view\/photo\/s_ratio_poster\/public\/p480747492.jpg","name":"\u8096\u7533\u514b\u7684\u6551\u8d4e","director":"\u5f17\u5170\u514b\u00b7\u5fb7\u62c9\u90a6\u7279 Frank Darabont","star":"9.7","quote":"\u5e0c\u671b\u8ba9\u4eba\u81ea\u7531\u3002","m_id":"1292052","order_num":0},{"id":2,"img":"https:\/\/img3.doubanio.com\/view\/photo\/s_ratio_poster\/public\/p2561716440.jpg","name":"\u9738\u738b\u522b\u59ec","director":"\u9648\u51ef\u6b4c Kaige Chen","star":"9.6","quote":"\u98ce\u534e\u7edd\u4ee3\u3002","m_id":"1291546","order_num":1},
     */
    private void parseJson(String responseData) {
        try {
            JSONObject jsonObject = new JSONObject(responseData);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("subject");
            for (int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject_i = jsonArray.getJSONObject(i);
                String title = jsonObject_i.get("name").toString();
                String imgUrl = jsonObject_i.get("img").toString();
                String average = jsonObject_i.get("star").toString();
                Log.e("movie",title + imgUrl);
                String genres = jsonObject_i.get("quote").toString();
                Movie movie = new Movie(title, imgUrl, average, genres);
                movieList.add(movie);
            }
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    MovieListAdapter adapter = new MovieListAdapter(movieList);
                    recyclerView.setAdapter(adapter);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
