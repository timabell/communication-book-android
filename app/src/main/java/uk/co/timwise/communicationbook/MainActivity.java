package uk.co.timwise.communicationbook;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tts setup
        tts = new TextToSpeech(this, this);
        loadLibrary();
    }

    private void loadLibrary() {
        toast("loading library...");
        //todo
        GridView gridview = (GridView)findViewById(R.id.grid_library);
        gridview.setAdapter(new LibraryAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast("clicky droid");
            }
        });
        toast("library loaded");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void speak(View view){
        speak("Hello there, pumpkin!");
    }

    private void speak(String s) {
        toast("speaking your message");
        tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void toast(String text) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    // tts init handler
    @Override
    public void onInit(int status) {
        toast("tts initialized");
    }
}
