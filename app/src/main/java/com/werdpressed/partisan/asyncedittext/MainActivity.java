package com.werdpressed.partisan.asyncedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String data = "";
    EditorFragment mEditorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            mEditorFragment = EditorFragment.newInstance(data);
            getFragmentManager().beginTransaction().
                    add(android.R.id.content, mEditorFragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mEditorFragment == null) mEditorFragment = (EditorFragment) getFragmentManager().findFragmentById(android.R.id.content);
        switch (item.getItemId()) {
            case R.id.add_text_async:
                data = getText(R.string.long_text).toString();
                mEditorFragment.setData(data, true);
                break;
            case R.id.add_text:
                data = getText(R.string.long_text).toString();
                mEditorFragment.setData(data, false);
                break;
            case R.id.clear_text:
                mEditorFragment.clearData();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
