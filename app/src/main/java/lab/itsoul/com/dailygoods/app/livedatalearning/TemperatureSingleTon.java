package lab.itsoul.com.dailygoods.app.livedatalearning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

//It works as a Repo or DataSource
public class TemperatureSingleTon {
    int x = 0;
    private MutableLiveData<Integer> xData =new MutableLiveData<>();
    private static TemperatureSingleTon SINGLE_INSTANCE = null;

    private TemperatureSingleTon() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        xData.postValue(++x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }

    public static TemperatureSingleTon getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized (TemperatureSingleTon.class) {
                SINGLE_INSTANCE = new TemperatureSingleTon();
            }
        }
        return SINGLE_INSTANCE;
    }
    public LiveData<Integer> getXObservable (){
        return this.xData ;
    }

}
