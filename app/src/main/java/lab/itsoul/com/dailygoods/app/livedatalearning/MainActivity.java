package lab.itsoul.com.dailygoods.app.livedatalearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToNextActivity ;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToNextActivity = findViewById(R.id.goToNextActivity);
        LightFragment lightFragment = new LightFragment();
        TvFragment tvFragment = new TvFragment ();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tvFragment , tvFragment)
                .replace(R.id.lightFragment , lightFragment)
                .commit();
        initListeners();
        intent = new Intent(this , AnotherActivity.class);
    }

    private void initListeners() {
        goToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
