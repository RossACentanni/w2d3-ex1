package com.example.w2d3_ex1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = FirstFragment.class.getSimpleName()+"_TAG";
    private OnButtonClickListenerFirst callback;

    private EditText inputMsg;
    private Button sendMsg;
    private TextView output;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstBTN:
                String msg = inputMsg.getText().toString();
                callback.sendToSecond(msg);
                break;
        }
    }

    public void printMessage(String msg){
        output.setText(msg);
    }

    public FirstFragment() {
        // Required empty public constructor, fragment won't work otherwise.
        //Not used for initialization.
    }

    public interface OnButtonClickListenerFirst{
        public void sendToSecond(String msg);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");

        try{
            callback = (OnButtonClickListenerFirst) getActivity();
        }
        catch (ClassCastException e){
            Log.d(TAG, "onAttach: Forgot to implement OnButtonClickListener!");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        // here is just a way for us to know that our parent activity is ready
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
        // you bind to the views here
        inputMsg = view.findViewById(R.id.firstET);
        sendMsg = view.findViewById(R.id.firstBTN);
        output = view.findViewById(R.id.firstTV);

        sendMsg.setOnClickListener(this);
    }

    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // you can't bind to the views just yet
        return inflater.inflate(R.layout.fragment_first_fragment, container, false);
    }

}
