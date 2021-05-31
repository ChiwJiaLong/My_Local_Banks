package sg.edu.rp.c346.id20031634.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView dbs, ocbc, uob;
    String bank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.DBS);
        registerForContextMenu(dbs);
        ocbc = findViewById(R.id.OCBC);
        registerForContextMenu(ocbc);
        uob = findViewById(R.id.UOB);
        registerForContextMenu(uob);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.English) {
            dbs.setText(R.string.DBS);
            uob.setText(R.string.UOB);
            ocbc.setText(R.string.OCBC);
            return true;
        } else if (id == R.id.Chinese) {
            dbs.setText(R.string.dbschinese);
            uob.setText(R.string.uobchinese);
            ocbc.setText(R.string.ocbcchinese);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact The Bank");
        menu.add(0, 2, 2, "Toggle Favourite");
        if (v == dbs) {
            bank = getString(R.string.DBS);
        } else if (v == ocbc) {
            bank = getString(R.string.OCBC);
        } else if (v == uob) {
            bank = getString(R.string.UOB);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bank.equalsIgnoreCase(getString(R.string.DBS))) {

            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Toast.makeText(MainActivity.this, "Website is chosen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Toast.makeText(MainActivity.this, "Contact is chosen", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsnumber)));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                Toast.makeText(MainActivity.this, "Toggle Favourite is chosen", Toast.LENGTH_SHORT).show();
                if (dbs.getCurrentTextColor() == (Color.BLACK)) {
                    dbs.setTextColor(Color.RED);
                } else if (dbs.getCurrentTextColor() == (Color.RED)) {
                    dbs.setTextColor(Color.BLACK);
                }
            }
        } else if (bank.equalsIgnoreCase(getString(R.string.OCBC))) {
            if (item.getItemId() == 0) {
                //code for action
                Toast.makeText(MainActivity.this, "Website is chosen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                //code for action
                Toast.makeText(MainActivity.this, "Contact is chosen", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcnumber)));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                //code for action
                Toast.makeText(MainActivity.this, "Toggle Favourite is chosen", Toast.LENGTH_SHORT).show();
                if (ocbc.getCurrentTextColor() == (Color.BLACK)) {
                    ocbc.setTextColor(Color.RED);
                } else if (ocbc.getCurrentTextColor() == (Color.RED)) {
                    ocbc.setTextColor(Color.BLACK);
                }
            }
        }else if (bank.equalsIgnoreCase(getString(R.string.UOB))) {
            if (item.getItemId() == 0) {
                //code for action
                Toast.makeText(MainActivity.this, "Website is chosen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                //code for action
                Toast.makeText(MainActivity.this, "Contact is chosen", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobnumber)));
                startActivity(intentCall);
            } else if (item.getItemId() == 2) {
                Toast.makeText(MainActivity.this, "Toggle Favourite is chosen", Toast.LENGTH_SHORT).show();
                if (uob.getCurrentTextColor() == (Color.BLACK)) {
                    uob.setTextColor(Color.RED);
                } else if (uob.getCurrentTextColor() == (Color.RED)) {
                    uob.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}