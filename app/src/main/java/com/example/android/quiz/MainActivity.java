package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String selectedGame;
    String[] games;

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        games = getResources().getStringArray(R.array.games);

        final Spinner gameSpinner = (Spinner) findViewById(R.id.game_spinner);
        ArrayAdapter<String> gameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, games);
        gameSpinner.setAdapter(gameAdapter);
        gameSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        //Sets the position of the selected item to a variable, then assigns the current drink and displays the appropriate toppings
                        int position = gameSpinner.getSelectedItemPosition();
                        selectedGame = games[position];
                        Log.i("Selected Game:", selectedGame);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                }
        );
    }

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(quantity));
    }

    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    //This method subtracts 1 to the quantity of drinks
    public void decrement(View view) {
        quantity -= 1;
        displayQuantity(quantity);
    }

    private String getHouseText() {
        EditText editText = (EditText) findViewById(R.id.house_edit_text);
        String houseText = editText.getText().toString();
        return houseText;
    }

    private String getAnimalText() {
        EditText editText = (EditText) findViewById(R.id.animal_edit_text);
        String animalText = editText.getText().toString();
        return animalText;
    }

    private boolean checkSellingCheckBoxes() {
        CheckBox reese = (CheckBox) findViewById(R.id.reese);
        boolean reeseChecked = reese.isChecked();

        CheckBox nooklings = (CheckBox) findViewById(R.id.timmy_tommy);
        boolean nooklingsChecked = nooklings.isChecked();

        CheckBox blathers = (CheckBox) findViewById(R.id.blathers);
        boolean blathersChecked = blathers.isChecked();

        if (reeseChecked && nooklingsChecked && !blathersChecked) {
            Log.i("Food", "True");
            return true;
        } else {
            Log.i("Food", "False");
            return false;
        }
    }

    private boolean checkFoodCheckBoxes() {
        CheckBox apples = (CheckBox) findViewById(R.id.apples);
        boolean applesChecked = apples.isChecked();

        CheckBox peaches = (CheckBox) findViewById(R.id.peaches);
        boolean peachesChecked = peaches.isChecked();

        CheckBox fish = (CheckBox) findViewById(R.id.fish);
        boolean fishChecked = fish.isChecked();

        CheckBox candy = (CheckBox) findViewById(R.id.candy);
        boolean candyChecked = candy.isChecked();

        CheckBox chocolateCoins = (CheckBox) findViewById(R.id.chocolate_coins);
        boolean chocolateCoinsChecked = chocolateCoins.isChecked();

        if (applesChecked && peachesChecked && !fishChecked && candyChecked && chocolateCoinsChecked) {
            Log.i("Food", "True");
            return true;
        } else {
            Log.i("Food", "False");
            return false;
        }
    }

    private boolean checkAbleCheckBoxes() {
        CheckBox orphans = (CheckBox) findViewById(R.id.orphans);
        boolean orphansChecked = orphans.isChecked();

        CheckBox masterChefs = (CheckBox) findViewById(R.id.master_chefs);
        boolean masterChefsChecked = masterChefs.isChecked();

        CheckBox sisters = (CheckBox) findViewById(R.id.sisters);
        boolean sistersChecked = sisters.isChecked();

        CheckBox hedgehogs = (CheckBox) findViewById(R.id.hedgehogs);
        boolean hedgehogsChecked = hedgehogs.isChecked();

        if (orphansChecked && !masterChefsChecked && sistersChecked && hedgehogsChecked) {
            return true;
        } else {
            return false;
        }
    }

    public void checkAnswers(View view) {
        int score = 0;

        RadioButton radioButton = (RadioButton) findViewById(R.id.nephews_radio_button);
        boolean radioButtonChecked = radioButton.isChecked();

        if (selectedGame == "Animal Crossing: New Leaf") {
            Log.i("0", "yes");
        }
        if (Objects.equals(selectedGame, "Animal Crossing: New Leaf")) {
            Log.i("1", "yes");
            score += 1;
        }
        if (Objects.equals(getHouseText().toLowerCase(), "tom nook")) {
            Log.i("2", "yes");
            score += 1;
        }
        if (checkSellingCheckBoxes()) {
            Log.i("3", "yes");
            score += 1;
        }
        if (Objects.equals(getAnimalText().toLowerCase(), "alpaca")) {
            Log.i("4", "yes");
            score += 1;
        }
        Log.i("Quantity", Integer.toString(quantity));
        if (quantity == 1) {
            Log.i("5", "yes");
            Log.i("Quantity", Integer.toString(quantity));
            score += 1;
        }
        if (checkFoodCheckBoxes()) {
            Log.i("6", "yes");
            score += 1;
        }
        if (radioButtonChecked) {
            Log.i("7", "yes");
            score += 1;
        }
        if (checkAbleCheckBoxes()) {
            Log.i("8", "yes");
            score += 1;
        }
        Log.i("Score", Integer.toString(score));
        Toast.makeText(getApplicationContext(), "Well done, you scored " + score + "!", Toast.LENGTH_LONG).show();
    }
}
