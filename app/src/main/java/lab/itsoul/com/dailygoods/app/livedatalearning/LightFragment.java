package lab.itsoul.com.dailygoods.app.livedatalearning;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LightFragment extends Fragment {

    ConstraintLayout constraintLayout ;
    LightFragViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LightFragViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         return inflater.inflate(R.layout.fragment_light, container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        constraintLayout = view.findViewById(R.id.parent);
        viewModel.liveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
              Log.d("sayed" , integer+" ");
              if( integer % 2 == 0){
                  constraintLayout.setBackgroundColor( getActivity().getResources().getColor(android.R.color.holo_blue_bright));
              }
              else {
                  constraintLayout.setBackgroundColor( getActivity().getResources().getColor(android.R.color.holo_red_dark));
              }

            }
        }) ;
    }
}
