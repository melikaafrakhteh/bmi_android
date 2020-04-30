package com.example.melikaafrakhteh;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView showText;
    private Button exit;
    private Button me;
    private Button calcute;
    private EditText editheight;
    private EditText editweight;
    double resultnumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defineView();
        viewBody();

    }

    private void defineView() {
        showText = findViewById(R.id.main_text);
        exit = findViewById(R.id.buttonExit);
        me = findViewById(R.id.buttonaboutme);
        calcute = findViewById(R.id.calcute);
        editheight = findViewById(R.id.heightGet);
        editweight = findViewById(R.id.weightGet);
    }

    public void viewBody() {
        calcute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightno = editweight.getText().toString();
                String heightno = editheight.getText().toString();

                if (!"".equals(heightno) && !"".equals(weightno)) {
                    double resultnumberWeight = Double.parseDouble(weightno);
                    double resultnumberHeight = Double.parseDouble(heightno);
                    resultnumber = (resultnumberWeight / (Math.pow(resultnumberHeight / 100, 2)));
                    display((float) resultnumber);
                } else {
                    Toast.makeText(MainActivity.this, "fill the blanks", Toast.LENGTH_LONG).show();
                }
            }

            private void display(float resultnumber1) {
                if (resultnumber1 < 18.5) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogTheme);
                    builder.setTitle("result");
                    String m ="you are underWeight:   "+resultnumber1;
                    builder.setMessage(m);
                    builder.setIcon(R.drawable.ic_launcher);
                    builder.setPositiveButton("try again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    builder.setCancelable(true);
                                }
                            });

                            builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent = new Intent(Intent.ACTION_MAIN);
                                    intent.addCategory(Intent.CATEGORY_HOME);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                            });
                    builder.show();

                } else if (resultnumber1 >= 18.5 && resultnumber1 <= 24.9) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogTheme);
                    builder.setTitle("result");
                    String m ="you are normal:   "+resultnumber1;
                    builder.setMessage(m);
                    builder.setIcon(R.drawable.ic_launcher);
                    builder.setCancelable(false);
                    builder.setPositiveButton("try again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.setCancelable(true);
                        }
                    });

                    builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                } else if (resultnumber1 >= 25 && resultnumber1 <= 29.9) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogTheme);
                    builder.setTitle("result");
                    String m ="you are overWeight:   "+resultnumber1;
                    builder.setMessage(m);
                    builder.setIcon(R.drawable.ic_launcher);
                    builder.setCancelable(false);
                    builder.setPositiveButton("try again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.setCancelable(true);
                        }
                    });

                    builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                } else if (resultnumber1 >= 30) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.DialogTheme);
                    builder.setTitle("result");
                    String m ="you are obese:   "+resultnumber1;
                    builder.setMessage(m);
                    builder.setIcon(R.drawable.ic_launcher);
                    builder.setCancelable(false);
                    builder.setPositiveButton("try again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.setCancelable(true);
                        }
                    });

                    builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                    });
                    builder.show();
                }
            }

        });


        Typeface typeTextView = Typeface.createFromAsset(getAssets(), "fonts/Debby.ttf");
        showText.setTypeface(typeTextView);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, aboutmeActivity.class));

            }

        });


    }

}


