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


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = SecondFragment.class.getSimpleName()+"_TAG";
    private OnButtonClickListenerSecond callback;

    private EditText inputMsg;
    private TextView output;
    private Button sendMsg;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.secondBTN:
                String msg = inputMsg.getText().toString();
                callback.sendToFirst(msg);
        }
    }

    public void printMessage(String msg){
        output.setText(msg);
    }

    public interface OnButtonClickListenerSecond{
        public void sendToFirst(String msg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");

        try{
            callback = (OnButtonClickListenerSecond) getActivity();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
        inputMsg = view.findViewById(R.id.secondET);
        sendMsg = view.findViewById(R.id.secondBTN);
        output = view.findViewById(R.id.secondTV);

        sendMsg.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
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
}
