package com.example.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

private Button btnSave;
private EditText editName;
private EditText editPunchSpeed;
private EditText editPunchPower;
private EditText editKickSpeed;
private EditText editkickPower;
private TextView txtGetData;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave=findViewById(R.id.button4);

        editName=findViewById(R.id.name);
        editPunchSpeed=findViewById(R.id.punchPower);
        editPunchPower=findViewById(R.id.punchPower);
        editKickSpeed=findViewById(R.id.kickSpeed);
        editkickPower=findViewById(R.id.kickPower);

        btnSave.setOnClickListener(SignUp.this);

        txtGetData =findViewById(R.id.txtGetData);

        txtGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery= ParseQuery.getQuery("KickBoxer");

                parseQuery.getInBackground("MwBBBMmatq", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if(object!=null && e==null){
                            txtGetData.setText(object.get("Name")+" ");
                        }else{
                            Toast.makeText(SignUp.this,e+(" "),Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ParseObject kick = new ParseObject("KickBoxing");
//
//                kick.put("Name","Maruf");
//                kick.put("Kick Power",1000);
//                kick.put("Kick Speed",1500);
//                kick.put("Punch Power",3000);
//                kick.put("Punch Speed",2000);
//
//                kick.saveInBackground(new SaveCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if(e==null){
//                            Toast.makeText(SignUp.this,"Kick is saved ",Toast.LENGTH_LONG).show();
//                        }else{
//                            Toast.makeText(SignUp.this,"Can not save",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
//

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        final ParseObject kick = new ParseObject("KickBoxer");

        kick.put("Name",editName.getText().toString());
        kick.put("PunchSpeed",editPunchSpeed.getText().toString());
        kick.put("PunchPower",editPunchPower.getText().toString());
        kick.put("KickPower",editkickPower.getText().toString());
        kick.put("KickSpeed",editKickSpeed.getText().toString());

        kick.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null){
                    Toast.makeText(SignUp.this,kick.get("Name")+" is saved",Toast.LENGTH_SHORT ).show();

                    editName.setText("");
                    editKickSpeed.setText("");
                    editkickPower.setText("");
                    editPunchPower.setText("");
                    editPunchSpeed.setText("");
                }else{
                    Toast.makeText(SignUp.this, e+" ", Toast.LENGTH_SHORT).show();

                    Log.i("failour",e+" ");
                }
            }
        });





    }

    public void testClicked(View v){

        ParseObject newObj = new ParseObject("New");

        newObj.put("name","Maeudf");

        newObj.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Toast.makeText(SignUp.this,"Save",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


//    public void helloWorldTapped(View v){
//        ParseObject boxer = new ParseObject("Boxer");
//
//        boxer.put("punch_speed",200);
//
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e==null){
//                    Toast.makeText(SignUp.this,"Saved",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
//
//    public void hitClicked(View v){
//
//        ParseObject obj = new ParseObject("Object");
//
//        obj.put("HITTED",500);
//
//        obj.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e==null){
//                    Toast.makeText(SignUp.this,"Saved and updated",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//    }
//
//    public void punchedClicked(View v){
//
//        String kickSpeed = kickText.getText().toString();
//
//        ParseObject punch = new ParseObject("Punched");
//
//        punch.put("Name","Maruf");
//        punch.put("Punch_Power",3000);
//        punch.put("Punch_Speed",2000);
//        punch.put("kick_Speed",kickSpeed);
//
//        punch.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e==null){
//                    Toast.makeText(SignUp.this,"Punch is saved",Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(SignUp.this,"Punch could not save",Toast.LENGTH_SHORT).show();
//
////                    Toast.makeText(SignUp.this," "+e,Toast.LENGTH_LONG).show();
//
//                    kickText.setText(" "+e);
//
//                }
//            }
//        });


//    public void saveClicked(View v){
//
//        String name = nameText.getText().toString();
//        ParseObject user = new ParseObject("User");
//
//        user.put("Name",name);
//
//        //saving the object to server
//
//        user.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e==null){
//                    Toast.makeText(SignUp.this," successfully saved",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(SignUp.this," Error saving the object "+e,Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }



    }


