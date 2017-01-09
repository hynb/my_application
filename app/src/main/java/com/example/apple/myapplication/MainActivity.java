package com.example.apple.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;
    private String str = "hello,how  are _ )you?";
    private ArrayList<Integer> startList = new ArrayList<>();
    private ArrayList<Integer> endList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private int[] s = {3, 5, 7, 2, 1, 8, 6, 0, 4, 9};
    private int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(() -> {
            System.out.print("women 都是一家人");
        }).start();


//        btn = (Button) findViewById(R.id.skip);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,FirstKotlinActivity.class));
//            }
//        });
//        EventBus.getDefault().register(this);
//        EventBus.getDefault().post("你奶奶个腿的");
//        _directionInsertSort(s);

        /**
         * 直接插入排序
         */
//        for(int i=1; i < s.length;i++){
//            if(s[i]<s[i-1]){
//                int j = i-1;
//                int  x = s[i];
//                s[i] = s[i-1];
//                while (x < s[j-1]){
//                    s[j] = s[j-1];
//                    j--;
//                    if(j==0)break;
//                }
//                s[j] = x;
//            }
//        }
        for (int i = 0; i < s.length; i++) {
            Log.e("onCreate: ", s[i] + "");
        }

        Log.e("onCreate: ", k + "");
/**
 * 不同的单词显示不同颜色
 */
//        textView = (TextView) findViewById(R.id.display);
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char temp = str.charAt(i);
//            if((temp>='a' && temp<='z') || (temp >= 'A' && temp <= 'Z')){
//
//            }else {
//                end = i;
//                startList.add(start);
//                endList.add(end);
//                while (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))){
//                    if(i < str.length()-1){
//                        i++;
//                    }else break;
//                }
//                start = i;
//            }
//        }
//        SpannableString spannableString = new SpannableString(str);
//        for (int i = 0 ;i < startList.size(); i++){
//            int color = i % 2 == 0  ? Color.BLUE : Color.RED;
//            spannableString.setSpan(new ForegroundColorSpan(color),startList.get(i),endList.get(i), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        }
//        textView.setText(spannableString);
//        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("你奶奶个腿");
//                subscriber.onCompleted();
//            }
//        });
//        Subscriber<String> mySubscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.e("onNext: ", s);
//            }
//        };
//        myObservable.subscribe(mySubscriber);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String str){
        ((TextView)findViewById(R.id.textView)).setText(str);
    }
    /**
     * 直接插入排序
     */

    private void directionInsertSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                int j = i;
                int x = a[i + 1];
                a[i + 1] = a[i];
                while (a[j - 1] > x) {
                    a[j] = a[j - 1];
                    j--;
                    if (j < 1) break;
                }
                a[j] = x;
            }
        }
    }

    private void _directionInsertSort(int[] a) {
        int i = 1;
        for (; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (x < a[j]) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = x;
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     * @param n
     * @param dk
     */
    private void shellInsertSort(int a[], int n, int dk) {
        for (int i = dk; i < n; ++i) {
            if (a[i] < a[i - dk]) {
                int j = i - dk;
                int x = a[i];
                a[i] = a[i - dk];
                while (x < a[j]) {
                    a[j + dk] = a[j];
                    j -= dk;
                    if (j < 0) break;
                }
                a[j + dk] = x;
            }
        }
    }

    private void shellSort(int a[], int n) {
        int dk = n / 2;
        while (dk >= 1) {
            shellInsertSort(a, n, dk);
            dk = dk / 2;
        }
    }

    /**
     * 交换排序(冒泡排序)
     */
    private void bubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                k++;
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化(pos)
     */

    private void _bubbleSort(int a[], int n) {
        int i = n - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                k++;
                if (a[j] > a[j + 1]) {
                    pos = j;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            i = pos;
        }
    }

    /**
     * @param a
     * @param low
     * @param high
     */
    private void quickSort(int a[], int low, int high) {
        if (low < high) {
            int privotLoc = partition(a, low, high);
            quickSort(a, low, privotLoc - 1);
            quickSort(a, privotLoc + 1, high);
        }
    }

    private int partition(int a[], int low, int high) {
        int privotKey = a[low];
        while (low < high) {
            while (low < high && a[high] >= privotKey) --high;
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            while (low < high && a[low] <= privotKey) ++low;
            int temp1 = a[low];
            a[low] = a[high];
            a[high] = temp1;
        }
        return low;
    }

    /**
     * 选择排序
     */
    private void selectSort(int[] a){

    }
}
