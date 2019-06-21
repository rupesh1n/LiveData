package livedata.rupesh.com.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getNumber(){
        Log.i(TAG, "Get Number");
        if (randomNumber == null){
            randomNumber = new MutableLiveData<>();
            createNumber();
        }
        return randomNumber;
    }

    public void createNumber() {
        Log.i(TAG, "Create Number");
        Random random = new Random();
        randomNumber.setValue("Number: " + (random.nextInt(20-1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "Cleared called");
    }
}
