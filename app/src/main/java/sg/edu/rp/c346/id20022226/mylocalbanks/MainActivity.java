package sg.edu.rp.c346.id20022226.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;
    Button bt3;

    String buttonClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);

        registerForContextMenu(bt1);
        registerForContextMenu(bt2);
        registerForContextMenu(bt3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == bt1) {
            buttonClicked = "DBS";
        } else if (v == bt2) {
            buttonClicked = "OCBC";
        } else if (v == bt3) {
            buttonClicked = "UOB";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            bt1.setText("DBS");
            bt1.setText("OCBC");
            bt1.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            bt1.setText("星展银行");
            bt2.setText("华侨银行");
            bt3.setText("大华银行");
            return true;
        } else {
            bt1.setText("Error translation");
            bt2.setText("Error translation");
            bt3.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (buttonClicked.equalsIgnoreCase("DBS")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if (buttonClicked.equalsIgnoreCase("OCBC")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        } else if (buttonClicked.equalsIgnoreCase("UOB")) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
            startActivity(intentCall);

            return true;  //menu item successfully handled
        }
    }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}