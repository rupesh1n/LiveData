package livedata.rupesh.com.livedata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.myTv);
        Button button = findViewById(R.id.button);

        final MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final LiveData<String> randomNo = model.getNumber();
        randomNo.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                Log.i(TAG, "Data updated on  UI");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.createNumber();
            }
        });
        Log.i(TAG, "Random Number Set");
    }
}
