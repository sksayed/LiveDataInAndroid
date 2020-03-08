package lab.itsoul.com.dailygoods.app.livedatalearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    TextView textView ;

    TvFragViewModel tvFragViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        textView = findViewById(R.id.textView);
        tvFragViewModel = new ViewModelProvider(this).get(TvFragViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvFragViewModel.getTemparatureValue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText("Tempareture is :"+integer);
            }
        });
    }
}
