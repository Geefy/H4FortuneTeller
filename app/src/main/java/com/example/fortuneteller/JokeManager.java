package com.example.fortuneteller;

import com.google.gson.Gson;

import java.util.ArrayList;

public class JokeManager {
    ArrayList<JokeHandler> listeners = new ArrayList<>();
    JokeApi api = new JokeApi();

    public Fortune GetFortune() {
        return new Gson().fromJson(api.getJoke(),Fortune.class);
    }
}
