package com.example.cquant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class emission extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emission);

        Spinner vehicle = findViewById(R.id.transport);
        String[] items = new String[]{"2W(Two-Wheeler)", "3W(Three-Wheeler)", "4W(Four-Wheeler)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items);
        vehicle.setAdapter(adapter);

        Button back = findViewById(R.id.back_emission);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        Button leader = findViewById(R.id.leader);
        leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Leaderboard.class);
                startActivity(intent1);
            }
        });





        Intent intent = getIntent();
        float d = intent.getFloatExtra("msg_dis",0);
        String str = String.format("%.3fKm",d);


        TextView distance = findViewById(R.id.dist);
        distance.setText(str);

        vehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int i, long l) {
                String selected_vehi = vehicle.getSelectedItem().toString();

                Spinner Fuel = findViewById(R.id.fuel);
                String[] item = new String[]{"Petrol", "Diesel"};
                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, item);
                Fuel.setAdapter(adapter1);





                Fuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapter1, View view, int i, long l) {
                        String selected_fuel = Fuel.getSelectedItem().toString();


                        Button calc_btn = findViewById(R.id.btn_calc);





                        if(selected_vehi.equals("2W(Two-Wheeler)") && selected_fuel.equals("Petrol"))
                        {

                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    double calc_emission =  39.04 * d;
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(String.format("%.3f gram",calc_emission));



                                }
                            });


                        }
                        else if(selected_vehi.equals("3W(Three-Wheeler)") && selected_fuel.equals("Petrol"))
                        {
                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    double calc_emission =  113.5 * d;
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(String.format("%.3f gram",calc_emission));



                                }
                            });

                        }
                        else if(selected_vehi.equals("3W(Three-Wheeler)") && selected_fuel.equals("Diesel"))
                        {
                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    double calc_emission =  132.2 * d;
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(String.format("%.3f gram",calc_emission));



                                }
                            });

                        }
                        else if(selected_vehi.equals("4W(Four-Wheeler)") && selected_fuel.equals("Petrol"))
                        {
                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    double calc_emission =  179.94 * d;
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(String.format("%.3f gram",calc_emission));



                                }
                            });

                        }
                        else if(selected_vehi.equals("4W(Four-Wheeler)") && selected_fuel.equals("Diesel"))
                        {
                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    double calc_emission =  173.58 * d;
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(String.format("%.3f gram",calc_emission));



                                }
                            });

                        }
                        else
                        {

                            calc_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String s = "*Something went wrong";
                                    TextView calc_CO2 = findViewById(R.id.text_co2);
                                    calc_CO2.setText(s);



                                }
                            });
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


















    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}