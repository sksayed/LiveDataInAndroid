package lab.itsoul.com.dailygoods.app.livedatalearning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TvFragViewModel extends ViewModel {

    private TemperatureSingleTon repository ;

    public TvFragViewModel() {
        repository = TemperatureSingleTon.getInstance();
    }

    public LiveData<Integer> getTemparatureValue () {
        return repository.getXObservable();
    }
}
