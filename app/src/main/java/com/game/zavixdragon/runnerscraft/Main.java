package com.game.zavixdragon.runnerscraft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.game.zavixdragon.runnerscraft.backend.CoreGame;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardName;

import java.util.Random;

public class Main extends AppCompatActivity {
    public static char[] ValidSeedCharacters = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    public AppData AppData;
    public AppLocation location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppData = new AppData();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        goToTitle();
    }

    @Override
    public void onBackPressed() {
        if (location == AppLocation.Title)
            super.onBackPressed();
        if (location == AppLocation.Join)
            goToTitle();
        if (location == AppLocation.Game)
            goToTitle();
        if (location == AppLocation.UpdateServer)
            goToGame();
    }

    //Title View
    public void goToTitle() {
        setContentView(R.layout.activity_appstart);
        findViewById(R.id.StartGameButton).setOnClickListener(new StartGameButtonListener(this));
        findViewById(R.id.JoinGameButton).setOnClickListener(new JoinGameButtonListener(this));
        location = AppLocation.Title;
    }

    private class StartGameButtonListener implements View.OnClickListener {
        private final Main main;

        public StartGameButtonListener(Main main) {
            this.main = main;
        }

        public void onClick(View v) {
            String seed = "";
            for (int i = 0; i < 5; i++)
                seed += Main.ValidSeedCharacters[new Random().nextInt(Main.ValidSeedCharacters.length)];
            main.AppData.Seed = seed;
            main.AppData.Game = new CoreGame(new Random(seed.hashCode()));
            main.goToGame();
        }
    }

    private class JoinGameButtonListener implements View.OnClickListener {
        private final Main main;

        public JoinGameButtonListener(Main main) {
            this.main = main;
        }

        public void onClick(View v) {
            main.goToJoin();
        }
    }

    //Join View
    public void goToJoin() {
        setContentView(R.layout.activity_joingame);
        EditText editText = (EditText) findViewById(R.id.GameCodeInput);
        editText.addTextChangedListener(new GameCodeInputListener(this));
        InputFilter[] editFilters = editText.getFilters();
        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
        newFilters[editFilters.length] = new InputFilter.AllCaps();
        editText.setFilters(newFilters);
        findViewById(R.id.JoinButton).setOnClickListener(new JoinButtonListener(this));
        location = AppLocation.Join;
    }

    private class GameCodeInputListener implements TextWatcher {
        private final Main main;

        public GameCodeInputListener(Main main) {
            this.main = main;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            main.AppData.Seed = s.toString();
        }

        public void afterTextChanged(Editable s) {}
    }

    private class JoinButtonListener implements View.OnClickListener {
        private final Main main;

        public JoinButtonListener(Main main) {
            this.main = main;
        }

        public void onClick(View v) {
            if (main.AppData.Seed.length() == 5) {
                main.AppData.Game = new CoreGame(new Random(main.AppData.Seed.hashCode()));
                main.goToGame();
            }
            else
                findViewById(R.id.InputError).setVisibility(View.VISIBLE);
        }
    }

    //Game View
    public void goToGame() {
        setContentView(R.layout.activity_game);
        findViewById(R.id.UpdateServerButton).setOnClickListener(new UpdateServerButtonListener(this));
        location = AppLocation.Game;
    }

    private class UpdateServerButtonListener implements View.OnClickListener {
        private final Main main;

        public UpdateServerButtonListener(Main main) {
            this.main = main;
        }

        public void onClick(View v) {
            main.goToUpdateServer();
        }
    }

    //Update View
    public void goToUpdateServer() {
        setContentView(R.layout.activity_updateserver);
        new Grid(this,
                new GridItem(R.id.imageButton1, 0, 0),
                new GridItem(R.id.imageButton2, 1, 0),
                new GridItem(R.id.imageButton3, 0, 1),
                new GridItem(R.id.imageButton4, 1, 1),
                new GridItem(R.id.imageButton5, 0, 2),
                new GridItem(R.id.imageButton6, 1, 2),
                new GridItem(R.id.imageButton7, 0, 3),
                new GridItem(R.id.imageButton8, 1, 3)).apply();
        location = AppLocation.UpdateServer;
    }

    private class UpdateSpecificServerButtonListener implements View.OnClickListener {
        private final Main main;
        private final GuardName name;

        public UpdateSpecificServerButtonListener(Main main, GuardName name) {
            this.main = main;
            this.name = name;
        }

        public void onClick(View v) {
            main.AppData.Game.update(name);

        }
    }

    //General
    private class AppData {
        String Seed;
        CoreGame Game;
    }

    private enum AppLocation {
        Title,
        Join,
        Game,
        UpdateServer
    }
}
