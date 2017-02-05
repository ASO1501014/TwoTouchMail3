package jp.ac.asojuku.st.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RadioGroup rgPlae = (RadioGroup)findViewById(R.id.rg_place);
                int checkId = rgPlae.getCheckedRadioButtonId();
                String strPlace = ((RadioButton)findViewById(checkId)).getText().toString();

                EditText edit01 = (EditText)findViewById(R.id.editText);
                String title = edit01.getText().toString();

                Resources res = getResources();

                int r = (int) ((Math.random()*3)+1);

                Uri uri ;

                if(r==1){
                    uri = Uri.parse("mailto"+getString(R.string.mail_to1).toString());
                }else if(r==2){
                    uri = Uri.parse("mailto"+getString(R.string.mail_to2).toString());
                }else if(r==3) {
                    uri = Uri.parse("mailto" + getString(R.string.mail_to3).toString());
                }
                Intent intent = new Intent(Intent.ACTION_SENDTO);


                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(intent.EXTRA_TEXT,strPlace + "に迎えに来て");
                startActivity(intent);


            }
        });
    }
}
