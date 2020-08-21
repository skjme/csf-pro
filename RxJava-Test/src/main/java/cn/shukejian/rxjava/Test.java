package cn.shukejian.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Test {

    public static void main(String[] args) {
        // 被观察者 (启点)
        Observable.just("hello")
                // 转换处理
                .map(s -> {
                    System.out.println("-------2--------");
                    return s.length();
                })
                // 观察者 （终点）
                .subscribe(
                        new Observer<Integer>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                                System.out.println("-------1--------");
                            }

                            @Override
                            public void onNext(@NonNull Integer r) {
                                System.out.println(r);
                                System.out.println("-------3--------");
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                System.out.println("-------4--------");
                            }
                        }
                );
    }
}
