# ASyncEditText

Demonstration of UI freezes caused by the `Edittext` `setText()` method, to complement [this StackOverflow post](http://stackoverflow.com/questions/29801232/edittext-performance-understanding-gpu-process-time-on-profile-gpu-rendering?noredirect=1#comment47938096_29801232).

I have made three video demonstrations that show this app running on a [Huawei Honor Holly running KitKat 4.4.2](http://www.gsmarena.com/huawei_honor_holly-6738.php) with the `hardwareAccelerated` attribute set to `true` in the `AndroidManifest`, then with the same phone with the same attribute set to `false`, and a separate [Nexus 7 (2013)
running Lollipop 5.1](http://www.gsmarena.com/asus_google_nexus_7_(2013)-5600.php). GPU Profiling is on in each case.

[Honor Holly - Acceleration On](https://drive.google.com/file/d/0BygzWY4QsrwEbWQtSjFUWFFNdWM/view?usp=sharing)

[Honor Holly - Acceleration Off](https://drive.google.com/file/d/0BygzWY4QsrwEX09aYzVSSENXZFU/view?usp=sharing)

[Nexus 7 (2013) - Acceleration On](https://drive.google.com/file/d/0BygzWY4QsrwEVkttRVN0RVlKN2c/view?usp=sharing)
