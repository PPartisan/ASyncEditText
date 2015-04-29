package com.werdpressed.partisan.asyncedittext;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.StringReader;

public class EditorFragment extends Fragment {

    public static final String CONTENT_ID="content";

    View rootView;
    ProgressBar mProgressBar;
    ScrollView mScrollView;
    EditText mEditText;
    String content;

    UpdateText ut;

    static EditorFragment newInstance(String content){

        EditorFragment frag = new EditorFragment();
        Bundle args = new Bundle();
        args.putString(CONTENT_ID, content);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.editor_fragment, container, false);

        mEditText = (EditText) rootView.findViewById(R.id.editor_fragment_edit_text);
        mScrollView = (ScrollView) rootView.findViewById(R.id.editor_fragment_parent);
        mProgressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);

        ut = new UpdateText();
        ut.execute(getData());

        return rootView;
    }

    void setData(String newData, boolean isAsync){
        if (isAsync){
            ut = new UpdateText();
            ut.execute(newData);
        } else {
            mEditText.setText(newData);
        }
    }

    String getData(){
        return getArguments().getString(CONTENT_ID);
    }

    void clearData(){
        mEditText.getText().clear();
    }


    class UpdateText extends AsyncTask <String, String, Void> {

        @Override
        protected void onPreExecute() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void result) {
            mProgressBar.setVisibility(View.GONE);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            content = values[0];
            if (mEditText.getText().toString().trim().equals("")){
                mEditText.setText(content);
            } else {
                mEditText.append(content);
            }
        }

        @Override
        protected Void doInBackground(String... content) {

            StringReader inputStreamReader = new StringReader(content[0]);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";

            try {
                while ((receiveString = bufferedReader.readLine()) != null ) {
                    publishProgress(receiveString + "\n");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
