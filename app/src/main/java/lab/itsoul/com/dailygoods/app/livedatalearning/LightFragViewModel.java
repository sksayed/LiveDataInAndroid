package lab.itsoul.com.dailygoods.app.livedatalearning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class LightFragViewModel extends ViewModel {
    private TemperatureSingleTon singleTonRepo ;

    public LightFragViewModel() {
        singleTonRepo = TemperatureSingleTon.getInstance();
    }
    public LiveData<Integer> liveData (){
        return singleTonRepo.getXObservable();
    }
}
