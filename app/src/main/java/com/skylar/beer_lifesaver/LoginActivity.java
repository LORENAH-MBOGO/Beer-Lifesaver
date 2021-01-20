package com.skylar.beer_lifesaver;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
//    Button loginButton,button2;
//    EditText userName,password;
//
//    TextView tx1;
//    int counter = 3;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        loginButton = (Button)findViewById(R.id.loginButton);
//        userName = (EditText)findViewById(R.id.userName);
//        password = (EditText)findViewById(R.id.password);
//
//        button2 = (Button)findViewById(R.id.button2);
//        tx1 = (TextView)findViewById(R.id.textView3);
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                if(userName.getText().toString().equals("admin") &&
//                        password.getText().toString().equals("admin")) {
//                    Toast.makeText(getApplicationContext(),
//                            "Redirecting...",Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//
//                    startActivity(intent);
//
//
//                }else{
//                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//
//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        loginButton.setEnabled(false);
//                    }
//                }
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }
}