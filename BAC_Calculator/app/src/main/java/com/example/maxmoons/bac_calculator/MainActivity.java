package com.example.maxmoons.bac_calculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public int hours = 0;
    public int weight = 200;
    public int amount = 0;
    public boolean gender = false;
    public boolean beer = false;
    public boolean wine = false;
    public boolean shot = false;
    public double ozDrink = 0;
    public double gAlcohol = 0.0;
    public double literBlood = 0;
    public double BAC = 0;
    public boolean holder = false;
    DecimalFormat df = new DecimalFormat("#.###");
    //BAC Formula: gAlcohol/(literBlood*10)=BAC
    //oz to g, 28.35x

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView HoursNumber = (TextView) findViewById(R.id.HoursNumber);
        final Button Calculate = (Button) findViewById(R.id.button);
        final SeekBar HoursBar = (SeekBar) findViewById(R.id.HoursBar);
        final SeekBar WeightBar = (SeekBar) findViewById(R.id.WeightBar);
        final SeekBar AmountBar = (SeekBar) findViewById(R.id.AmountBar);
        final TextView AmountNumber = (TextView) findViewById(R.id.AmountNumber);
        final TextView WeightNumber = (TextView) findViewById(R.id.WeightNumber);
        final CheckBox Female = (CheckBox) findViewById(R.id.Female);
        final CheckBox ShotCheck = (CheckBox) findViewById(R.id.ShotCheck);
        final CheckBox BeerCheck = (CheckBox) findViewById(R.id.BeerCheck);
        final CheckBox WineCheck = (CheckBox) findViewById(R.id.WineCheck);

        HoursBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                hours = progress;
                HoursNumber.setText(hours+"");

            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        WeightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                weight = progress+120;
                WeightNumber.setText(weight+"");

            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        AmountBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar MHeightInches, int progress, boolean fromUser) {
                amount = progress;
                AmountNumber.setText(amount+"");

            }

            public void onStartTrackingTouch(SeekBar MHeightInches) {
            }

            public void onStopTrackingTouch(SeekBar MHeightInches) {
            }
        });

        Female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gender = b;


            }
        });

        ShotCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                shot=b;
                if(shot==true)
                {
                    BeerCheck.setChecked(false);
                    //ShotCheck.setChecked(true);
                    WineCheck.setChecked(false);
                }
                //DrinkCheck(ShotCheck);


            }
        });

        BeerCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                beer=b;
                if(beer==true)
                {
                    //BeerCheck.setChecked(true);
                    ShotCheck.setChecked(false);
                    WineCheck.setChecked(false);
                }
                //DrinkCheck(BeerCheck);


            }
        });

        WineCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                wine=b;
                if(wine==true)
                {
                    BeerCheck.setChecked(false);
                    ShotCheck.setChecked(false);
                    //WineCheck.setChecked(true);
                }
                //DrinkCheck(WineCheck);


            }
        });


    }

    public void Calculate(View v){
        literBlood = weight*0.07;
        if(beer)
        {
            ozDrink=amount*12;
            gAlcohol = ozDrink * 28.35 * .06;
        }
        if(wine)
        {
            ozDrink=amount*5;
            gAlcohol = ozDrink * 28.35 * .12;
        }
        if(shot)
        {
            ozDrink=amount*1.5;
            gAlcohol = ozDrink * 28.35 * .4;
        }
        BAC=gAlcohol/(literBlood*100);
        BAC -= hours * .016;
        if(gender)
            BAC+=hours*0.00175;
        if(BAC<0)
            BAC=0.0;
        holder=!holder;
        final TextView HoursNumber = (TextView) findViewById(R.id.HoursNumber);
        final Button Calculate = (Button) findViewById(R.id.button);
        final SeekBar HoursBar = (SeekBar) findViewById(R.id.HoursBar);
        final SeekBar WeightBar = (SeekBar) findViewById(R.id.WeightBar);
        final SeekBar AmountBar = (SeekBar) findViewById(R.id.AmountBar);
        final TextView AmountNumber = (TextView) findViewById(R.id.AmountNumber);
        final TextView WeightNumber = (TextView) findViewById(R.id.WeightNumber);
        final CheckBox Female = (CheckBox) findViewById(R.id.Female);
        final CheckBox ShotCheck = (CheckBox) findViewById(R.id.ShotCheck);
        final CheckBox BeerCheck = (CheckBox) findViewById(R.id.BeerCheck);
        final CheckBox WineCheck = (CheckBox) findViewById(R.id.WineCheck);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView7 = (TextView) findViewById(R.id.textView7);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);
        final TextView textView9 = (TextView) findViewById(R.id.textView9);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        if(holder)
        {
            HoursNumber.setVisibility(View.INVISIBLE);
            HoursBar.setVisibility(View.INVISIBLE);
            Calculate.setText("Back");
            WeightNumber.setVisibility(View.INVISIBLE);
            WeightBar.setVisibility(View.INVISIBLE);
            AmountNumber.setVisibility(View.INVISIBLE);
            AmountBar.setVisibility(View.INVISIBLE);
            Female.setVisibility(View.INVISIBLE);
            ShotCheck.setVisibility(View.INVISIBLE);
            BeerCheck.setVisibility(View.INVISIBLE);
            WineCheck.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView7.setVisibility(View.VISIBLE);
            textView8.setText(df.format(BAC));
            textView8.setVisibility(View.VISIBLE);
            if(BAC>.08)
                textView9.setText("It is illegal to drive.");
            else if(BAC>=.06)
                textView9.setText("Only drive in an emergency.");
            else if(BAC>=.03)
                textView9.setText("Only drive if necessary.");
            else if (BAC>=.01)
                textView9.setText("Be cautious while driving.");
            else
                textView9.setText("Driving should be as normal.");
            textView9.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.VISIBLE);
            textView5.setVisibility(View.VISIBLE);
        }
        else
        {
            HoursNumber.setVisibility(View.VISIBLE);
            HoursBar.setVisibility(View.VISIBLE);
            Calculate.setText("Calculate BAC");
            WeightNumber.setVisibility(View.VISIBLE);
            WeightBar.setVisibility(View.VISIBLE);
            AmountNumber.setVisibility(View.VISIBLE);
            AmountBar.setVisibility(View.VISIBLE);
            Female.setVisibility(View.VISIBLE);
            ShotCheck.setVisibility(View.VISIBLE);
            BeerCheck.setVisibility(View.VISIBLE);
            WineCheck.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView7.setVisibility(View.INVISIBLE);
            textView8.setText(df.format(BAC));
            textView8.setVisibility(View.INVISIBLE);
            textView9.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            textView5.setVisibility(View.INVISIBLE);
        }

    }

    /*private void DrinkCheck(View v) {
        final CheckBox ShotCheck = (CheckBox) findViewById(R.id.ShotCheck);
        final CheckBox BeerCheck = (CheckBox) findViewById(R.id.BeerCheck);
        final CheckBox WineCheck = (CheckBox) findViewById(R.id.WineCheck);
        if(beer==true)
        {
            BeerCheck.setChecked(true);
            ShotCheck.setChecked(false);
            WineCheck.setChecked(false);
        }
        if(wine==true)
        {
            BeerCheck.setChecked(false);
            ShotCheck.setChecked(false);
            WineCheck.setChecked(true);
        }
        if(shot==true)
        {
            BeerCheck.setChecked(false);
            ShotCheck.setChecked(true);
            WineCheck.setChecked(false);
        }
    }*/


    public void Terms(View v)
    {
        Uri uri = Uri.parse("https://microhealthllc.com/about/terms-of-use/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
